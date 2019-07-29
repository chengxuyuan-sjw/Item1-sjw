<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>未审核申请</title>
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
        .fontcc{
            width:auto;font-family:"Franklin Gothic Medium",Arial,Helvetica,sans-serif;font-size:18px;color:#888888;line-height:25px;letter-spacing:1px
        }

    </style>
    <script type="text/javascript">
        $(function () {
            $("button[id^=delete-]").each(function () {
                $(this).on("click",function () {
                    var tid=this.id.split("-")[1];
                    var json={"tid":tid};
                    $.ajax({
                            type:"post",
                            url:"${pageContext.request.contextPath}/deleteTravel.action", //传送地址
                            contentType : "application/json;charset=utf-8",
                            dataType : "json",
                            data: JSON.stringify(json),
                            success:function(date){
                                if (date==true) {
                                    alert("成功删除该记录");
                                }else {
                                    alert("被通过或审核中记录信息不可被删除");
                                }
                            },
                            error:function (e) { //错误如何操作
                                alert("被通过记录信息不可被删除");
                            }
                        }

                    )
                });
            });
        });

        $(function () {
           $("input[id^=ecount-]").each(function () {
              $(this).click(function () {
                  var tid=this.id.split("-")[1];
                  var json={tid:tid};
                  $.ajax({
                          type:"post",
                          url:"${pageContext.request.contextPath}/TravelModel.action", //传送地址
                          contentType : "application/json;charset=utf-8",
                          dataType : "json",
                          data: JSON.stringify(json),
                          success:function(date){
                             var emp=date;
                              con = "";
                              $.each(emp, function(index, item){
                                  con += "<li class='fontcc'>姓名:"+item.ename+"</li>";
                                  con += "<li class='fontcc'>部门："+item.did+"</li>";
                                  con += "<li class='fontcc'>联系方式："+item.phone+"</li>";
                                  });
                              $("#info-table").html(con); //把内容入到这个div中即完成
                          },
                          error:function (e) { //错误如何操作

                          }

                      }

                  )
              });
           });
        });

        $(function () {
           $("button[id^=approval-]").each(function () {
               $(this).click(function () {
                  var tid=this.id.split("-")[1];
                  var audit=this.id.split("-")[2];
                  var json={"tid":tid,"audit":audit};
                   $.ajax({
                           type:"post",
                           url:"${pageContext.request.contextPath}/Approval.action", //传送地址
                           contentType : "application/json;charset=utf-8",
                           dataType : "json",
                           data: JSON.stringify(json),
                           success:function(date){
                               alert("审批成功!");
                               window.location.reload();
                           },
                           error:function (e) { //错误如何操作
                               alert("审批失败!");
                               window.location.reload();
                           }

                       }

                   )
               });
           }) ;
        });

        $(function () {
           $("button[id^=sumit-]").each(function () {
              $(this).click(function () {
                 var tid=this.id.split("-")[1];
                 var audit=this.id.split("-")[2];
                 var json={"tid":tid,"audit":audit};
                  $.ajax({
                          type:"post",
                          url:"${pageContext.request.contextPath}/submit.action", //传送地址
                          contentType : "application/json;charset=utf-8",
                          dataType : "json",
                          data: JSON.stringify(json),
                          success:function(date){
                              alert("提交成功!");
                              window.location.reload();
                          },
                          error:function (e) { //错误如何操作
                              alert("提交失败!");
                              window.location.reload();
                          }

                      }

                  )
              });
           });
        });

        $(function () {
           $("#addEmp").click(function () {
              window.location.href="/CreatDeatilList.action";
           });
        });
    </script>
</head>
<body data-type="generalComponents">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>




<div class="tpl-content-wrapper">
    <div class="tpl-content-page-title">
        出差申请记录
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
                                        <button type="button" id="addEmp" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span>新增差旅申请</button>
                                    </div>
                                </div>
                            </div>
                            <form action="/TravelsList.action">
                                <div class="am-u-sm-12 am-u-md-3">
                                    <div class="am-form-group">
                                        <select data-am-selected="{btnSize: 'sm'}" name="column">
                                            <option value="option1">分类查询</option>
                                            <option value="iid">业务类型</option>
                                            <option value="title">差旅概况</option>
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
                                    <th class="table-author am-hide-sm-only">申请状态</th>
                                    <th class="table-author am-hide-sm-only">差旅概况</th>
                                    <th class="table-set">开始日期</th>
                                    <th class="table-set">结束日期</th>
                                    <th class="table-set">申请时间</th>
                                    <th class="table-set">申请人员详情</th>
                                    <th class="table-type">费用详情</th>
                                    <th class="table-type">操作</th>
                                    <th class="table-type">审批</th>
                                </tr>


                                <c:forEach items="${travels}" var="item">
                                    <tr>


                                        <td>
                                            <c:if test="${item.audit==9}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-warning" value="审核中"></button>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.audit==0}">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <input type="button" class="am-btn am-btn-default am-btn-secondary" value="已保存"></button>
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
                                                ${item.subdate}
                                        </td>
                                        <td class="am-hide-sm-only">
                                               <input type="button" id="ecount-${item.tid}" name="ecount-${item.tid}" data-toggle="modal" data-target="#myModal" value="(点击查看详情)">
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
                                            <a href="/TypeList.action?tid=${item.tid}">${item.total}</a>
                                        </td>
                                        <td>
                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <c:if test="${item.audit==2||item.audit==0}">
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-" id="edit-${item.tid}"><span class="am-icon-pencil-square-o"></span><a href="/EditListplaceholder.action?tid=${item.tid}">编辑</a></button>
                                                    </c:if>
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" id="delete-${item.tid}"><span class="am-icon-pencil-square-o"></span>删除</button>
                                                    <c:if test="${item.audit==0}">
                                                    <button  id="sumit-${item.tid}-9"  class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 提交</button>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </td>
                                        <c:if test="${item.audit==9}">
                                        <td>
                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-" id="approval-${item.tid}-1"><span class="am-icon-pencil-square-o"></span>同意申请</button>
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" id="approval-${item.tid}-2"><span class="am-icon-pencil-square-o"></span>拒绝申请</button>
                                                </div>
                                            </div>
                                        </td>
                                        </c:if>
                                        <c:if test="${item.audit==1||item.audit==2}">
                                            <td>
                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <span class="am-icon-calendar">已审核</span>
                                                </div>
                                            </div>
                                            </td>
                                        </c:if>
                                        <c:if test="${item.audit==0}">
                                            <td>
                                                <div class="am-btn-toolbar">
                                                    <div class="am-btn-group am-btn-group-xs">
                                                        <span class="am-icon-bell-o">未提交</span>
                                                    </div>
                                                </div>
                                            </td>
                                        </c:if>
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
</div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/app.js"></script>
</body>
</html>
