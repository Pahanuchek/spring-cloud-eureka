package ru.novozhilov.service;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.novozhilov.model.Book;

@Service
public class BookProvider {

    private WebClient webClient;

    public BookProvider(ReactorLoadBalancerExchangeFilterFunction reactorLoadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(reactorLoadBalancerExchangeFilterFunction)
                .build();
    }

    public Book getRandomBook() {
        Book book = webClient.get()
                .uri("http://book-service/api/books/random")
                .retrieve()
                .bodyToMono(Book.class)
                .block();

        return book;
    }

}
