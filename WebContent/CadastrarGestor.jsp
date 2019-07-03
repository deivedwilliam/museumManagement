<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de gestor</title>
</head>
<body>
	<h1>Sistema de gerenciamento de museu</h1>
	<h2>Cadastro de gestor</h2>
	<form action="efetuarLogin" method="post">
	<div class="container">
		<label>Nome completo<br></label>
		<input type="text" placeholder="Digite o nome" name="nomeUsario"/>
		<label><br>CPF<br></label>
		<input type="text" placeholder="Digite o CPF" name="cpfUser" value="${cpf}"/> <!-- Esse value deve ser verificado depois -->
		<input type="submit" name="cmd" value="Cadastrar Gestor"/>
	</div>
	
		
	</form>
</body>
</html>