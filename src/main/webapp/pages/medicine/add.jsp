<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keyword" content="">

    <title>首页</title>

    <!-- Bootstrap core CSS -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="../assets/css/style.css" rel="stylesheet">
    <link href="../assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<section id="container" >
    <!-- **********************************************************************************************************************************************************
    TOP BAR CONTENT & NOTIFICATIONS
    *********************************************************************************************************************************************************** -->
    <!--header start-->
    <jsp:include page="../include/head.jsp"/>
    <!--header end-->

    <!-- **********************************************************************************************************************************************************
    MAIN SIDEBAR MENU
    *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <jsp:include page="../include/aside.jsp"/>
    <!--sidebar end-->

    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper site-min-height">
			<div class="row mt">
				<div class="col-lg-12">
					<div class="form-panel">
			      	  <h4 class="mb"><i class="fa fa-angle-right"></i>请输入药物信息</h4>
			              <form  enctype="multipart/form-data" class="form-horizontal tasi-form" method="post" action="add.do" >
			                  <div class="form-group has-success">
			                      <label class="col-sm-2 control-label col-lg-2" for="name">名称</label>
			                      <div class="col-lg-10">
			                          <input type="text" class="form-control" id="name" name="name" type="text">
			                      </div>
			                  </div>
							  <div class="form-group has-success">
							      <label class="col-sm-2 control-label col-lg-2" for="price">价格</label>
							      <div class="col-lg-10">
							          <input type="text" class="form-control" id="price" name="price" type="text">
							      </div>
							  </div>
							  
							  <div class="form-group has-success">
							      <label class="col-sm-2 control-label col-lg-2" for="photo">照片</label>
							      <div class="col-lg-10">
							          <input type="file" class="form-control" id="photo" name="photo">
							      </div>
							  </div>
							  <button type="submit">提交</button>
							  <button type="reset">重置</button>
			              </form>
						  <a href="/caseMgr/pages/patient/list.do">返回列表</a>
					</div><!-- /form-panel -->
				</div><!-- /col-lg-12 -->
			</div>
        </section>
    </section><!-- /MAIN CONTENT -->

    <!--main content end-->
    <!--footer start-->
    <jsp:include page="../include/footer.jsp"/>
    <!--footer end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
<script class="include" type="text/javascript" src="../assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="../assets/js/jquery.scrollTo.min.js"></script>
<script src="../assets/js/jquery.nicescroll.js" type="text/javascript"></script>


<!--common script for all pages-->
<script src="../assets/js/common-scripts.js"></script>

<!--script for this page-->


</body>
</html>

