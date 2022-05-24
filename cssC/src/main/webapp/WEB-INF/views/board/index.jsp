<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../common/head.jsp"/>
</head>
  <body>
    <div class="site-mobile-menu">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close">
            	<span class="icofont-close js-menu-toggle"></span>
            </div>
        	<div class="site-mobile-menu-body"></div>
		</div>
    </div> <!-- /.untree_co-hero -->
    <jsp:include page="../common/nav.jsp"></jsp:include>
    <div class="untree_co-hero">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-12">
                    <div class="row align-items-center justify-content-between">
                        <div class="col-lg-5">
                            <h1 class="mb-4 heading" data-aos="fade-up" data-aos-delay="100">"오늘 뭐먹조?"</h1>
                            <div class="mb-4 desc" data-aos="fade-up" data-aos-delay="200">
                            	<p><a href="#" target="_blank" class="link-highlight">음식점 고르기 전</a></p>
                            </div>
                            <p class="mb-0" data-aos="fade-up" data-aos-delay="300"><a href="#" class="btn btn-primary">주소선택</a></p>
                        </div>
                        <div class="col-lg-6" data-aos="fade-up" data-aos-delay="100">
                            <div class="hero-img-wrap">
                                <span class="img-circle rotating">
                                	<img src="/resources/assets/images/circle-two.png" alt="Image" class="img-fluid">
                                </span>
                                <span class="img-circle rotating2">
                                	<img src="/resources/assets/images/circle-one.png" alt="Image" class="img-fluid">
                                </span>
                                <img src="/resources/assets/images/bowl.png" alt="Image" class="img-fluid img-bowl">
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div>	  
    <ul class="list-unstyled social-hero-section mb-0">
        <li data-aos="fade-left" data-aos-delay="0"><a href="#"><span class="icon-whatsapp"></span></a></li>
        <li data-aos="fade-left" data-aos-delay="100"><a href="#"><span class="icon-instagram"></span></a></li>
        <li data-aos="fade-left" data-aos-delay="200"><a href="#"><span class="icon-facebook"></span></a></li>
        <li data-aos="fade-left" data-aos-delay="300"><a href="#"><span class="icon-twitter"></span></a></li>
    </ul>
  

  
	<div class="untree_co-section">
	    <div class="container">
	
	    	<div class="row mb-5">
	     		<div class="col-lg-12 text-center">
	        	<ul class="custom-nav js-custom-dots list-unstyled">
	            	<li class="active"><a href="#">menu</a></li>
	        	</ul>
	        </div>
		</div>
	    <div class="owl-single no-dots owl-carousel">
			<div class="item">
	        	<div class="row mb-5">
	            	<div class="col-12 text-center">
	            	<h2 class="heading">Category</h2>
	        		</div>
	       		</div>
		        <div class="row">
		        	<div class="col-6 col-md-6 col-lg-4 mb-4">
			            <div class="product">
			            	<a href="#" class="thumbnail"><img src="/resources/assets/images/bowl.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="#">치킨</a></h3>
			            </div>
		        	</div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
			        	<div class="product">
			            	<a href="#" class="thumbnail"><img src="/resources/assets/images/bowl-2.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="#">피자</a></h3>
			            </div>
			        </div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
			        	<div class="product">
			            	<a href="#" class="thumbnail"><img src="/resources/assets/images/bowl-3.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="#">중국집</a></h3>
			            </div>
			        </div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
				        <div class="product">
			                <a href="#" class="thumbnail"><img src="/resources/assets/images/bowl-2.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="#">한식</a></h3>
			            </div>
			        </div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
				        <div class="product">
			                <a href="#" class="thumbnail"><img src="/resources/assets/images/bowl-3.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="#">일식/돈까스</a></h3>
			            </div>
			        </div>
			        <div class="col-6 col-md-6 col-lg-4 mb-4">
			     		<div class="product">
			            	<a href="#" class="thumbnail"><img src="/resources/assets/images/bowl.png" alt="Image" class="img-fluid"></a>
			                <h3 class="mb-0"><a href="#">족발/보쌈</a></h3>
			            </div>
			        </div>
			    </div>
		    </div> <!-- end breeakfast -->
	    </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>