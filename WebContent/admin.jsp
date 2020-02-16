<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>后台管理界面</title>
	<link rel="stylesheet" href="src/css/layui.css">
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/login_overlay.css" rel='stylesheet' type='text/css' />
	<link href="css/style6.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="css/shop.css" type="text/css" />
	<link rel="stylesheet" href="css/owl.carousel.css" type="text/css" media="all">
	<link rel="stylesheet" href="css/owl.theme.css" type="text/css" media="all">
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/fontawesome-all.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Inconsolata:400,700" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800"
	    rel="stylesheet">
	<link rel="stylesheet" href="layui/css/layui.css" >

	<style type="text/css">

	     .layui-table-cell {
            height: 100%;
            max-width: 100%;
	   }
		.woaicss_title_bg1 {background-position:0 0;}
		.woaicss_title_bg2 {background-position:0 -30px;}
		.woaicss_title_bg3 {background-position:0 -60px;}
		.woaicss_title_bg4 {background-position:0 -90px;}
		.woaicss_title_bg5 {background-position:0 -120px;}
	</style>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">后台管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item">控制台</li>
      <li class="layui-nav-item"><a href="#"onclick="javascript:woaicssq(4)">商品管理</a></li>
      <li class="layui-nav-item"><a href="#" onclick="javascript:woaicssq(3)">用户列表</a></li>
     
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          ${user.name }
        </a>
        <dl class="layui-nav-child">
          <dd><a href="#">个人信息</a></dd>
          <dd><a href="logout.action">安全退出</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="logout.action">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="#"onclick="javascript:woaicssq(1)">所有商品</a>
          <dl class="layui-nav-child">
            <dd><a href="search.action?gsort=餐厨&do=searchsort&fwhere=manager">餐厨</a></dd>
            <dd><a href="search.action?gsort=客厅&do=searchsort&fwhere=manager">沙发</a></dd>
            <dd><a href="search.action?gsort=茶几&do=searchsort&fwhere=manager">茶几</a></dd>
            <dd><a href="search.action?gsort=床&do=searchsort&fwhere=manager">床</a></dd>
            <dd><a href="search.action?gsort=衣柜&do=searchsort&fwhere=manager">衣柜</a></dd>
            <dd><a href="search.action?gsort=桌椅&do=searchsort&fwhere=manager">桌椅</a></dd> 
            <dd><a href="search.action?gsort=洗漱台&do=searchsort&fwhere=manager">洗漱台</a></dd>
            <dd><a href="search.action?gsort=花洒&do=searchsort&fwhere=manager">花洒</a></dd>
            <dd><a href="search.action?gsort=床柜&do=searchsort&fwhere=manager">床柜</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="#" onclick="javascript:woaicssq(5)">添加商品</a></li>
        <li class="layui-nav-item"><a href="#" onclick="javascript:woaicssq(2)">评论管理</a></li>

      </ul>
    </div>
  </div>
  
  <div class="layui-body">
  		<script language="javascript"> 
			 function woaicssq(num){
			 for(var id = 1;id<=5;id++)
			 {
				 var MrJin="woaicss_con"+id;
				 
				 if(id==num)
				 document.getElementById(MrJin).style.display="flex"; 
	
				 else
				 document.getElementById(MrJin).style.display="none";
			 }
/* 			 if(num==1) 
			 	document.getElementById("woaicsstitle").className=" woaicss_title_bg1";
			 if(num==2)
			 	document.getElementById("woaicsstitle").className=" woaicss_title_bg2";
			 if(num==3)
			 	document.getElementById("woaicsstitle").className="woaicss_title_bg3";
			 if(num==4)
				 document.getElementById("woaicsstitle").className="wwoaicss_title_bg4"; */
			 }
			</script>
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    <div class="row1" style=".row1 { display: -webkit-box; display: -ms-flexbox;  -ms-flex-wrap: wrap;}">
			<div class="row woaicss_con" id="woaicss_con1" style="display:flex;">

			 <c:forEach items="${goodslist }" var="goods">
				
				<div class="col-md-3 product-men women_two">
						<div class="product-googles-info googles">
							<div class="men-pro-item">
								<input class="layui-upload-file" type="file" accept="" name="file">
								<div class="men-thumb-item">
								
								  <img src="${goods.img }" width="300" height="364">
								  <div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											
										</div>
								  </div>
							  </div>
								<div class="item-info-product">
									<div class="info-product-price">
										<div class="grid_meta">
											<div class="product_price">
												<h4>
													<a href="#">${ goods.name}<p>${goods.intro }</p></a>
												</h4>
												<div class="grid-price mt-2">
													<span class="money ">￥${goods.price }</span>
												</div>
											</div>
											
										</div>
										<div class="googles single-item hvr-outline-out" style="display: none;">
											<form action="#" method="post">
												<input type="hidden" name="cmd" value="_cart">
												<input type="hidden" name="add" value="1">
												<input type="hidden" name="googles_item" value="${ goods.name}">
												<input type="hidden" name="amount" value="${goods.price }">
												<button type="submit" class="googles-cart pgoogles-cart">
													<i class="fas fa-cart-plus"></i>
												</button>	
											</form>

										</div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
					
			</c:forEach> 
			
			</div>	
			<div class="woaicss_con" id="woaicss_con2" style="display:none;">
					<table class="layui-table">
						  <colgroup>
						    <col width="150">
						    <col width="200">
						    <col>
						  </colgroup>
						  <thead>
						    <tr>
						      <th>商品</th>
						      <th>评论用户</th>
						      <th>评论内容</th>
						      
						      <th>操作</th>
						    </tr> 
						  </thead>
			
						   
						  <tbody>
		
					
						<c:forEach items="${reviewslist }" var="reviews">    
							<tr>
						      <td><img layer-pid="图片id，可以不写" layer-src="/images/bug-success-bg.jpg" src="${reviews.img }" alt="图片	"></td>
						      <td>${reviews.name }</td>
						      <td>${reviews.content }</td>
						      
						      <td><a href="reviews.action?reviewsid=${reviews.id }&do=deletereviews">删除</a></td>
						    </tr>
						 </c:forEach>
						  
						  </tbody>
			
						</table>

			</div>
			<div class="woaicss_con" id="woaicss_con3" style="display:none;">
							
				<table class="layui-table" id="usertable" lay-filter="test">
					<script type="text/html" id="barDemo">
  						<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  						<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  						<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"href="userdelete.action?usersid=${d.id }">删除</a>
					</script>
				</table>

			</div>
			<div class="woaicss_con" id="woaicss_con5" style="display:none;">
					<table class="layui-table" >
						<tr><td colspan="7" style="text-align: center;"><h3>添加商品</h3></td></tr>
						<tr>
				      <th>商品ID</th>
				      <th>商品名称</th>
				      <th>价格</th>
				      <th>参考图</th>
				      <th>种类</th>
				      <th>简介</th>
				      <th>描述</th>
				   
				      
				    </tr> 
					  <form action="addgoods.action" method="post"  " name="form" enctype="multipart/form-data">
					   			
					  	<tr>
						  	
						  		
						      <td><input type="text" name="goodsname" required="required"></td>
						      <td><input type="text" name="gprice" required="required"></td>
						      <td><input type="file" name="file"></td>
						      <td><input type="text" name="sort" required="required"></td>
						      <td><input type="text" name="intro" required="required"></td>
						      <td><textarea type="text" name="descri" required="required"></textarea></td>
						      <td><button  type="submit" >添加</button></td>
						
						      
						    </tr> 
						    </form>
				</table>
			</div>
			<div class="woaicss_con" id="woaicss_con4" style="display:none;">
			
				
				<table class="layui-hide" id="goodstable">
			
				<script src="layui/layui.js" charset="utf-8"></script>

			</div>

			
	</div>
  </div>
  

