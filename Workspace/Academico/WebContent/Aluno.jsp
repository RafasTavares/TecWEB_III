<%@page import="br.unit.rafael.academico.Classe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.unit.rafael.academico.Aluno"%>
<%@page import="br.unit.rafael.controller.AlunoController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" href="content\css\bootstrap.css" />
<script type="text/javascript" src="content\js\bootstrap.js"></script>
<script type="text/javascript" src="content\js\funcoes.js"></script>
<script type="text/javascript" src="content\js\jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alunos</title>

</head>
<body>

	<strong>Alunos</strong>
	<a href="NovoAluno.jsp">Novo Aluno</a>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Matricula</th> 
					<th>Sexo</th>
					<th>Data de nascimento</th>
					<th>Estado civil</th>
					<th>Nota</th>
					</br>
				</tr>
			</thead>
			<c:forEach items="${alunos}" var="elemento">
			<tbody>
				<tr>
					<td>${elemento.nome}</td>
					<td>${elemento.matricula}</td>
					<td>${elemento.sexo}</td>
					<td>${elemento.dtNascimento}</td>
					<td>${elemento.estadoCivil}</td>
					<td>${elemento.nota}</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
</body>
</html>