<%@page import="br.unit.rafael.academico.Aluno"%>
<%@page import="br.unit.rafael.controller.AdicionarController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="content\css\bootstrap.css" />
<script type="text/javascript" src="content\js\bootstrap.js"></script>
<script type="text/javascript" src="content\js\funcoes.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="content\js\jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Aluno</title>
</head>
<body style="text-align:left;">
	<form class="form-vertical" role="form" method="post"
		action="AdicionarController">
		<fieldset>
			<div class="container">
				<button class="btn btn-primary" href="Aluno.jsp">Voltar</button> </br> <strong>Novo Aluno</strong>
				<div class="control-group">
					<label class="control-label">Nome:</label>
					<div class="controls">
						<input type="text" placeholder="Insira seu nome"
							class="input-xlarge" name="nome">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Matricula:</label>
					<div class="controls">
						<input type="text" placeholder="Insira uma matricula"
							class="input-xlarge" name="matricula">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Data de Nascimento:</label>
					<div class="controls">
						<input type="text" placeholder="Insira a sua data de nascimento"
							class="input-xlarge" name="dtNascimento">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Nota:</label>
					<div class="controls">
						<input type="text" placeholder="Insira sua nota"
							class="input-xlarge" name="nota">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Sexo</label>
					<div class="controls">
						<label class="radio"> <input type="radio" name="sexo"
							value="Masculino" checked="checked"> Masculino
						</label> <label class="radio"> <input type="radio" name="sexo"
							value="Feminino"> Feminino
						</label>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">Estado Civil</label>
					<div class="controls">
						<select id="estadoCivil" name="estadoCivil" class="input-xlarge">
							<option>Solteiro</option>
							<option>Casado</option>
							<option>Divorciado</option>
							<option>União Estável</option>
						</select>
					</div>
				</div>


				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit"
							class="btn btn-primary">Salvar</button>
					</div>
				</div>
			</div>
		</fieldset>
	</form>
</body>
</html>



