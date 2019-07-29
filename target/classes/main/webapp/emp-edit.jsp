<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>雇员信息修改</title>
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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<div class="tpl-content-wrapper">
    <div class="tpl-content-page-title">
        雇员信息修改
    </div>
    <div class="tpl-portlet-components">
        <div class="portlet-title">
            <div class="caption font-green bold">
                <span class="am-icon-code"></span>修改
            </div>


        </div>
        <div class="tpl-block ">

            <div class="am-g tpl-amazeui-form">


                <div class="am-u-sm-12 am-u-md-9">
                    <form class="am-form am-form-horizontal" action="/EmpUpdate.action">
                        <div class="am-form-group">
                            <label for="eid"  class="am-u-sm-3 am-form-label">员工号 / ID</label>
                            <div class="am-u-sm-9">
                                <input type="text" id="eid" name="eid" placeholder="员工号 / ID" value="${param.eid}" readonly>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="did"  class="am-u-sm-3 am-form-label">部门编号 / ID</label>
                            <div class="am-u-sm-9">
                                <input type="text" id="did" name="did" placeholder="部门编号 / DeptId">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="lid" class="am-u-sm-3 am-form-label">职务等级/ LID</label>
                            <div class="am-u-sm-9">
                                <input type="tel" id="lid"  name="lid" placeholder="输入要修改后的等级 / Telephone">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="phone" class="am-u-sm-3 am-form-label">联系电话 / Telephone</label>
                            <div class="am-u-sm-9">
                                <input type="tel" id="phone" name="phone" placeholder="输入要修改的联系电话 / Telephone">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="locked"  class="am-u-sm-3 am-form-label">账户状态</label>
                            <div class="am-u-sm-9">
                                <select data-am-selected="{btnSize: 'sm'}" name="locked" id="locked" >
                                    <option value="option1">账户状态</option>
                                    <option value="1">锁定</option>
                                    <option value="0">正常</option>
                                </select>
                            </div>
                        </div>
                        </br>
                        </br>
                        </br>
                        </br>
                        <div class="am-form-group">
                            <div class="am-u-sm-9 am-u-sm-push-3">
                                <button type="submit" class="am-btn am-btn-primary">保存修改</button>
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
