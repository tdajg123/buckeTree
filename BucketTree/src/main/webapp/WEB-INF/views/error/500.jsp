<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
 <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300italic,600|Arimo:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <!--custom css-->
<style>
body
{
	background-color: #68b2b1;
	font-family: 'Open Sans', sans-serif;
	line-height: 1.2;
}
h1, h2, h3, h4, h5, h6, p
{
	padding: 0px;
	margin: 0px;
}
#home {
    width: 100%;
    text-align:center;
    margin-top:10%;
}
#overlay {
    position: relative;
    height: 100%;
    width: 100%;
    overflow: hidden;
}
a, a:hover, a:focus{
	text-decoration: none;
}
h1.error-title
{
	font-size: 135px;
	font-family: 'Arimo', sans-serif;
	color: #fff;
}
h1.error-title small
{
	font-size: 80px;
	color: #fff;
}
.alert-icon i
{
	font-size: 88px;
	color: #fff;
}
#page-content
{
	padding: 100px 0px 150px;
}
h3.sub-title
{
	font-size: 30px;
	padding-bottom: 15px;
}
.form-control {
    display: block;
    width: 100%;
    height: 50px;
    padding: 6px 86px 6px 12px;
}
.white
{
	color: #fff;
}
.btn-search, .btn-search:hover, .btn-search:focus
{
	background-color: #E74C3C;
	color: #fff;
	padding: 14px 23px;
}
.search-page
{
	margin-top: 40px;
}
.btn-back, .btn-back:hover, .btn-back:focus
{
	background-color: #E74C3C;
	padding: 15px 20px;
	display: inline-block;
	margin-top: 30px;
	color: #fff;
	text-decoration: none;
}
.btn-back i
{
	padding-left: 5px;
}
.no-border-radius
{
	border-radius: 0px;
}
#footer
{
	background-color: #fff;
	position: absolute;
	width: 100%;
	bottom: 0px;
}
.nav-footer
{
	list-style: none;
	float: right;
}
.nav-footer li
{
	display: inline-block;
}
.nav-footer li a
{
	border-right: 1px solid #ddd;
	padding: 0px 15px ;
	color: #E74C3C;
}
.red
{
	color: #E74C3C;
}
.nav-footer li.last-child a
{
	border-right: none;
}
.magt20, .footer-line
{
	margin: 20px 0px;
	text-align: center;
}
@media (min-width: 435px) and (max-width: 768px) {

	.footer-line
	{
		text-align: center;
	}
	.magt20
	{
	display: inline-block;
	text-align: center;
	float: left;
	width: 100%;
	}
}
@media (min-width: 250px) and (max-width: 434px) {
	
	.magt20, .footer-line{
		text-align: center;
		float: left;
	}
	.magt20{
		margin: 20px -14px !important;
	}
	.width-fix{
		width: 300px;
		margin: 0 auto;
	}
}

</style>
</head>
<body>
    <div id="home">
      <div class="container">
        <div class="row">
          <p class="alert-icon"><i class="fa fa-exclamation-triangle"></i></p>
          <h1 class="error-title"><small>ERROR</small> 500</h1>
          <h3 class="sub-title white">Page Not Find!</h3>
          <p class="page-par white">For Some Reason The Page You Requested Could Not Be Found On Our Server</p>
            <a href="javascript:history.go(-1)" class="btn-back">Go Back To Home!<i class="fa fa-arrow-right"></i></a>
      </div>
      </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>