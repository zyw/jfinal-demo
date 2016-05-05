package cn.v5cn.jfinal.demo.controller;

import cn.v5cn.jfinal.demo.models.Project;
import cn.v5cn.jfinal.demo.util.Message;
import com.jfinal.core.Controller;

/**
 * Created by lenovo on 2016/5/3.
 */
public class ProjectController extends Controller {
    public void index(){
        render("/views/project-list.html");
    }

    public void save(){
        Project project = getModel(Project.class);
        boolean result = project.save();
        if(result){
            renderJson(Message.success("保存项目成功。",result));
        }else{
            renderJson(Message.fail("保存项目失败！",result));
        }
    }

    public void list(){
        Project project = getModel(Project.class);
        renderJson(project.queryAll());
    }
}
