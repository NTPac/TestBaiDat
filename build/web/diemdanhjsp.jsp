<%-- 
    Document   : diemdanhjsp.jsp
    Created on : Jan 6, 2021, 7:27:18 PM
    Author     : Administrator
--%>

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.ntppackage.ConnectDBClass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
              }

              td, th {
                border: 1px solid #dddddd;
                text-align: left;
              }

              tr:nth-child(even) {
                background-color: #dddddd;
              }
        </style>
        <%
            
            String currentDate = LocalDate.now().toString();
            String id = request.getParameter("id");
            ConnectDBClass conn = new ConnectDBClass();
            ResultSet rs = conn.chonDuLieuTuDTB("SELECT * FROM `"+id+"`");
            ResultSetMetaData rsmd = rs.getMetaData();
            int i = rsmd.getColumnCount();
        %>
    </head>
    <body>
        <form action="diemdanh">
            <input hidden="true" name="id" value="<%=id%>">
            <table>
            <tr>
                <th>stt</th>
                <th>msv</th>
                <th>ho ten</th>
                <th>ngay sinh</th>
                <%if(i>4)
                    for(int j = 5;j<=i;j++){ %>                       
                <th><%=rsmd.getColumnName(i)%></th>
                        <%
                           
                           }
                %>
                <th><%=currentDate%></th>>
            </tr>
            <%
               
            while (rs.next()) {                    
            %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <%if(i>4)
                    for(int j = 5;j<=i;j++){ %>                       
                <td><%=rs.getString(j)%></td>
                        <%
                           
                           }
                %>
                <td><input type="checkbox" name="list" value="<%=rs.getString(1)%>"></td>
            </tr>
            <%};%>
            
        </table>
            <button type="submit">xac nhan</button>
        </form>
    </body>
</html>
