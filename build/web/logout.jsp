<%-- 
    Document   : logout.jsp
    Created on : Apr 29, 2020, 3:25:17 PM
    Author     : miguelbispo
--%>

<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%
    session.setAttribute("user",null);
    
    String address =  "login.jsp";
    response.sendRedirect(address);
%>