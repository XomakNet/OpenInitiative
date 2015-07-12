package net.xomak.openinitiative.controller;

import net.xomak.openinitiative.exception.NotAuthorizedException;
import net.xomak.openinitiative.exception.UserFriendlyException;
import net.xomak.openinitiative.model.User;
import net.xomak.openinitiative.model.message.AuthMessage;
import net.xomak.openinitiative.model.message.GenericMessage;
import net.xomak.openinitiative.service.SessionHolder;
import net.xomak.openinitiative.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by regis on 06.07.2015.
 */
@Controller
public class BaseController  {
    @Autowired
    protected UserService userService;

    @Autowired
    SessionHolder sessions;

    public String getCurrentUrl(final HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        if(request.getQueryString() != null) {
            url += "?" + request.getQueryString();
        }
        return url;
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public RedirectView notAuthorizedExceptionHandler(final HttpServletRequest request, final NotAuthorizedException exception) {
        GenericMessage authMessage = new GenericMessage("Ошибка", exception.getMessage(), GenericMessage.MessageType.DANGER);
        RedirectView rw = new RedirectView("/user/auth", true);
        //rw.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        if (outputFlashMap != null){
            outputFlashMap.put("message", authMessage);
            String returnURL = getCurrentUrl(request);
            outputFlashMap.put("returnURL", returnURL);
        }
        return rw;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(final Exception exception)  throws UserFriendlyException {
        throw new UserFriendlyException("Произошла внутренняя ошибка.");
    }

    @ExceptionHandler(UserFriendlyException.class)
    public ModelAndView handleUserFriendlyException(final UserFriendlyException exception) {
        ModelAndView model = new ModelAndView("error/common");
        model.addObject("errorTitle", "Ошибка");
        model.addObject("errorText", exception.getMessage());
        return model;
    }

    @ModelAttribute("user")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
