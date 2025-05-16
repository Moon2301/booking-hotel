package com.hotel.booking.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class error {

    @Controller
    public class CustomErrorController implements ErrorController {

        @RequestMapping("/error")
        public String handleError() {
            
            return "error";
        }
    }
}
