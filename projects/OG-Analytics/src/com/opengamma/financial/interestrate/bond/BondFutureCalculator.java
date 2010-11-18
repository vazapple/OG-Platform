/**
 * Copyright (C) 2009 - 2010 by OpenGamma Inc.
 * 
 * Please see distribution for license.
 */
package com.opengamma.financial.interestrate.bond;

import com.opengamma.financial.interestrate.bond.definition.Bond;
import com.opengamma.math.function.Function1D;
import com.opengamma.math.rootfinding.BracketRoot;
import com.opengamma.math.rootfinding.RealSingleRootFinder;
import com.opengamma.math.rootfinding.VanWijngaardenDekkerBrentSingleRootFinder;

/**
 * 
 */
public class BondFutureCalculator {

  private static BracketRoot s_bracketRoot = new BracketRoot();
  private static final RealSingleRootFinder s_root = new VanWijngaardenDekkerBrentSingleRootFinder();

  public static double impliedRepoRate(final Bond bond, final double deliveryDate, final double cleanPrice, final double futurePrice, final double convertionFactor, final double accuredInterstFraction) {

    final Function1D<Double, Double> f = new Function1D<Double, Double>() {
      @Override
      public Double evaluate(final Double irr) {
        return netBasis(bond, deliveryDate, cleanPrice, futurePrice, convertionFactor, accuredInterstFraction, irr);
      }
    };

    final double[] range = s_bracketRoot.getBracketedPoints(f, 0.0, 0.2);
    return s_root.getRoot(f, range[0], range[1]);
  }

  public static double netBasis(final Bond bond, final double deliveryDate, final double cleanPrice, final double futurePrice, final double convertionFactor, final double accuredInterstFraction,
      final double repoRate) {
    final double invoicePrice = futurePrice * convertionFactor + bond.getCouponAnnuity().getNthPayment(0).getAmount() * accuredInterstFraction;
    final double dirtyPrice = BondPriceCalculator.dirtyPrice(bond, cleanPrice);

    double ccRate = Math.log(1 + repoRate);
    return BondPriceCalculator.forwardDirtyPrice(bond, dirtyPrice, deliveryDate, ccRate) - invoicePrice;
  }

  /**
   * The gross basis (for deliverable bonds only) is defined as gross basis = clean bond price - (futures price * conversion faction). See Choudhry M, Bond & Money Markets, p726 
   * @param cleanPrice The current quoted price of the deliverable bond
   * @param futurePrice The current quoted price of the bond futures contract 
   * @param convertionFactor The fixed convention factor for the bond 
   * @return The gross basis 
   */
  public static double grossBasis(final double cleanPrice, final double futurePrice, final double convertionFactor) {
    return cleanPrice - futurePrice * convertionFactor;
  }

}
