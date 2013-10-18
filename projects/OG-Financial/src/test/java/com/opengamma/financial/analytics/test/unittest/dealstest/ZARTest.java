package com.opengamma.financial.analytics.test.unittest.dealstest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;
import com.opengamma.financial.analytics.test.IRSwapSecurity;
import com.opengamma.financial.analytics.test.IRSwapTradeParser;
import com.opengamma.util.ResourceUtils;
import com.opengamma.util.test.TestGroup;
/**
 * 
 */
@Test(groups = TestGroup.UNIT)
public class ZARTest {
  private static final Logger s_logger = LoggerFactory.getLogger(ZARTest.class);
  private static final String CURRENCY="ZAR";    
  private static final String PAY_CURRENCY = "LEG1_CCY";

    public void test() throws Exception {
      IRSwapTradeParser tradeParser = new IRSwapTradeParser();
      Resource resource = ResourceUtils.createResource("classpath:com/opengamma/financial/analytics/test/Trades14Oct.csv"); 
      List<IRSwapSecurity> trades = tradeParser.parseCSVFile(resource.getURL());
      List<IRSwapSecurity> tradesClean = Lists.newArrayList(); 
      for (IRSwapSecurity irSwapSecurity : trades) {
        
        String currency = irSwapSecurity.getRawInput().getString(PAY_CURRENCY);
        if (currency.equals(CURRENCY)){
          tradesClean.add(irSwapSecurity);  
        }
        
      }
      s_logger.warn("Got {} trades", trades.size());
    }
}
