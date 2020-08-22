package com.sebastian.czech.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ApiController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public Info info() {
        return new Info(counter.incrementAndGet());
    }

}
