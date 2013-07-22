/**
 * Copyright (C) 2011 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.master.config;

import java.util.Map;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.master.AbstractMetaDataRequest;
import com.opengamma.util.PublicSPI;

/**
 * Request for meta-data about the configuration master.
 * <p>
 * This will return meta-data valid for the whole master.
 */
@PublicSPI
@BeanDefinition
public class ConfigMetaDataRequest extends AbstractMetaDataRequest {

  /**
   * Whether to fetch the config types meta-data, true by default.
   */
  @PropertyDefinition
  private boolean _configTypes = true;

  /**
   * Creates an instance.
   */
  public ConfigMetaDataRequest() {
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ConfigMetaDataRequest}.
   * @return the meta-bean, not null
   */
  public static ConfigMetaDataRequest.Meta meta() {
    return ConfigMetaDataRequest.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ConfigMetaDataRequest.Meta.INSTANCE);
  }

  @Override
  public ConfigMetaDataRequest.Meta metaBean() {
    return ConfigMetaDataRequest.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 7511639:  // configTypes
        return isConfigTypes();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 7511639:  // configTypes
        setConfigTypes((Boolean) newValue);
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
      ConfigMetaDataRequest other = (ConfigMetaDataRequest) obj;
      return JodaBeanUtils.equal(isConfigTypes(), other.isConfigTypes()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(isConfigTypes());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets whether to fetch the config types meta-data, true by default.
   * @return the value of the property
   */
  public boolean isConfigTypes() {
    return _configTypes;
  }

  /**
   * Sets whether to fetch the config types meta-data, true by default.
   * @param configTypes  the new value of the property
   */
  public void setConfigTypes(boolean configTypes) {
    this._configTypes = configTypes;
  }

  /**
   * Gets the the {@code configTypes} property.
   * @return the property, not null
   */
  public final Property<Boolean> configTypes() {
    return metaBean().configTypes().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ConfigMetaDataRequest}.
   */
  public static class Meta extends AbstractMetaDataRequest.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code configTypes} property.
     */
    private final MetaProperty<Boolean> _configTypes = DirectMetaProperty.ofReadWrite(
        this, "configTypes", ConfigMetaDataRequest.class, Boolean.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "configTypes");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 7511639:  // configTypes
          return _configTypes;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends ConfigMetaDataRequest> builder() {
      return new DirectBeanBuilder<ConfigMetaDataRequest>(new ConfigMetaDataRequest());
    }

    @Override
    public Class<? extends ConfigMetaDataRequest> beanType() {
      return ConfigMetaDataRequest.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code configTypes} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> configTypes() {
      return _configTypes;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
