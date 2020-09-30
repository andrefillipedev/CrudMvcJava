<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro Cliente</title>
	</head>
	<body>
		<h1>Cadastro Cliente</h1>
		<form action="ClienteController" method="POST">
			<input type="hidden" name="action" value="salvar"/>
			
			<label for="nome">Nome:*</label>
			<input type="text" name="nome" id="nome" required="required" /><br/>
				
			<label for="cpf">CPF:*</label>
			<input type="text" name="cpf" id="cpf" required="required" /><br/>
				
			<label for="email">E-mail:*</label>
			<input type="text" name="email" id="email" required="required" /><br/>
				
			<label for="dataNasc">Data de Nascimento:</label>
			<input type="date" name="dataNasc" id="dataNasc" /><br/>
				
			<label>Sexo:</label>
			<input type="radio" name="sexo" value="Masculino" />Masculino
			<input type="radio" name="sexo" value="Feminino" />Feminino<br/>
				
			<label for="nomeSocial">Nome Social:</label>
			<input type="text" name="nomeSocial" id="nomeSocial" /><br/>
				
			<label for="apelido">Apelido:</label>
			<input type="text" name="apelido" id="apelido" /><br/>
				
			<label for="telefone">Telefone:</label>
			<input type="text" name="telefone" id="telefone" /><br/>
				
			<input type="submit" value="Salvar" />
			<a href="ClienteController?listar=1">Listar clientes</a>
		</form>
			* Campos Obrigatórios
	</body>
</html>