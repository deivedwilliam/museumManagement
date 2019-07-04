<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitar Criação do Museu</title>
</head>
<body>
	<h1>Sistema de gerenciamento de museu</h1>
	<h2>Solicitar Criação do Museu</h2>
	<form action="UsuarioActions" method="post">
		<div class="container">
			<label>Nome<br></label>
			<input type="text" placeholder="Digite o nome" name="nomeMuseu"/><br>
			<label>Data de Criação<br></label>
			<input type="date" name="dataCriacao"/><br>
			<label>Cidade<br></label>
			<input type="text" placeholder="Digite a cidade" name="cidadeMuseu"/><br>
			<label>Estado<br></label>
			<input type="text" placeholder="Digite o Estado" name="estadoMuseu"/>
			<label><br>Nome do Gestor<br></label>
			<input type="text" placeholder="Digite o Nome do Gestor" name="nomeGestor"/>
			<label><br>CPF do Gestor<br></label>
			<input type="text" placeholder="Digite o CPF" name="cpfGestor"/>
			<label><br>Senha<br></label> 
			<input type="password" placeholder="Digite a Senha" name="pswGestor"/><br>
			<input type="submit" name="cmd" value="Solicitar Criacao"/>
		</div>
	</form>
</body>
</html>