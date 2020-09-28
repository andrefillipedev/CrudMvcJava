<%@page import="m02aula06.basica.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar Cadastro Cliente</title>
	</head>
	<body>
		<h1>Alterar Cadastro Cliente</h1>
		<%
		Cliente cliente = (Cliente) request.getAttribute("cliente");
		%>
		<form action="ClienteController" method="POST">
			<input type="hidden" name="action" value="alterar"/>
			<input type="hidden" name="id" value="1"/>
			<label for="nome">Nome:*</label>
			<input type="text" name="nome" id="nome" required="required" value="<% if(cliente.getNome()!=null) { out.print(cliente.getNome()); } %>" /><br/>
				
			<label for="cpf">CPF:*</label>
			<input type="text" name="cpf" id="cpf" required="required" value="<% if(cliente.getCpf()!=null) { out.print(cliente.getCpf()); } %>" /><br/>
				
			<label for="email">E-mail:*</label>
			<input type="text" name="email" id="email" required="required" value="<% if(cliente.getEmail()!=null) { out.print(cliente.getEmail()); } %>" /><br/>
				
			<label for="dataNasc">Data de Nascimento:</label>
			<input type="date" name="dataNasc" id="dataNasc" value="<% if(cliente.getDataNascimento()!=null) { out.print(cliente.getDataNascimento()); } %>" /><br/>
				
			<label>Sexo:</label>
			<input type="radio" name="sexo" value="Masculino" <% if(cliente.getSexo()!=null && cliente.getSexo().equals("Masculino")) { out.print("checked");} %> />Masculino
			<input type="radio" name="sexo" value="Feminino" <% if(cliente.getSexo()!=null && cliente.getSexo().equals("Feminino")) { out.print("checked");} %> />Feminino<br/>
				
			<label for="nomeSocial">Nome Social:</label>
			<input type="text" name="nomeSocial" id="nomeSocial" value="<% if(cliente.getNomeSocial()!=null) { out.print(cliente.getNomeSocial()); } %>" /><br/>
				
			<label for="apelido">Apelido:</label>
			<input type="text" name="apelido" id="apelido" value="<% if(cliente.getApelido()!=null) { out.print(cliente.getApelido()); } %>" /><br/>
				
			<label for="telefone">Telefone:</label>
			<input type="text" name="telefone" id="telefone" value="<% if(cliente.getTelefone()!=null) { out.print(cliente.getTelefone()); } %>" /><br/>
				
			<input type="submit" value="Salvar" />
		</form>
			* Campos Obrigatórios
	</body>
</html>