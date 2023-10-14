package ru.mipt.pdris.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {

    private final Random random = new Random();

    public String getRandomNumber() {
        return String.valueOf(random.nextInt(100));
    }
}
