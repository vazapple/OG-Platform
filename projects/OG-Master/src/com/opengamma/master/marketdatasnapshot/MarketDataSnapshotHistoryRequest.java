/**
 * Copyright (C) 2011 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.master.marketdatasnapshot;

import java.util.Map;

import javax.time.InstantProvider;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.id.ObjectIdentifiable;
import com.opengamma.master.AbstractHistoryRequest;
import com.opengamma.util.PublicSPI;

/**
 * Request for the history of a market data snapshot.
 * <p>
 * A full snapshot master implements historical storage of data.
 * History can be stored in two dimensions and this request provides searching.
 * <p>
 * The first historic dimension is the classic series of versions.
 * Each new version is stored in such a manor that previous versions can be accessed.
 * <p>
 * The second historic dimension is corrections.
 * A correction occurs when it is realized that the original data stored was incorrect.
 * A simple master might simply replace the original version with the corrected value.
 * A full implementation will store the correction in such a manner that it is still possible
 * to obtain the value before the correction was made.
 * <p>
 * For example, a snapshot added on Monday and updated on Thursday has two versions.
 * If it is realized on Friday that the version stored on Monday was incorrect, then a
 * correction may be applied. There are now two versions, the first of which has one correction.
 * This may continue, with multiple corrections allowed for each version.
 * <p>
 * Versions and corrections are represented by instants in the search.
 */
@PublicSPI
@BeanDefinition
public class MarketDataSnapshotHistoryRequest extends AbstractHistoryRequest {

  /**
   * Set whether to include the data values from the snapshot. Set to {@code false} to reduce the
   * size of the data transferred. Defaults to {@code true}. A master implementation may ignore
   * this part of the request and always include the data.
   */
  @PropertyDefinition
  private boolean _includeData = true;

  /**
   * Creates an instance.
   * The object identifier must be added before searching.
   */
  public MarketDataSnapshotHistoryRequest() {
    super();
  }

  /**
   * Creates an instance with object identifier.
   * This will retrieve all versions and corrections unless the relevant fields are set.
   * 
   * @param objectId  the object identifier, not null
   */
  public MarketDataSnapshotHistoryRequest(final ObjectIdentifiable objectId) {
    super(objectId);
  }

  /**
   * Creates an instance with object identifier and optional version and correction.
   * 
   * @param objectId  the object identifier, not null
   * @param versionInstantProvider  the version instant to retrieve, null for all versions
   * @param correctedToInstantProvider  the instant that the data should be corrected to, null for all corrections
   */
  public MarketDataSnapshotHistoryRequest(final ObjectIdentifiable objectId, InstantProvider versionInstantProvider, InstantProvider correctedToInstantProvider) {
    super(objectId, versionInstantProvider, correctedToInstantProvider);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code MarketDataSnapshotHistoryRequest}.
   * @return the meta-bean, not null
   */
  public static MarketDataSnapshotHistoryRequest.Meta meta() {
    return MarketDataSnapshotHistoryRequest.Meta.INSTANCE;
  }
  static {
    JodaBeanUtils.registerMetaBean(MarketDataSnapshotHistoryRequest.Meta.INSTANCE);
  }

  @Override
  public MarketDataSnapshotHistoryRequest.Meta metaBean() {
    return MarketDataSnapshotHistoryRequest.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 274670706:  // includeData
        return isIncludeData();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 274670706:  // includeData
        setIncludeData((Boolean) newValue);
        return;
    }
    super.propertySet(propertyName, newValue, quiet);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      MarketDataSnapshotHistoryRequest other = (MarketDataSnapshotHistoryRequest) obj;
      return JodaBeanUtils.equal(isIncludeData(), other.isIncludeData()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(isIncludeData());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets set whether to include the data values from the snapshot. Set to {@code false} to reduce the
   * size of the data transferred. Defaults to {@code true}. A master implementation may ignore
   * this part of the request and always include the data.
   * @return the value of the property
   */
  public boolean isIncludeData() {
    return _includeData;
  }

  /**
   * Sets set whether to include the data values from the snapshot. Set to {@code false} to reduce the
   * size of the data transferred. Defaults to {@code true}. A master implementation may ignore
   * this part of the request and always include the data.
   * @param includeData  the new value of the property
   */
  public void setIncludeData(boolean includeData) {
    this._includeData = includeData;
  }

  /**
   * Gets the the {@code includeData} property.
   * size of the data transferred. Defaults to {@code true}. A master implementation may ignore
   * this part of the request and always include the data.
   * @return the property, not null
   */
  public final Property<Boolean> includeData() {
    return metaBean().includeData().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code MarketDataSnapshotHistoryRequest}.
   */
  public static class Meta extends AbstractHistoryRequest.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code includeData} property.
     */
    private final MetaProperty<Boolean> _includeData = DirectMetaProperty.ofReadWrite(
        this, "includeData", MarketDataSnapshotHistoryRequest.class, Boolean.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<Object>> _map = new DirectMetaPropertyMap(
      this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "includeData");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 274670706:  // includeData
          return _includeData;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends MarketDataSnapshotHistoryRequest> builder() {
      return new DirectBeanBuilder<MarketDataSnapshotHistoryRequest>(new MarketDataSnapshotHistoryRequest());
    }

    @Override
    public Class<? extends MarketDataSnapshotHistoryRequest> beanType() {
      return MarketDataSnapshotHistoryRequest.class;
    }

    @Override
    public Map<String, MetaProperty<Object>> metaPropertyMap() {
      return _map;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code includeData} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> includeData() {
      return _includeData;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
