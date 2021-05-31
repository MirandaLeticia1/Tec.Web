<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:admin_template>
	<jsp:attribute name="content">
		<div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header card-header-primary">
                            <h4 class="card-title">Editar de Contato</h4>
                        </div>
                        <div class="card-body">
                            <form action="${pageContext.request.contextPath}/usuarioServlet?&acao=salvar"
                                  method="POST">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Nome</label>
                                            <input type="text" name="nome" class="form-control" maxlength="30"
                                                   value="${usuario.nome}"
                                                   required="required">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Login</label>
                                            <input type="text" name="login" class="form-control" maxlength="50"
                                                   value="${usuario.login}"
                                                   required="required">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Password</label>
                                            <input type="password" name="password" class="form-control" maxlength="50"
                                                   value="${usuario.password}"
                                                   required="required">
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" name="id" value="${usuario.id}">
                                <input type="submit" value="salvar" class="btn btn-sm btn-primary"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</jsp:attribute>
</mt:admin_template>


