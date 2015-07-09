package net.xomak.openinitiative.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by regis on 09.07.2015.
 */
@Controller
public class MainController extends BaseController {
    @RequestMapping("/")
    public String mainPage() {
        return "redirect:/initiatives/";
    }
}