</div>
<script src="layui/layui.js"></script>  

<script src="layui/lay/modules/table.js"></script>

<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#goodstable'
    	 , url : '/project/goodsservlet',
    		 toolbar: 'default'
    ,cols: [[
    	
         {field: 'id', title: 'ID', minWidth:60,width:60, align:"center",sort: true},
 　　 { field: 'img', title: '图片预览',width:120, sort: false,style:'height:100px;', templet:function (d) {
                 return  '<div> <img layer-pid="图片id，可以不写"  layer-src="/images/bug-success-bg.jpg" src="'+d.img+'" alt="图片	"></div>'
             }
         },
         {field: 'name', title: '名称',edit: 'text',  minWidth:50, align:'center'},
         {field: 'price', title: '价格',edit: 'text', width:60, align:'center',sort: true},
         {field: 'intro', title: '简介',edit: 'text', minWidth:100,width:130, align:'center',sort: true},
         {field: 'sort', title: '种类',edit: 'text', width:100,minWidth:100, align:'center',sort: true},
         {field: 'description', title: '描述',edit: 'text', edit: 'text', minWidth:100, align:'center',sort: true},

         {title: '操作', minWidth:175,align:"center",templet:function (f) {
             return  '<a href="goodsdelete.action?goodsid='+f.id+'">删除</a>'
         } }
    ]]
 
   
	  });

	  

	});
	</script>

 <script>

 
layui.use(['table','element'], function(){
  var element = layui.element //元素操作
   var table = layui.table;
 
		 table = table.render({
      elem: '#usertable',
      url : '/project/userservlet',
      cellMinWidth : 95,

      toolbar: 'default', //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
      limits : [10,15,20,25],
      limit : 20,
      id : "userListTable",
      cols : [[
         
          {field: 'id', title: 'ID', minWidth:60,width:60, align:"center",sort: true},
  　　　　 { field: 'img', title: '图片预览', width:120, sort: false,style:'height:100px;', templet:function (d) {
                  return  '<div> <img layer-pid="图片id，可以不写"  layer-src="/images/bug-success-bg.jpg" src="'+d.img+'" alt="图片	"></div>'
              }
          },
          {field: 'username', title: '用户名',edit: 'text',  minWidth:150, align:'center'},
          {field: 'password', title: '密码',edit: 'text', minWidth:100, align:'center',sort: true},
          {field: 'name', title: '名字',edit: 'text', minWidth:60,width:80, align:'center',sort: true},
          {field: 'email', title: '邮箱',edit: 'text', minWidth:100, align:'center',sort: true,templet:function(d){
              return '<a class="layui-blue" href="mailto:'+d.email+'">'+d.email+'</a>';
          }},
          {field: 'range', title: '权限',minWidth:100,width:80,  align:'center',templet:function(d){
              return d.range == "0" ? "用户" : "管理员";
          }},
          {title: '操作', minWidth:175, fixed:"right",align:"center",templet:function (f) {
              return  '<a href="userdelete.action?usersid='+f.id+'">删除</a>'
          } }
      ]]
  });



        
  
/*   //向世界问个好
  layer.msg(''); */
  
  //监听Tab切换
  element.on('tab(demo)', function(data){
    layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
      tips: 1
    });
  });
  
});
</script> 
</body>
</html>
