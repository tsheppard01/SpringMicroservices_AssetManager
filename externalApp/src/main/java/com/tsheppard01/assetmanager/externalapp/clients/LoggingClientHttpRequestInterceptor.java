package com.tsheppard01.assetmanager.externalapp.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

  private static Logger LOGGER = LoggerFactory
      .getLogger(LoggingClientHttpRequestInterceptor.class);

  @Override
  public ClientHttpResponse intercept(
      HttpRequest httpRequest, byte[] bytes,
      ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

    logRequestDetails(httpRequest);
    return clientHttpRequestExecution.execute(httpRequest, bytes);
  }

  private void logRequestDetails(HttpRequest httpRequest) {
    LOGGER.info("Request Method: {}", httpRequest.getMethod());
    LOGGER.info("Request URI: {}", httpRequest.getURI());
  }
}
