/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.security.option;

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
import org.threeten.bp.ZonedDateTime;

/**
 * The extreme spread payoff style.
 */
@BeanDefinition
public class ExtremeSpreadPayoffStyle extends PayoffStyle {

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * The period end.
   */
  @PropertyDefinition(validate = "notNull")
  private ZonedDateTime _periodEnd;
  /**
   * The reverse flag.
   */
  @PropertyDefinition
  private boolean _reverse;

  /**
   * Creates an instance.
   */
  private ExtremeSpreadPayoffStyle() {
  }

  /**
   * Creates an instance.
   * 
   * @param periodEnd  the period end, not null
   * @param reverse  whether the style is reversed
   */
  public ExtremeSpreadPayoffStyle(ZonedDateTime periodEnd, boolean reverse) {
    setPeriodEnd(periodEnd);
    setReverse(reverse);
  }

  //-------------------------------------------------------------------------
  @Override
  public <T> T accept(PayoffStyleVisitor<T> visitor) {
    return visitor.visitExtremeSpreadPayoffStyle(this);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ExtremeSpreadPayoffStyle}.
   * @return the meta-bean, not null
   */
  public static ExtremeSpreadPayoffStyle.Meta meta() {
    return ExtremeSpreadPayoffStyle.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ExtremeSpreadPayoffStyle.Meta.INSTANCE);
  }

  @Override
  public ExtremeSpreadPayoffStyle.Meta metaBean() {
    return ExtremeSpreadPayoffStyle.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 566572890:  // periodEnd
        return getPeriodEnd();
      case 1099846370:  // reverse
        return isReverse();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 566572890:  // periodEnd
        setPeriodEnd((ZonedDateTime) newValue);
        return;
      case 1099846370:  // reverse
        setReverse((Boolean) newValue);
        return;
    }
    super.propertySet(propertyName, newValue, quiet);
  }

  @Override
  protected void validate() {
    JodaBeanUtils.notNull(_periodEnd, "periodEnd");
    super.validate();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ExtremeSpreadPayoffStyle other = (ExtremeSpreadPayoffStyle) obj;
      return JodaBeanUtils.equal(getPeriodEnd(), other.getPeriodEnd()) &&
          JodaBeanUtils.equal(isReverse(), other.isReverse()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getPeriodEnd());
    hash += hash * 31 + JodaBeanUtils.hashCode(isReverse());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the period end.
   * @return the value of the property, not null
   */
  public ZonedDateTime getPeriodEnd() {
    return _periodEnd;
  }

  /**
   * Sets the period end.
   * @param periodEnd  the new value of the property, not null
   */
  public void setPeriodEnd(ZonedDateTime periodEnd) {
    JodaBeanUtils.notNull(periodEnd, "periodEnd");
    this._periodEnd = periodEnd;
  }

  /**
   * Gets the the {@code periodEnd} property.
   * @return the property, not null
   */
  public final Property<ZonedDateTime> periodEnd() {
    return metaBean().periodEnd().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the reverse flag.
   * @return the value of the property
   */
  public boolean isReverse() {
    return _reverse;
  }

  /**
   * Sets the reverse flag.
   * @param reverse  the new value of the property
   */
  public void setReverse(boolean reverse) {
    this._reverse = reverse;
  }

  /**
   * Gets the the {@code reverse} property.
   * @return the property, not null
   */
  public final Property<Boolean> reverse() {
    return metaBean().reverse().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ExtremeSpreadPayoffStyle}.
   */
  public static class Meta extends PayoffStyle.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code periodEnd} property.
     */
    private final MetaProperty<ZonedDateTime> _periodEnd = DirectMetaProperty.ofReadWrite(
        this, "periodEnd", ExtremeSpreadPayoffStyle.class, ZonedDateTime.class);
    /**
     * The meta-property for the {@code reverse} property.
     */
    private final MetaProperty<Boolean> _reverse = DirectMetaProperty.ofReadWrite(
        this, "reverse", ExtremeSpreadPayoffStyle.class, Boolean.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "periodEnd",
        "reverse");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 566572890:  // periodEnd
          return _periodEnd;
        case 1099846370:  // reverse
          return _reverse;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends ExtremeSpreadPayoffStyle> builder() {
      return new DirectBeanBuilder<ExtremeSpreadPayoffStyle>(new ExtremeSpreadPayoffStyle());
    }

    @Override
    public Class<? extends ExtremeSpreadPayoffStyle> beanType() {
      return ExtremeSpreadPayoffStyle.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code periodEnd} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ZonedDateTime> periodEnd() {
      return _periodEnd;
    }

    /**
     * The meta-property for the {@code reverse} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> reverse() {
      return _reverse;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
