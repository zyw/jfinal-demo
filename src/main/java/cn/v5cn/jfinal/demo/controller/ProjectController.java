package cn.v5cn.jfinal.demo.controller;

import cn.v5cn.jfinal.demo.models.Project;
import cn.v5cn.jfinal.demo.util.Message;
import cn.v5cn.jfinal.demo.util.OperateTypeEnum;
import com.jfinal.core.Controller;

/**
 * Created by lenovo on 2016/5/3.
 */
public class ProjectController extends Controller {
    public void index(){
        //render("/views/project-list.vue");
    }

    public void save(){
        Project project = getModel(Project.class);
        Long id = project.getLong("id");
        boolean result;
        OperateTypeEnum operateType;
        if(id == null){
            result = project.save();
            operateType = OperateTypeEnum.ADD;
        }else{
            result = project.update();
            operateType = OperateTypeEnum.UPDATE;
        }

        if(result){
            renderJson(Message.success("保存项目成功。",result,operateType));
        }else{
            renderJson(Message.fail("保存项目失败！",result,operateType));
        }
    }

    public void delete(){
        String id = getPara();
        boolean result = Project.project.deleteById(id);
        if(result){
            renderJson(Message.success("删除项目成功。",result,OperateTypeEnum.DELETE));
        } else{
            renderJson(Message.fail("删除项目失败！",result,OperateTypeEnum.DELETE));
        }
    }

    public void list(){
        renderJson(Project.project.queryAll());
    }
}
