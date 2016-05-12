<template>
    <div id="projects" style="height: calc(100% - 36px);">
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
        <div class="row J_mainContent" id="content-main">
            <div class="container">
                <input type="hidden" value="${CONTEXT_PATH}" v-model="contextPath">
                <div class="col-sm-12 plt-warp">
                    <div class="project-list-title">项目列表</div>
                    <div class="plt-line"></div>
                </div>

                <div class="col-sm-3 project-warp" v-for="project of list">
                    <a class="project-item animated" v-link="{path:'/aboard/'+project.id}" v-on:mouseOver="mover"
                       v-on:mouseOut="mout" href="javascript:;">
                        <div class="project-name">{{ project.name }}</div>
                    </a>
                    <div class="project-muen">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-chevron-circle-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="javascript:;" v-on:click="editHander(project)">编辑</a>
                            </li>
                            <li><a href="javascript:;" v-on:click="deleteHander(project.id)">删除</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3 project-warp">
                    <a class="project-item add-project animated" v-on:mouseOver="mover" v-on:mouseOut="mout"
                       href="javascript:;" v-on:click="showDialog">
                        <i class="fa fa-plus"></i>
                        <div class="add-title">添加项目</div>
                    </a>
                </div>
            </div>
            <div class="modal inmodal" id="projectFormModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content animated flipInY">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span
                                    aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title">新建项目</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" method="post" action="{{contextPath}}/project/save"
                                  id="saveProjectForm">
                                <input type="hidden" name="project.id">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">项目名称：</label>

                                    <div class="col-sm-8">
                                        <input type="text" name="project.name" placeholder="项目名称(必填)"
                                               class="form-control" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">项目简介：</label>

                                    <div class="col-sm-8">
                                        <textarea placeholder="项目简介(可选)" name="project.summary"
                                                  class="form-control"></textarea>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" id="saveProjectBtn">保存</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data(){
            return {
                list:[],
                contextPath:""
            };
        },
        ready(){
            this.contextPath = $("#contextPath").val();
            this.reload();
            $("#saveProjectForm").ajaxForm({
                dataType:'json',
                success: (responseText, statusText, xhr, $form) => {
                    if(responseText.status == 1){
                        $("#projectFormModal").modal('hide');
                        this.reload();
                        if(responseText.operateType === "UPDATE"){
                            layer.msg("保存项目信息成功。", {time: 4000, icon:1});
                        }
                    }else{
                        layer.msg("保存项目信息异常！", {time: 4000, icon:2});
                    }
                }
            });
            $("#saveProjectBtn").on("click",function(){
                $("#saveProjectForm").submit();
            });
        },
        methods:{
            mover(event){
                $(event.target).addClass("pulse");
            },
            mout(event){
                $(event.target).removeClass("pulse");
            },
            showDialog(){
                $(".modal-title").text("添加项目");
                $("#projectFormModal").modal('show');
            },
            reload(){
                $.getJSON(this.contextPath+"/project/list",(data) => {
                    this.list = data;
                });
            },
            editHander(project){
                $(".modal-title").text("编辑项目");
                $("#saveProjectForm input[name='project.id']").val(project.id);
                $("#saveProjectForm input[name='project.name']").val(project.name);
                $("#saveProjectForm textarea[name='project.summary']").val(project.summary);
                $("#projectFormModal").modal('show');
            },
            deleteHander(id){
                var confirmId = layer.confirm('你确定要删除吗？', {
                    title:"提示",
                    btn: ['确定','取消'] //按钮
                }, () => {
                    Vue.http.get(this.contextPath+"/project/delete/"+id).then((response) => {
                        if(response.ok && response.data.result){
                            this.reload();
                            layer.close(confirmId);
                        }else{
                            layer.msg("删除项目信息失败！", {time: 4000, icon:2});
                        }
                    }, function(response){
                        layer.msg("删除项目信息异常！", {time: 4000, icon:2});
                    });
                });
            }
        }
    }
</script>
<style type="text/css">
    .plt-warp {
        margin-top: 10px;
        line-height: 70px;
    }
    .project-list-title {
        float: left;
        margin-right: 10px;
        font-size: 20px;
    }
    .plt-line {
        float: left;
        height: 1px;
        width: 90%;
        margin-top: 35px;
        background: linear-gradient(to right,#343434,white);
    }
    .project-warp {
        padding: 15px;
    }
    .project-item {
        display: block;
        height: 140px;
        box-shadow: 0 10px 10px #999;
        background: url("res/img/pbg/1.jpg") no-repeat;
    }
    .project-warp .add-project {
        background: #eee;
        text-align: center;
        padding-top: 35px;
        font-size: 35px;
        color: #666;
    }
    .project-warp .add-project:hover {
        color: #0d8ddb;
    }
    .project-warp .add-project .add-title {
        color: #666;
        font-size: 20px;
    }
    .project-item .project-name {
        color:#FFF;
        padding-left: 10px;
        padding-top: 5px;
        font-size: 16px;
        width: 80%;
    }

    .project-warp .project-muen {
        position:absolute;
        top: 22px;
        right: 25px;
        z-index: 200;
    }
    .project-warp .project-muen i {
        color: #FFFFFF;
    }
</style>