<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>汽车删除</title>
    <link rel="stylesheet" type="text/css" href="/css/css.css">
</head>

<body>
<div style="margin-left: 400px;margin-top: 200px">
<h1>删除汽车</h1>
    <br>
<form action="${pageContext.request.contextPath}/CarDeleteServlet" method="post">
    <table>
        <tr>
            <td>汽车id：</td>
            <td><input type="text" name="id" value=""/></td>
        </tr>
        <tr>
            <td>汽车名称：</td>
            <td><input type="text" name="car_name" value=""/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
