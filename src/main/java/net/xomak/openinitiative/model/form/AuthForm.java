package net.xomak.openinitiative.model.form;

/**
 * Created by Костя on 03.07.2015.
 */
public class AuthForm {
    String login;
    String password;

    public AuthForm() {
    }

    public AuthForm(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
