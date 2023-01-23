package ua.ithillel.lesson29.homework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PingController {

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping (){
        return "ping";
    }
}
