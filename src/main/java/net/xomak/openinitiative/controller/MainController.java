package net.xomak.openinitiative.controller;

import net.xomak.openinitiative.exception.UserFriendlyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by regis on 09.07.2015.
 */
@Controller
public class MainController extends BaseController {
    @RequestMapping("/")
    public String mainPage() throws UserFriendlyException {
        return "redirect:/initiatives/";
    }
}
