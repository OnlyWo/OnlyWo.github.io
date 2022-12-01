<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
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
    <form action="/JSPServlet" method="get">
        <input type="text" name="id" value="" placeholder="&nbsp;请按id搜索车" style="margin-left: 200px;width: 200px;height: 30px;border-radius: 20px;background-color: #b2c6ce;"/>
        <input type="submit" value="提交" style="width: 50px;height: 30px;border-radius: 20px;background-color: #ec071a;"/>
    </form>
</div>
<div style="clear: both"></div>
<div class="header">
    <div class="nav">
        <ul>
        </ul>
    </div>
</div>
<div style="clear: both"></div>
<!--     main02 start-->
<div class="main02">
    <div class="rt">
        <ul class="carlist">
            <ul>
                <c:forEach items="${carList}" var="cars" varStatus="cass">
                    <li>
                        <a href="#"><img src="${cars.carUrl}" width="450px" height="450px"></a>
                        <a href="#"><h1>汽车名称：${cars.car_name}</h1></a>
                    </li>
                    <table style="display: block;float: left;margin-left:100px">
                        <tr>
                            <td>汽车名称：</td>
                            <td>${cars.car_name}</td><br>
                        </tr>
                        <tr>
                            <td>汽车备注：</td>
                            <td>${cars.remark}</td><br>
                        </tr>
                        <tr>
                            <td>品牌汽车：</td>
                            <td>${cars.brand}</td><br>
                        </tr>
                        <tr>
                            <td>汽车类型：</td>
                            <td>${cars.type}</td>
                        </tr>
                        <tr>
                            <td>汽车价格：</td>
                            <td>${cars.price}</td><br>
                        </tr>
                        <tr>
                            <td>汽车状态：</td>
                            <td>${cars.state}</td><br>
                        </tr>
                        <tr>
                            <td>汽车id：</td>
                            <td>${cars.id}</td><br>
                        </tr>
                        <tr>
                            <td>是否可租：</td>
                            <td>${cars.rentable==0?"不可租":"可租"}</td><br></td>
                        </tr>
                    </table>

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
</html>
