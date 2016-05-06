/**
 * Created by lenovo on 2016/5/6.
 */

import Vue from "Vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

import app from "../../views/app.vue";

var Home = Vue.extend({
    template: "<h1>ddddddddd</h1>"
});

var App = Vue.extend({
    component: app
});

var router = new VueRouter();

router.map({
    '/home':{
        component: Home
    }

});

router.redirect({
    '/':"/home"
});

router.start(App,"#wrapper");