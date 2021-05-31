package br.com.bank.controller;

import br.com.bank.model.Usuario;

import br.com.bank.service.UsuarioServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usuarioServlet")
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Usuario usuario;
    private final UsuarioServiceImpl service;

    public UsuarioServlet() {
        this.service = new UsuarioServiceImpl();
        this.usuario = new Usuario();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/usuarios/list_usuarios.jsp");
        switch (acao) {
            case "remover":
                Long id = Long.parseLong(request.getParameter("id"));
                this.service.delete(id);
                request.setAttribute("sucesso", "Usuario: " + id + " Removido com sucesso");
                request.setAttribute("usuarios", this.service.list());
                rd.forward(request, response);
                break;
            case "editar":
                RequestDispatcher edit = request.getRequestDispatcher("/admin/pages/usuarios/edit_usuarios.jsp");
                Usuario usuario = this.service.findById(Long.parseLong(request.getParameter("id")));
                request.setAttribute("usuario", usuario);
                edit.forward(request, response);
                break;
            case "cadastrar":
                RequestDispatcher cadastrarRd = request.getRequestDispatcher("/admin/pages/usuarios/add_usuarios.jsp");
                cadastrarRd.forward(request, response);
                break;
            case "listar":
                request.setAttribute("usuarios", this.service.list());
                rd.forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.usuario = new Usuario();
        this.usuario.setNome(request.getParameter("nome"));
        this.usuario.setLogin(request.getParameter("login"));
        this.usuario.setPassword(request.getParameter("password"));

        if (null == request.getParameter("id")) {
            this.service.salvar(usuario);
        } else {
            this.usuario.setId(Long.parseLong(request.getParameter("id")));
            this.service.update(usuario);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/usuarios/list_usuarios.jsp");
        request.setAttribute("sucesso", "Usuario " + usuario.getNome() + "salvo com sucesso");
        request.setAttribute("usuarios", this.service.list());
        rd.forward(request, response);
    }
}
