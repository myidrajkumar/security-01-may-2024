package com.rajkumar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @GetMapping("/loggedinloan")
    public String getLoanDaetails() {
        return "Here are the loan details from the DB";
    }
}
