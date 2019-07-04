<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Sistema de gerenciamento de museu</h1>
	<h2>Login</h2>
	<form action="UsuarioActions" method="post" >
	<div class = "container">
		<label>CPF<br></label>
		<input type="text" placeholder="Digite o CPF" name="cpfUsuario">
		<label><br>Senha<br></label> 
		<input type="password" placeholder="Digite a Senha" name="pswUsuario" ><br>
		<input type="submit" name="cmd" value="Entrar" >
	</div>
	<div class="container">
		<br>
		<span><a href="CadastrarUsuario.jsp">Criar um novo usuário</a></span>
	</div>
	</form>	
</body>
</html>