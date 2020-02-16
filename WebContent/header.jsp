<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIVE-主页</title>
  <link rel="stylesheet" href="layui/dist/css/layui.css?t=1568076536509" media="all">

</head>
<body>

	<div class="banner-top container-fluid" id="home">
		<!-- header -->
		<header>
			<div class="row">
				<div class="col-md-3 top-info text-left mt-lg-4"></div>
				<div class="col-md-6 logo-w3layouts text-center">
					<h1 class="logo-w3layouts">
						<a class="navbar-brand" href="index.html">LIVE</a>
					</h1>
				</div>

				<div class="col-md-3 top-info-cart text-right mt-lg-4">
					<ul class="cart-inner-info">
						<li class="button-log">
						<c:if test="${user!=null }">尊敬的 ${user.name }<c:if test="${user.name==null }">${user.username }</c:if> 欢迎您！ </c:if>
							
								<a class="btn-open" href="#"> <span class="fa fa-user" aria-hidden="true"></span>
								
							</a>
							<c:if test="${user!=null }"> <a  href="logout.action" >注销</a></c:if>
							
						</li>
						<li class="galssescart galssescart2 cart cart box_1">
							<form action="#" method="post" class="last">
								<input type="hidden" name="cmd" value="_cart">
								<input type="hidden" name="display" value="1">
								<button class="top_googles_cart" type="submit" name="submit" value="">
									购物袋
									<i class="fas fa-cart-arrow-down"></i>
								</button>
							</form>
						</li>
					</ul>
