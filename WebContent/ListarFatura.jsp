<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="dao.Faturadao" %>
<%@ page import="Basicas.Fatura" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Faturas</title>
</head>
<body>

	<%
	FaturaDao dao = new FaturaDao();
	List<Fatura> lista = dao.listar();
	%>
	
	<table border='1' style='width: 100%;'>
		<tr>
			<td>CODIGOFATURA </td>
			<td> NOMECLIENTE </td>
			<td>DATAVENCIMENTO</td>
			<td> VALORTOTAL </td>
			<td>  NUMEROBOLETO </td>
		</tr>
	
		<% 
		for (Fatura Fatura : lista) {
		%>
		
		<tr>
			<td> <%= Fatura.getcodigoFatura() %> </td>
			<td> <%= Fatura.getnomeCliente() %> </td>
			<td> <%= Fatura.dataVencimento() %> </td>
			<td> <%= Fatura.valorTotal() %> </td>
			<td> 
			    <a href='editarContato.jsp?id=<%=contato.getId()%>'>Alterar</a> &nbsp;
				<a href='removerFatura?nomeCliente=<%=Fatura.getnomeCliente()%>'>Remover</a>
			</td>
		</tr>
		
		<%
		}
		%>
		
	</table>

</body>
</html>