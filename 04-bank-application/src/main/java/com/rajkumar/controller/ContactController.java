package com.rajkumar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    @GetMapping("/loggedincontact")
    public String getContactDaetails() {
        return "Here are the contact details from the DB";
    }
}
