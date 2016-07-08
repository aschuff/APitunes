var gulp = require('gulp'); // npm install gulp
var sass = require('gulp-sass'); // npm install gulp-sass
var browserify = require('gulp-browserify') // npm install gulp-browserify

// SPECIFYING DEPENDENCIES
// gulp.task('default',['html', 'css', 'js'])
gulp.task('default', ['html', 'css', 'js'])

// SASS TO CSS
gulp.task('css', function (){
  gulp.src('./css/styles.css')
  .pipe(sass())
  .pipe(gulp.dest('../public'))
});

// HTML
gulp.task('html', function () {
    gulp.src('./templates/*.html').pipe(gulp.dest('../public/templates'));

    return gulp.src('./index.html')
        .pipe(gulp.dest('../public'));
});

//JS
gulp.task('js', function(){
  gulp.src('./js/*.js')
    .pipe(browserify())
    .pipe(gulp.dest('../public'))
});

// WATCH CHANGES
gulp.task('watch', function () {
    gulp.watch('./js/*.js', ['js']);
    gulp.watch('./js/*/*.js', ['js']);
    gulp.watch('./css/*.css', ['css']);
    gulp.watch('./index.html', ['html']);
    gulp.watch('./templates/*.html', ['html']);
});