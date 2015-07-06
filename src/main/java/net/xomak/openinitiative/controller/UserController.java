package net.xomak.openinitiative.controller;

import net.xomak.openinitiative.exception.InternalErrorException;
import net.xomak.openinitiative.model.form.AuthForm;
import net.xomak.openinitiative.model.form.NewUserForm;
import net.xomak.openinitiative.model.message.GenericMessage;
import net.xomak.openinitiative.validator.NewUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Костя on 03.07.2015.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    NewUserValidator newUserValidator;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String userAuthPage(Model model) {
        model.addAttribute("authFormData", new AuthForm());
        return "user/auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String userAuth(@ModelAttribute("authFormData") AuthForm authFormData, Model model) throws InternalErrorException {
        boolean result = userService.authByLoginAndPassword(authFormData.getLogin(), authFormData.getPassword());
        if(!result) {
            model.addAttribute("message", new GenericMessage("Авторизация не удалась", "Неправильный логин или пароль", GenericMessage.MessageType.DANGER));
        }
        return "user/auth";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String userNewPage(Model model) {
        model.addAttribute("newUserForm", new NewUserForm());
        return "user/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String userNew(@ModelAttribute("newUserForm")NewUserForm form, BindingResult br, Model model) throws InternalErrorException{
        newUserValidator.validate(form, br);
        if(br.hasErrors()) {
            return "user/new";
        }
        else {
            userService.createUser(form.getLogin(), form.getEmail(), form.getPassword());
            return "redirect:/category/";
        }
    }
}
