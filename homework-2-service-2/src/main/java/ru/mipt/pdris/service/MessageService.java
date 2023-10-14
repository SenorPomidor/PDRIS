package ru.mipt.pdris.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mipt.pdris.feign.ServiceClient;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final ServiceClient serviceClient;

    public ResponseEntity<String> saveContentWithRandomNumber() {
        return serviceClient.getRandomNumber();
    }
}
