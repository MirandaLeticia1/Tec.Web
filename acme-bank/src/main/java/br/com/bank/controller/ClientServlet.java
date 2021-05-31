package br.com.bank.controller;

import br.com.bank.model.Client;
import br.com.bank.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clientServlet")
public class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ClientServiceImpl service;

    public ClientServlet() {
        this.service = new ClientServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Response to client").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // PEGA OS DADOS DO REQUEST
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // MONTEI O MEU OBJETO CLIENT
        Client client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setPhone(phone);

        // SALVAR O MEU CLIENT
        this.service.save(client);

    }

}
