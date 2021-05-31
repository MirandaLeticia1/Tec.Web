<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="sidebar" data-color="purple" data-background-color="white"
     data-image="${pageContext.request.contextPath}/assets/img/sidebar-1.jpg">
    <div class="sidebar-wrapper">
        <ul class="nav">
            <li class="nav-item ">
                <a class="nav-link" href="${pageContext.request.contextPath}/usuarioServlet?&acao=cadastrar">
                    <i class="material-icons">fingerprint</i>
                    <p>Cadastro de Usuarios</p>
                </a>
            </li>
        </ul>
        <ul class="nav">
            <li class="nav-item ">
                <a class="nav-link" href="${pageContext.request.contextPath}/usuarioServlet?&acao=listar">
                    <i class="material-icons">fingerprint</i>
                    <p>Listar Usuarios</p>
                </a>
            </li>
        </ul>

        <ul class="nav">
            <li class="nav-item ">
                <a class="nav-link" href="${pageContext.request.contextPath}/contatosServlet?&acao=cadastrar">
                    <i class="material-icons">person</i>
                    <p>Cadastro de Contatos</p>
                </a>
            </li>
        </ul>
        <ul class="nav">
            <li class="nav-item ">
                <a class="nav-link" href="${pageContext.request.contextPath}/contatosServlet?&acao=listar">
                    <i class="material-icons">person</i>
                    <p>Listar Contatos</p>
                </a>
            </li>
        </ul>
    </div>
</div>
    