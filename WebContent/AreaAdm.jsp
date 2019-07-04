<%@page import="dominio.UsuarioMD"%>
<%@page import="dominio.MuseuMD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dados.DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dados.DTO.*" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGMuseu</title>
</head>
<body>
	
	<div class="container">
	<h2>Área Administrativa</h2><br>
	Bem Vindo <%= ((UsuarioMD)request.getAttribute("Usuario")).getNome() %>!
		<br>
		<form action="criarMuseu">
		<input type="submit" name="cmd" value="Criar Museu" >
		</form>
	</div>
</body>
</html>