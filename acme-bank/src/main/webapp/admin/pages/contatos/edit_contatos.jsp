<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:admin_template>
	
	<jsp:attribute name="content">
        <script
                src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js">
        </script>
		<div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header card-header-primary">
                            <h4 class="card-title">Editar de Contato</h4>
                        </div>
                        <div class="card-body">
                            <form action="${pageContext.request.contextPath}/contatosServlet?&acao=editar"
                                  method="POST">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Nome</label>
                                            <input type="text" name="nome" class="form-control" maxlength="30"
                                                   value="${contato.nome}"
                                                   required="required">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Email</label>
                                            <input type="email" name="email" class="form-control" maxlength="50"
                                                   value="${contato.email}"
                                                   required="required">
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" name="id" value="${contato.id}">
                                <input type="submit" value="salvar" class="btn btn-sm btn-primary"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</jsp:attribute>

</mt:admin_template>


