/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.integration.copier.snapshot.writer;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opengamma.OpenGammaRuntimeException;
import com.opengamma.core.marketdatasnapshot.CurveKey;
import com.opengamma.core.marketdatasnapshot.CurveSnapshot;
import com.opengamma.core.marketdatasnapshot.UnstructuredMarketDataSnapshot;
import com.opengamma.core.marketdatasnapshot.ValueSnapshot;
import com.opengamma.core.marketdatasnapshot.VolatilitySurfaceKey;
import com.opengamma.core.marketdatasnapshot.VolatilitySurfaceSnapshot;
import com.opengamma.core.marketdatasnapshot.YieldCurveKey;
import com.opengamma.core.marketdatasnapshot.YieldCurveSnapshot;
import com.opengamma.id.ExternalIdBundle;
import com.opengamma.integration.copier.sheet.SheetFormat;
import com.opengamma.integration.copier.sheet.writer.CsvSheetWriter;
import com.opengamma.integration.copier.snapshot.SnapshotColumns;
import com.opengamma.integration.copier.snapshot.SnapshotType;
import com.opengamma.util.time.Tenor;
import com.opengamma.util.tuple.Pair;

/**
 * Writes a snapshot to exported file
 */
public class FileSnapshotWriter implements SnapshotWriter {

  private CsvSheetWriter _sheetWriter;
  private static final Logger s_logger = LoggerFactory.getLogger(FileSnapshotWriter.class);

  public FileSnapshotWriter(String filename) {

    if (filename == null) {
      throw new OpenGammaRuntimeException("File name omitted, cannot export to file");
    }

    if (SheetFormat.of(filename) == SheetFormat.CSV || SheetFormat.of(filename) == SheetFormat.XLS) {
      _sheetWriter = new CsvSheetWriter(filename, SnapshotColumns.columns());
    } else {
      throw new OpenGammaRuntimeException("Input filename should end in .CSV or .XLS");
    }
  }

  /** Ordinated ValueSnapshots, needed for Volatility Surfaces */
  private void writeOrdinatedValueSnapshot(Map<String, String> prefixes,
                                           Map<Pair<Object, Object>, ValueSnapshot> valueSnapshots) {

    for (Map.Entry<Pair<Object, Object>, ValueSnapshot> entry : valueSnapshots.entrySet()) {
      Map<String, String> tempRow = new HashMap<>();
      ValueSnapshot valueSnapshot = entry.getValue();
      tempRow.putAll(prefixes);

      String surfaceX;
      if (entry.getKey().getFirst() instanceof Tenor) {
        surfaceX = ((Tenor) entry.getKey().getFirst()).toFormattedString();
      } else {
        surfaceX = entry.getKey().getFirst().toString();
      }

      String surfaceY;
      if (entry.getKey().getSecond() instanceof Pair) {
        surfaceY = ((Pair) entry.getKey().getSecond()).getFirst() + "|" + ((Pair) entry.getKey().getSecond()).getSecond();
      } else {
        surfaceY = entry.getKey().getSecond().toString();
      }

      tempRow.put(SnapshotColumns.SURFACE_X.get(), surfaceX);
      tempRow.put(SnapshotColumns.SURFACE_Y.get(), surfaceY);
      if (valueSnapshot.getMarketValue() != null) {
        tempRow.put(SnapshotColumns.MARKET_VALUE.get(), valueSnapshot.getMarketValue().toString());
      }
      if (valueSnapshot.getOverrideValue() != null) {
        tempRow.put(SnapshotColumns.OVERRIDE_VALUE.get(), valueSnapshot.getOverrideValue().toString());
      }
      _sheetWriter.writeNextRow(tempRow);
    }
  }

  /** Named ValueSnapshots, needed for Unstructured Market */
  private void writeValueSnapshot(Map<String, String> prefixes, Map<String, ValueSnapshot> valueSnapshots) {

    for (Map.Entry<String, ValueSnapshot> entry : valueSnapshots.entrySet()) {
      Map<String, String> tempRow = new HashMap<>();
      ValueSnapshot valueSnapshot = entry.getValue();
      tempRow.putAll(prefixes);
      tempRow.put(SnapshotColumns.VALUE_NAME.get(), entry.getKey());
      if (valueSnapshot.getMarketValue() != null) {
        tempRow.put(SnapshotColumns.MARKET_VALUE.get(), valueSnapshot.getMarketValue().toString());
      }
      if (valueSnapshot.getOverrideValue() != null) {
        tempRow.put(SnapshotColumns.OVERRIDE_VALUE.get(), valueSnapshot.getOverrideValue().toString());
      }
      _sheetWriter.writeNextRow(tempRow);
    }
  }

  private void writeUnstructuredMarketDataSnapshot(Map<String, String> prefixes,
                                                   UnstructuredMarketDataSnapshot snapshot) {

    for (ExternalIdBundle eib : snapshot.getTargets()) {
      Map<String, String> tempRow = new HashMap<>();
      tempRow.putAll(prefixes);
      tempRow.put(SnapshotColumns.ID_BUNDLE.get(), StringUtils.join(eib.getExternalIds(), '|'));
      //Row written by writeValueSnapshot
      writeValueSnapshot(tempRow, snapshot.getTargetValues(eib));
    }
  }

