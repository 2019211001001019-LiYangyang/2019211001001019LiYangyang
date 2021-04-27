<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/20
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(request.getAttribute("message")!=null){
        out.println(request.getAttribute("message"));
    }
%>
<%
    //read cookies
    Cookie[] allCookies = request.getCookies();
    String username="",password="",rememberMeValue="";
    if (allCookies!=null){
        for (Cookie c:allCookies){
            if(c.getName().equals("cUsername"));
            //get value of this cookie
            username= c.getValue();
        }for (Cookie c:allCookies){
            if(c.getName().equals("cPassword"));
            //get value of this cookie
            password= c.getValue();
        }for (Cookie c:allCookies){
            if(c.getName().equals("cRememberMe"));
            //get value of this cookie
            rememberMeValue= c.getValue();
        }
    }
%>
<form method="post" action="/2019211001001109LiYangyang_war_exploded/login">
    <table>
        <tr> <td>Username:<input type="text" name="username" value="<%=username%>"><br/></td></tr>
        <tr> <td>password:<input type="password" name="password" value="<%=password%>" required minlength="8"><br/></td></tr>
        <tr> <td><input type="checkbox" value="1" <%=rememberMeValue.equals(1) ?"checked":""%>checked/>rememberMe</td></tr>
        <tr> <td></td><td><input type="submit" name="rememberMe" value="Submit"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>