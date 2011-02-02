/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.view.rest;

import java.util.concurrent.ExecutorService;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.fudgemsg.FudgeContext;

import com.opengamma.OpenGammaRuntimeException;
import com.opengamma.engine.view.ViewProcessor;
import com.opengamma.util.SingletonFactoryBean;

/**
 * Spring helper for {@link DataViewProcessorsResource}.
 */
public class RestViewProcessorFactoryBean extends SingletonFactoryBean<DataViewProcessorsResource> {

  private ViewProcessor _viewProcessor;
  private ActiveMQConnectionFactory _connectionFactory;
  private String _topicPrefix;
  private FudgeContext _fudgeContext;
  private ExecutorService _executorService;
   
  public ViewProcessor getViewProcessor() {
    return _viewProcessor;
  }

  public void setViewProcessor(ViewProcessor viewProcessor) {
    _viewProcessor = viewProcessor;
  }

  public ActiveMQConnectionFactory getConnectionFactory() {
    return _connectionFactory;
  }

  public void setConnectionFactory(ActiveMQConnectionFactory connectionFactory) {
    _connectionFactory = connectionFactory;
  }

  public String getTopicPrefix() {
    return _topicPrefix;
  }

  public void setTopicPrefix(String topicPrefix) {
    _topicPrefix = topicPrefix;
  }
  
  public FudgeContext getFudgeContext() {
    return _fudgeContext;
  }
  
  public void setFudgeContext(FudgeContext fudgeContext) {
    _fudgeContext = fudgeContext;
  }
  
  public ExecutorService getExecutorService() {
    return _executorService;
  }
  
  public void setExecutorService(ExecutorService executorService) {
    _executorService = executorService;
  }

  @Override
  protected DataViewProcessorsResource createObject() {
    if (_viewProcessor == null) {
      throw new OpenGammaRuntimeException("The viewProcessor property must be set");
    }
    if (_connectionFactory == null) {
      throw new OpenGammaRuntimeException("The connectionFactory property must be set");
    }
    if (_topicPrefix == null) {
      throw new OpenGammaRuntimeException("The topicPrefix property must be set");
    }
    if (_executorService == null) {
      throw new OpenGammaRuntimeException("The executorService property must be set");
    }
    
    DataViewProcessorsResource resource = new DataViewProcessorsResource();
    resource.addViewProcessor(DataViewProcessorsResource.DEFAULT_VIEW_PROCESSOR_NAME, getViewProcessor(), getConnectionFactory(), getTopicPrefix(), getFudgeContext(), getExecutorService());
    return resource;
  }

}
