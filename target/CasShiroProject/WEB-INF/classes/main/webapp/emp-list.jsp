<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>雇员列表</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/app.css">
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-1.12.4.js"
            integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
            crossorigin="anonymous"></script>

    <script src="../bootstrap/js/bootstrap.js"></script>
    <style type="text/css">
        .modal.fade.in{
            top:90px;
        }
    </style>
    <script type="text/javascript">
        $(function () {
           $("li[id^=li-]").click(function () {
              $(this).attr("class","am-active");
           });
        });
        
        $(function () {
           $("#addEmp").click(function () {
               window.location.href="/emp-add.jsp";
           }) 
        });

        $(function () {
            $("#deleteEmp").click(function () {
                var ids="";
                $("input[id^=check-]").each(function () {
                    if ($(this).prop("checked")){
                        ids+=$(this).val()+",";
                    }
                });
                var json={"ids":ids};
                $.ajax({
                        type:"post",
                        url:"${pageContext.request.contextPath}/UpdateLocked.action", //传送地址
                        contentType : "application/json;charset=utf-8",
                        dataType : "json",
                        data: JSON.stringify(json),
                        success:function(date){
                            alert(date);
                        },
                        error:function (e) { //错误如何操作
                            alert("您的数据提交失败");
                        }

                    }

                )
            });
        });

        $(function () {
           $("#addEmp").click(function () {
              window.location.href="/ListAll.action"
           });
        });
    </script>
</head>
<body data-type="generalComponents">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>




<div class="tpl-content-wrapper">
    <div class="tpl-content-page-title">
        雇员列表
    </div>

    <div class="tpl-portlet-components">
        <div class="portlet-title">
            <div class="caption font-green bold">
                <span class="am-icon-code"></span> 列表
            </div>



            <div class="am-g">

                <div class="am-u-sm-12">
                        <div class="tpl-block">
                            <div class="am-g">
                                <div class="am-u-sm-12 am-u-md-6">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" id="addEmp" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增雇员信息</button>
                                            <button type="button" id="deleteEmp" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除所选雇员</button>
                                        </div>
                                    </div>
                                </div>
                                <form action="/LimitEmp.action">
                                <div class="am-u-sm-12 am-u-md-3">
                                    <div class="am-form-group">
                                        <select data-am-selected="{btnSize: 'sm'}" name="column">
                                            <option value="option1">分类查询</option>
                                            <option value="did">所在部门</option>
                                            <option value="eid">员工号码</option>
                                            <option value="lid">职务等级</option>
                                            <option value="ename">员工姓名</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-3">
                                    <div class="am-input-group am-input-group-sm">
                                        <input type="text" id="keyword" name="keyword"  class="am-form-field">
                                        <span class="am-input-group-btn">
                                        <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="submit"></button>
                                        </span>
                                    </div>
                                </div>
                                </form>
                        <table class="am-table am-table-striped am-table-hover table-main">

                            <tr>
                                <th class="table-type">&nbsp;</th>
                                <th class="table-type">照片</th>
                                <th class="table-author am-hide-sm-only">工号</th>
                                <th class="table-set">姓名</th>
                                <th class="table-set">级别</th>
                                <th class="table-set">所在部门</th>
                                <th class="table-set">基本工资</th>
                                <th class="table-type">联系方式</th>
                                <th class="table-type">操作</th>
                            </tr>


                            <c:forEach items="${emps}" var="emps">
                                <tr>
                                    <td><input type="checkbox" id="check-${emps.eid}" value="${emps.eid}"></td>
                                    <td class="am-hide-sm-only">
                                        <img style="width: 20px;height: 20px" src="${emps.photo}">
                                    </td>
                                    <td class="am-hide-sm-only">
                                        ${emps.eid}
                                    </td>
                                    <td class="am-hide-sm-only">
                                        ${emps.ename}
                                    </td>
                                    <td class="am-hide-sm-only">
                                        ${emps.lid}
                                    </td>
                                    <td class="am-hide-sm-only">
                                        ${emps.did}
                                    </td>
                                    <td class="am-hide-sm-only">
                                         ${emps.sal}
                                    </td>
                                    <td class="am-hide-sm-only">
                                         ${emps.phone}
                                    </td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary" id="edit- ${emps.eid}"><span class="am-icon-pencil-square-o"></span><a href="emp-edit.jsp?eid=${emps.eid}">编辑</a></button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                        </table>
                        <div class="am-cf">

                            <div class="am-fr">
                                <ul class="am-pagination tpl-pagination">
                                    <c:forEach var="i" begin="1" end="${count}" step="1">
                                    <li id="li-${i}"><a href="/LimitEmp.action?start=${i}">${i}</a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <hr>
                </div>

            </div>
        </div>
        <div class="tpl-alert"></div>
    </div>

</div>

</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
