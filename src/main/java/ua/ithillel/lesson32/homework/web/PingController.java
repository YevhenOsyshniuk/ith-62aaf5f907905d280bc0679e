package ua.ithillel.lesson32.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PingController {

    @RequestMapping(path = "/ok", method = RequestMethod.GET)
    @ResponseBody
    public String ping() {
        return "ok";
    }
}
