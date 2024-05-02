package com.rajkumar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

    @GetMapping("/loggedincard")
    public String getCardDaetails() {
        return "Here are the card details from the DB";
    }
}
