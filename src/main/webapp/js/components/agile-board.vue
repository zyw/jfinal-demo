<template>
    <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i
                    class="fa fa-bars"></i> </a>
                <form role="search" class="navbar-form-custom" method="post"
                      action="http://www.zi-han.net/theme/hplus/search_results.html">
                    <div class="form-group">
                        <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search"
                               id="top-search">
                    </div>
                </form>
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <!--<div class="btn-group">
                        <button data-toggle="dropdown" class="btn btn-primary dropdown-toggle">新建任务 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="buttons.html#">列 表</a>
                            </li>
                            <li><a href="buttons.html#" class="font-bold">任 务</a>
                            </li>
                            <li><a href="buttons.html#">禁用</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="buttons.html#">删除</a>
                            </li>
                        </ul>
                    </div>-->
                    <div class="btn-group" style="margin-top: -6px;">
                        <button type="button" class="btn btn-primary">新建任务</button>
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="caret"></span>
                            <span class="sr-only">新建任务</span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">新建任务</a></li>
                            <li><a href="#">新建列表</a></li>
                        </ul>
                    </div>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li class="m-t-xs">
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="{{contextPath}}/res/img/a7.jpg">
                                </a>
                                <div class="media-body">
                                    <small class="pull-right">46小时前</small>
                                    <strong>小四</strong> 这个在日本投降书上签字的军官，建国后一定是个不小的干部吧？
                                    <br>
                                    <small class="text-muted">3天前 2014.11.8</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="{{contextPath}}/res/img/a4.jpg">
                                </a>
                                <div class="media-body ">
                                    <small class="pull-right text-navy">25小时前</small>
                                    <strong>国民岳父</strong> 如何看待“男子不满自己爱犬被称为狗，刺伤路人”？——这人比犬还凶
                                    <br>
                                    <small class="text-muted">昨天</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a class="J_menuItem" href="mailbox.html">
                                    <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="mailbox.html">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                    <span class="pull-right text-muted small">4分钟前</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="profile.html">
                                <div>
                                    <i class="fa fa-qq fa-fw"></i> 3条新回复
                                    <span class="pull-right text-muted small">12分钟钱</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a class="J_menuItem" href="notifications.html">
                                    <strong>查看所有 </strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="dropdown hidden-xs">
                    <a class="right-sidebar-toggle" aria-expanded="false">
                        <i class="fa fa-tasks"></i> 主题
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="row J_mainContent wt-scroll" id="content-main" style="overflow-x: auto;">
        <div class="gray-bg">
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row" style="width: calc(({{tlist.length}} + 1) * 320px);">
                    <div class="col-sm-3"  v-for="tl of tlist">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h3>{{tl.name}}</h3>
                                <p class="small"><i class="fa fa-hand-o-up"></i> 在列表之间拖动任务面板</p>

                                <div class="input-group">
                                    <input type="text" placeholder="添加新任务" class="input input-sm form-control">
                            <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-white"><i class="fa fa-plus"></i> 添加
                                        </button>
                                </span>
                                </div>

                                <ul class="sortable-list connectList agile-list">
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">加强过程管理，及时统计教育经费使用情况，做到底码清楚，</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.01
                                        </div>
                                    </li>
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">支持财会人员的继续培训工作。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.05.12
                                        </div>
                                    </li>
                                    <li class="info-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">协同教导处搞好助学金、减免教科书费的工作。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.10
                                        </div>
                                    </li>
                                    <li class="danger-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">要求会计、出纳人员严格执行财务制度，遵守岗位职责，按时上报各种资料。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-primary">确定</a>
                                            <i class="fa fa-clock-o"></i> 2015.06.10
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">做好职工公费医疗工作，按时发放门诊费。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.09
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">有计划地把课本复习三至五遍。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-primary">确定</a>
                                            <i class="fa fa-clock-o"></i> 2015.08.04
                                        </div>
                                    </li>
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">看一本高质量的高中语法书</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.05.12
                                        </div>
                                    </li>
                                    <li class="info-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">选择一份较好的英语报纸，通过阅读提高英语学习效果。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.10
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <a class="btn btn-white btn-bitbucket" style="width: 100%;">
                            <i class="fa fa-plus-circle"></i> 添加任务列表
                        </a>
                    </div>
                    <!--<div class="col-sm-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h3>任务列表</h3>
                                <p class="small"><i class="fa fa-hand-o-up"></i> 在列表之间拖动任务面板</p>

                                <div class="input-group">
                                    <input type="text" placeholder="添加新任务" class="input input-sm form-control">
                            <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-white"><i class="fa fa-plus"></i> 添加
                                        </button>
                                </span>
                                </div>

                                <ul class="sortable-list connectList agile-list">
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">加强过程管理，及时统计教育经费使用情况，做到底码清楚，</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.01
                                        </div>
                                    </li>
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">支持财会人员的继续培训工作。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.05.12
                                        </div>
                                    </li>
                                    <li class="info-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">协同教导处搞好助学金、减免教科书费的工作。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.10
                                        </div>
                                    </li>
                                    <li class="danger-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">要求会计、出纳人员严格执行财务制度，遵守岗位职责，按时上报各种资料。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-primary">确定</a>
                                            <i class="fa fa-clock-o"></i> 2015.06.10
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">做好职工公费医疗工作，按时发放门诊费。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.09
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">有计划地把课本复习三至五遍。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-primary">确定</a>
                                            <i class="fa fa-clock-o"></i> 2015.08.04
                                        </div>
                                    </li>
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">看一本高质量的高中语法书</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.05.12
                                        </div>
                                    </li>
                                    <li class="info-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">选择一份较好的英语报纸，通过阅读提高英语学习效果。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.10
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h3>进行中</h3>
                                <p class="small"><i class="fa fa-hand-o-up"></i> 在列表之间拖动任务面板</p>
                                <ul class="sortable-list connectList agile-list">
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">全面、较深入地掌握我们“产品”的功能、特色和优势并做到应用自如。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.01
                                        </div>
                                    </li>
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">根据自己以前所了解的和从其他途径搜索到的信息，录入客户资料150家。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.05.12
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">锁定有意向客户20家。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.10
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">力争完成销售指标。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.09
                                        </div>
                                    </li>
                                    <li class="info-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">在总结和摸索中前进。</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-primary">确定</a>
                                            <i class="fa fa-clock-o"></i> 2015.08.04
                                        </div>
                                    </li>
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">不断学习行业知识、产品知识，为客户带来实用介绍内容</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.05.12
                                        </div>
                                    </li>
                                    <li class="danger-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">先友后单：与客户发展良好友谊，转换销售员角色，处处为客户着想</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.11.04
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h3>已完成</h3>
                                <p class="small"><i class="fa fa-hand-o-up"></i> 在列表之间拖动任务面板</p>
                                <ul class="sortable-list connectList agile-list">
                                    <li class="info-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">制定工作日程表</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.10
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">每天坚持打40个有效电话，挖掘潜在客户</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.09
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">拜访客户之前要对该客户做全面的了解(客户的潜在需求、职位、权限以及个人性格和爱好)</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.09
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">提高自己电话营销技巧，灵活专业地与客户进行电话交流</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-primary">确定</a>
                                            <i class="fa fa-clock-o"></i> 2015.08.04
                                        </div>
                                    </li>
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">通过电话销售过程中了解各盛市的设备仪器使用、采购情况及相关重要追踪人</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.05.12
                                        </div>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>








                    <div class="col-sm-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h3>已完成</h3>
                                <p class="small"><i class="fa fa-hand-o-up"></i> 在列表之间拖动任务面板</p>
                                <ul class="sortable-list connectList agile-list">
                                    <li class="info-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">制定工作日程表</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.10
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">每天坚持打40个有效电话，挖掘潜在客户</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.09
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">拜访客户之前要对该客户做全面的了解(客户的潜在需求、职位、权限以及个人性格和爱好)</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.09
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">提高自己电话营销技巧，灵活专业地与客户进行电话交流</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-primary">确定</a>
                                            <i class="fa fa-clock-o"></i> 2015.08.04
                                        </div>
                                    </li>
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">通过电话销售过程中了解各盛市的设备仪器使用、采购情况及相关重要追踪人</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.05.12
                                        </div>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h3>已完成</h3>
                                <p class="small"><i class="fa fa-hand-o-up"></i> 在列表之间拖动任务面板</p>
                                <ul class="sortable-list connectList agile-list">
                                    <li class="info-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">制定工作日程表</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.10
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">每天坚持打40个有效电话，挖掘潜在客户</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.09
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">拜访客户之前要对该客户做全面的了解(客户的潜在需求、职位、权限以及个人性格和爱好)</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标签</a>
                                            <i class="fa fa-clock-o"></i> 2015.09.09
                                        </div>
                                    </li>
                                    <li class="warning-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">提高自己电话营销技巧，灵活专业地与客户进行电话交流</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-primary">确定</a>
                                            <i class="fa fa-clock-o"></i> 2015.08.04
                                        </div>
                                    </li>
                                    <li class="success-element">
                                        <a href="javascript:;" class="check-link"><i class="fa fa-square-o"></i> </a>
                                        <span class="m-l-xs">通过电话销售过程中了解各盛市的设备仪器使用、采购情况及相关重要追踪人</span>
                                        <div class="agile-detail">
                                            <a href="#" class="pull-right btn btn-xs btn-white">标记</a>
                                            <i class="fa fa-clock-o"></i> 2015.05.12
                                        </div>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                    -->
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data(){
            return {
                tlist:[]
            };
        },
        ready(){
            $(".sortable-list").sortable({connectWith:".connectList"}).disableSelection();
            $("#content-main").on("click",".check-link",function() {
                var e = $(this).find("i"),
                        a = $(this).next("span");
                return e.toggleClass("fa-check-square").toggleClass("fa-square-o"),
                        a.toggleClass("todo-completed"),
                        !1
            });

            this.$http.get("agile-board/list/"+this.$route.params.pid).then((response) => {
                if(response.ok){
                    this.tlist = response.data;
                }else{
                    layer.msg("加载任务列表失败！", {time: 4000, icon:2});
                }

            },(response) => {
                layer.msg("加载任务列表异常！", {time: 4000, icon:2});
            });
        }
    }
</script>
<style>
    .my-col-sm-3{
        width: 320px;
        float: left;
        padding-left: 5px;
        padding-right: 5px;
    }
    .col-sm-3{
        width: 320px;
    }
</style>