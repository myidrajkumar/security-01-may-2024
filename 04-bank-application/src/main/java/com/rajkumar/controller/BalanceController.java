package com.rajkumar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/balances")
public class BalanceController {

    @GetMapping("/loggedinbalance")
    public String getBalanceDaetails() {
        return "Here are the balance details from the DB";
    }
}
