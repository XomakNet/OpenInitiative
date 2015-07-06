package net.xomak.openinitiative.model.form;

/**
 * Created by regis on 06.07.2015.
 */
public class NewUserForm {
    private String login;
    private String email;
    private String password;
    private String passwordConfirmation;

    public NewUserForm() {
    }

    public NewUserForm(final String login, final String email, final String password, final String passwordConfirmation) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(final String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
