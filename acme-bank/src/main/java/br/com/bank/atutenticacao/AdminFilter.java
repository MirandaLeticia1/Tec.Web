package br.com.bank.atutenticacao;

import br.com.bank.model.Login;
import br.com.bank.service.UsuarioServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/*")
public class AdminFilter implements Filter {

    private HttpServletRequest httpRequest;
    Login login;

    public AdminFilter() {
        this.login = new Login().getInstance();
    }

    private static final String[] loginRequiredURLs = {
            "/view_profile", "/edit_profile", "/update_profile"
    };

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        if (path.startsWith("/admin/")) {
            chain.doFilter(request, response);
            return;
        }

        boolean isLoggedIn = (this.login.getUsuario() != null);
        String loginURI = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the user is already logged in and he's trying to login again
            // then forward to the homepage
            httpRequest.getRequestDispatcher("/").forward(request, response);

        } else if (!isLoggedIn && isLoginRequired()) {
            // the user is not logged in, and the requested page requires
            // authentication, then forward to the login page
            String loginPage = "/login.jsp";
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request, response);
        } else {
            // for other requested pages that do not require authentication
            // or the user is already logged in, continue to the destination
            chain.doFilter(request, response);
        }
    }

    private boolean isLoginRequired() {
        String requestURL = httpRequest.getRequestURL().toString();

        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }

        return false;
    }

    public void destroy() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
