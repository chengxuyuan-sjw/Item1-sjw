<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>雇员入职登记</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="../assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="../assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="../assets/css/admin.css">
    <link rel="stylesheet" href="../assets/css/app.css">
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-1.12.4.js"
            integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
            crossorigin="anonymous"></script>

    <script src="../bootstrap/js/bootstrap.js"></script>
    <style type="text/css">
        .tips{
            color: #00e359;
            font-size: 8px
        }
    </style>
    <script type="text/javascript">
        $(function () {
           $("#eid").blur(function () {
               var eid=$("#eid").val();
               var json={"eid":eid};
               $.ajax({
                       type:"post",
                       url:"${pageContext.request.contextPath}/AjaxReset.action", //传送地址
                       contentType : "application/json;charset=utf-8",
                       dataType : "json",
                       data: JSON.stringify(json),
                       success:function(date){
                           if (date==true) {
                               $("#tips").attr("style", "font-size: 14px;color: #00e359");
                               $("#tips").text("该工号可用");
                           }else {
                               $("#tips").attr("style","font-size: 14px;color: #b92c28");
                               $("#tips").text("该工号已存在,请更换工号");
                           }
                       },
                       error:function (e) { //错误如何操作

                       }

                   }

               )
           });

        });
    </script>
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
 <jsp:include page="left.jsp"></jsp:include>
     <div class="tpl-content-wrapper">
         <div class="tpl-content-page-title">
             雇员入职
         </div>

         <div class="tpl-portlet-components">
             <div class="portlet-title">
                 <div class="caption font-green bold">
                     <span class="am-icon-code"></span> 信息录入
                 </div>
             </div>
             <div class="tpl-block">

                 <div class="am-g">
                     <div class="tpl-form-body tpl-form-line">
                         <form class="am-form tpl-form-line-form" action="/addEmpDeatils.action" method="post" enctype="multipart/form-data">
                             <div class="am-form-group">
                                 <label class="am-u-sm-3 am-form-label">工号 <span class="tpl-form-line-small-title">empId</span></label>
                                 <div class="am-u-sm-9">
                                     <input type="text" class="tpl-form-input" id="eid" name="eid" placeholder="请输入员工工号"><span id="tips" ></span>
                                 </div>
                             </div>

                             <div class="am-form-group">
                                 <label class="am-u-sm-3 am-form-label">登陆密码 <span class="tpl-form-line-small-title">empId</span></label>
                                 <div class="am-u-sm-9">
                                     <input type="text" class="tpl-form-input" id="password" name="password" placeholder="请输入员工登陆企业系统的密码">
                                 </div>
                             </div>

                             <div class="am-form-group">
                                 <label  class="am-u-sm-3 am-form-label">入职部门 <span class="tpl-form-line-small-title">dept</span></label>
                                 <div class="am-u-sm-9">
                                     <select data-am-selected="{searchBox: 1}" name="did">
                                         <c:forEach items="${depts}" var="items">
                                         <option value="${items.did}">${items.dname}</option>
                                         </c:forEach>
                                     </select>
                                 </div>
                             </div>

                             <div class="am-form-group">
                                 <label  class="am-u-sm-3 am-form-label">职务 <span class="tpl-form-line-small-title">level</span></label>
                                 <div class="am-u-sm-9">
                                     <select data-am-selected="{searchBox: 1}" name="lid">
                                         <c:forEach items="${levels}" var="item">
                                         <option value="${item.lid}">${item.title}</option>
                                         </c:forEach>
                                     </select>
                                 </div>
                             </div>

                             <div class="am-form-group">
                                 <label class="am-u-sm-3 am-form-label">姓名 <span class="tpl-form-line-small-title">name</span></label>
                                 <div class="am-u-sm-9">
                                     <input type="text" id="ename" name="ename" placeholder="输入入职员工姓名">
                                 </div>
                             </div>

                             <div class="am-form-group">
                                 <label  class="am-u-sm-3 am-form-label">员工照片<span class="tpl-form-line-small-title">Images</span></label>
                                 <div class="am-u-sm-9">
                                     <div class="am-form-group am-form-file">
                                         <button type="button" class="am-btn am-btn-danger am-btn-sm">
                                             <i class="am-icon-cloud-upload"></i> 添加员工照片</button>
                                         <input type="file" name="file" id="file">
                                     </div>

                                 </div>
                             </div>

                             <div class="am-form-group">
                                 <label  class="am-u-sm-3 am-form-label">薪资 <span class="tpl-form-line-small-title">sql</span></label>
                                 <div class="am-u-sm-9">
                                     <input type="text" id="sal" name="sal" placeholder="单位/月">
                                 </div>
                             </div>

                             <div class="am-form-group">
                                 <label  class="am-u-sm-3 am-form-label">联系电话 <span class="tpl-form-line-small-title">empId</span></label>
                                 <div class="am-u-sm-9">
                                     <input type="text" class="tpl-form-input" id="phone" name="phone" placeholder="请输入员工联系方式">
                                 </div>
                             </div>

                             <div class="am-form-group">
                                 <div class="am-u-sm-9 am-u-sm-push-3">
                                     <button type="submit" class="am-btn am-btn-primary">提交信息</button>
                                 </div>
                             </div>

                         </form>
                     </div>
                 </div>
             </div>
         </div>
     </div>
 </div>


 <script src="assets/js/jquery.min.js"></script>
 <script src="assets/js/amazeui.min.js"></script>
 <script src="assets/js/app.js"></script>
</body>
</html>
