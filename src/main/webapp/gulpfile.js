/**
 * Created by lenovo on 2016/5/6.
 */
var gulp = require('gulp'),
    babel = require('gulp-babel'),
    browserify = require('browserify'),
    babelify = require("babelify"),
    source = require("vinyl-source-stream");

gulp.task('browserify',function(){
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