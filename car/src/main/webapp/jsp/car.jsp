<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>车信息</title>
    <link rel="stylesheet" type="text/css" href="/css/css.css">
</head>
<body>

<div style="margin-left: 150px;margin-top: 50px">
<h1>车信息</h1>
    <br>
    <table>
        <tr>
            <th>id</th>
            <th>汽车名称</th>
            <th>汽车备注</th>
            <th>品牌</th>
            <th>类型</th>
            <th>价格</th>
            <th>是否可租</th>
            <th>是否上架</th>
        </tr>
        <x:forEach items="${carList}" var="y" varStatus="z"><%--varStatus="z"索引下标--%>
            <tr>
                <td>${y.id}</td>
                <td>${y.car_name}</td>
                <td>${y.remark}</td>
                <td>${y.brand}</td>
                <td>${y.type}</td>
                <td>${y.price}</td>
                <td>${y.rentable==0?"不可租":"可租"}</td>
                <td>${y.state}</td>
            </tr>
        </x:forEach>
    </table>
<form action="/RootServlet" method="post">
    <input type="submit" name="action" value="添加汽车">
    <input type="submit" name="action" value="修改汽车">
    <input type="submit" name="action" value="删除汽车">
    <input type="submit" name="action" value="上传图片">
    <input type="submit" name="action" value="修改用户信息">
    <input type="submit" name="action" value="删除用户">
    <input type="submit" name="action" value="退出">
</form>
</div>
</body>
</html>
