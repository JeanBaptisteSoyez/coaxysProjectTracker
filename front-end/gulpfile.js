var gulp = require('gulp'),
    plumber = require('gulp-plumber'),
    babel = require('gulp-babel'),
    uglify = require('gulp-uglify'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    sass = require('gulp-sass'),
    bourbon = require('node-bourbon').includePaths,
    livereload = require('gulp-livereload');

var theme = { name: 'frontend', path: 'CoaxysProjectTracker/', src: '_src/', dest: { css: 'Content/', js: 'Scripts/' } };

// sass task
gulp.task('sass', function () {
    return gulp.src(theme.path + theme.src + 'scss/*.scss')
        .pipe(plumber())
        .pipe(sass({
            outputStyle: 'compressed',
            includePaths: ['styles'].concat(bourbon)
        }))
        .pipe(gulp.dest(theme.path + theme.dest.css))
        .pipe(livereload());
});

// js task
gulp.task('js', function () {
    return gulp.src(theme.path + theme.src + 'js/*.js')
        .pipe(plumber())
        .pipe(babel())
        .pipe(uglify())
        .pipe(concat('all.min.js'))
        .pipe(gulp.dest(theme.path + theme.dest.js))
        .pipe(livereload());
});

// watcher
gulp.task('watch', function () {
    livereload.listen();

    gulp.watch(theme.path + theme.src + 'scss/*.scss', ['sass'])
        .on('change', function (event) {
            console.log('SASS: file compiled: ' + event.path);
        });

    gulp.watch(theme.path + theme.src + 'js/*.js', ['js'])
        .on('change', function (event) {
            console.log('JS: file compiled: ' + event.path);
        });
});

gulp.task('default', ['watch']);


