package net.xomak.openinitiative.controller;

import net.xomak.openinitiative.exception.UserFriendlyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Xomak on 11.07.2015.
 */
@Controller
public class ErrorController extends BaseController {

    @RequestMapping("error/404")
    public String notFoundError(final Model model) {
        model.addAttribute("errorTitle", "Ошибка 404");
        model.addAttribute("errorText", "Страница не найдена");
        return "error/common";
    }

    @RequestMapping("error/403")
    public String deniedError(final Model model) {
        model.addAttribute("errorTitle", "Ошибка 403");
        model.addAttribute("errorText", "Доступ запрещен");
        return "error/common";
    }

    @RequestMapping("error/400")
    public String badRequestError(final Model model) {
        model.addAttribute("errorTitle", "Ошибка 400");
        model.addAttribute("errorText", "Некорректный запрос");
        return "error/common";
    }

}
