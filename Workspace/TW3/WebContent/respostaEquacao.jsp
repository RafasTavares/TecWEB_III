<%@page import="br.unit.si.rafael.exemplo.web.Equacao2Grau"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resposta Equação</title>
</head>
<body>
Resultado : 
<% 
   double a = Double.parseDouble(request.getParameter("a")); 
   double b = Double.parseDouble(request.getParameter("b")); 
   double c = Double.parseDouble(request.getParameter("c")); 

   Equacao2Grau eq = new Equacao2Grau(a , b, c);
%>
Equação <%= eq.toString() %>
<br>
Raizes:
<%=
 eq.getX1()
%>
e
<%= 
eq.getX2() 
%>
</body>
</html>