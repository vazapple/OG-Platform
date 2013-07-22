/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.convention;

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
import org.threeten.bp.LocalTime;

import com.opengamma.financial.convention.businessday.BusinessDayConvention;
import com.opengamma.financial.convention.daycount.DayCount;
import com.opengamma.id.ExternalId;
import com.opengamma.id.ExternalIdBundle;
import com.opengamma.util.money.Currency;

/**
 * Convention for ibor indices.
 */
@BeanDefinition
public class IborIndexConvention extends Convention {

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * The day count.
   */
  @PropertyDefinition(validate = "notNull")
  private DayCount _dayCount;

  /**
   * The business day convention.
   */
  @PropertyDefinition(validate = "notNull")
  private BusinessDayConvention _businessDayConvention;

  /**
   * The number of settlement days.
   */
  @PropertyDefinition
  private int _settlementDays;

  /**
   * Should dates follow the end-of-month rule.
   */
  @PropertyDefinition
  private boolean _isEOM;

  /**
   * The currency.
   */
  @PropertyDefinition(validate = "notNull")
  private Currency _currency;

  /**
   * The fixing time.
   */
  @PropertyDefinition(validate = "notNull")
  private LocalTime _fixingTime;

  /**
   * The fixing time zone.
   */
  @PropertyDefinition(validate = "notNull")
  private String _fixingTimeZone;

  /**
   * The fixing calendar.
   */
  @PropertyDefinition(validate = "notNull")
  private ExternalId _fixingCalendar;

  /**
   * The region calendar.
   */
  @PropertyDefinition(validate = "notNull")
  private ExternalId _regionCalendar;

  /**
   * The fixing page information.
   */
  @PropertyDefinition(validate = "notNull")
  private String _fixingPage;

  /**
   * For the builder
   */
  /* package */ IborIndexConvention() {
    super();
  }

  /**
   * @param name The convention name, not null
   * @param externalIdBundle The external identifiers for this convention, not null
   * @param dayCount The day-count, not null
   * @param businessDayConvention The business-day convention, not null
   * @param settlementDays The settlement days
   * @param isEOM True if dates follow the end-of-month rule
   * @param currency The currency, not null
   * @param fixingTime The fixing time, not null
   * @param fixingTimeZone The fixing time zone, not null
   * @param fixingCalendar The fixing calendar, not null
   * @param regionCalendar The region calendar, not null
   * @param fixingPage The fixing page name, not null
   */
  public IborIndexConvention(final String name, final ExternalIdBundle externalIdBundle, final DayCount dayCount, final BusinessDayConvention businessDayConvention,
      final int settlementDays, final boolean isEOM, final Currency currency, final LocalTime fixingTime, final String fixingTimeZone, final ExternalId fixingCalendar,
      final ExternalId regionCalendar, final String fixingPage) {
    super(name, externalIdBundle);
    setDayCount(dayCount);
    setBusinessDayConvention(businessDayConvention);
    setSettlementDays(settlementDays);
    setIsEOM(isEOM);
    setCurrency(currency);
    setFixingTime(fixingTime);
    setFixingTimeZone(fixingTimeZone);
    setFixingCalendar(fixingCalendar);
    setRegionCalendar(regionCalendar);
    setFixingPage(fixingPage);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code IborIndexConvention}.
   * @return the meta-bean, not null
   */
  public static IborIndexConvention.Meta meta() {
    return IborIndexConvention.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(IborIndexConvention.Meta.INSTANCE);
  }

