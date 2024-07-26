package com.devsu.account.controllers;

import com.devsu.account.services.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cuentas")
public class AccountController {

    public AccountController(AccountService accountService) {
    }


}
