/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.analytics.ircurve.strips;

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

import com.opengamma.id.ExternalId;
import com.opengamma.util.ArgumentChecker;
import com.opengamma.util.time.Tenor;

/**
 * Zero-coupon inflation curve node.
 */
//TODO do we need a start tenor and maturity tenor?
@BeanDefinition
public class ZeroCouponInflationNode extends CurveNode {

  /** Serialization version */
  private static final long serialVersionUID = 1L;

  /**
   * The tenor.
   */
  @PropertyDefinition(validate = "notNull")
  private Tenor _tenor;

  /**
   * The zero-coupon convention.
   */
  @PropertyDefinition(validate = "notNull")
  private ExternalId _inflationLegConvention;

  /**
   * The fixed leg convention.
   */
  @PropertyDefinition(validate = "notNull")
  private ExternalId _fixedLegConvention;

  /**
   * Flag indicating the inflation node type.
   */
  @PropertyDefinition(validate = "notNull")
  private InflationNodeType _inflationNodeType;

  /**
   * For the builder.
   */
  /* package */ ZeroCouponInflationNode() {
    super();
  }

  /**
   * @param tenor The tenor, not null
   * @param inflationLegConvention The inflation leg convention id, not null
   * @param fixedLegConvention The fixed leg convention id, not null
   * @param inflationNodeType The inflation node type, not null
   * @param curveNodeIdMapperName The curve node id mapper name, not null
   */
  public ZeroCouponInflationNode(final Tenor tenor, final ExternalId inflationLegConvention, final ExternalId fixedLegConvention,
      final InflationNodeType inflationNodeType, final String curveNodeIdMapperName) {
    super(curveNodeIdMapperName);
    setTenor(tenor);
    setInflationLegConvention(inflationLegConvention);
    setFixedLegConvention(fixedLegConvention);
    setInflationNodeType(inflationNodeType);
  }

  /**
   * @param tenor The tenor, not null
   * @param inflationLegConvention The zero coupon convention id, not null
   * @param fixedLegConvention The fixed leg convention id, not null
   * @param inflationNodeType The inflation node type, not null
   * @param curveNodeIdMapperName The curve node id mapper name, not null
   * @param name The name, not null
   */
  public ZeroCouponInflationNode(final Tenor tenor, final ExternalId inflationLegConvention, final ExternalId fixedLegConvention,
      final InflationNodeType inflationNodeType, final String curveNodeIdMapperName, final String name) {
    super(curveNodeIdMapperName, name);
    setTenor(tenor);
    setInflationLegConvention(inflationLegConvention);
    setFixedLegConvention(fixedLegConvention);
    setInflationNodeType(inflationNodeType);
  }

  @Override
  public Tenor getResolvedMaturity() {
    return _tenor;
  }

