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
						<h4>html</h4>
							<div class="progress">
							  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
								<span class="sr-only">40% Complete (success)</span>
							  </div>
							</div>
						<h4>css</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
							<span class="sr-only">20% Complete</span>
						  </div>
						</div>
						<h4>js</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
							<span class="sr-only">30% Complete (warning)</span>
						  </div>
						</div>
						<h4>php</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
							<span class="sr-only">50% Complete (danger)</span>
						  </div>
						</div>
					</div>
					<div class="col-md-6 about-right">
						<h4>illustrate</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
							<span class="sr-only">70% Complete (danger)</span>
						  </div>
						</div>
						<h4>print</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
							<span class="sr-only">60% Complete (danger)</span>
						  </div>
						</div>
						<h4>photoshop</h4>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
							<span class="sr-only">90% Complete (danger)</span>
						  </div>
						</div>
						<h4>media</h4>
							<div class="progress">
							  <div class="progress-bar progress-bar-danger-3" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%">
								<span class="sr-only">75% Complete (success)</span>
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
			<h3>Services</h3>
			<div class="service-grids">
							<div class="col-md-4 service-grid">
									<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
								<h4>THE BEST DESIGN</h4>
								<span> </span>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages containing of Letraset sheets</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<h4>THE BEST SUPPORT</h4>
								<span> </span>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages containing of Letraset sheets</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-bullhorn" aria-hidden="true"></span>
								<h4>THE BEST SOLUTIONS</h4>
								<span> </span>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages containing of Letraset sheets</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
								<h4>THE BEST SOLUTIONS</h4>
								<span> </span>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages containing of Letraset sheets</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
								<h4>THE BEST SOLUTIONS</h4>
								<span> </span>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages containing of Letraset sheets</p>
							</div>
							<div class="col-md-4 service-grid">
								<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
								<h4>THE BEST SOLUTIONS</h4>
								<span> </span>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod Lorem Ipsum passages containing of Letraset sheets</p>
							</div>
							<div class="clearfix"> </div>
						</div>
		</div>
	</div>
<!-- services -->
<!-- portfolio -->
	<div class="gallery">
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
	<div class="client">
		<div class="container">
			<h3>Clients</h3>
			<div class="nbs-flexisel-container"><div class="nbs-flexisel-inner"><ul id="flexiselDemo1" class="nbs-flexisel-ul" style="left: -228px; display: block;">			
					
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<img src="me/images/5.png" alt=" " class="img-responsive">
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<img src="me/images/2.png" alt=" " class="img-responsive">
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<img src="me/images/3.png" alt=" " class="img-responsive">
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<img src="me/images/4.png" alt=" " class="img-responsive">
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<img src="me/images/6.png" alt=" " class="img-responsive">
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<img src="me/images/7.png" alt=" " class="img-responsive">
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<img src="me/images/5.png" alt=" " class="img-responsive">
						</div>
					</li>
					<li class="nbs-flexisel-item" style="width: 300px;">
						<div class="sliderfig-grid">
							<img src="me/images/1.png" alt=" " class="img-responsive">
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