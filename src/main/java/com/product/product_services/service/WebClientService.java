package com.product.product_services.service;

import com.product.product_services.error.GlobalError;
import com.product.product_services.error.exception.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {

  private final WebClient.Builder webClient;

  public void addProductToStore(int productId, int storeId, int quantity) {

    webClient
        .build()
        .post()
        .uri(
            "http://localhost:8080/stocks/add",
            uriBuilder ->
                uriBuilder
                    .queryParam("storeId", storeId)
                    .queryParam("productId", productId)
                    .queryParam("quantity", quantity)
                    .build())
        .retrieve()
        .onStatus(
            HttpStatusCode::isError,
            clientResponse ->
                clientResponse
                    .bodyToMono(GlobalError.class)
                    .flatMap(
                        globalError -> Mono.error(new ClientException(globalError.getMessage()))))
        .bodyToMono(String.class)
        .block();
  }
}
