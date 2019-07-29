<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-title">
            Amaze UI 列表
        </div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="index.html" class="nav-link active">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                    </a>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="chart.html" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-bar-chart"></i>
                        <span>数据表</span>
                        <i class="tpl-left-nav-content tpl-badge-danger">
                            12
                        </i>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <!-- 打开状态 a 标签添加 active 即可   -->
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-table"></i>
                        <span>企业信息</span>
                        <!-- 列表打开状态的i标签添加 tpl-left-nav-more-ico-rotate 图表即90°旋转  -->
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display:block">
                        <li>
                            <!-- 打开状态 a 标签添加 active 即可   -->
                            <a href="DeptList.action" class="active">
                                <i class="am-icon-angle-right"></i>
                                <span>部门列表</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>

                            <a href="/LimitEmp.action">
                                <i class="am-icon-angle-right"></i>
                                <span>雇员列表</span>
                            </a>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>差旅情况</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu">
                        <li class="tpl-left-nav-item">
                            <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>申请列表</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>
                            <ul class="tpl-left-nav-sub-menu">
                                <li >
                                    <a href="/TravelsList.action">
                                        <i class="am-icon-angle-right"></i>
                                        <span>全部申请</span>
                                    </a>
                                    <a href="/TravelListByAudit.action?audit=0">
                                        <i class="am-icon-angle-right"></i>
                                        <span>未提交申请</span>
                                    </a>
                                    <a href="/TravelListByAudit.action?audit=9">
                                        <i class="am-icon-angle-right"></i>
                                        <span>待审核申请</span>
                                    </a>
                                    <a href="/TravelListByAudit.action?audit=1">
                                        <i class="am-icon-angle-right"></i>
                                        <span>已通过申请</span>
                                    </a>
                                    <a href="/TravelListByAudit.action?audit=2">
                                        <i class="am-icon-angle-right"></i>
                                        <span>被拒绝申请</span>
                                    </a>
                                </li>
                        </li>
                                <li class="tpl-left-nav-item">
                                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                                        <i class="am-icon-angle-right"></i>
                                        <span>出差列表</span>
                                        <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                    </a>
                                    <ul class="tpl-left-nav-sub-menu">
                                        <li>
                                            <a href="/TravelEmpList.action">
                                                <i class="am-icon-angle-right"></i>
                                                <span>出差人员</span>
                                            </a>
                                        </li>
                         </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="login.html" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-key"></i>
                        <span>登录</span>

                    </a>
                </li>
            </ul>
        </div>
    </div>