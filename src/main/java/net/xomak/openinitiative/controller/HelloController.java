package net.xomak.openinitiative.controller;


import net.xomak.openinitiative.model.Attachment;
import net.xomak.openinitiative.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    AttachmentRepository repository;

    @RequestMapping("/hello")
    public ModelAndView hello() {

        System.out.println("HelloController");
        Attachment test = new Attachment("test2");
        repository.save(test);

        String output = "";

        for (Attachment attachment : repository.findAll()) {
            output += attachment;
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("msg", "Test: "+output);

        return model;

    }

}