  @Override
  public <T> T accept(final CurveNodeVisitor<T> visitor) {
    ArgumentChecker.notNull(visitor, "visitor");
    return visitor.visitZeroCouponInflationNode(this);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ZeroCouponInflationNode}.
   * @return the meta-bean, not null
   */
  public static ZeroCouponInflationNode.Meta meta() {
    return ZeroCouponInflationNode.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ZeroCouponInflationNode.Meta.INSTANCE);
  }

  @Override
  public ZeroCouponInflationNode.Meta metaBean() {
    return ZeroCouponInflationNode.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 110246592:  // tenor
        return getTenor();
      case -438961387:  // inflationLegConvention
        return getInflationLegConvention();
      case -2101140213:  // fixedLegConvention
        return getFixedLegConvention();
      case -279739482:  // inflationNodeType
        return getInflationNodeType();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 110246592:  // tenor
        setTenor((Tenor) newValue);
        return;
      case -438961387:  // inflationLegConvention
        setInflationLegConvention((ExternalId) newValue);
        return;
      case -2101140213:  // fixedLegConvention
        setFixedLegConvention((ExternalId) newValue);
        return;
      case -279739482:  // inflationNodeType
        setInflationNodeType((InflationNodeType) newValue);
        return;
    }
    super.propertySet(propertyName, newValue, quiet);
  }

  @Override
  protected void validate() {
    JodaBeanUtils.notNull(_tenor, "tenor");
    JodaBeanUtils.notNull(_inflationLegConvention, "inflationLegConvention");
    JodaBeanUtils.notNull(_fixedLegConvention, "fixedLegConvention");
    JodaBeanUtils.notNull(_inflationNodeType, "inflationNodeType");
    super.validate();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ZeroCouponInflationNode other = (ZeroCouponInflationNode) obj;
      return JodaBeanUtils.equal(getTenor(), other.getTenor()) &&
          JodaBeanUtils.equal(getInflationLegConvention(), other.getInflationLegConvention()) &&
          JodaBeanUtils.equal(getFixedLegConvention(), other.getFixedLegConvention()) &&
          JodaBeanUtils.equal(getInflationNodeType(), other.getInflationNodeType()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getTenor());
    hash += hash * 31 + JodaBeanUtils.hashCode(getInflationLegConvention());
    hash += hash * 31 + JodaBeanUtils.hashCode(getFixedLegConvention());
    hash += hash * 31 + JodaBeanUtils.hashCode(getInflationNodeType());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the tenor.
   * @return the value of the property, not null
   */
  public Tenor getTenor() {
    return _tenor;
  }

  /**
   * Sets the tenor.
   * @param tenor  the new value of the property, not null
   */
  public void setTenor(Tenor tenor) {
    JodaBeanUtils.notNull(tenor, "tenor");
    this._tenor = tenor;
  }

  /**
   * Gets the the {@code tenor} property.
   * @return the property, not null
   */
  public final Property<Tenor> tenor() {
    return metaBean().tenor().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the zero-coupon convention.
   * @return the value of the property, not null
   */
  public ExternalId getInflationLegConvention() {
    return _inflationLegConvention;
  }

  /**
   * Sets the zero-coupon convention.
   * @param inflationLegConvention  the new value of the property, not null
   */
  public void setInflationLegConvention(ExternalId inflationLegConvention) {
    JodaBeanUtils.notNull(inflationLegConvention, "inflationLegConvention");
    this._inflationLegConvention = inflationLegConvention;
  }

  /**
   * Gets the the {@code inflationLegConvention} property.
   * @return the property, not null
   */
  public final Property<ExternalId> inflationLegConvention() {
    return metaBean().inflationLegConvention().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the fixed leg convention.
   * @return the value of the property, not null
   */
  public ExternalId getFixedLegConvention() {
    return _fixedLegConvention;
  }

  /**
   * Sets the fixed leg convention.
   * @param fixedLegConvention  the new value of the property, not null
   */
  public void setFixedLegConvention(ExternalId fixedLegConvention) {
    JodaBeanUtils.notNull(fixedLegConvention, "fixedLegConvention");
    this._fixedLegConvention = fixedLegConvention;
  }

  /**
   * Gets the the {@code fixedLegConvention} property.
   * @return the property, not null
   */
  public final Property<ExternalId> fixedLegConvention() {
    return metaBean().fixedLegConvention().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets flag indicating the inflation node type.
   * @return the value of the property, not null
   */
  public InflationNodeType getInflationNodeType() {
    return _inflationNodeType;
  }

  /**
   * Sets flag indicating the inflation node type.
   * @param inflationNodeType  the new value of the property, not null
   */
  public void setInflationNodeType(InflationNodeType inflationNodeType) {
    JodaBeanUtils.notNull(inflationNodeType, "inflationNodeType");
    this._inflationNodeType = inflationNodeType;
  }

  /**
   * Gets the the {@code inflationNodeType} property.
   * @return the property, not null
   */
  public final Property<InflationNodeType> inflationNodeType() {
    return metaBean().inflationNodeType().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ZeroCouponInflationNode}.
   */
  public static class Meta extends CurveNode.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code tenor} property.
     */
    private final MetaProperty<Tenor> _tenor = DirectMetaProperty.ofReadWrite(
        this, "tenor", ZeroCouponInflationNode.class, Tenor.class);
    /**
     * The meta-property for the {@code inflationLegConvention} property.
     */
    private final MetaProperty<ExternalId> _inflationLegConvention = DirectMetaProperty.ofReadWrite(
        this, "inflationLegConvention", ZeroCouponInflationNode.class, ExternalId.class);
    /**
     * The meta-property for the {@code fixedLegConvention} property.
     */
    private final MetaProperty<ExternalId> _fixedLegConvention = DirectMetaProperty.ofReadWrite(
        this, "fixedLegConvention", ZeroCouponInflationNode.class, ExternalId.class);
    /**
     * The meta-property for the {@code inflationNodeType} property.
     */
    private final MetaProperty<InflationNodeType> _inflationNodeType = DirectMetaProperty.ofReadWrite(
        this, "inflationNodeType", ZeroCouponInflationNode.class, InflationNodeType.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "tenor",
        "inflationLegConvention",
        "fixedLegConvention",
        "inflationNodeType");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 110246592:  // tenor
          return _tenor;
        case -438961387:  // inflationLegConvention
          return _inflationLegConvention;
        case -2101140213:  // fixedLegConvention
          return _fixedLegConvention;
        case -279739482:  // inflationNodeType
          return _inflationNodeType;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends ZeroCouponInflationNode> builder() {
      return new DirectBeanBuilder<ZeroCouponInflationNode>(new ZeroCouponInflationNode());
    }

    @Override
    public Class<? extends ZeroCouponInflationNode> beanType() {
      return ZeroCouponInflationNode.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code tenor} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Tenor> tenor() {
      return _tenor;
    }

    /**
     * The meta-property for the {@code inflationLegConvention} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalId> inflationLegConvention() {
      return _inflationLegConvention;
    }

    /**
     * The meta-property for the {@code fixedLegConvention} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalId> fixedLegConvention() {
      return _fixedLegConvention;
    }

    /**
     * The meta-property for the {@code inflationNodeType} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<InflationNodeType> inflationNodeType() {
      return _inflationNodeType;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
