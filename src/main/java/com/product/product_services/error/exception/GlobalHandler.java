package com.product.product_services.error.exception;

import com.product.product_services.error.GlobalError;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

  @ExceptionHandler(ClientException.class)
  public ResponseEntity<GlobalError> handleClientException(ClientException e) {

    return new ResponseEntity<>(new GlobalError(e.getMessage()), HttpStatusCode.valueOf(400));
  }


}
