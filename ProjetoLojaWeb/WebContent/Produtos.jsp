<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.usjt.TO.ProdutoTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produto</title>
</head>
<body>

	<%ProdutoTO to = (ProdutoTO)request.getAttribute("produto"); %>
	
	ID Produto:<%=to.getId()%><br> 
	Quantidade:<%=to.getQtd()%><br>
	Valor:<%=to.getValor()%><br>
	Nome:<%=to.getNome()%><br>
	Marca:<%=to.getMarca()%><br>
    Fornecedor:<%=to.getFornecedor()%><br>
	
</body>
</html>