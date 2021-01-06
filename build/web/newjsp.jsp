<%-- 
    Document   : newjsp
    Created on : Jan 6, 2021, 7:08:23 PM
    Author     : Administrator
--%>

<%@page import="com.ntppackage.ConnectDBClass"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        ConnectDBClass con = new ConnectDBClass();
        ResultSet rs;
        rs = con.chonDuLieuTuDTB("SELECT * FROM `danhsachdiemdanh`");
        %>
        <a href="TaoBangjsp.jsp">Tao Bang</a>
        <table>
            <tr>
                <th>stt</th>
                <th>ten bang</th>
            </tr>
            <%
                
            while (rs.next()) {                    
            %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><a href="diemdanhjsp.jsp?id=<%=rs.getString(2)%>"><%=rs.getString(2)%></a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
