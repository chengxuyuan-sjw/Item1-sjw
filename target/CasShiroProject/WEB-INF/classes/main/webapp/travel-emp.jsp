<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>出差人员列表</title>
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

</head>
<body data-type="generalComponents">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>




<div class="tpl-content-wrapper">
    <div class="tpl-content-page-title">
        出差详细情况
    </div>

    <div class="tpl-portlet-components">
        <div class="portlet-title">
            <div class="caption font-green bold">
                <span class="am-icon-code"></span> 记录
            </div>



            <div class="am-g">

                <div class="am-u-sm-12">
                    <div class="tpl-block">
                        <div class="am-g">
                            <div class="am-u-sm-12 am-u-md-6">
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button" id="addEmp" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增差旅申请</button>
                                    </div>
                                </div>
                            </div>

                            <table class="am-table am-table-striped am-table-hover table-main">

                                <tr>
                                    <th class="table-author am-hide-sm-only">申请编号</th>
                                    <th class="table-author am-hide-sm-only">姓名</th>
                                    <th class="table-set">联系方式</th>
                                    <th class="table-set">基本工资</th>
                                    <th class="table-set">工号</th>
                                    <th class="table-set">入职时间</th>
                                    <th class="table-type">操作</th>
                                </tr>


                                <c:forEach items="${travels}" var="item">
                                    <tr>


                                        <td>
                                            <c:if test="${item.audit==9}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-secondary" value="已提交"></button>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.audit==2}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-danger" value="被拒绝"></button>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.audit==1}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-success" value="被通过"></button>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.audit==0}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-warning" value="审核中"></button>
                                                </div>
                                            </c:if>
                                        </td>

                                        <td class="am-hide-sm-only">
                                                ${item.title}
                                        </td>
                                        <td class="am-hide-sm-only">
                                                ${item.sdate}
                                        </td>
                                        <td class="am-hide-sm-only">
                                                ${item.edate}
                                        </td>
                                        <td class="am-hide-sm-only">
                                                ${item.dest}
                                        </td>
                                        <td class="am-hide-sm-only">
                                            <input type="button" id="ecount-${item.tid}" name="ecount-${item.tid}" data-toggle="modal" data-target="#myModal" value="${item.ecount}(点击查看详情)">
                                            <!-- 模态框（Modal） -->
                                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                            <h4 class="modal-title" id="myModalLabel">出差人员信息</h4>
                                                        </div>
                                                        <div class="modal-body" id="info-table">

                                                        </div>
                                                    </div><!-- /.modal-content -->
                                                </div><!-- /.modal -->
                                            </div>
                                        </td>
                                        <td class="am-hide-sm-only">
                                                ${item.total}
                                        </td>
                                        <td>
                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-" id="edit-${item.tid}"><span class="am-icon-pencil-square-o"></span><a href="/EditListplaceholder.action?tid=${item.tid}">编辑</a></button>
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" id="delete-${item.tid}"><span class="am-icon-pencil-square-o"></span>删除</button>
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
                                            <li id="li-${i}"><a href="/?start=${i}">${i}</a></li>
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

