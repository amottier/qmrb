# Dependencies

* Babel: to write ES2015
  * babelify: to apply Babel to Browserify
* Browserify: allow to build modular applications
  * brfs: browserify fs.readFileSync() static asset inliner
  * browserify-ngannotate: a Browserify transform that uses ng-annotate to add dependency injection annotations to your AngularJS source code, preparing it for minification
  * bulkify: transform inline bulk-require calls into statically resolvable require maps
* Debowerify: to use Bower components using Browserify
* gulp: to automate building
  * gulp-angular-templatecache: store AngularJS templates cache
  * gulp-autoprefixer: to add vendor specific prefix to CSS
  * gulp-changed: detect if a file as changed
  * gulp-if: conditionally run a task
  * gulp-notify: to send notifications to the OS
  * gulp-sass: gulp plugin for sass
  * gulp-sourcemaps: source map (association minified source code with original sources) support for gulp
  * gulp-streamify: wrap old plugins to support streams
  * gulp-uglify: minify files with UglifyJS.
  * gulp-util: utility functions for gulp plugins
  * run-sequence: run a series of dependent gulp tasks in order
  * vinyl-buffer: convert streaming vinyl files to use buffers
  * vinyl-source-stream: use conventional text streams at the start of your gulp or vinyl pipelines
* JSHint: for code quality
* Karma: for test execution
* Jasmine: testing framework
* watchify: watch modified files to trigger rebuild of browserify bundles

babel-core dependencies:
* browser-sync: synchronize browsers (for test)
* del: delete files or globs (e.g. \*.js)


## Vinyl
Vinyl is a very simple metadata object that describes a file. When you think of a file, two attributes come to mind: path and contents. These are the main attributes on a Vinyl object. A file does not necessarily represent something on your computer’s file system. You have files on S3, FTP, Dropbox, Box, CloudThingly.io and other services. Vinyl can be used to describe files from all of these sources.
