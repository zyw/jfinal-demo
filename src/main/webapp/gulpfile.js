/**
 * Created by lenovo on 2016/5/6.
 */
var gulp = require('gulp'),
    babel = require('gulp-babel'),
    vueify = require('vueify'),
    browserify = require('browserify'),
    babelify = require("babelify"),
    source = require("vinyl-source-stream");

gulp.task('browserify1',function(){
    return gulp.src('./res/js/app.js')
        .browserify({
            insertGlobals : true,
            debug : !gulp.env.production
        })
        .pipe(babel({
            presets: ['es2015']
        }))
        /*.bundle()
        .pipe(source('bundle.js'))*/
        .pipe(gulp.dest('js'));
});

gulp.task("browserify", function () {
    return browserify({
        entries: "js/app.js"
    })
        .transform("babelify", {presets: ["es2015"]})
        .transform(vueify)
        .bundle()
        .pipe(source("app.js"))
        .pipe(gulp.dest("res/js"));
});