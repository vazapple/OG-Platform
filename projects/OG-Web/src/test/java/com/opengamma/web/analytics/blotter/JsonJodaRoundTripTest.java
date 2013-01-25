/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.web.analytics.blotter;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.MetaBean;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;

import com.google.common.collect.ImmutableSet;
import com.opengamma.financial.convention.businessday.BusinessDayConventionFactory;
import com.opengamma.financial.convention.daycount.DayCountFactory;
import com.opengamma.financial.convention.frequency.SimpleFrequency;
import com.opengamma.financial.conversion.JodaBeanConverters;
import com.opengamma.financial.security.fx.FXForwardSecurity;
import com.opengamma.financial.security.swap.FixedInterestRateLeg;
import com.opengamma.financial.security.swap.FloatingInterestRateLeg;
import com.opengamma.financial.security.swap.FloatingRateType;
import com.opengamma.financial.security.swap.InterestRateNotional;
import com.opengamma.financial.security.swap.SwapLeg;
import com.opengamma.financial.security.swap.SwapSecurity;
import com.opengamma.id.ExternalId;
import com.opengamma.util.money.Currency;

@SuppressWarnings("unchecked")
public class JsonJodaRoundTripTest {

  static {
    JodaBeanConverters.getInstance();
  }

  @Test
  public void fxForwardRoundTrip() throws JSONException {
    ZonedDateTime forwardDate = zdt(2012, 12, 21, 10, 0, 0, 0, ZoneOffset.UTC);
    ExternalId regionId = ExternalId.of("Reg", "123");
    FXForwardSecurity fxForward = new FXForwardSecurity(Currency.USD, 150, Currency.GBP, 100, forwardDate, regionId);
    fxForward.setName("GBP/USD forward");

    JsonDataSink sink = new JsonDataSink(BlotterResource.getStringConvert());
    BeanVisitor<JSONObject> writingVisitor = new BuildingBeanVisitor<>(fxForward, sink, BlotterResource.getStringConvert());
    BeanTraverser traverser = new BeanTraverser();
    JSONObject json = (JSONObject) traverser.traverse(FXForwardSecurity.meta(), writingVisitor);
    assertNotNull(json);
    System.out.println(json);

    JsonBeanDataSource dataSource = new JsonBeanDataSource(new JSONObject(json.toString()));
    MetaBeanFactory metaBeanFactory = new MapMetaBeanFactory(ImmutableSet.<MetaBean>of(FXForwardSecurity.meta()));
    BeanVisitor<BeanBuilder<Bean>> readingVisitor =
        new BeanBuildingVisitor<>(dataSource, metaBeanFactory, BlotterResource.getStringConvert());
    BeanBuilder<FXForwardSecurity> beanBuilder =
        (BeanBuilder<FXForwardSecurity>) traverser.traverse(FXForwardSecurity.meta(), readingVisitor);
    FXForwardSecurity fxForward2 = beanBuilder.build();
    assertEquals(fxForward, fxForward2);
  }

  @Test
  public void swapRoundTrip() throws JSONException {
    ZonedDateTime tradeDate = zdt(2012, 12, 21, 10, 0, 0, 0, ZoneOffset.UTC);
    ZonedDateTime effectiveDate = zdt(2013, 1, 21, 10, 0, 0, 0, ZoneOffset.UTC);
    ZonedDateTime maturityDate = zdt(2013, 12, 21, 10, 0, 0, 0, ZoneOffset.UTC);
    SwapLeg payLeg = new FixedInterestRateLeg(
        DayCountFactory.INSTANCE.getDayCount("Act/360"),
        SimpleFrequency.MONTHLY,
        ExternalId.of("Reg", "123"),
        BusinessDayConventionFactory.INSTANCE.getBusinessDayConvention("Following"),
        new InterestRateNotional(Currency.GBP, 123),
        false,
        0.01);
    SwapLeg receiveLeg = new FloatingInterestRateLeg(
        DayCountFactory.INSTANCE.getDayCount("Act/Act"),
        SimpleFrequency.QUARTERLY,
        ExternalId.of("Reg", "123"),
        BusinessDayConventionFactory.INSTANCE.getBusinessDayConvention("Modified Following"),
        new InterestRateNotional(Currency.GBP, 234),
        false,
        ExternalId.of("Rate", "asdf"),
        FloatingRateType.IBOR);
    SwapSecurity security = new SwapSecurity(tradeDate, effectiveDate, maturityDate, "cpty", payLeg, receiveLeg);
    security.setName("Test swap");

    JsonDataSink sink = new JsonDataSink(BlotterResource.getStringConvert());
    BeanTraverser traverser = new BeanTraverser();
    BeanVisitor<JSONObject> writingVisitor = new BuildingBeanVisitor<>(security, sink, BlotterResource.getStringConvert());
    JSONObject json = (JSONObject) traverser.traverse(SwapSecurity.meta(), writingVisitor);
    assertNotNull(json);
    System.out.println(json);

    JsonBeanDataSource dataSource = new JsonBeanDataSource(new JSONObject(json.toString()));
    MetaBeanFactory metaBeanFactory = new MapMetaBeanFactory(ImmutableSet.<MetaBean>of(
        SwapSecurity.meta(),
        FixedInterestRateLeg.meta(),
        FloatingInterestRateLeg.meta(),
        InterestRateNotional.meta()));
    BeanVisitor<BeanBuilder<SwapSecurity>> readingVisitor =
        new BeanBuildingVisitor<>(dataSource, metaBeanFactory, BlotterResource.getStringConvert());
    BeanBuilder<SwapSecurity> beanBuilder =
        (BeanBuilder<SwapSecurity>) traverser.traverse(SwapSecurity.meta(), readingVisitor);
    SwapSecurity security2 = beanBuilder.build();
    assertEquals(security, security2);
  }

  //-------------------------------------------------------------------------
  private static ZonedDateTime zdt(int y, int m, int d, int hr, int min, int sec, int nanos, ZoneId zone) {
    return LocalDateTime.of(y, m, d, hr, min, sec, nanos).atZone(zone);
  }

}
