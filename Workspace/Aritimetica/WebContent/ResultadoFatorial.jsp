<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado do fatorial</title>
</head>
<body>
<strong>Resultado: </strong></br>
<%
int p = Integer.parseInt(request.getParameter("valor")); 
long result = Operacoes.Fatorial(p);

DecimalFormat formatar = new DecimalFormat("###,###,###,##0");

%>
<%=
formatar.format(result)
%>
</body>
</html>