<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="m02aula06.basica.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<body>
	
	<%
	String tableHeader = "<table border='1'>" + 
			"<tr>" +
				"<th>Nome</th>"+
				"<th>Cpf</th>"+
				"<th>Email</th>"+
				"<th>Data de Nascimento</th>"+
				"<th>Sexo</th>"+
				"<th>Nome Social</th>"+
				"<th>Apelido</th>"+
				"<th>Telefone</th>"+
			"</tr>";
	out.print(tableHeader);		
	String tableData="";
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	String dataNascFormatada="";
	
	List<Cliente> lista = (List<Cliente>) request.getAttribute("clientes");
	for(int i=0; i<lista.size(); i++){
		formato = new SimpleDateFormat("dd/MM/yyyy");
		if(lista.get(i).getDataNascimento()!=null) {
			dataNascFormatada = formato.format(lista.get(i).getDataNascimento());	
		}		
		tableData = "<tr>" +  
					   "<td>"+lista.get(i).getNome()+"</td>"+
					   "<td>"+lista.get(i).getCpf()+"</td>"+
					   "<td>"+lista.get(i).getEmail()+"</td>"+
					   "<td>"+dataNascFormatada+"</td>"+
					   "<td>"+lista.get(i).getSexo()+"</td>"+
					   "<td>"+lista.get(i).getNomeSocial()+"</td>"+
					   "<td>"+lista.get(i).getApelido()+"</td>"+
					   "<td>"+lista.get(i).getTelefone()+"</td>"+
					   "<td><a href='ClienteController?excluir=1&id="+ lista.get(i).getId() +"'>excluir</a></td>"+
					   "<td><a href='ClienteController?alterar=1&id="+ lista.get(i).getId() +"'>alterar</a></td>" +
					 "</tr>";
		//out.println(lista.get(i).getCpf() + "<br/>");
		out.print(tableData);
	}	
	%>
</body>
</html>