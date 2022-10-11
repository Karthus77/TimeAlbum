# 时光相册
- 2022夏季学期移动软件开发作业
## 1.项目简介

时光相册是一款用于记录有意义的相片的地方。你可以在这里查看属于自己的回忆~


<img src="https://user-images.githubusercontent.com/72655347/187847873-f8b75b43-8e6f-4516-ba29-8620713eb020.png" width="20%">

## 用户模块

### 登陆

<img src="https://user-images.githubusercontent.com/72655347/187847917-bbe9dde0-9db4-4b09-81ec-c28870e799b2.png" width="20%">


### 注册

<img src="https://user-images.githubusercontent.com/72655347/187847961-20cb70e6-f304-4714-b8da-520411ecf490.png" width="20%">


### 个人界面

<img src="https://user-images.githubusercontent.com/72655347/187847999-7b0152e7-84ad-49c1-9e01-d12c0c67e05d.png" width="20%">


### 修改

<img src="https://user-images.githubusercontent.com/72655347/187848030-0dd86eed-8fae-4216-a1bb-849b878faa07.png" width="20%">


## 功能模块

### 图片展示

<img src="https://user-images.githubusercontent.com/72655347/187848051-21432958-2ecf-4348-89d2-62a339b13913.png" width="20%">


### 上传图片

<img src="https://user-images.githubusercontent.com/72655347/187848082-6511d4d5-eb90-4b6b-a7db-7acc70e8404c.png" width="20%">

<img src="https://user-images.githubusercontent.com/72655347/187848161-69202a06-e0f6-463c-8c1d-464fe77652a3.png" width="20%">



## 2.当前完成情况

基本功能已完成

## 3.控件与技术

### Activity

<img src="https://user-images.githubusercontent.com/72655347/187848222-e5095956-27f0-4a5e-bb89-48f1f6ca3b53.png" width="20%">


共用了三个6个activity

## fragment

<img src="https://user-images.githubusercontent.com/72655347/187848248-7080bcc4-93fb-4384-a1ed-85d020d1244f.png" width="20%">

fragment是activity的碎片，常用于一个活动中的不同界面

## 适配器模式

<img src="https://user-images.githubusercontent.com/72655347/187848271-9be9f190-99b2-4089-89f7-5858798ad20f.png" width="20%">

使用了设计模式中的适配器模式结合RecycleView实现重复item加载

### 九宫格技术

利用adapter嵌套实现了仿九宫格

参考博客[安卓九宫格上传图片(微信朋友圈，QQ动态)小demo](https://blog.csdn.net/Karthus77/article/details/115396118)

## 4.测试及上线情况

### 输入bug测试

app测试功能正常，利用正则表达式实现前端的输入判断

```java
public boolean checkUsername(String str) {
        String regexp = "^[0-9a-zA-Z]{6,12}$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public boolean checkPassword(String str) {
        String regexp = "^[0-9a-zA-Z]{6,12}$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
```

### 竖屏bug测试

```xml
 <activity android:name=".Activity.WriteActivity"
            android:screenOrientation="portrait"/>
```

### 断网功能测试


<img src="https://user-images.githubusercontent.com/72655347/187848301-38ef77a9-36ee-4182-8b59-3edde5275fb7.png" width="20%">
## 5.实际遇到的问题

在联网过程中在Activity由于需要实时加载一些图片的问题。可能会涉及到activity和fragment生命周期的问题，通过使用onResume和不断debug调试解决了问题

## 6.心得体会

在重构项目的过程中，使得我更加熟悉了开发的前后端流程，跟之前的开发对比，也显得轻车熟路，游刃有余。在大一时我也曾给同学写过APP当生日礼物，我认为的浪漫是一种生活的情调，随手拍照是浪漫，回宿舍给室友带杯饮料是浪费，餐厅打饭给阿姨说一声谢谢也是浪漫，其实很多时候都可以很浪漫~

参考博客[【Android实战-03(淘宝类APP)】](https://blog.csdn.net/Karthus77/article/details/113865169)

