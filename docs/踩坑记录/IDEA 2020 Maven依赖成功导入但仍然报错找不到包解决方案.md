## IDEA 2020 Maven依赖成功导入但仍然报错找不到包解决方案

## 问题描述

项目中引入新的依赖，本地仓库和项目中都可以定位到依赖，但是点击运行，IDEA仍然提示如法加载该依赖。

## 报错原因

 IDEA启动程序按钮和maven的build使用的jar包环境不一样 。

## 解决方案

设置idea构建/运行操作委托给maven就行了。

具体设置：Settings搜索Runner,勾选`Delegate IDE build/run actions to Maven`