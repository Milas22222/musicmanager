<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加音乐</title>
		
		<!-- 配置外部依赖 -->
		<link href="/MusicManagement/css/bootstrap.css" rel="stylesheet">
		
		<script src="/MusicManagement/js/jquery.1.9.min.js"></script>
		<script src="/MusicManagement/js/bootstrap.js"></script>
	</head>

	<body>
		<!-- 导航栏 -->
		<div>
			<nav class="navbar navbar-inverse">
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li><a href="/MusicManagement/index.jsp">首页<span class="sr-only"></span></a></li>
			        <li class="active"><a href="/MusicManagement/addMusic.jsp">添加音乐</a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">购买专辑</a></li>
			            <li><a href="#">商店</a></li>
			            <li><a href="#">我的购买项</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="#">其他曲库</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="#">dididid</a></li>
			          </ul>
			        </li>
			      </ul>
			      
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="#">用户：</a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">root <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">主页</a></li>
			            <li><a href="#">联系我们</a></li>
			            <li><a href="#">私信</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="#"></a></li>
			          </ul>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</div>
		<!-- 设置轮播图 -->
		<div class="center-block">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="margin-left: 22%; margin-right: 22%">
			  <ol class="carousel-indicators">
			    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
			  </ol>
			
			  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img class="img-responsive center-block" src="/MusicManagement/img/01.jpg">
			    </div>
			    <div class="item">
			      <img class="img-responsive center-block" src="/MusicManagement/img/02.jpg">
			    </div>
			    <div class="item">
			      <img class="img-responsive center-block" src="/MusicManagement/img/03.jpg">
			    </div>
			  </div>
			
			  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
		</div>
		
		<br/>
		<!-- 添加音乐 -->
		<div class="container">
			<form action="/MusicManagement/AddServlet" method="post" enctype="multipart/form-data">
			  <div class="form-group">
			    <label for="exampleInputEmail1">音乐名称：</label>
			    <input type="text" name="mname" class="form-control" placeholder="请输入音乐名称">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail1">作者名称：</label>
			    <input type="text" name="author" class="form-control" placeholder="请输入作者名称">
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputFile">选择需要添加的音乐文件：</label>
			    <input type="file" name="files" >
			  </div>
			  <div>
			  	<input type="submit" class="btn btn-info" value="添加音乐"/>
			  </div>
			</form>
		</div>
		
	</body>
</html>