<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.usjt.TO.FuncionarioTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Funcionario</title>
</head>
<body>
	<%FuncionarioTO to = (FuncionarioTO)request.getAttribute("funcionario"); %>
	
	<label>ID Funcionário:</label>	<%=to.getIdFuncionario()%><br>
	<label> Usuario:</label>	<%=to.getUsuario() %><br>
	<label> Senha:</label> <%=to.getSenha() %><br>
	<label> RG:</label> <%=to.getRg() %><br>
</body>
</html>