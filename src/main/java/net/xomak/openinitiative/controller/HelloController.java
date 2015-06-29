package net.xomak.openinitiative.controller;


import net.xomak.openinitiative.model.*;
import net.xomak.openinitiative.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    InitiativeCategoryRepository initiativeCategoryRepository;

    @Autowired
    InitiativeRepository initiativeRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/hello")
    public ModelAndView hello() {

        ComplexText testText = new ComplexText("Complex text text text");
        User user = userRepository.findOne(1L);

        Status status = statusRepository.findOne(1L);
        Initiative test = new Initiative("Test initiative", "Test description", testText, status, 0, null, user);

        initiativeRepository.save(test);

        String output = "";

        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("msg", "Test: "+output);

        return model;

    }

}