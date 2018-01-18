package icat.sinomed.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by liucong on  16-3-25-025.
 */
public class LoginFilter extends OncePerRequestFilter {

    public static final String USER_SESSION_KEY = "user";

    public static boolean isLogin(HttpSession session) {
        return session.getAttribute(USER_SESSION_KEY) != null;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        final HttpSession session = request.getSession();

        final boolean isLogin = isLogin(session);

        if (!isLogin) {
            String requestURI = request.getRequestURI();
            if (requestURI.startsWith("/api/")) {
                response.sendRedirect("/api/403");
            } else {
                response.sendRedirect("/login");

            }
        } else {
            chain.doFilter(request, response);
        }
    }


}
