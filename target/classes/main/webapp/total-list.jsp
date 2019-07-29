<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>雇员出差信息</title>
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
        .img-model{
            display: inline;
            float: left;
            width:50px;
            height: 60px;
        }
        .totalclass{
            border:1px solid #0b76ac;
        }

    </style>
    <script type="text/javascript">
        $(function () {
        $("#submitButton").click(function () {
           var tpid=$("#tpid").val();
           var tid=$("#tid").val();
           var title=$("#title").val();
           var price=$("#price").val();
           var json={"tpid":tpid,"tid":tid,"title":title,"price":price}
            $.ajax({
                    type:"post",
                    url:"${pageContext.request.contextPath}/addTotal.action", //传送地址
                    contentType : "application/json;charset=utf-8",
                    dataType : "json",
                    data: JSON.stringify(json),
                    success:function(date){
                        window.location.reload();
                        alert("费用提交成功");
                    },
                    error:function (e) { //错误如何操作
                        window.location.reload();
                        alert("您的数据提交失败");
                    }

                }

            )
        });
        });

        $(function() {
           $("button[id^=delete-]").each(function () {
              $(this).click(function () {
                  var tcid=this.id.split("-")[1];
                  var tid=this.id.split("-")[2];
                  var json={"tcid":tcid,"tid":tid};
                  $.ajax({
                          type:"post",
                          url:"${pageContext.request.contextPath}/deleteByTcid.action", //传送地址
                          contentType : "application/json;charset=utf-8",
                          dataType : "json",
                          data: JSON.stringify(json),
                          success:function(date){
                              window.location.reload();
                              alert("费用删除成功");
                          },
                          error:function (e) { //错误如何操作
                              alert("您的数据提交失败");
                          }

                      }

                  )
              }) ;
           });
        });
    </script>
</head>
<body data-type="generalComponents">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<div class="tpl-content-wrapper">
    <div class="tpl-content-page-title">
        费用支付详情
    </div>

    <div class="tpl-portlet-components">
        <div class="portlet-title">
            <div class="caption font-green bold">
                <span class="am-icon-code"></span> 详情
            </div>



            <div class="am-g">

                <div class="am-u-sm-12">
                    <div class="tpl-block">
                        <div class="am-g">
                            <div class="am-u-sm-12 am-u-md-6">
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button" id="addEmp" class="am-btn am-btn-default am-btn-danger" data-toggle="modal" data-target="#mymodal"><span class="am-icon-plus"></span> 添加新费用支出</button>
                                        <!-- 模态框（Modal） -->
                                        <div class="modal fade" id="mymodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h4 class="modal-title" id="myModalLabel">新增费用</h4>
                                                    </div>

                                                    <div class="modal-body">

                                                                   出差类型: <select class="totalclass" name="tpid" id="tpid">
                                                                        <option value="option1">===出差类型===</option>
                                                                        <c:forEach items="${types}" var="item">
                                                                            <option value="${item.tpid}">${item.title}</option>
                                                                        </c:forEach>
                                                                    </select><br><br>

                                                                    出行费用:<input type="text" class="totalclass" name="price" id="price"> <br><br>

                                                                    费用说明:<input type="text" name="title" id="title" class="totalclass">

                                                                    <input type="text" name="tid" id="tid" value="${param.tid}" hidden>


                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                        <button type="submit" id="submitButton" class="btn btn-primary">提交费用信息</button>
                                                    </div>
                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal -->
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <table class="am-table am-table-striped am-table-hover table-main">
                                <tr>
                                    <th class="table-author am-hide-sm-only">差旅编号</th>
                                    <th class="table-author am-hide-sm-only">支出分类</th>
                                    <th class="table-author am-hide-sm-only">用途</th>
                                    <th class="table-author am-hide-sm-only">金额</th>
                                    <th class="table-author am-hide-sm-only">操作</th>
                                </tr>


                                <c:forEach items="${list}" var="item">
                                    <tr>
                                        <td class="am-hide-sm-only">
                                             ${item.tid}
                                        </td>
                                        <td class="am-hide-sm-only">
                                            <c:forEach items="${types}" var="type">
                                                <c:if test="${type.tpid==item.tpid}">
                                                    <c:out value="${type.title}"/>
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td class="am-hide-sm-only">
                                            ${item.title}
                                        </td>
                                        <td class="am-hide-sm-only">
                                             ${item.price}
                                        </td>
                                        <td>
                                            <button id="delete-${item.tcid}-${item.tid}" name="delete-${item.tcid}" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
                                        </td>
                                    </tr>
                             </c:forEach>

                            </table>
                            <div class="am-cf">

                                <div class="am-fr">
                                    <h1 style="color: #ac2925">${total}￥</h1>
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
