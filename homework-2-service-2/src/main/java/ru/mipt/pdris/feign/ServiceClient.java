package ru.mipt.pdris.feign;

import feign.RequestLine;
import org.springframework.http.ResponseEntity;

public interface ServiceClient {

    @RequestLine("GET /random/number")
    ResponseEntity<String> getRandomNumber();
}
