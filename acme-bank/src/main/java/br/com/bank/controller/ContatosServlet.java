package br.com.bank.controller;

import br.com.bank.model.Contato;
import br.com.bank.service.ContatoServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ContatoServlet
 */
@WebServlet("/contatosServlet")
public class ContatosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Contato contato;
    private final ContatoServiceImpl service;

    public ContatosServlet() {
        this.service = new ContatoServiceImpl();
        this.contato = new Contato();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
        switch (acao) {
            case "remover":
                Long id = Long.parseLong(request.getParameter("id"));
                this.service.delete(id);
                request.setAttribute("sucesso", "Contato: " + id + " Removido com sucesso");
                request.setAttribute("contatos", this.service.list());
                rd.forward(request, response);
                break;
            case "editar":
                RequestDispatcher edit = request.getRequestDispatcher("/admin/pages/contatos/edit_contatos.jsp");
                Contato contato = this.service.findById(Long.parseLong(request.getParameter("id")));
                request.setAttribute("contato", contato);
                edit.forward(request, response);
                break;
            case "cadastrar":
                RequestDispatcher cadastrarRd = request.getRequestDispatcher("/admin/pages/contatos/add_contatos.jsp");
                cadastrarRd.forward(request, response);
                break;
            case "listar":
                request.setAttribute("contatos", this.service.list());
                rd.forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.contato = new Contato();
        this.contato.setNome(request.getParameter("nome"));
        this.contato.setEmail(request.getParameter("email"));

        if (null == request.getParameter("id")) {
            this.service.salvar(contato);
        } else {
            this.contato.setId(Long.parseLong(request.getParameter("id")));
            this.service.update(contato);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
        request.setAttribute("sucesso", "Contato " + contato.getNome() + "salvo com sucesso");
        request.setAttribute("contatos", this.service.list());
        rd.forward(request, response);
    }
}
