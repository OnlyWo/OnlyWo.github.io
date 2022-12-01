<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/css.css">
</head>
<body>
<div style="margin-left: 400px;margin-top: 200px">
<h1>添加车辆信息</h1>
  <br>
<form action="${pageContext.request.contextPath}/AddCarServlet" method="post">
  <table>
    <tr>
      <td>汽车名称：</td>
      <td><input type="text" name="car_name" value=""/></td>
    </tr>
    <tr>
      <td>汽车备注：</td>
      <td><input type="text" name="remark" value=""/></td>
    </tr>
    <tr>
      <td>品牌：</td>
      <td><input type="text" name="brand" value=""/></td>
    </tr>
    <tr>
      <td>类型：</td>
      <td><input type="text" name="type" value=""/></td>
    </tr>
    <tr>
      <td>价格：</td>
      <td><input type="text" name="price" value=""/></td>
    </tr>
    <tr>
      <td>是否可租：</td>
      <td>
        <input type="radio" name="rentable" value="0"/>不可租
        <input type="radio" name="rentable" value="1"/>可租
      </td>
    </tr>
    <tr>
      <td>是否上架：</td>
      <td>
        <input type="radio" name="state" value="上架"/>上架
        <input type="radio" name="state" value="下架"/>下架
      </td>
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
