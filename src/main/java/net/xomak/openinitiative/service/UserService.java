package net.xomak.openinitiative.service;

import net.xomak.openinitiative.exception.InternalErrorException;
import net.xomak.openinitiative.exception.NotAuthorizedException;
import net.xomak.openinitiative.model.User;
import net.xomak.openinitiative.model.UserRole;
import net.xomak.openinitiative.repository.UserRepository;
import net.xomak.openinitiative.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Костя on 03.07.2015.
 */
@Service
public class UserService {

    //TODO: Move to app config
    private static final long DEFAULT_ROLE_ID = 1;

    @Autowired
    SessionHolder sessions;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository roleRepository;

    private String hashPassword(final String password) throws InternalErrorException {
        try {
            byte[] bytesOfMessage = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            //byte[] digestBytes = md.digest(bytesOfMessage);
            md.update(password.getBytes(), 0, password.length());
            return new BigInteger(1, md.digest()).toString(16);
        }
        catch(UnsupportedEncodingException e) {
            throw new InternalErrorException("Не найдена кодировка для хеширования пароля");
        }
        catch(NoSuchAlgorithmException e) {
            throw new InternalErrorException("Проблемы с алгоритмом хеширования пароля");
        }
    }

    public boolean authByLoginAndPassword(String login, String password) throws InternalErrorException {
        User user = userRepository.findByLoginAndPasswordHash(login, hashPassword(password));
        if(user != null) {
            user.getRole();
            sessions.getSession().setAttribute("user", user);
            return true;
        }
        else return false;
    }

    public User getCurrentUser() {
        Object user = sessions.getSession().getAttribute("user");
        if(user instanceof User) {
            return (User)user;
        }
        else return null;
    }

    public boolean isAuthorized() {
        if(getCurrentUser() != null) return true;
        else return false;
    }

    public void logout() {
        if(isAuthorized()) sessions.getSession().removeAttribute("user");
    }

    public void assertIsAuthorized(String message) throws NotAuthorizedException {
        if(!this.isAuthorized()) throw new NotAuthorizedException(message);
    }

    @Transactional
    public void createUser(String name, String email, String password) throws InternalErrorException {
        UserRole role = roleRepository.findById(DEFAULT_ROLE_ID);
        User newUser = new User(name, email, role, this.hashPassword(password));
        userRepository.save(newUser);
    }

    public UserRole createRole(String name, boolean isAdministrator, boolean isResponcer) {
        UserRole role = new UserRole("Пользователь", false, false);
        return roleRepository.save(role);
    }

    public boolean isLoginExists(String login) {
        if(userRepository.findByLogin(login) != null) {
            return true;
        }
        else return false;
    }

    public User getUserById(long id) {
        return userRepository.findOne(id);
    }



}
