/**
 * Created by lenovo on 2016/5/3.
 */
var projects = new Vue({
    el:"#projects",
    data:{
        list:[]
    },
    ready:function(){
        this.reload();
    },
    methods: {
        mover:function(event){
            $(event.target).addClass("pulse");
        },
        mout:function(event){
            $(event.target).removeClass("pulse");
        },
        showDialog:function(){
            $(".modal-title").text("添加项目");
            $("#projectFormModal").modal('show');
        },
        reload:function(){
            $.getJSON(this.contextPath+"/project/list",function(data){
                projects.list = data;
            });
        },
        editHander:function(project){
            $(".modal-title").text("编辑项目");
            $("#saveProjectForm input[name='project.id']").val(project.id);
            $("#saveProjectForm input[name='project.name']").val(project.name);
            $("#saveProjectForm textarea[name='project.summary']").val(project.summary);
            $("#projectFormModal").modal('show');
        },
        deleteHander:function(id){
            var confirmId = layer.confirm('你确定要删除吗？', {
                title:"提示",
                btn: ['确定','取消'] //按钮
            }, function(){
                Vue.http.get(projects.contextPath+"/project/delete/"+id).then(function(response){
                    if(response.ok && response.data.result){
                        projects.reload();
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
});

$("#saveProjectForm").ajaxForm({
    dataType:'json',
    success: function(responseText, statusText, xhr, $form){
        if(responseText.status == 1){
            $("#projectFormModal").modal('hide');
            projects.reload();
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