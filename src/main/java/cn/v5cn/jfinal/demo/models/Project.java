package cn.v5cn.jfinal.demo.models;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by lenovo on 2016/5/3.
 */
public class Project extends Model<Project> {
    public static final Project project = new Project();

    public List<Project> queryAll(){
        return this.find("select * from project");
    }
}
