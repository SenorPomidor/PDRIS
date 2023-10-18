package ru.mipt.pdris.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mipt.pdris.service.RandomService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/random")
public class RandomController {

    private final RandomService randomService;

    @GetMapping("/number")
    public String getRandomNumber() {
        return randomService.getRandomNumber();
    }
}
