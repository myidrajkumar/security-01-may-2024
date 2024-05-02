package com.rajkumar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notices")
public class NoticeController {

    @GetMapping("/loggedinnotice")
    public String getNoticeDaetails() {
        return "Here are the notice details from the DB";
    }
}
