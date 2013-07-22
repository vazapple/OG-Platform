/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.provider.livedata;

import java.util.Map;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.impl.direct.DirectBean;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.util.PublicSPI;

/**
 * Request to get meta-data about a live data provider.
 * <p>
 * This class is mutable and not thread-safe.
 */
@PublicSPI
@BeanDefinition
public class LiveDataMetaDataProviderRequest extends DirectBean {

  /**
   * Creates an instance.
   */
  public LiveDataMetaDataProviderRequest() {
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code LiveDataMetaDataProviderRequest}.
   * @return the meta-bean, not null
   */
  public static LiveDataMetaDataProviderRequest.Meta meta() {
    return LiveDataMetaDataProviderRequest.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(LiveDataMetaDataProviderRequest.Meta.INSTANCE);
  }

  @Override
  public LiveDataMetaDataProviderRequest.Meta metaBean() {
    return LiveDataMetaDataProviderRequest.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    super.propertySet(propertyName, newValue, quiet);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    return hash;
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code LiveDataMetaDataProviderRequest}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null);

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    public BeanBuilder<? extends LiveDataMetaDataProviderRequest> builder() {
      return new DirectBeanBuilder<LiveDataMetaDataProviderRequest>(new LiveDataMetaDataProviderRequest());
    }

    @Override
    public Class<? extends LiveDataMetaDataProviderRequest> beanType() {
      return LiveDataMetaDataProviderRequest.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
