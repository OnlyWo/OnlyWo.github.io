function show(data){
    let html = "";
    $.each(data,function (index,obj){
        html+="<li>";
        html+="<a href='/JSPServlet?id="+obj.id+"'><img src="+obj.carUrl+" width='450px' height='450px'>";
        html+="</a>";
        html+="<a href='#'><h1>汽车名称："+obj.car_name+"汽车价格："+obj.price+"</h1></a>";
        html+="</li>";
    });
    $(".carlist").html(html);/*innerHTML*/
}