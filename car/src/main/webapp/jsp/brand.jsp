<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>汽车</title>
    <link href='/css/core.css'  rel='stylesheet' />
    <link href='/css/iconfont.css'  rel='stylesheet' />
    <link rel="stylesheet" type="text/css" href="/css/public.css">
    <script src="/jquery/jquery.js"></script>
    <script src="/jquery/cars.js"></script>
</head>
<body>
<div class="publicTopW">
    <div class="common_top">
        <div class="top_m">
            <div class="top_m_r">
                <a href="#" target="_blank"><i class="iconfont icon-vip"></i> 会员俱乐部</a>
                <a href="#" target="_blank" class="paddl26">我的订单</a>
                <a href="#" target="_blank" class="paddl26 red">营业网点</a>
                <a href="#" target="_blank" class="paddl26 ">招募合伙人</a>
            </div>
            <!--            完成-->
            <div class="top_m_l">
                <iframe width="500" scrolling="no" height="30" frameborder="0" allowtransparency="true" src="https://i.tianqi.com?c=code&id=11&icon=1&py=guiyang1&site=16"></iframe>
            </div>
        </div>
    </div>
    <div style="clear: both"></div>

    <div class="common_head">
        <div class="phone_r">
            <h2><i class="iconfont icon-lianxiwomen"></i> 19985144372</h2>
            <h3>09:00~22:00</h3></div>
        <a href="#"><img src="/images/logo.png" class="logo" /></a>
    </div>
</div>
<div>
    <form action="/BrandServlet" method="get">
        <input type="text" name="brand" value="" placeholder="&nbsp;请输入汽车品牌" style="margin-left: 200px;width: 200px;height: 30px;border-radius: 20px;background-color: #b2c6ce;"/>
        <input type="submit" value="提交" style="width: 50px;height: 30px;border-radius: 20px;background-color: #ec071a;"/>
    </form>
</div>
<div style="clear: both"></div>

<div class="header">
    <div class="nav">
        <ul>
            <li><a href="javascript:query('全部')">全部汽车</a></li>
            <li><a href="javascript:query('红旗')">红旗</a></li>
            <li><a href="javascript:query('奥迪')">奥迪</a></li>
            <li><a href="javascript:query('牧马人')">牧马人</a></li>
            <li><a href="javascript:query('奔驰')">奔驰</a></li>
            <li><a href="javascript:query('宝马')">宝马</a></li>
            <li><a href="javascript:query('福特')">福特</a></li>
            <li><a href="javascript:query('本田')">本田</a></li>
            <li><a href="javascript:query('大众')">大众</a></li>
        </ul>
    </div>
</div>
<div style="clear: both;"></div>
<!--     main02 start-->
<div class="main02">
    <div class="rt">
        <ul class="carlist">
            <ul>
                <c:forEach items="${carList}" var="cars" varStatus="cass">
                    <li>
                        <a href="/JSPServlet?id=${cars.id}"><img src="${cars.carUrl}" width="450px" height="450px"></a>
                        <a href="#"><h1>汽车名称：${cars.car_name}  汽车价格：${cars.price}</h1></a>
                    </li>
                </c:forEach>
            </ul>
        </ul>
    </div>
</div>
<!--     main02 end-->
<div style="clear: both"></div>
<!-- footer start -->
<div class="footer">
    <a href="#">首页</a>
    <a href="#">公司简介</a>
    <a href="#">产品展示</a>
    <a href="#">新闻资讯</a>
    <a href="#">联系我们</a>
    <br>
    华信智原科技有限公司 版权所有 &copy; Copyright 2022 备案号：<a style="color: #9ba3a8;" href="#" target="_blank">黔ICP备2022003204号-1</a><br />
    地址：贵州省花溪区小屯路（小屯大街461、463号） 咨询热线：0335-3925555
</div>
<!-- footer end -->
</body>
<script>

    /*// ajax get
    let query = function (car_name){
        $.get('/JsonGetServlet',{car_name:car_name},function (rs) {
            show(rs.data);
        })
    }
    query("H5");*/


    /*// ajax post
    let query = function (type){
        $.post('/JsonPostServlet',{type:type},function (rs){
            let json = JSON.parse(rs);
            show(json.data);
        });
    }
    query("全部");*/

    // ajax post 2
    let query = function (brand){
        $.post('/JsonPostServlet',{brand:brand},function (rs){
            show(rs.data);
        },'json');
    }

    /*// ajax post 3
    let query = function (type){
        $.getJSON('/JsonPostServlet',{type:type},function (rs){
            show(rs.data);
        });
    }
    query("全部");*/


</script>
</html>