package ru.mipt.pdris.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mipt.pdris.service.MessageService;

@RestController
@RequiredArgsConstructor
public class CombineController {

    private final MessageService messageService;

    @GetMapping("/number")
    public ResponseEntity<String> saveContentWithRandomNumber() {
        return messageService.saveContentWithRandomNumber();
    }
}
