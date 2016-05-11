<template>
<div>

    <div class="container" id="projects">
        <input type="hidden" value="${CONTEXT_PATH}" v-model="contextPath">
        <div class="col-sm-12 plt-warp">
            <div class="project-list-title">项目列表</div> <div class="plt-line"></div>
        </div>

        <div class="col-sm-3 project-warp" v-for="project of list">
            <a class="project-item animated" v-link="{path:'/aboard'}" v-on:mouseOver="mover" v-on:mouseOut="mout" href="javascript:;">
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
               href="javascript:;" v-on:click="showDialog" >
                <i class="fa fa-plus"></i>
                <div class="add-title">添加项目</div>
            </a>
        </div>
    </div>
    <div class="modal inmodal" id="projectFormModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content animated flipInY">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">新建项目</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="post" action="{{contextPath}}/project/save" id="saveProjectForm">
                        <input type="hidden" name="project.id">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">项目名称：</label>

                            <div class="col-sm-8">
                                <input type="text" name="project.name" placeholder="项目名称(必填)" class="form-control" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">项目简介：</label>

                            <div class="col-sm-8">
                                <textarea placeholder="项目简介(可选)" name="project.summary" class="form-control"></textarea>
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
                console.log(this.contextPath);
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