  @Override
  public void flush() {
    _sheetWriter.flush();
  }

  @Override
  public void writeCurves(Map<CurveKey, CurveSnapshot> curves) {

    if (curves == null || curves.isEmpty()) {
      s_logger.warn("Snapshot does not contain any Curve Snapshots.");
      return;
    }

    for (Map.Entry<CurveKey, CurveSnapshot> entry : curves.entrySet()) {
      CurveSnapshot curve = entry.getValue();
      Map<String, String> tempRow = new HashMap<>();
      tempRow.put(SnapshotColumns.TYPE.get(), SnapshotType.CURVE.get());
      tempRow.put(SnapshotColumns.NAME.get(), entry.getKey().getName());
      tempRow.put(SnapshotColumns.INSTANT.get(), curve.getValuationTime().toString());
      //Row written via writeUnstructuredMarketDataSnapshot
      writeUnstructuredMarketDataSnapshot(tempRow, curve.getValues());
    }
  }

  @Override
  public void writeGlobalValues(UnstructuredMarketDataSnapshot globalValues) {

    if (globalValues == null || globalValues.isEmpty()) {
      s_logger.warn("Snapshot does not contain any Global Values.");
      return;
    }

    Map<String, String> tempRow = new HashMap<>();
    tempRow.put(SnapshotColumns.TYPE.get(), SnapshotType.GOBAL_VALUES.get());
    //Row written via writeUnstructuredMarketDataSnapshot
    writeUnstructuredMarketDataSnapshot(tempRow, globalValues);
  }

  @Override
  public void writeVolatilitySurface(Map<VolatilitySurfaceKey, VolatilitySurfaceSnapshot> volatilitySurface) {

    if (volatilitySurface == null || volatilitySurface.isEmpty()) {
      s_logger.warn("Snapshot does not contain any Volatility Surfaces.");
      return;
    }

    for (Map.Entry<VolatilitySurfaceKey, VolatilitySurfaceSnapshot> entry : volatilitySurface.entrySet()) {
      VolatilitySurfaceSnapshot surface = entry.getValue();
      Map<String, String> tempRow = new HashMap<>();
      tempRow.put(SnapshotColumns.TYPE.get(), SnapshotType.VOL_SURFACE.get());
      tempRow.put(SnapshotColumns.NAME.get(), entry.getKey().getName());
      tempRow.put(SnapshotColumns.SURFACE_TARGET.get(), entry.getKey().getTarget().toString());
      tempRow.put(SnapshotColumns.SURFACE_INSTRUMENT_TYPE.get(), entry.getKey().getInstrumentType());
      tempRow.put(SnapshotColumns.SURFACE_QUOTE_TYPE.get(), entry.getKey().getQuoteType());
      tempRow.put(SnapshotColumns.SURFACE_QUOTE_UNITS.get(), entry.getKey().getQuoteUnits());
      //Row written by writeOrdinatedValueSnapshot
      writeOrdinatedValueSnapshot(tempRow, surface.getValues());
    }
  }

  @Override
  public void writeYieldCurves(Map<YieldCurveKey, YieldCurveSnapshot> yieldCurves) {

    if (yieldCurves == null || yieldCurves.isEmpty()) {
      s_logger.warn("Snapshot does not contain any Yield Curve Snapshots.");
      return;
    }

    for (Map.Entry<YieldCurveKey, YieldCurveSnapshot> entry : yieldCurves.entrySet()) {
      YieldCurveSnapshot curve = entry.getValue();
      Map<String, String> tempRow = new HashMap<>();
      tempRow.put(SnapshotColumns.TYPE.get(), SnapshotType.YIELD_CURVE.get());
      tempRow.put(SnapshotColumns.NAME.get(), entry.getKey().getName());
      tempRow.put(SnapshotColumns.YIELD_CURVE_CURRENCY.get(), entry.getKey().getCurrency().toString());
      tempRow.put(SnapshotColumns.INSTANT.get(), curve.getValuationTime().toString());
      //Row written via writeUnstructuredMarketDataSnapshot
      writeUnstructuredMarketDataSnapshot(tempRow, curve.getValues());
    }
  }

  @Override
  public void writeName(String name) {

    if (name == null || name.isEmpty()) {
      s_logger.warn("Snapshot does not contain name.");
      return;
    }

    Map<String, String> tempRow = new HashMap<>();
    tempRow.put(SnapshotColumns.TYPE.get(), SnapshotType.NAME.get());
    tempRow.put(SnapshotColumns.NAME.get(), name);
    _sheetWriter.writeNextRow(tempRow);
  }

  @Override
  public void writeBasisViewName(String basisName) {

    if (basisName == null || basisName.isEmpty()) {
      s_logger.warn("Snapshot does not contain basis name.");
      return;
    }

    Map<String, String> tempRow = new HashMap<>();
    tempRow.put(SnapshotColumns.TYPE.get(), SnapshotType.BASIS_NAME.get());
    tempRow.put(SnapshotColumns.NAME.get(), basisName);
    _sheetWriter.writeNextRow(tempRow);
  }

  @Override
  public void close() {
    flush();
    _sheetWriter.close();
  }
}
