<%@page import="mo.*" import="java.util.*"  pageEncoding="utf-8" %>

<%Seller sellercon=(Seller)session.getAttribute("user");
  if(sellercon==null){
	  response.sendRedirect("login.html");
	  return;
	  }
	Iterator<Action> list_menu=sellercon.getAction();
%>
<%
	int select=0;
	if(request.getParameter("select")!=null)
		select=Integer.parseInt(request.getParameter("select"));
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
</head>

<body>
<div class="lefter">
    <div class="logo"><a href="#" target="_blank"><img src="images/logo.png" alt="后台管理系统" /></a></div>
</div>
<div class="righter nav-navicon" id="admin-nav">
    <div class="mainer">
        <div class="admin-navbar">
            <span class="float-right">
            	<a class="button button-little bg-main" href="#">前台首页</a>
                <a class="button button-little bg-yellow" href="login.jsp">注销登录</a>
            </span>
            <ul class="nav nav-inline admin-nav">
            <%while(list_menu.hasNext()){ Action acti=list_menu.next(); 
            	if(acti.getIs_dir()==1){
            		Iterator<Action> list_list=sellercon.getAction();
            %>
                <li <%if(acti.getId()==select)out.println("class='active'"); %>><a href="index.jsp?select=<%=acti.getId()%>" ><%=acti.getAction_name() %></a>
                    <ul>
                    <%while(list_list.hasNext()){Action acti1=list_list.next(); 
                    	if(acti1.getParent()==acti.getId()){
                    %>
                    <li><a href="<%=acti1.getLink() %>"><%=acti1.getAction_name() %></a></li>
                    <%}} %>
                    </ul>
                </li>
             <%}} %>
            </ul>
        </div>
        <div class="admin-bread">
            <span>您好，sellercon.getName()，欢迎您的光临。</span>
            <ul class="bread">
                <li><a href="index.html" class="icon-home"> 开始</a></li>
                <li><a href="system.html">设置</a></li>
                <li>系统设置</li>
            </ul>
        </div>
    </div>
</div>
