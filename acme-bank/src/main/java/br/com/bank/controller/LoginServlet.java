package br.com.bank.controller;

import br.com.bank.model.Login;
import br.com.bank.model.Usuario;
import br.com.bank.service.UsuarioServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UsuarioServiceImpl usuarioService;
    Login login;

    public LoginServlet() {
        this.usuarioService = new UsuarioServiceImpl();
        this.login = new Login().getInstance();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (this.login.getUsuario() != null) {
            RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard/index.jsp");
            request.setAttribute("user", login);
            rd.forward(request, response);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (this.login.getUsuario() != null) {
            RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard/index.jsp");
            request.setAttribute("user", login);
            rd.forward(request, response);
        }

        List<Usuario> usuarios = this.usuarioService.findByLogin(login);
        Usuario usuario = usuarios.get(0);

        if (usuario.getLogin().equals(login) && pass.equals(usuario.getPassword())) {
            HttpSession session = request.getSession(false);
            session.setAttribute("login", this.login);

            RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard/index.jsp");
            request.setAttribute("user", login);
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard/index.jsp");
            request.setAttribute("error", "Erro, login ou senha inválidos");
            rd.forward(request, response);
        }
    }
}
