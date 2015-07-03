package net.xomak.openinitiative.controller;


import net.xomak.openinitiative.model.Initiative;
import net.xomak.openinitiative.model.InitiativeCategory;
import net.xomak.openinitiative.model.User;
import net.xomak.openinitiative.model.form.NewInitiative;
import net.xomak.openinitiative.service.InitiativeService;
import net.xomak.openinitiative.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/initiative")
public class InitiativeController {

    @Autowired
    InitiativeService service;

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User getUser() {
        return userService.getCurrentUser();
    }


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String categoryCreate(Model model) {

        Iterable<InitiativeCategory> categories = service.getActiveCategories();
//        Map<Long, String> categoriesMap = new HashMap<Long, String>();
//        Iterator<InitiativeCategory> categoryIterator = categories.iterator();
//        while(categoryIterator.hasNext())
//        {
//            InitiativeCategory category =
//            categoriesMap.put()
//        }
        model.addAttribute("initiative", new NewInitiative());
        model.addAttribute("categories", categories);
        return "initiative/form";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String categorySave(@Valid @ModelAttribute("initiative")NewInitiative initiative, BindingResult br, Model model) {
        if(br.hasErrors()) {
            return "initiative/form";
        }
        else {
            return "redirect:/initiative/";
        }
    }
}