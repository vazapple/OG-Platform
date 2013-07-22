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
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.financial.convention.businessday.BusinessDayConvention;
import com.opengamma.financial.convention.daycount.DayCount;
import com.opengamma.financial.convention.frequency.Frequency;
import com.opengamma.id.ExternalId;
import com.opengamma.util.ArgumentChecker;

/**
 * An inflation swap leg linked to an index.
 */
@BeanDefinition
public class InflationIndexSwapLeg extends InflationLeg {

  /** Serialization version */
  private static final long serialVersionUID = 1L;

  /**
   * The external id of the index.
   */
  @PropertyDefinition(validate = "notNull")
  private ExternalId _indexId;

  /**
   * The lag.
   */
  @PropertyDefinition
  private int _lag;

  /**
   * The interpolation method.
   */
  @PropertyDefinition(validate = "notNull")
  private InterpolationMethod _interpolationMethod;

  /**
   * For the builder.
   */
  /* package */InflationIndexSwapLeg() {
    super();
  }

  /**
   * @param dayCount The day count, not null
   * @param frequency The frequency, not null
   * @param regionId The region id, not null
   * @param businessDayConvention The business day convention, not null
   * @param notional The notional, not null
   * @param isEOM True if dates follow the EOM convention
   * @param indexId The id of the index, not null
   * @param lag The quotation lag
   * @param interpolationMethod The interpolation method, not null
   */
  public InflationIndexSwapLeg(final DayCount dayCount, final Frequency frequency, final ExternalId regionId, final BusinessDayConvention businessDayConvention,
      final Notional notional, final boolean isEOM, final ExternalId indexId, final int lag, final InterpolationMethod interpolationMethod) {
    super(dayCount, frequency, regionId, businessDayConvention, notional, isEOM);
    setIndexId(indexId);
    setLag(lag);
    setInterpolationMethod(interpolationMethod);
  }

  @Override
  public <T> T accept(final SwapLegVisitor<T> visitor) {
    ArgumentChecker.notNull(visitor, "visitor");
    return visitor.visitInflationIndexSwapLeg(this);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code InflationIndexSwapLeg}.
   * @return the meta-bean, not null
   */
  public static InflationIndexSwapLeg.Meta meta() {
    return InflationIndexSwapLeg.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(InflationIndexSwapLeg.Meta.INSTANCE);
  }

  @Override
  public InflationIndexSwapLeg.Meta metaBean() {
    return InflationIndexSwapLeg.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1943291277:  // indexId
        return getIndexId();
      case 106898:  // lag
        return getLag();
      case 374385573:  // interpolationMethod
        return getInterpolationMethod();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1943291277:  // indexId
        setIndexId((ExternalId) newValue);
        return;
      case 106898:  // lag
        setLag((Integer) newValue);
        return;
      case 374385573:  // interpolationMethod
        setInterpolationMethod((InterpolationMethod) newValue);
        return;
    }
    super.propertySet(propertyName, newValue, quiet);
  }

  @Override
  protected void validate() {
    JodaBeanUtils.notNull(_indexId, "indexId");
    JodaBeanUtils.notNull(_interpolationMethod, "interpolationMethod");
    super.validate();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      InflationIndexSwapLeg other = (InflationIndexSwapLeg) obj;
      return JodaBeanUtils.equal(getIndexId(), other.getIndexId()) &&
          JodaBeanUtils.equal(getLag(), other.getLag()) &&
          JodaBeanUtils.equal(getInterpolationMethod(), other.getInterpolationMethod()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getIndexId());
    hash += hash * 31 + JodaBeanUtils.hashCode(getLag());
    hash += hash * 31 + JodaBeanUtils.hashCode(getInterpolationMethod());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the external id of the index.
   * @return the value of the property, not null
   */
  public ExternalId getIndexId() {
    return _indexId;
  }

  /**
   * Sets the external id of the index.
   * @param indexId  the new value of the property, not null
   */
  public void setIndexId(ExternalId indexId) {
    JodaBeanUtils.notNull(indexId, "indexId");
    this._indexId = indexId;
  }

  /**
   * Gets the the {@code indexId} property.
   * @return the property, not null
   */
  public final Property<ExternalId> indexId() {
    return metaBean().indexId().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the lag.
   * @return the value of the property
   */
  public int getLag() {
    return _lag;
  }

  /**
   * Sets the lag.
   * @param lag  the new value of the property
   */
  public void setLag(int lag) {
    this._lag = lag;
  }

  /**
   * Gets the the {@code lag} property.
   * @return the property, not null
   */
  public final Property<Integer> lag() {
    return metaBean().lag().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the interpolation method.
   * @return the value of the property, not null
   */
  public InterpolationMethod getInterpolationMethod() {
    return _interpolationMethod;
  }

  /**
   * Sets the interpolation method.
   * @param interpolationMethod  the new value of the property, not null
   */
  public void setInterpolationMethod(InterpolationMethod interpolationMethod) {
    JodaBeanUtils.notNull(interpolationMethod, "interpolationMethod");
    this._interpolationMethod = interpolationMethod;
  }

  /**
   * Gets the the {@code interpolationMethod} property.
   * @return the property, not null
   */
  public final Property<InterpolationMethod> interpolationMethod() {
    return metaBean().interpolationMethod().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code InflationIndexSwapLeg}.
   */
  public static class Meta extends InflationLeg.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code indexId} property.
     */
    private final MetaProperty<ExternalId> _indexId = DirectMetaProperty.ofReadWrite(
        this, "indexId", InflationIndexSwapLeg.class, ExternalId.class);
    /**
     * The meta-property for the {@code lag} property.
     */
    private final MetaProperty<Integer> _lag = DirectMetaProperty.ofReadWrite(
        this, "lag", InflationIndexSwapLeg.class, Integer.TYPE);
    /**
     * The meta-property for the {@code interpolationMethod} property.
     */
    private final MetaProperty<InterpolationMethod> _interpolationMethod = DirectMetaProperty.ofReadWrite(
        this, "interpolationMethod", InflationIndexSwapLeg.class, InterpolationMethod.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "indexId",
        "lag",
        "interpolationMethod");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1943291277:  // indexId
          return _indexId;
        case 106898:  // lag
          return _lag;
        case 374385573:  // interpolationMethod
          return _interpolationMethod;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends InflationIndexSwapLeg> builder() {
      return new DirectBeanBuilder<InflationIndexSwapLeg>(new InflationIndexSwapLeg());
    }

    @Override
    public Class<? extends InflationIndexSwapLeg> beanType() {
      return InflationIndexSwapLeg.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code indexId} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalId> indexId() {
      return _indexId;
    }

    /**
     * The meta-property for the {@code lag} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Integer> lag() {
      return _lag;
    }

    /**
     * The meta-property for the {@code interpolationMethod} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<InterpolationMethod> interpolationMethod() {
      return _interpolationMethod;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
