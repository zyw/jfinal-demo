package cn.v5cn.jfinal.demo.models;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by lenovo on 2016/5/12.
 */
public class TaskList extends Model<TaskList> {
    public static final TaskList taskList = new TaskList();

    public List<TaskList> findTaskListByPid(Long pid){
        List<TaskList> tls = taskList.find("select * from task_list where pid=?", pid);

        return tls;
    }
}
