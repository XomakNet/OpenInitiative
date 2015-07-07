package net.xomak.openinitiative.controller;

import net.xomak.openinitiative.model.User;
import net.xomak.openinitiative.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by regis on 06.07.2015.
 */
@Controller
public class BaseController  {
    @Autowired
    protected UserService userService;

    @ModelAttribute("user")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
