package net.xomak.openinitiative.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Костя on 03.07.2015.
 */
@Service
public class SessionHolder {
    private ThreadLocal<HttpSession> sessions = new ThreadLocal<HttpSession>();
    public HttpSession getSession() {
        return sessions.get();
    }

    public void putSession(final HttpSession session) {
        sessions.set(session);
    }
}
