package cn.v5cn.jfinal.demo;

import cn.v5cn.jfinal.demo.controller.AgileBoardController;
import cn.v5cn.jfinal.demo.controller.IndexController;
import cn.v5cn.jfinal.demo.controller.ProjectController;
import cn.v5cn.jfinal.demo.interceptor.AppInterceptor;
import cn.v5cn.jfinal.demo.models.Project;
import cn.v5cn.jfinal.demo.models.TaskList;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * Created by lenovo on 2016/4/27.
 */
public class AppConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        PropKit.use("config.properties");
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/",IndexController.class);
        routes.add("/agile-board", AgileBoardController.class);
        routes.add("/project", ProjectController.class);
    }

    @Override
    public void configPlugin(Plugins plugins) {
        DruidPlugin dp = new DruidPlugin(PropKit.get("jdbc.url"),PropKit.get("jdbc.username"),PropKit.get("jdbc.password"));
        plugins.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);

        arp.addMapping("project",Project.class);
        arp.addMapping("task_list", TaskList.class);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new AppInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {
        handlers.add(new ContextPathHandler());
    }
}
