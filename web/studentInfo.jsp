<%@ page import="main.Pojo.tuser" %>
<%@ page import="java.util.List" %>
<%@ page import="main.Dao.TuserDao" %>
<%@ page import="main.Pojo.studentinfo" %>
<%@ page import="main.Dao.StudentInfoDao" %><%--
  Created by IntelliJ IDEA.
  User: 流
  Date: 2023/12/12
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
    <tr>
        <th>编号</th>
        <th>专业编码</th>
        <th>名字</th>
        <th>性别</th>
        <th>生日</th>
        <th>地址</th>
    </tr>
        <%
            StudentInfoDao studentinfoDao = new StudentInfoDao();
            List<studentinfo> studentinfoList = studentinfoDao.getStudentInfoList();
            for (int i = 0; i < studentinfoList.size(); i++) {
                //单一的实体类对象
                studentinfo studentinfo = studentinfoList.get(i);
        %>
        <tr>
            <td><%=studentinfo.getSid()%></td>
            <td><%=studentinfo.getNum()%></td>
            <td><%=studentinfo.getName()%></td>
            <td><%=studentinfo.getSex()%></td>
            <td><%=studentinfo.getBirthday()%></td>
            <td><a href="mapServlet?address=<%=studentinfo.getAddress()%>"><%=studentinfo.getAddress()%></a></td>
        </tr>

        <%
            }
        %>
</table>



</body>
</html>
