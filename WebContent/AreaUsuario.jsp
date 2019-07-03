<%@page import="dominio.UsuarioMD"%>
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
	<h4>Sistema de Gerenciamento de Museu</h4><br>
	Bem Vindo <%= ((UsuarioMD)request.getAttribute("Usuario")).getNome() %>!
		<br>
		<span><a href="CriarSolicitacao.jsp">Criar Solicitação de Museu</a></span>
	</div>
</body>
</html>