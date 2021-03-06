/**
 * Copyright (C) 2011 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.analytics.volatility.surface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opengamma.OpenGammaRuntimeException;
import com.opengamma.engine.ComputationTarget;
import com.opengamma.engine.target.ComputationTargetType;
import com.opengamma.financial.analytics.model.InstrumentTypeProperties;

/**
 * Constructs volatility surface data objects for IR future options if the target is the currency of the option.
 */
public class RawIRFutureOptionVolatilitySurfaceDataFunction extends RawVolatilitySurfaceDataFunction {
  /** The logger */
  private static final Logger s_logger = LoggerFactory.getLogger(RawIRFutureOptionVolatilitySurfaceDataFunction.class);

  /**
   * Default constructor
   */
  public RawIRFutureOptionVolatilitySurfaceDataFunction() {
    super(InstrumentTypeProperties.IR_FUTURE_OPTION);
  }

  @Override
  protected ComputationTargetType getTargetType() {
    return ComputationTargetType.CURRENCY;
  }

  @Override
  protected VolatilitySurfaceDefinition<?, ?> getDefinition(final VolatilitySurfaceDefinitionSource definitionSource, final ComputationTarget target, final String definitionName) {
    final String fullDefinitionName = definitionName + "_" + target.getUniqueId().getValue();
    final VolatilitySurfaceDefinition<?, ?> definition = definitionSource.getDefinition(fullDefinitionName, InstrumentTypeProperties.IR_FUTURE_OPTION);
    if (definition == null) {
      throw new OpenGammaRuntimeException("Could not get volatility surface definition named " + fullDefinitionName + " for instrument type " + InstrumentTypeProperties.IR_FUTURE_OPTION);
    }
    return definition;
  }

  @Override
  protected VolatilitySurfaceSpecification getSpecification(final VolatilitySurfaceSpecificationSource specificationSource, final ComputationTarget target, final String specificationName) {
    final String fullSpecificationName = specificationName + "_" + target.getUniqueId().getValue();
    final VolatilitySurfaceSpecification specification = specificationSource.getSpecification(fullSpecificationName, InstrumentTypeProperties.IR_FUTURE_OPTION);
    if (specification == null) {
      throw new OpenGammaRuntimeException("Could not get volatility surface specification named " + fullSpecificationName + " for instrument type " + InstrumentTypeProperties.IR_FUTURE_OPTION);
    }
    return specification;
  }

}
