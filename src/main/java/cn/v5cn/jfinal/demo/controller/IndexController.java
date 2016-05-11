package cn.v5cn.jfinal.demo.controller;

import com.jfinal.core.Controller;

import java.util.List;

/**
 * Created by lenovo on 2016/4/27.
 */
public class IndexController extends Controller {
    public void index() {

//        renderJson(voucherList);
        renderFreeMarker("/index.html");
    }

    /*public void main(){
        render("/views/main.html");
    }*/
}