  @Override
  public IborIndexConvention.Meta metaBean() {
    return IborIndexConvention.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1905311443:  // dayCount
        return getDayCount();
      case -1002835891:  // businessDayConvention
        return getBusinessDayConvention();
      case -295948000:  // settlementDays
        return getSettlementDays();
      case 100464505:  // isEOM
        return isIsEOM();
      case 575402001:  // currency
        return getCurrency();
      case 1255686170:  // fixingTime
        return getFixingTime();
      case -1504625946:  // fixingTimeZone
        return getFixingTimeZone();
      case 394230283:  // fixingCalendar
        return getFixingCalendar();
      case 1932874322:  // regionCalendar
        return getRegionCalendar();
      case 1255559132:  // fixingPage
        return getFixingPage();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1905311443:  // dayCount
        setDayCount((DayCount) newValue);
        return;
      case -1002835891:  // businessDayConvention
        setBusinessDayConvention((BusinessDayConvention) newValue);
        return;
      case -295948000:  // settlementDays
        setSettlementDays((Integer) newValue);
        return;
      case 100464505:  // isEOM
        setIsEOM((Boolean) newValue);
        return;
      case 575402001:  // currency
        setCurrency((Currency) newValue);
        return;
      case 1255686170:  // fixingTime
        setFixingTime((LocalTime) newValue);
        return;
      case -1504625946:  // fixingTimeZone
        setFixingTimeZone((String) newValue);
        return;
      case 394230283:  // fixingCalendar
        setFixingCalendar((ExternalId) newValue);
        return;
      case 1932874322:  // regionCalendar
        setRegionCalendar((ExternalId) newValue);
        return;
      case 1255559132:  // fixingPage
        setFixingPage((String) newValue);
        return;
    }
    super.propertySet(propertyName, newValue, quiet);
  }

  @Override
  protected void validate() {
    JodaBeanUtils.notNull(_dayCount, "dayCount");
    JodaBeanUtils.notNull(_businessDayConvention, "businessDayConvention");
    JodaBeanUtils.notNull(_currency, "currency");
    JodaBeanUtils.notNull(_fixingTime, "fixingTime");
    JodaBeanUtils.notNull(_fixingTimeZone, "fixingTimeZone");
    JodaBeanUtils.notNull(_fixingCalendar, "fixingCalendar");
    JodaBeanUtils.notNull(_regionCalendar, "regionCalendar");
    JodaBeanUtils.notNull(_fixingPage, "fixingPage");
    super.validate();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      IborIndexConvention other = (IborIndexConvention) obj;
      return JodaBeanUtils.equal(getDayCount(), other.getDayCount()) &&
          JodaBeanUtils.equal(getBusinessDayConvention(), other.getBusinessDayConvention()) &&
          JodaBeanUtils.equal(getSettlementDays(), other.getSettlementDays()) &&
          JodaBeanUtils.equal(isIsEOM(), other.isIsEOM()) &&
          JodaBeanUtils.equal(getCurrency(), other.getCurrency()) &&
          JodaBeanUtils.equal(getFixingTime(), other.getFixingTime()) &&
          JodaBeanUtils.equal(getFixingTimeZone(), other.getFixingTimeZone()) &&
          JodaBeanUtils.equal(getFixingCalendar(), other.getFixingCalendar()) &&
          JodaBeanUtils.equal(getRegionCalendar(), other.getRegionCalendar()) &&
          JodaBeanUtils.equal(getFixingPage(), other.getFixingPage()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getDayCount());
    hash += hash * 31 + JodaBeanUtils.hashCode(getBusinessDayConvention());
    hash += hash * 31 + JodaBeanUtils.hashCode(getSettlementDays());
    hash += hash * 31 + JodaBeanUtils.hashCode(isIsEOM());
    hash += hash * 31 + JodaBeanUtils.hashCode(getCurrency());
    hash += hash * 31 + JodaBeanUtils.hashCode(getFixingTime());
    hash += hash * 31 + JodaBeanUtils.hashCode(getFixingTimeZone());
    hash += hash * 31 + JodaBeanUtils.hashCode(getFixingCalendar());
    hash += hash * 31 + JodaBeanUtils.hashCode(getRegionCalendar());
    hash += hash * 31 + JodaBeanUtils.hashCode(getFixingPage());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the day count.
   * @return the value of the property, not null
   */
  public DayCount getDayCount() {
    return _dayCount;
  }

  /**
   * Sets the day count.
   * @param dayCount  the new value of the property, not null
   */
  public void setDayCount(DayCount dayCount) {
    JodaBeanUtils.notNull(dayCount, "dayCount");
    this._dayCount = dayCount;
  }

  /**
   * Gets the the {@code dayCount} property.
   * @return the property, not null
   */
  public final Property<DayCount> dayCount() {
    return metaBean().dayCount().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the business day convention.
   * @return the value of the property, not null
   */
  public BusinessDayConvention getBusinessDayConvention() {
    return _businessDayConvention;
  }

  /**
   * Sets the business day convention.
   * @param businessDayConvention  the new value of the property, not null
   */
  public void setBusinessDayConvention(BusinessDayConvention businessDayConvention) {
    JodaBeanUtils.notNull(businessDayConvention, "businessDayConvention");
    this._businessDayConvention = businessDayConvention;
  }

  /**
   * Gets the the {@code businessDayConvention} property.
   * @return the property, not null
   */
  public final Property<BusinessDayConvention> businessDayConvention() {
    return metaBean().businessDayConvention().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the number of settlement days.
   * @return the value of the property
   */
  public int getSettlementDays() {
    return _settlementDays;
  }

  /**
   * Sets the number of settlement days.
   * @param settlementDays  the new value of the property
   */
  public void setSettlementDays(int settlementDays) {
    this._settlementDays = settlementDays;
  }

  /**
   * Gets the the {@code settlementDays} property.
   * @return the property, not null
   */
  public final Property<Integer> settlementDays() {
    return metaBean().settlementDays().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets should dates follow the end-of-month rule.
   * @return the value of the property
   */
  public boolean isIsEOM() {
    return _isEOM;
  }

  /**
   * Sets should dates follow the end-of-month rule.
   * @param isEOM  the new value of the property
   */
  public void setIsEOM(boolean isEOM) {
    this._isEOM = isEOM;
  }

  /**
   * Gets the the {@code isEOM} property.
   * @return the property, not null
   */
  public final Property<Boolean> isEOM() {
    return metaBean().isEOM().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency.
   * @return the value of the property, not null
   */
  public Currency getCurrency() {
    return _currency;
  }

  /**
   * Sets the currency.
   * @param currency  the new value of the property, not null
   */
  public void setCurrency(Currency currency) {
    JodaBeanUtils.notNull(currency, "currency");
    this._currency = currency;
  }

  /**
   * Gets the the {@code currency} property.
   * @return the property, not null
   */
  public final Property<Currency> currency() {
    return metaBean().currency().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the fixing time.
   * @return the value of the property, not null
   */
  public LocalTime getFixingTime() {
    return _fixingTime;
  }

  /**
   * Sets the fixing time.
   * @param fixingTime  the new value of the property, not null
   */
  public void setFixingTime(LocalTime fixingTime) {
    JodaBeanUtils.notNull(fixingTime, "fixingTime");
    this._fixingTime = fixingTime;
  }

  /**
   * Gets the the {@code fixingTime} property.
   * @return the property, not null
   */
  public final Property<LocalTime> fixingTime() {
    return metaBean().fixingTime().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the fixing time zone.
   * @return the value of the property, not null
   */
  public String getFixingTimeZone() {
    return _fixingTimeZone;
  }

  /**
   * Sets the fixing time zone.
   * @param fixingTimeZone  the new value of the property, not null
   */
  public void setFixingTimeZone(String fixingTimeZone) {
    JodaBeanUtils.notNull(fixingTimeZone, "fixingTimeZone");
    this._fixingTimeZone = fixingTimeZone;
  }

  /**
   * Gets the the {@code fixingTimeZone} property.
   * @return the property, not null
   */
  public final Property<String> fixingTimeZone() {
    return metaBean().fixingTimeZone().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the fixing calendar.
   * @return the value of the property, not null
   */
  public ExternalId getFixingCalendar() {
    return _fixingCalendar;
  }

  /**
   * Sets the fixing calendar.
   * @param fixingCalendar  the new value of the property, not null
   */
  public void setFixingCalendar(ExternalId fixingCalendar) {
    JodaBeanUtils.notNull(fixingCalendar, "fixingCalendar");
    this._fixingCalendar = fixingCalendar;
  }

  /**
   * Gets the the {@code fixingCalendar} property.
   * @return the property, not null
   */
  public final Property<ExternalId> fixingCalendar() {
    return metaBean().fixingCalendar().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the region calendar.
   * @return the value of the property, not null
   */
  public ExternalId getRegionCalendar() {
    return _regionCalendar;
  }

  /**
   * Sets the region calendar.
   * @param regionCalendar  the new value of the property, not null
   */
  public void setRegionCalendar(ExternalId regionCalendar) {
    JodaBeanUtils.notNull(regionCalendar, "regionCalendar");
    this._regionCalendar = regionCalendar;
  }

  /**
   * Gets the the {@code regionCalendar} property.
   * @return the property, not null
   */
  public final Property<ExternalId> regionCalendar() {
    return metaBean().regionCalendar().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the fixing page information.
   * @return the value of the property, not null
   */
  public String getFixingPage() {
    return _fixingPage;
  }

  /**
   * Sets the fixing page information.
   * @param fixingPage  the new value of the property, not null
   */
  public void setFixingPage(String fixingPage) {
    JodaBeanUtils.notNull(fixingPage, "fixingPage");
    this._fixingPage = fixingPage;
  }

  /**
   * Gets the the {@code fixingPage} property.
   * @return the property, not null
   */
  public final Property<String> fixingPage() {
    return metaBean().fixingPage().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code IborIndexConvention}.
   */
  public static class Meta extends Convention.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code dayCount} property.
     */
    private final MetaProperty<DayCount> _dayCount = DirectMetaProperty.ofReadWrite(
        this, "dayCount", IborIndexConvention.class, DayCount.class);
    /**
     * The meta-property for the {@code businessDayConvention} property.
     */
    private final MetaProperty<BusinessDayConvention> _businessDayConvention = DirectMetaProperty.ofReadWrite(
        this, "businessDayConvention", IborIndexConvention.class, BusinessDayConvention.class);
    /**
     * The meta-property for the {@code settlementDays} property.
     */
    private final MetaProperty<Integer> _settlementDays = DirectMetaProperty.ofReadWrite(
        this, "settlementDays", IborIndexConvention.class, Integer.TYPE);
    /**
     * The meta-property for the {@code isEOM} property.
     */
    private final MetaProperty<Boolean> _isEOM = DirectMetaProperty.ofReadWrite(
        this, "isEOM", IborIndexConvention.class, Boolean.TYPE);
    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<Currency> _currency = DirectMetaProperty.ofReadWrite(
        this, "currency", IborIndexConvention.class, Currency.class);
    /**
     * The meta-property for the {@code fixingTime} property.
     */
    private final MetaProperty<LocalTime> _fixingTime = DirectMetaProperty.ofReadWrite(
        this, "fixingTime", IborIndexConvention.class, LocalTime.class);
    /**
     * The meta-property for the {@code fixingTimeZone} property.
     */
    private final MetaProperty<String> _fixingTimeZone = DirectMetaProperty.ofReadWrite(
        this, "fixingTimeZone", IborIndexConvention.class, String.class);
    /**
     * The meta-property for the {@code fixingCalendar} property.
     */
    private final MetaProperty<ExternalId> _fixingCalendar = DirectMetaProperty.ofReadWrite(
        this, "fixingCalendar", IborIndexConvention.class, ExternalId.class);
    /**
     * The meta-property for the {@code regionCalendar} property.
     */
    private final MetaProperty<ExternalId> _regionCalendar = DirectMetaProperty.ofReadWrite(
        this, "regionCalendar", IborIndexConvention.class, ExternalId.class);
    /**
     * The meta-property for the {@code fixingPage} property.
     */
    private final MetaProperty<String> _fixingPage = DirectMetaProperty.ofReadWrite(
        this, "fixingPage", IborIndexConvention.class, String.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "dayCount",
        "businessDayConvention",
        "settlementDays",
        "isEOM",
        "currency",
        "fixingTime",
        "fixingTimeZone",
        "fixingCalendar",
        "regionCalendar",
        "fixingPage");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1905311443:  // dayCount
          return _dayCount;
        case -1002835891:  // businessDayConvention
          return _businessDayConvention;
        case -295948000:  // settlementDays
          return _settlementDays;
        case 100464505:  // isEOM
          return _isEOM;
        case 575402001:  // currency
          return _currency;
        case 1255686170:  // fixingTime
          return _fixingTime;
        case -1504625946:  // fixingTimeZone
          return _fixingTimeZone;
        case 394230283:  // fixingCalendar
          return _fixingCalendar;
        case 1932874322:  // regionCalendar
          return _regionCalendar;
        case 1255559132:  // fixingPage
          return _fixingPage;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends IborIndexConvention> builder() {
      return new DirectBeanBuilder<IborIndexConvention>(new IborIndexConvention());
    }

    @Override
    public Class<? extends IborIndexConvention> beanType() {
      return IborIndexConvention.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code dayCount} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<DayCount> dayCount() {
      return _dayCount;
    }

    /**
     * The meta-property for the {@code businessDayConvention} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<BusinessDayConvention> businessDayConvention() {
      return _businessDayConvention;
    }

    /**
     * The meta-property for the {@code settlementDays} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Integer> settlementDays() {
      return _settlementDays;
    }

    /**
     * The meta-property for the {@code isEOM} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> isEOM() {
      return _isEOM;
    }

    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Currency> currency() {
      return _currency;
    }

    /**
     * The meta-property for the {@code fixingTime} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<LocalTime> fixingTime() {
      return _fixingTime;
    }

    /**
     * The meta-property for the {@code fixingTimeZone} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> fixingTimeZone() {
      return _fixingTimeZone;
    }

    /**
     * The meta-property for the {@code fixingCalendar} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalId> fixingCalendar() {
      return _fixingCalendar;
    }

    /**
     * The meta-property for the {@code regionCalendar} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalId> regionCalendar() {
      return _regionCalendar;
    }

    /**
     * The meta-property for the {@code fixingPage} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> fixingPage() {
      return _fixingPage;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
