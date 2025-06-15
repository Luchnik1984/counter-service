package org.skypro.counter.controller;

import org.skypro.counter.service.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MyService")
public class CounterController {
    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping
    public String hello(){
        return "Hello, World!";
    }
    @GetMapping ("/counter")
    public String count(){
        counterService.countdown();
        return "Количество запросов: " +counterService.getCount();
    }

    @GetMapping("/greetings")
    public String greetings (@RequestParam("name") String name,
                             @RequestParam("lastName") String lastName){
        return " hello "+name+" "+lastName;
    }
}
