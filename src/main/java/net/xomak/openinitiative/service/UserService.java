package net.xomak.openinitiative.service;

import net.xomak.openinitiative.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Костя on 03.07.2015.
 */
@Service
public class UserService {

    @Autowired
    SessionHolder sessions;

    public User getCurrentUser() {
        Object user = sessions.getSession().getAttribute("user");
        if(user instanceof User) {
            return (User)user;
        }
        else return null;
    }
}
