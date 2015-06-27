package net.xomak.openinitiative.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello() {

        System.out.println("HelloController");
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("msg", "Test");

        return model;

    }

}