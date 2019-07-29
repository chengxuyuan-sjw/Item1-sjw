<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>修改申请</title>
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
        修改出差申请
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
                    <form class="am-form am-form-horizontal" action="/UpdateTravel.action">

                        <div class="am-form-group">
                            <label for="title"  class="am-u-sm-3 am-form-label">申请事由 / ID</label>
                            <div class="am-u-sm-9">
                                <input type="text" id="title" name="title" placeholder="${deatils.title}">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="sdate" class="am-u-sm-3 am-form-label">出差开始时间/ Start</label>
                            <div class="am-u-sm-9">
                                <input type="datetime" id="sdate"  name="sdate" placeholder="请按照yyyy-MM-dd格式输入">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="edate" class="am-u-sm-3 am-form-label">出差结束时间/ End</label>
                            <div class="am-u-sm-9">
                                <input type="datetime" id="edate" name="edate" placeholder="请按照yyyy-MM-dd格式输入" />
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="iid"  class="am-u-sm-3 am-form-label">出差类型</label>
                            <div class="am-u-sm-9">
                                <select data-am-selected="{btnSize: 'sm'}" name="iid" id="iid" >
                                    <option value="option1">===出差类型===</option>
                                    <c:forEach items="${items}" var="item">
                                    <option value="${item.iid}">${item.title}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="note" class="am-u-sm-3 am-form-label">出差详情 / Intro</label>
                            <div class="am-u-sm-9">
                                <textarea class="" rows="5" name="note" id="note" placeholder="${deatils.note}" ></textarea>
                                <input type="hidden" name="tid" value="${param.tid}">
                                <small>250字以内写出主要详情...</small>
                            </div>
                        </div>
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