<div class="overlay-login text-left">
						<button type="button" class="overlay-close1">
							<i class="fa fa-times" aria-hidden="true"></i>
						</button>
						<div class="wrap">
						
							<div class="layui-tab layui-tab-brief" lay-filter="demo">
							  <ul class="layui-tab-title">
							    <li class="layui-this"><h5 class="text-center mb-4">登录</h5></li>
							    <li><h5 class="text-center mb-4">注册</h5></li>

							  </ul>
							<div class="layui-tab-content">
							    <div class="layui-tab-item layui-show">
							    
							      
							        <div carousel-item="">
							          	
										<div class="login p-5 bg-dark mx-auto mw-100">
											<form action="login.action"   method="post">
												<div class="form-group">
													<label class="mb-2">用户名</label>
													<span id="messaged" style="color: red;"> ${msg } </span>
													<input type="text" class="form-control" name="username"v id="usernamed"   aria-describedby="" placeholder="请输入用户名"  required="">
													<small id="emailHelp" class="form-text text-muted">我们永远不会和别人分享您的信息。</small>
												</div>
												<div class="form-group">
													<label class="mb-2">密码</label>
													<input type="password" class="form-control" name="password" id="pd" placeholder="请输入密码" required="">
												</div>
												<div class="form-group">
													<input type="text" name="captcha" style="width:100px;height: 39px;" maxlength="4" required="required" placeholder="请输入验证码">
													<img src="captcha?v=<%=new Date().getTime() %>" id="captcha" alt="验证码" title="点击刷新验证码" onclick="change()">
												</div>
												
												<div class="form-check mb-2">
													<input type="checkbox" class="form-check-input" id="exampleCheck1">
													<label class="form-check-label" for="exampleCheck1">记住密码</label>
												</div>
												<button type="submit" class="btn btn-primary submit mb-4">登录</button>
							
											</form>
										</div>
							        
							      </div>
							    </div>
							    <div class="layui-tab-item">
							              <div carousel-item="">
							          	
										<div class="login p-5 bg-dark mx-auto mw-100">
											<form action="register.action" onsubmit="return check();"name="form" method="post">
												<div class="form-group">
													<label class="mb-2">用户名</label>
													<span id="message" style="color: red;"> ${msg }</span>
													<input type="text" class="form-control" name="username" id="username" onblur="validate()" aria-describedby="" placeholder="请输入用户名" required="">
													<small id="emailHelp" class="form-text text-muted"><span id="spanUserId" style="color: red;""class="reg_icon"></span></small>
												</div>
												<div class="form-group">
													<label class="mb-2">密码</label>
													<input type="password" class="form-control" name="password" id="password" placeholder="请输入密码" onblur="check()" required="">
												</div>
												
												<div class="form-group">
													<label class="mb-2">确认密码</label>
													<input type="password" class="form-control" name="repassword" id="repassword" placeholder="请再次确认密码" onblur="recheck()" required="">
												</div>
												<div class="form-group">
													
													<input type="text" name="captcha" style="width:100px;height: 39px;" maxlength="4" required="required" placeholder="请输入验证码">
													<img src="captcha?v=<%=new Date().getTime() %>" id="captcha" alt="验证码" title="点击刷新验证码" onclick="change()">
												</div>
												

												<button type="submit" class="btn btn-primary  submit mb-4">注册</button>
							
											</form>
										</div>
							    </div>
							
							
							  </div>
							</div>

						</div>
						</div>
					</div>


				</div>
			</div>
			<div class="search">
				<div class="mobile-nav-button">
					<button id="trigger-overlay" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
				<!-- open/close -->
				<div class="overlay overlay-door">
					<button type="button" class="overlay-close">
						<i class="fa fa-times" aria-hidden="true"></i>
					</button>
					<form action="search.action?do=searchname" method="post" class="d-flex">
						<input class="form-control" name="gname" type="search" placeholder="Search here..." required="">
						<button type="submit" class="btn btn-primary submit">
							<i class="fas fa-search"></i>
						</button>
					</form>

				</div>
				<!-- open/close -->
			</div>
			<label class="top-log mx-auto"></label>
			<!-- nav-bar -->
			<nav class="navbar navbar-expand-lg navbar-light bg-light top-header mb-2">
				<button class="navbar-toggler mx-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
				    aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon">
					</span>
				</button>
				
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav nav-mega mx-auto">
						<li class="nav-item active">
							<a class="nav-link ml-lg-0" href="goodslist.action">首页</a>
						</li>
						
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
							    aria-expanded="false">起居室</a>
							<ul class="dropdown-menu mega-menu ">
								<li>
									<div class="row">
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"><a href="search.action?gsort=客厅&do=searchsort&fwhere=q">沙发</a></h5>
											<ul>
												<li class="media-mini mt-3">KARLSTAD 卡斯塔</li>
												<li class="media-mini mt-3">GRÖNLID 格罗恩里德</li>
												<li class="media-mini mt-3">VIMLE 维姆勒</li>
											</ul>
											<br>
											<h5 class="tittle-w3layouts-sub"><a href="search.action?gsort=茶几&do=searchsort&fwhere=q">茶几</a></h5>
											<ul>
												<li class="media-mini mt-3">VITTSJÖ 维特索</li>
												<li class="media-mini mt-3">LISTERBY 丽思德比</li>
												<li class="media-mini mt-3">VITTSJÖ 维特索</li>
											</ul>
										</div>
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"></h5>
											<div class="media-mini mt-3">
												<a href="#">
													<img src="images/32.JPG" class="img-fluid" alt="">
												</a>
											</div>
										</div>
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"></h5>
											<div class="media-mini mt-3">
												<a href="#">
													<img src="images/40.JPG" class="img-fluid" alt="">
												</a>
											</div>
										</div>
									</div>
									<hr>
								</li>
							</ul>
						</li>
						
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
							    aria-expanded="false">卧室</a>
							<ul class="dropdown-menu mega-menu ">
								<li>
									<div class="row">
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"><a href="search.action?gsort=床&do=searchsort&fwhere=q">床</a></h5>
											<ul>
												<li class="media-mini mt-3">FOLLAFOSS 弗拉夫斯</li>
												<li class="media-mini mt-3">FINSLAND 菲茵斯兰</li>
											</ul>
											<br>
											<h5 class="tittle-w3layouts-sub"><a href="search.action?gsort=衣柜&do=searchsort&fwhere=q">衣柜</a></h5>
											<ul>
												<li class="media-mini mt-3">MUSKEN 穆斯肯</li>
												<li class="media-mini mt-3">PAX 帕克思</li>
											</ul>
											<br>
											<h5 class="tittle-w3layouts-sub"><a href="search.action?gsort=床柜&do=searchsort&fwhere=q">床柜</a></h5>
											<ul>
												<li class="media-mini mt-3">HEMNES 汉尼斯</li>
												<li class="media-mini mt-3">MALM 马尔姆</li>
											</ul>
										</div>
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"></h5>
											<div class="media-mini mt-3">
												<a href="#">
													<img src="images/47.JPG" class="img-fluid" alt="">
												</a>
											</div>
										</div>
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"></h5>
											<div class="media-mini mt-3">
												<a href="#">
													<img src="images/52.JPG" class="img-fluid" alt="">
												</a>
											</div>
										</div>
									</div>
									<hr>
								</li>
							</ul>
						</li>
						
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="search.action?gsort=餐厨" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
							    aria-expanded="false">餐厨</a>
							<ul class="dropdown-menu mega-menu ">
								<li>
									<div class="row">
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"><a href="search.action?gsort=餐厨&do=searchsort&fwhere=q">厨面&橱柜</a></h5>
											<ul>
												<li class="media-mini mt-3">AVSEN 霍夫森</li>
												<li class="media-mini mt-3">GRUNDVATTNET 伦瓦特</li>
												<li class="media-mini mt-3">智能厨房橱柜</li>
											</ul>
											<br>
											<h5 class="tittle-w3layouts-sub"><a href="search.action?gsort=桌椅&do=searchsort&fwhere=q">餐桌&餐椅</a></h5>
											<ul>
												<li class="media-mini mt-3">MELLTORP 麦托 / TEODORES 帝奥多斯</li>
												<li class="media-mini mt-3">INGATORP 英格托 / INGOLF 英格弗</li>
												<li class="media-mini mt-3">KEDALEN 伊克多兰 / EKEDALEN 伊克多兰</li>
											</ul>
										</div>
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"></h5>
											<div class="media-mini mt-3">
												<a href="#">
													<img src="images/16.webp" class="img-fluid" alt="">
												</a>
											</div>
										</div>
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"></h5>
											<div class="media-mini mt-3">
												<a href="#">
													<img src="images/10.webp" class="img-fluid" alt="">
												</a>
											</div>
										</div>
									</div>
									<hr>
								</li>
							</ul>
						</li>
						
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
							    aria-expanded="false">浴室</a>
							<ul class="dropdown-menu mega-menu ">
								<li>
									<div class="row">
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"><a href="search.action?gsort=洗漱台&do=searchsort&fwhere=q">洗漱台</a></h5>
											<ul>
												<li class="media-mini mt-3">HEMNES 汉尼斯</li>
												<li class="media-mini mt-3">TÖRNVIKEN 通维肯</li>
												<li class="media-mini mt-3">RÅGRUND 罗格朗</li>
												<li class="media-mini mt-3">STORJORM 司铎约</li>
											</ul>
											<br>
											<h5 class="tittle-w3layouts-sub"><a href="search.action?gsort=花洒&do=searchsort&fwhere=q">淋浴器</a></h5>
											<ul>
												<li class="media-mini mt-3">BROGRUND 布鲁格隆德</li>
												<li class="media-mini mt-3">VOXNAN 沃斯南</li>
											</ul>
										</div>
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"></h5>
											<div class="media-mini mt-3">
												<a href="#">
													<img src="images/18.webp" class="img-fluid" alt="">
												</a>
											</div>
										</div>
										<div class="col-md-4 media-list span4 text-left">
											<h5 class="tittle-w3layouts-sub"></h5>
											<div class="media-mini mt-3">
												<a href="#">
													<img src="images/23.webp" class="img-fluid" alt="">
												</a>
											</div>
										</div>
									</div>
									<hr>
								</li>
							</ul>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="about.jsp">关于我们</a>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- //header -->
		<!-- banner -->
		<div class="banner">
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<div class="carousel-caption text-center">
							<h3>卧室
								<span>
												
											营造你喜欢的氛围——想你所想，及你所需

										
										</span>
							</h3>
							<a href="#" class="btn btn-sm animated-button gibson-three mt-4">Shop Now</a>
						</div>
					</div>
					<div class="carousel-item item2">
						<div class="carousel-caption text-center">
							<h3>Make  HOME Yours
								<span>            </span>
							</h3>
							<a href="#" class="btn btn-sm animated-button gibson-three mt-4">Shop Now</a>

						</div>
					</div>
					<div class="carousel-item item3">
						<div class="carousel-caption text-center">
							<h3>电视墙
								<span>
										容得下你所有想法——灵活组合，功能强大。
										
										</span>
							</h3>
							<a href="#" class="btn btn-sm animated-button gibson-three mt-4">Shop Now</a>

						</div>
					</div>
					<div class="carousel-item item4">
						<div class="carousel-caption text-center">
							<h3>衣柜
								<span>
										打造你的梦想衣柜——外表美观，内部巧妙
								</span>
							</h3>
							<a href="#" class="btn btn-sm animated-button gibson-three mt-4">Shop Now</a>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			<!--//banner -->
		</div>
	</div>

			<script src="layui/dist/layui.js?t=1568076536509"></script>
			<script>
			
			 
			layui.use(['layer', 'element'], function(){
			  var element = layui.element //元素操作
			 
			  
/* 			  //向世界问个好
			  layer.msg('say hi');
			   */
			
			  
			});
			</script>
			  <script type="text/javascript">
	
			
					//定义一个请求
					var xmlHttp;
					 
					function createXMLHttpRequest() {
						//表示当前浏览器不是ie,如ns,firefox
						if(window.XMLHttpRequest) {
							xmlHttp = new XMLHttpRequest();
						} else if (window.ActiveXObject) {
							xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						}
					}
					
					
					//field为获取用户所填写的用户名
					function validate(f) {
						var field = document.getElementById("username").value;
					    //判断用户名是否为空
						if (field.trim().length != 0) {
							//创建Ajax核心对象XMLHttpRequest
							createXMLHttpRequest();
							//将获取用户名发送到另一个jsp中去验证
							var url = "user_validate.jsp?username=" + field.trim() + "&time=" + new Date().getTime();
							
							//设置请求方式为GET，设置请求的URL，设置为异步提交，true为异步，false为同步
							xmlHttp.open("GET", url, true);	
							//将方法地址复制给onreadystatechange属性
							//类似于电话号码
							xmlHttp.onreadystatechange=callback;
							
							//将设置信息发送到Ajax引擎
							xmlHttp.send(null);
						} else {
							document.getElementById("spanUserId").innerHTML = "";
						}	
					}
					
					//发送请求之后，返回的状体
					function callback() {
						//alert(xmlHttp.readyState);
						//Ajax引擎状态为成功
						if (xmlHttp.readyState == 4) {
							//HTTP协议状态为成功
							if (xmlHttp.status == 200) {
								if (xmlHttp.responseText.trim() != "") {
									//设置请返回的消息信息
									document.getElementById("spanUserId").innerHTML =  xmlHttp.responseText 
								}else {
									document.getElementById("spanUserId").innerHTML = "";
								}
							}else {
								alert("请求失败，错误码=" + xmlHttp.status);
							}
						}
					}
					function check(){
						if(form.username.value.length < 5){	
							document.getElementById("message").innerText = "请输入4位以上的用户名";
							return false;
						}else{
							document.getElementById("message").innerText ="";
							//获取表单中username的值，并去掉首尾空格(trim)
							var password = form.password.value.trim();
							//判断username的长度是否在6~20位,此规则是自定义的，不同系统不同业务判断条件不一样
							if(password.length < 6 && password.length < 20){
								//如果不满足要求，提示用户
								document.getElementById("message").innerText = "请输入6位以上的密码";
								//阻止表单继续提交
								return false;
							}
							//省略其他值有效性判断
							return true;
							
						}
						return true;
			
				    }	
					function recheck(){
			
							
							//获取表单中username的值，并去掉首尾空格(trim)
							var password = form.password.value.trim();
							var repassword = form.repassword.value.trim();
							//判断username的长度是否在6~20位,此规则是自定义的，不同系统不同业务判断条件不一样
							if(password != repassword ){
								//如果不满足要求，提示用户
								document.getElementById("message").innerText = "两次密码不一致！！！";
								//阻止表单继续提交
								return false;
							}
							//省略其他值有效性判断
							document.getElementById("message").innerText ="";
							return true;
							
			
			
				    }	
			
			</script>
</body>
</html>