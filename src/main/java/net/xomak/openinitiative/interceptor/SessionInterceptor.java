package net.xomak.openinitiative.interceptor;

import net.xomak.openinitiative.service.SessionHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Костя on 03.07.2015.
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    SessionHolder sessions;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        sessions.putSession(request.getSession());
        return super.preHandle(request, response, handler);
    }

}