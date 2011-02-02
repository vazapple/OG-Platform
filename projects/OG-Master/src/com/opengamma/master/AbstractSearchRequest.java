/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.master;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.joda.beans.BeanDefinition;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.BasicMetaBean;
import org.joda.beans.impl.direct.DirectBean;
import org.joda.beans.impl.direct.DirectMetaProperty;

import com.google.common.base.Objects;
import com.opengamma.id.VersionCorrection;
import com.opengamma.util.PublicSPI;
import com.opengamma.util.db.PagingRequest;

/**
 * Request for searching for documents.
 * <p>
 * Documents will be returned that match the search criteria.
 * This abstract class provides the ability to page the results and to search
 * as at a specific version and correction instant.
 * See {@link AbstractHistoryRequest} for more details on how history works.
 */
@PublicSPI
@BeanDefinition
public abstract class AbstractSearchRequest extends DirectBean {

  /**
   * The request for paging.
   * By default all matching items will be returned.
   */
  @PropertyDefinition
  private PagingRequest _pagingRequest = PagingRequest.ALL;
  /** 
   * The version-correction locator to search at, not null.
   */
  @PropertyDefinition(set = "manual")
  private VersionCorrection _versionCorrection = VersionCorrection.LATEST;

  /**
   * Creates an instance.
   */
  public AbstractSearchRequest() {
  }

  //-------------------------------------------------------------------------
  /**
   * Sets the version-correction locator to search at, null for the latest.
   * 
   * @param versionCorrection  the version-correction, null converted to LATEST
   */
  public void setVersionCorrection(VersionCorrection versionCorrection) {
    this._versionCorrection = Objects.firstNonNull(versionCorrection, VersionCorrection.LATEST);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code AbstractSearchRequest}.
   * @return the meta-bean, not null
   */
  public static AbstractSearchRequest.Meta meta() {
    return AbstractSearchRequest.Meta.INSTANCE;
  }

  @Override
  public AbstractSearchRequest.Meta metaBean() {
    return AbstractSearchRequest.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName) {
    switch (propertyName.hashCode()) {
      case -2092032669:  // pagingRequest
        return getPagingRequest();
      case -2031293866:  // versionCorrection
        return getVersionCorrection();
    }
    return super.propertyGet(propertyName);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue) {
    switch (propertyName.hashCode()) {
      case -2092032669:  // pagingRequest
        setPagingRequest((PagingRequest) newValue);
        return;
      case -2031293866:  // versionCorrection
        setVersionCorrection((VersionCorrection) newValue);
        return;
    }
    super.propertySet(propertyName, newValue);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the request for paging.
   * By default all matching items will be returned.
   * @return the value of the property
   */
  public PagingRequest getPagingRequest() {
    return _pagingRequest;
  }

  /**
   * Sets the request for paging.
   * By default all matching items will be returned.
   * @param pagingRequest  the new value of the property
   */
  public void setPagingRequest(PagingRequest pagingRequest) {
    this._pagingRequest = pagingRequest;
  }

  /**
   * Gets the the {@code pagingRequest} property.
   * By default all matching items will be returned.
   * @return the property, not null
   */
  public final Property<PagingRequest> pagingRequest() {
    return metaBean().pagingRequest().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the version-correction locator to search at, not null.
   * @return the value of the property
   */
  public VersionCorrection getVersionCorrection() {
    return _versionCorrection;
  }

  /**
   * Gets the the {@code versionCorrection} property.
   * @return the property, not null
   */
  public final Property<VersionCorrection> versionCorrection() {
    return metaBean().versionCorrection().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code AbstractSearchRequest}.
   */
  public static class Meta extends BasicMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code pagingRequest} property.
     */
    private final MetaProperty<PagingRequest> _pagingRequest = DirectMetaProperty.ofReadWrite(this, "pagingRequest", PagingRequest.class);
    /**
     * The meta-property for the {@code versionCorrection} property.
     */
    private final MetaProperty<VersionCorrection> _versionCorrection = DirectMetaProperty.ofReadWrite(this, "versionCorrection", VersionCorrection.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<Object>> _map;

    @SuppressWarnings({"unchecked", "rawtypes" })
    protected Meta() {
      LinkedHashMap temp = new LinkedHashMap();
      temp.put("pagingRequest", _pagingRequest);
      temp.put("versionCorrection", _versionCorrection);
      _map = Collections.unmodifiableMap(temp);
    }

    @Override
    public AbstractSearchRequest createBean() {
      throw new UnsupportedOperationException("AbstractSearchRequest is an abstract class");
    }

    @Override
    public Class<? extends AbstractSearchRequest> beanType() {
      return AbstractSearchRequest.class;
    }

    @Override
    public Map<String, MetaProperty<Object>> metaPropertyMap() {
      return _map;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code pagingRequest} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<PagingRequest> pagingRequest() {
      return _pagingRequest;
    }

    /**
     * The meta-property for the {@code versionCorrection} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<VersionCorrection> versionCorrection() {
      return _versionCorrection;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
