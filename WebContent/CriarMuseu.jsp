<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criação de Museu</title>
</head>
<body>
	<h1>Sistema de gerenciamento de museu</h1>
	<h2>Criação de Museu</h2>
	<form action="criarMuseu" method="post">
		<div class="container">
			<label>Escolha o museu abaixo<br></label>
			<select>
				<% for(Museu item : Solicitacoes){ %>
					<option><%=item.Nome%></option>
				<% } %>
			</select>			
			<input type="submit" name="cmd" value="Criar Museu"/>
		</div>
	</form>
</body>
</html>