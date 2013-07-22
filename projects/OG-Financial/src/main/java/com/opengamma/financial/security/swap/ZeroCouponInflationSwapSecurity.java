/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.security.swap;

import java.util.Map;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.threeten.bp.ZonedDateTime;

import com.opengamma.financial.security.FinancialSecurityVisitor;
import com.opengamma.util.ArgumentChecker;
import org.joda.beans.Property;
import org.joda.beans.impl.direct.DirectMetaProperty;

/**
 * A security for a zero-coupon inflation swap.
 */
@BeanDefinition
public class ZeroCouponInflationSwapSecurity extends SwapSecurity {

  /** Serialization version */
  private static final long serialVersionUID = 1L;

  /**
   * The security type.
   */
  public static final String SECURITY_TYPE = "ZERO_COUPON_INFLATION_SWAP";

  /**
   * Is the notional exchanged
   */
  @PropertyDefinition
  private boolean _exchangeNotional;

  /**
   * For the builder
   */
  /* package */ZeroCouponInflationSwapSecurity() {
    super(SECURITY_TYPE);
  }

  /**
   * @param tradeDate The trade date, not null
   * @param effectiveDate The effective date, not null
   * @param maturityDate The maturity date, not null
   * @param counterparty The counterparty, not null
   * @param payLeg The pay leg, not null
   * @param receiveLeg The receive leg, not null
   * @param exchangeNotional True if the notional is exchanged
   */
  public ZeroCouponInflationSwapSecurity(final ZonedDateTime tradeDate, final ZonedDateTime effectiveDate, final ZonedDateTime maturityDate,
      final String counterparty, final SwapLeg payLeg, final SwapLeg receiveLeg, final boolean exchangeNotional) {
    super(SECURITY_TYPE, tradeDate, effectiveDate, maturityDate, counterparty, payLeg, receiveLeg);
    setExchangeNotional(exchangeNotional);
  }

  @Override
  public <T> T accept(final FinancialSecurityVisitor<T> visitor) {
    ArgumentChecker.notNull(visitor, "visitor");
    return visitor.visitZeroCouponInflationSwapSecurity(this);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ZeroCouponInflationSwapSecurity}.
   * @return the meta-bean, not null
   */
  public static ZeroCouponInflationSwapSecurity.Meta meta() {
    return ZeroCouponInflationSwapSecurity.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ZeroCouponInflationSwapSecurity.Meta.INSTANCE);
  }

  @Override
  public ZeroCouponInflationSwapSecurity.Meta metaBean() {
    return ZeroCouponInflationSwapSecurity.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1793327747:  // exchangeNotional
        return isExchangeNotional();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1793327747:  // exchangeNotional
        setExchangeNotional((Boolean) newValue);
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
      ZeroCouponInflationSwapSecurity other = (ZeroCouponInflationSwapSecurity) obj;
      return JodaBeanUtils.equal(isExchangeNotional(), other.isExchangeNotional()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(isExchangeNotional());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets is the notional exchanged
   * @return the value of the property
   */
  public boolean isExchangeNotional() {
    return _exchangeNotional;
  }

  /**
   * Sets is the notional exchanged
   * @param exchangeNotional  the new value of the property
   */
  public void setExchangeNotional(boolean exchangeNotional) {
    this._exchangeNotional = exchangeNotional;
  }

  /**
   * Gets the the {@code exchangeNotional} property.
   * @return the property, not null
   */
  public final Property<Boolean> exchangeNotional() {
    return metaBean().exchangeNotional().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ZeroCouponInflationSwapSecurity}.
   */
  public static class Meta extends SwapSecurity.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code exchangeNotional} property.
     */
    private final MetaProperty<Boolean> _exchangeNotional = DirectMetaProperty.ofReadWrite(
        this, "exchangeNotional", ZeroCouponInflationSwapSecurity.class, Boolean.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "exchangeNotional");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1793327747:  // exchangeNotional
          return _exchangeNotional;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends ZeroCouponInflationSwapSecurity> builder() {
      return new DirectBeanBuilder<ZeroCouponInflationSwapSecurity>(new ZeroCouponInflationSwapSecurity());
    }

    @Override
    public Class<? extends ZeroCouponInflationSwapSecurity> beanType() {
      return ZeroCouponInflationSwapSecurity.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code exchangeNotional} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> exchangeNotional() {
      return _exchangeNotional;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
