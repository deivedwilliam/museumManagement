<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usuário</title>
</head>
<body>
	<h1>Sistema de gerenciamento de museu</h1>
	<h2>Cadastro de usuário</h2>
	<form action="UsuarioActions" method="post">
		<div class="container">
			<label>Nome completo<br></label>
			<input type="text" placeholder="Digite o nome" name="nomeUsuario"/>
			<label><br>CPF<br></label>
			<input type="text" placeholder="Digite o CPF" name="cpfUsuario"/>
			<label><br>Senha<br></label> 
			<input type="password" placeholder="Digite a Senha" name="pswUsuario"/>
			<input type="submit" name="cmd" value="Cadastrar Usuario"/>
		</div>
	
		
	</form>
</body>
</html>