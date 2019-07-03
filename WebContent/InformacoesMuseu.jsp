<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informações do Museu</title>
</head>
<body>
	<h1>Sistema de gerenciamento de museu</h1>
	<h2>Informações do Museu</h2>
	<form action="criarMuseu" method="post">
		<div class="container">
			<label>Nome: ${museu.nome} <br></label>
			<label>Data de criação: ${museu.data}<br></label>
			<label>Cidade: ${museu.cidade}<br></label>			
			<label>Estado: ${museu.estado}<br></label>			
			<label><br>CPF do Gestor: ${museu.cpfGestor}<br></label>
			<input type="submit" name="cmd" value="Confirmar a criação"/>
		</div>			
	</form>
</body>
</html>