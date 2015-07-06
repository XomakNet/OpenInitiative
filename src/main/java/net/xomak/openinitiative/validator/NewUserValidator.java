package net.xomak.openinitiative.validator;

import net.xomak.openinitiative.model.form.NewUserForm;
import net.xomak.openinitiative.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by regis on 06.07.2015.
 */
@Component
public class NewUserValidator implements Validator {

    @Autowired
    UserService userService;
    private static final int LOGIN_MAX_LENGTH = 15;
    private static final int LOGIN_MIN_LENGTH = 4;
    private static final int PASSWORD_MAX_LENGTH = 50;
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String LOGIN_PATTERN = "^[A-Za-z0-9-_]+$";
    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9!@-_]+$";

    public boolean supports(final Class aClass) {
        return NewUserForm.class.equals(aClass);
    }

    public void validate(final Object o, final Errors e) {
        NewUserForm data = (NewUserForm) o;
        if (data.getLogin().length() < LOGIN_MIN_LENGTH || data.getLogin().length() > LOGIN_MAX_LENGTH) {
            e.rejectValue("login", "login.length", "Логин должен содержать от " + LOGIN_MIN_LENGTH + " до " + LOGIN_MAX_LENGTH + " символов");
        } else {
            Pattern loginPattern = Pattern.compile(LOGIN_PATTERN);
            Matcher loginMatcher = loginPattern.matcher(data.getLogin());
            if(!loginMatcher.matches()) {
                e.rejectValue("login", "login.regex", "Логин содержит запрещенные символы");
            }
            else {
                if (userService.isLoginExists(data.getLogin())) {
                    e.rejectValue("login", "login.exists", "Такой логин уже существует");
                }
            }
        }

        if (data.getPassword().length() < PASSWORD_MIN_LENGTH || data.getLogin().length() > PASSWORD_MAX_LENGTH) {
            e.rejectValue("password", "password.length", "Пароль должен содержать от " + PASSWORD_MIN_LENGTH + " до " + PASSWORD_MAX_LENGTH + " символов");
        }
        else {
            Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
            Matcher passwordMatcher = passwordPattern.matcher(data.getPassword());
            if(!passwordMatcher.matches()) {
                e.rejectValue("password", "password.regex", "Пароль содержит запрещенные символы");
            }
            else {
                if (!data.getPassword().equals(data.getPasswordConfirmation())) {
                    e.rejectValue("passwordConfirmation", "passwordConfirmation.matches", "Пароль и его подтверждение не совпадают");
                }
            }
        }


        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
        Matcher emailMatcher = emailPattern.matcher(data.getEmail());
        if (!emailMatcher.matches()) {
            e.rejectValue("email", "email.regex", "Некорректный адрес электронной почты");
        }

    }
}
