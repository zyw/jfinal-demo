/**
 * Created by lenovo on 2016/4/29.
 */
$(function(){
    $(".check-link").click(function() {
        var e = $(this).find("i"),
            a = $(this).next("span");
        return e.toggleClass("fa-check-square").toggleClass("fa-square-o"),
            a.toggleClass("todo-completed"),
            !1
    })
});