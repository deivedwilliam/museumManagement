<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dados.DTO.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Criação de Museu</title>
</head>
<body>
 <table id="tabela-solicitacoes">
        <tr>
            <th>ID solicitação</th>
            <th>Nome</th>
            <th>Data de criação</th>
            <th>Cidade</th>
            <th>CPF do gestor</th>
        </tr>

        <%
            ArrayList<SolicitacaoMuseuDTO> solicitacoes = (ArrayList<SolicitacaoMuseuDTO>) request.getAttribute("solicitacoes");
            for (SolicitacaoMuseuDTO solicitacao : solicitacoes) {
        %>
        <tr>
            <td>
                <form id="solicitacao-<%= solicitacao.getId() %>-form" action="UsuarioActions" method="post">
                    <input type="hidden" name="id" value="<%= solicitacao.getId() %>"/>
                </form>
            </td>
             <td><%= solicitacao.getId() %></td>
            <td><%= solicitacao.getNome() %></td>
            <td><%= solicitacao.getDataCriacao() %></td>
            <td><%= solicitacao.getCidade() %></td>
            <td><%= solicitacao.getCpfGestor() %></td>
            <td><input type="submit" value="Criar" name="cmd" form="solicitacao-<%= solicitacao.getId() %>-form"/></td>
        </tr>
        <%
            }
        %>
</table>
</body>
</html>