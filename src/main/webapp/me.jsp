<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>就是个农民工</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="ice,多线程,并发,java后端,数据库设计,bootstrap,jquery,兼职" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<%@include file="navi.jsp"%>
<link href="me/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="me/css/swipebox.css">
<script src="me/js/jquery.min.js"></script>
<script type="text/javascript" src="me/js/move-top.js"></script>
       <script type="text/javascript" src="me/js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
				});
			});
		</script>
		<script type="text/javascript">
		$(document).ready(function() {
				/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
				*/
		$().UItoTop({ easingType: 'easeOutQuart' });
});
</script>
<!------ Light Box ------>
    <script src="me/js/jquery.swipebox.min.js"></script> 
    <script type="text/javascript">
		jQuery(function($) {
			$(".swipebox").swipebox();
		});
	</script>
    <!------ Eng Light Box ------>
</head>
<body>
<!-- header -->
	<div class="banner">
		<div class="container">
			<div class="logo">
				<h1><a href="index.jsp">穷</a></h1>
			</div>	
			<div class="banner-info">
				<h2>Hi,I am Ice</h2>
				<h3>外号：三寸光阴</h3>
			</div>
		</div>
	</div>
<!-- header -->
<!-- about -->
				<div class="scroll">
					<a href="#contact" class="scroll"><img src="me/images/down.png" class="img-responsive" alt=""></a>
				</div>
	<div class="about">
		<div class="container">
			<h3>会干啥</h3>
			<div class="study2">
			<div class="col-md-6 about-left">
						<h4>javaEE</h4>
							<div class="progress">
							  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
							  </div>
							</div>
						<h4>代码质量</h4>
							<div class="progress">
							  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
							  </div>
							</div>
						<h4>java多线程</h4>
							<div class="progress">
							  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
							  </div>
							</div>
						<h4>bootstrap+jquery</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 67%">
						  </div>
						</div>
						<h4>scrum</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 64%">
						  </div>
						</div>
					</div>
					<div class="col-md-6 about-right">
						<h4>spring</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
						  </div>
						</div>
						<h4>持续集成</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
						  </div>
						</div>
						<h4>数据库设计</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 76%">
						  </div>
						</div>
						<h4>linux</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 73%">
						  </div>
						</div>
						<h4>svn+git</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
						  </div>
						</div>
					</div>
		</div>
	</div>
	</div>
<!-- about -->
<!-- services -->
	<div class="services">
		<div class="container">
			<h3>干过啥</h3>
			<div class="service-grids">
							<div class="col-md-4 service-grid">
									<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
								<h4>Coding in JAVA</h4>
								<span></span>
								<p>代码敲了6年多,喜欢敲击键盘,生产代码的感觉,同事也是为了实现自身的价值,不仅仅是出卖劳力,挣命生活.随着时间的推移,对代码越来越敬畏,想一直coding下去.</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<h4>多线程开发</h4>
								<span></span>
								<p>基本开发,线程调优,线程安全,线程协同.对于多线程开发有不少的经验和心得.对于ringbuffer也有所了解,也很不错的东西,了解原理、思想。
								</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-bullhorn" aria-hidden="true"></span>
								<h4>数据库设计</h4>
								<span> </span>
								<p>参与过系统的设计,经历过从0到1的旅程.对表设计、索引、分表、分库等有不少经验和心得.调优sql自然也是会的.不过具体DBA,还相差不少,毕竟术业有专攻^_^</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
								<h4>敏捷开发</h4>
								<span></span>
								<p>喜欢真正的敏捷,在每个迭代中快速得到反馈,进行修正,感受迭代成功的喜悦.曾做过scrum master,做过具体的执行.对看板、卡片、迭代会议有一定的经验,也有自己的认识.</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
								<h4>持续集成</h4>
								<span> </span>
								<p>虽然对其理论知识理解不深刻,但是实践中一直在遵循,也深刻知道其优点和带来的巨大好处.会长期的执行下去,就像一种习惯.当然,也会搭建持续集成的环境,并实践过.</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
								<h4>代码质量</h4>
								<span> </span>
								<p><b>放在最后,不是不重,而是太重!</b>我写的代码,一定会去雕琢它,不管有没有人看!因为你对它敬畏了,它自然会以一种方式反馈给你的!我爱高质量的代码,轻微洁癖!一般会用sonar撸一遍代码~</p>
							</div>
							<div class="clearfix"> </div>
						</div>
		</div>
	</div>
