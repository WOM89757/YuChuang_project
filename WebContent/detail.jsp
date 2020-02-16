<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Single</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
	<meta name="keywords" content="" />
	<link rel="stylesheet" href="layui/dist/css/layui.css?t=1568076536509" media="all">
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/login_overlay.css" rel='stylesheet' type='text/css' />
	<link href="css/style6.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="css/shop.css" type="text/css" />
	<link rel="stylesheet" href="css/owl.carousel.css" type="text/css" media="all">
	<link rel="stylesheet" href="css/owl.theme.css" type="text/css" media="all">
	<link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
	<link href="css/easy-responsive-tabs.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/fontawesome-all.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Inconsolata:400,700" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800"
	    rel="stylesheet">
</head>

<body>
	<div class="banner-top container-fluid" id="home">
		<!-- header -->
		<header>
			<div class="row">
				<div class="col-md-3 top-info text-left mt-lg-4">
				</div>
				<div class="col-md-6 logo-w3layouts text-center">
					<h1 class="logo-w3layouts">
						<a class="navbar-brand" href="index.html">
							Goggles </a>
					</h1>
				</div>

				<div class="col-md-3 top-info-cart text-right mt-lg-4">
				<ul class="cart-inner-info">
						<li class="button-log">
						<c:if test="${user!=null }">尊敬的 ${user.name }<c:if test="${user.name==null }">${user.username }</c:if>用户欢迎您！ </c:if>
							
								<a class="btn-open" href="#"> <span class="fa fa-user" aria-hidden="true"></span>
								
							</a>
							<c:if test="${user!=null }"> <a href="logout.action">注销</a></c:if>
							
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
													<span id="messaged" style="color: red;"> </span>
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
													<span id="message" style="color: red;"> </span>
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
		<!-- banner -->
		<div class="banner_inner">
			<div class="services-breadcrumb">
				<div class="inner_breadcrumb">

					<ul class="short">
						<li>
							<a href="goodslist.action">Home</a>
							<i>|</i>
						</li>
						<li>Single Page</li>
					</ul>
				</div>
			</div>

		</div>
		
	</div>
		<!--//banner -->
		<!--/shop-->
		<section class="banner-bottom-wthreelayouts py-lg-5 py-3">
			<div class="container">
				<div class="inner-sec-shop pt-lg-4 pt-3">
					<div class="row">
							<div class="col-lg-4 single-right-left ">
									<div class="grid images_3_of_2">
										<div class="flexslider1">
					
											<ul class="slides">
												<li data-thumb="images/d2.jpg">
													<div class="thumb-image"> <img src="${goods.img }" data-imagezoom="true" class="img-fluid" alt=" "> </div>
												</li>

											</ul>
											<div class="clearfix"></div>
										</div>
									</div>
								</div>
								<div class="col-lg-8 single-right-left simpleCart_shelfItem">
									<h3> ${goods.name }</h3>
									<p><span class="item_price">￥${ goods.price } </span>
												<span>${goods.intro }</span>
									</p>
									<div class="rating1">
										<ul class="stars">
											<li><a href=""><i class="fa fa-star" aria-hidden="true"></i></a></li>
											<li><a href=""><i class="fa fa-star" aria-hidden="true"></i></a></li>
											<li><a href=""><i class="fa fa-star" aria-hidden="true"></i></a></li>
											<li><a href=""><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
											<li><a href=""><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
										</ul>
									</div>

					
									
									<div class="occasion-cart">
											<div class="googles single-item singlepage">
													<form action="#" method="post">
														<input type="hidden" name="cmd" value="_cart">
														<input type="hidden" name="add" value="1">
														<input type="hidden" name="googles_item" value="${ goods.name }">
														<input type="hidden" name="amount" value="${ goods.price }">
														<input type="hidden" name="shipping" value="${goods.id }">
														<input type="hidden" name="shipping2" value="${goods.img }">
														<button type="submit" class="googles-cart pgoogles-cart">
															加入购物袋
														</button>
														
													</form>
		
												</div>
									</div>
	
			
								</div>
								<div class="clearfix"> </div>
								<!--/tabs-->
								<div class="responsive_tabs">
									<div id="horizontalTab">
										<ul class="resp-tabs-list">
											<li>Description</li>
											<li>Reviews</li>
										
										</ul>
										<div class="resp-tabs-container">
											<!--/tab_one-->
											<div class="tab1">
					
												<div class="single_page">
													<h6>${goods.name }</h6>
													<p>${ goods.description }</p>
												</div>
											</div>
											<!--//tab_one-->
											<div class="tab2">
					
												<div class="single_page">
													<div class="bootstrap-tab-text-grids">
													<c:forEach items="${reviewslist }" var="reviews">
														<div class="bootstrap-tab-text-grid">
															<div class="bootstrap-tab-text-grid-left">
																<img src="${reviews.img }" alt=" " class="img-fluid">
															</div>
															<div class="bootstrap-tab-text-grid-right">
																<ul>
																	<li><a href="#">${reviews.name }</a></li>
																	<li><a href="#"><i class="fa fa-reply-all" aria-hidden="true"></i> Reply</a></li>
																</ul>
																<p>${reviews.content }</div>
															<div class="clearfix"> </div>
														</div>
													</c:forEach>	
														<div class="add-review">
															<h4>add a review</h4>
															<form action="reviews.action?do=addreviews&goodsid=${goods.id }&userid=${user.id } " method="post">
																	<!-- <input class="form-control" type="text" name="Name" placeholder="Enter your name..." required="">
																<input class="form-control" type="email" name="Email" placeholder="Enter your email..." required="">
																 --><textarea name="Message" required=""></textarea>
																<input type="submit" value="SEND">
															</form>
														</div>
													</div>
					
												</div>
											</div>

											</div>
										</div>
									</div>
								</div>
								<!--//tabs-->
					
					</div>
				</div>
			</div>
				<div class="container-fluid">
					<!--/slide-->
					<div class="slider-img mid-sec mt-lg-5 mt-2 px-lg-5 px-3">
						<!--//banner-sec-->
						<h3 class="tittle-w3layouts text-left my-lg-4 my-3">Featured Products</h3>
						<div class="mid-slider">
							<div class="owl-carousel owl-theme row">
						<c:forEach items="${goodslist }" var="good">
															<div class="item">
									<div class="gd-box-info text-center">
										<div class="product-men women_two bot-gd">
											<div class="product-googles-info slide-img googles">
												<div class="men-pro-item">
													<div class="men-thumb-item">
														<img src="${good.img }" class="img-fluid" alt="">
														<div class="men-cart-pro">
															<div class="inner-men-cart-pro">
																<a href="detail.action?goodsid=${good.id }&do=getreviews " class="link-product-add-cart">Quick View</a>
															</div>
														</div>
														<span class="product-new-top">New</span>
													</div>
													<div class="item-info-product">

														<div class="info-product-price">
															<div class="grid_meta">
																<div class="product_price">
																	<h4>
																		<a href="single.html">${good.name } </a>
																	</h4>
																	<div class="grid-price mt-2">
																		<span class="money ">${good.price }</span>
																	</div>
																</div>
																<ul class="stars">
																	<li>
																		<a href="#">
																			<i class="fa fa-star" aria-hidden="true"></i>
																		</a>
																	</li>
																	<li>
																		<a href="#">
																			<i class="fa fa-star" aria-hidden="true"></i>
																		</a>
																	</li>
																	<li>
																		<a href="#">
																			<i class="fa fa-star" aria-hidden="true"></i>
																		</a>
																	</li>
																	<li>
																		<a href="#">
																			<i class="fa fa-star-half-o" aria-hidden="true"></i>
																		</a>
																	</li>
																	<li>
																		<a href="#">
																			<i class="fa fa-star-o" aria-hidden="true"></i>
																		</a>
																	</li>
																</ul>
															</div>
															<div class="googles single-item hvr-outline-out">
																<form action="#" method="post">
																	<input type="hidden" name="cmd" value="_cart">
																	<input type="hidden" name="add" value="1">
																	<input type="hidden" name="googles_item" value="${good.name }">
																	<input type="hidden" name="amount" value="${good.price }">
																	<button type="submit" class="googles-cart pgoogles-cart">
																		<i class="fas fa-cart-plus"></i>
																	</button>
																</form>

															</div>
														</div>

													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
						</c:forEach>

							</div>
							</div>
						</div>
				</div>
		</section>
		<!--footer -->
			<c:import url="footer.jsp"></c:import>
		<!-- //footer -->

		<!--jQuery-->
		<script src="js/jquery-2.2.3.min.js"></script>
		<!-- newsletter modal -->
		<!--search jQuery-->
		<script src="js/modernizr-2.6.2.min.js"></script>
		<script src="js/classie-search.js"></script>
		<script src="js/demo1-search.js"></script>
		<!--//search jQuery-->
		<!-- cart-js -->
		<script src="js/minicart.js"></script>
		<script>
			googles.render();

			googles.cart.on('googles_checkout', function (evt) {
				var items, len, i;

				if (this.subtotal() > 0) {
					items = this.items();

					for (i = 0, len = items.length; i < len; i++) {}
				}
			});
		</script>
		<!-- //cart-js -->
		<script>
			$(document).ready(function () {
				$(".button-log a").click(function () {
					$(".overlay-login").fadeToggle(200);
					$(this).toggleClass('btn-open').toggleClass('btn-close');
				});
			});
			$('.overlay-close1').on('click', function () {
				$(".overlay-login").fadeToggle(200);
				$(".button-log a").toggleClass('btn-open').toggleClass('btn-close');
				open = false;
			});
		</script>
		<!-- carousel -->
		<!-- price range (top products) -->
		<script src="js/jquery-ui.js"></script>
		<script>
			//<![CDATA[ 
			$(window).load(function () {
				$("#slider-range").slider({
					range: true,
					min: 0,
					max: 9000,
					values: [50, 6000],
					slide: function (event, ui) {
						$("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
					}
				});
				$("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));

			}); //]]>
		</script>
		<!-- //price range (top products) -->

		<script src="js/owl.carousel.js"></script>
		<script>
			$(document).ready(function () {
				$('.owl-carousel').owlCarousel({
					loop: true,
					margin: 10,
					responsiveClass: true,
					responsive: {
						0: {
							items: 1,
							nav: true
						},
						600: {
							items: 2,
							nav: false
						},
						900: {
							items: 3,
							nav: false
						},
						1000: {
							items: 4,
							nav: true,
							loop: false,
							margin: 20
						}
					}
				})
			})
		</script>

		<!-- //end-smooth-scrolling -->

		<!-- single -->
		<script src="js/imagezoom.js"></script>
		<!-- single -->
		<!-- script for responsive tabs -->
		<script src="js/easy-responsive-tabs.js"></script>
		<script>
			$(document).ready(function () {
				$('#horizontalTab').easyResponsiveTabs({
					type: 'default', //Types: default, vertical, accordion           
					width: 'auto', //auto or any width like 600px
					fit: true, // 100% fit in a container
					closed: 'accordion', // Start closed if in accordion view
					activate: function (event) { // Callback function if tab is switched
						var $tab = $(this);
						var $info = $('#tabInfo');
						var $name = $('span', $info);
						$name.text($tab.text());
						$info.show();
					}
				});
				$('#verticalTab').easyResponsiveTabs({
					type: 'vertical',
					width: 'auto',
					fit: true
				});
			});
		</script>
		<!-- FlexSlider -->
		<script src="js/jquery.flexslider.js"></script>
		<script>
			// Can also be used with $(document).ready()
			$(window).load(function () {
				$('.flexslider1').flexslider({
					animation: "slide",
					controlNav: "thumbnails"
				});
			});
		</script>
		<!-- //FlexSlider-->

		<!-- dropdown nav -->
		<script>
			$(document).ready(function () {
				$(".dropdown").hover(
					function () {
						$('.dropdown-menu', this).stop(true, true).slideDown("fast");
						$(this).toggleClass('open');
					},
					function () {
						$('.dropdown-menu', this).stop(true, true).slideUp("fast");
						$(this).toggleClass('open');
					}
				);
			});
		</script>
		<!-- //dropdown nav -->
	<script src="js/move-top.js"></script>
    <script src="js/easing.js"></script>
    <script>
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event) {
                event.preventDefault();
                $('html,body').animate({
                    scrollTop: $(this.hash).offset().top
                }, 900);
            });
        });
    </script>
    <script>
        $(document).ready(function() {
            /*
            						var defaults = {
            							  containerID: 'toTop', // fading element id
            							containerHoverID: 'toTopHover', // fading element hover id
            							scrollSpeed: 1200,
            							easingType: 'linear' 
            						 };
            						*/

            $().UItoTop({
                easingType: 'easeOutQuart'
            });

        });
    </script>
    <!--// end-smoth-scrolling -->


		<script src="js/bootstrap.js"></script>

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
		<!-- js file -->
</body>

</html>