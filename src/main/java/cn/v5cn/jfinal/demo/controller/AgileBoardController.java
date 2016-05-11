package cn.v5cn.jfinal.demo.controller;

import com.jfinal.core.Controller;

/**
 * Created by lenovo on 2016/4/29.
 */
public class AgileBoardController extends Controller {
    public void index(){
        render("/views/agile-board.vue");
    }
}
