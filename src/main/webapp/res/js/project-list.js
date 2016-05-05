/**
 * Created by lenovo on 2016/5/3.
 */
$(function(){
    /*$(".project-item").on("mouseover",function(){
        $(this).addClass("bounce");
    });
    $(".project-item").on("mouseout",function(){
        $(this).removeClass("bounce");
    });*/

});

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
        }
    }
});

$("#saveProjectForm").ajaxForm({
    dataType:'json',
    success: function(responseText, statusText, xhr, $form){
        if(responseText.status == 1){
            $("#projectFormModal").modal('hide');
            projects.reload();
        }else{
            layer.msg("保存项目信息异常！", {time: 4000, icon:2});
        }
    }
});
$("#saveProjectBtn").on("click",function(){
    $("#saveProjectForm").submit();
});