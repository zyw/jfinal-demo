package cn.v5cn.jfinal.demo.controller;

import cn.v5cn.jfinal.demo.models.TaskList;
import com.jfinal.core.Controller;

import java.util.List;

/**
 * Created by lenovo on 2016/4/29.
 */
public class AgileBoardController extends Controller {
    public void index(){

    }

    public void list(){
        Long pid = getParaToLong();
        List<TaskList> result = TaskList.taskList.findTaskListByPid(pid);
        renderJson(result);
    }
}
