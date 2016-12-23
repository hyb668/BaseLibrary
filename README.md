# BaseLibrary: Base Library for Android

Android基本库，现在分为common、util和ui,主要包含`adapter`、`base`、`zxing`、`listener`，`logger`，`util`，`widget`，这个基本库集合了一般Android项目所需的公共类，可直接导入使用，加快项目开发。

## Communication

这个基本库收集实际开发中已经在使用的类，如果有需要的类可以加入此库中，可以SVN上提交到分支，经过核查后合并；
稍后会share到github上，也可以在GitHub上提issues。

# Binaries

* Common:[ ![Download](https://api.bintray.com/packages/wangtotang/maven/common/images/download.svg) ](https://bintray.com/wangtotang/maven/common/_latestVersion)
* Util:  [ ![Download](https://api.bintray.com/packages/wangtotang/maven/util/images/download.svg) ](https://bintray.com/wangtotang/maven/util/_latestVersion)
* UI:[ ![Download](https://api.bintray.com/packages/wangtotang/maven/ui/images/download.svg) ](https://bintray.com/wangtotang/maven/ui/_latestVersion)

```groovy
dependencies {
    compile "com.gosuncn.core:common:${latest_version}"
    compile "com.gosuncn.core:util:${latest_version}"
    compile "com.gosuncn.core:ui:${latest_version}"
}
```

# Document

在工程目录下`document/`文件夹中，含有相关文档，如果想详细了解，请查阅。

## Build

To build:

```bash
$ git clone git@github.com:GosuncnMobile/BaseLibrary.git
$ cd BaseLibrary/
$ ./gradlew build
```

# Sample Usage

project中有样例演示，可以在 `sample/` 文件夹找到.

点击[下载运行APK](https://github.com/GosuncnMobile/BaseLibrary/raw/master/baselibrary_sample_v1.0_2016-12-23_alpha.apk)

## Util

包含常用的工具类

## Common

包含需要依赖第三方库的工具类

## Ui

包含自定义的ui组件

# Plugins

提供自动生成插件，可以在`plugins/` 文件夹找到.

## DaggerHelper

用于自动生成Dagger Component和Module以及一些目录

## Bugs and Feedback

如果有bugs,功能需求以及讨论，可以提issues,无论群上还是[GitHub Issues][issues].

## LICENSE

    Copyright 2016 GOSUNCN

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [issues]:https://github.com/GosuncnMobile/BaseLibrary/issues

