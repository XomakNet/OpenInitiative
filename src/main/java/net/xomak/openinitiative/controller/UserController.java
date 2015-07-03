package net.xomak.openinitiative.controller;

import net.xomak.openinitiative.model.InitiativeCategory;
import net.xomak.openinitiative.model.form.AuthFormData;
import net.xomak.openinitiative.model.form.NewInitiative;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Костя on 03.07.2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String userAuth(Model model) {
        model.addAttribute("authFormData", new AuthFormData());
        return "user/auth";
    }
}
