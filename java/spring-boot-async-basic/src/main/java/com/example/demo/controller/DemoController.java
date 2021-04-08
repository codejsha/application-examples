package com.example.demo.controller;

import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

@RestController
public class DemoController {

    private final TaskExecutor taskExecutor;

    public DemoController(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @GetMapping("/hello")
    public Callable<String> hello() {
        return () -> "Hello world";
    }

    @GetMapping("/hello2")
    public CompletableFuture<String> hello2() {
        return CompletableFuture.supplyAsync(() -> "Hello world 2", taskExecutor);
    }
}
