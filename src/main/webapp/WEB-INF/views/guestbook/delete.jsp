<%@page import="com.cafe24.mysite.dao.GuestbookDao"%>
<%@page import="com.cafe24.mysite.vo.GuestbookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	String password = request.getParameter("password");

	GuestbookVo vo = new GuestbookVo();
	vo.setNo(Long.parseLong(no));
	vo.setPassword(password);

	new GuestbookDao().delete(vo);
%>