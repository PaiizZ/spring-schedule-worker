package com.example.ooo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
//        rts.scheduleAt("test", ZonedDateTime.now().plusSeconds(5L).toInstant());
//        rts.scheduleAt("test", ZonedDateTime.now().plusSeconds(5L).toInstant());

        return "";
    }
}
