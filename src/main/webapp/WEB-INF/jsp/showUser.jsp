<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>测试</title>  
  </head>  
    
  <body>  
  	<form action="showUser">
  		输入id：<input name="id"></input>
  		<input type="submit" value="提交"></input>
  	</form>
  	${user.id}
    ${user.userName} 
    ${user.age}
    ${user.address} 
  </body>  
</html> 