<!-- services -->
<!-- portfolio 后端工程师。。。没这多可炫的，可耻的hidden了。。。。-->
	<div class="gallery" hidden="hidden">
		<div class="container">
			<h3>Portfolio</h3>
			<div class="portfolio">
					<div id="portfoliolist">
					<div class="portfolio card mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="me/images/2.JPG" class="swipebox"  title="Image Title"> <img src="me/images/2.JPG" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>
		                </div>
					</div>				
					<div class="portfolio app mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="me/images/3.JPG" class="swipebox"  title="Image Title"> <img src="me/images/3.JPG" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>
		                </div>
					</div>					
					<div class="portfolio icon mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="icon" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="me/images/4.JPG" class="swipebox"  title="Image Title"> <img src="me/images/4.JPG" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>
		                </div>
					</div>
					<div class="portfolio app mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="me/images/5.JPG" class="swipebox"  title="Image Title"> <img src="me/images/5.JPG" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>
		                </div>
					</div>			
					<div class="portfolio card mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="me/images/6.JPG" class="swipebox"  title="Image Title"> <img src="me/images/6.JPG" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>
		                </div>
					</div>	
					<div class="portfolio card mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="me/images/7.JPG" class="swipebox"  title="Image Title"> <img src="me/images/7.JPG" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>
		                </div>
					</div>	
					<div class="portfolio icon mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="icon" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="me/images/13.JPG" class="swipebox"  title="Image Title"> <img src="me/images/13.JPG" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>
		                </div>
						</div>
					<div class="portfolio logos mix_all wow bounceIn" data-wow-delay="0.4s" data-cat="logos" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="me/images/14.JPG" class="swipebox"  title="Image Title"> <img src="me/images/14.JPG" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>
		                </div>
					</div>
				<div class="clearfix"></div>					
				</div>
		  <div class="clearfix"></div>
			</div>

		</div>
	</div>
<!-- portfolio -->	
<!-- client -->
<style>
img{
border-radius: 9px;
-webkit-border-radius: 9px;
-moz-border-radius: 9px;
}
</style>
	<div class="client">
		<div class="container">
			<h3>哪待过</h3>
			<div class="nbs-flexisel-container"><div class="nbs-flexisel-inner"><ul id="flexiselDemo1" class="nbs-flexisel-ul" style="left: -228px; display: block;">			
					
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<a href="http://www.shuyun.com/" target="view_window1"><img src="me/images/shuyun.jpg" alt=" " class="img-responsive"></a>
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<a href="http://www.ericsson.com/cn/" target="view_window2"><img src="me/images/ericsson.jpg" alt=" " class="img-responsive"></a>
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<a href="http://www.ctrip.com/" target="view_window3"><img src="me/images/ctrip.jpg" alt=" " class="img-responsive"></a>
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<a href="http://www.jme.com/" target="view_window4"><img src="me/images/jme.jpg" alt=" " class="img-responsive"></a>
						</div>
					</li>
					
					</ul>
					<div class="nbs-flexisel-nav-left" style="top: 27.5px;"></div><div class="nbs-flexisel-nav-right" style="top: 27.5px;"></div></div></div>
					<script type="text/javascript">
							$(window).load(function() {
								$("#flexiselDemo1").flexisel({
									visibleItems: 7,
									animationSpeed: 1000,
									autoPlay: true,
									autoPlaySpeed: 3000,    		
									pauseOnHover: true,
									enableResponsiveBreakpoints: true,
									responsiveBreakpoints: { 
										portrait: { 
											changePoint:480,
											visibleItems: 2
										}, 
										landscape: { 
											changePoint:640,
											visibleItems:3
										},
										tablet: { 
											changePoint:768,
											visibleItems: 3
										}
									}
								});
								
							});
					</script>
					<script type="text/javascript" src="me/js/jquery.flexisel.js"></script>



		</div>
	</div>
<!-- client -->
<!-- contact 
	<div class="contact" id="contact">
		<div class="container">
			<h3>Contact</h3>
			<div class="footer-left">
				<li><i class="add"> </i>lorem ipsum</li>
				<li><i class="phone"> </i>1234567890</li>
				<li><a href="mailto:info@example.com"><i class="mail"> </i>info@sitename.com </a></li>
			<div class="soci">
					<ul>
						<li><a href="#"><i class="facebk"> </i></a></li>
						<li><a href="#"><i class="twter"> </i></a></li>
						<li><a href="#"><i class="goopl"> </i></a></li>
						<li><a href="#"><i class="insta"> </i></a></li>
							<div class="clearfix"></div>	
					</ul>
			</div>
			</div>
			<div class="co-ntact">
	
				  <form method="post" action="contact-post.html">
					<div class="to">
                     	<input type="text" class="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}">
					 	<input type="text" class="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}">
					 	<input type="text" class="text" value="Subject" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Subject';}">
					</div>
					<div class="text">
	                   <textarea value="Message" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message';}">Message</textarea>
	                   <div class="form-submit">
			           <input name="submit" type="submit" id="submit" value="Submit"><br>
			           </div>
	                </div>
	                <div class="clearfix"></div>
                   </form>
			</div>
		</div>
	</div>
 contact -->
	<a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 0;"></span> <span id="toTopHover" style="opacity: 0;"> </span></a>
	<div class="contact" id="contact"></div>
	<div class="ds-thread" data-thread-key="whq-message" data-title="我很穷简介" data-url="www.wohenqiong.com/me.jsp"></div>
	
</body>
</html>