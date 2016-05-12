/**
 * Created by lenovo on 2016/5/6.
 */

import Vue from "Vue";
import VueRouter from "vue-router";
import VueResource from "vue-resource";
import App from "./app.vue"
import Main from "./components/main.vue";
import PList from "./components/project-list.vue";
import ABoard from "./components/agile-board.vue";

Vue.use(VueRouter);
Vue.use(VueResource);

var Home = Vue.extend({
    template: "<h1>ddddddddd</h1>"
});

var router = new VueRouter();

router.map({
    "/main":{
        component:Main
    },
    '/home':{
        component: Home
    },
    '/plist':{
        component:PList
    },
    "/aboard/:pid":{
        component:ABoard
    }

});

router.redirect({
    '/':"/main"
});

router.start(App,"#wrapper");