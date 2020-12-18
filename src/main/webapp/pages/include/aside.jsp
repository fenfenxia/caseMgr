<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>aside</title>
</head>
<body>
<aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="#"><img src="../assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">管理员</h5>
              	  	
                  <li class="mt">
                      <a class="active" href="../../index.html">
                          <i class="fa fa-desktop"></i>
                          <span>返回首页</span>
                      </a>
                  </li>
				<!--   病人管理-->
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-bar-chart-o"></i>
                          <span>病人管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="../patient/add.jsp">增加</a></li>
                          <li><a  href="../patient/delete.jsp">删除</a></li>
                          <li><a  href="../patient/modify.jsp">修改</a></li>
						  <li><a  href="../patient/select.jsp">查看</a></li>
                      </ul>
                  </li>
				<!--   药物管理-->
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>药物管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="../medicine/add.jsp">增加</a></li>
                          <li><a  href="../medicine/delete.jsp">删除</a></li>
                          <li><a  href="../medicine/modify.jsp">修改</a></li>
                          <li><a  href="../medicine/select.jsp">查看</a></li>
                      </ul>
                  </li>
                
				  <!--  病历管理-->
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>病历管理</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="../case/add.jsp">增加</a></li>
                          <li><a  href="../case/delete.jsp">删除</a></li>
                          <li><a  href="../case/modify.jsp">修改</a></li>
                          <li><a  href="../case/select.jsp">查看</a></li>
						  
                      </ul>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
</body>
</html>
