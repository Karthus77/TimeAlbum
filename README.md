# ITnews
 * [ITnews](#itnews)
  * [一、项目概述](#一项目概述)
  * [二、功能详情](#二功能详情)
    * [版本自动检测更新](#版本自动检测更新)
    * [登陆与注册](#登陆与注册)
    * [底部导航栏](#底部导航栏)
      * [新闻](#新闻)
      * [轮播图](#轮播图)
      * [消息(本地数据库开发)](#消息本地数据库开发)
      * [个人](#个人)
    * [新闻详情页](#新闻详情页)
    * [新闻发布界面](#新闻发布界面)
    * [用户信息修改](#用户信息修改)
      * [头像](#头像)
      * [昵称](#昵称)
      * [性别](#性别)
      * [个人简介](#个人简介)
      * [修改密码](#修改密码)
    * [忘记密码](#忘记密码)
    * [项目附加处理](#项目附加处理)
  * [三、项目时间安排(仅供参考)](#三项目时间安排仅供参考)
## 一、项目概述
   ITnews是由2021年3月由中国海洋大学爱特工作室开发的一款小型新闻类APP。从设计到产品开发与测试累计用时一个月。
- **项目名称**:ITnews

- **开发组人员**：UI:吴慧敏 程序:刘召 APP：张凯 王子懿 黄博斌
- **项目经理:**黄博斌
- **设计目标**: 设计一款新闻类APP，能够即时查看新闻与发布新闻，用户可以关注作者，收藏文章等



## 二、功能详情

### 版本自动检测更新

打开APP进入欢迎界面时，检测软件版本，若不为最新版本则弹窗提示更新。

### 登陆与注册

若用户此前未登陆账号，则跳转至登陆界面。若无账号，则点击注册，注册账号。

注册账号时填写邮箱获取验证码，获取成功后填写账号密码则注册成功

### 底部导航栏

登陆之后进入APP主界面，在屏幕下方有一个底部导航栏。分别为(新闻，消息，我的文章，个人)

#### 新闻

新闻区分为两个板块，关注与推荐(可参考新浪微博的首页)

推荐部分的新闻会有后台算法对每个用户有不同推送

关注部分显示你关注的作者发布的新闻内容

每条新闻由标题和封面图片两部分组成，点击新闻跳转新闻详情页

上拉加载，下拉刷新新闻

#### 轮播图

在新闻界面推荐部分，滚动4张新闻图片

#### 消息(本地数据库开发)

对用户操作进行提示信息。（如关注，发布文章，评论)

在未读消息时做出提示(参考QQ的红点)

#### 个人

显示个人头像，昵称，性别，关注量，粉丝量，收藏文章数，个人简介，邮箱等信息

### 新闻详情页

新闻详情页上方显示文章标题，作者，作者头像

下方显示文章内容，图片，图片以九宫格的方式呈现(第一张图片默认为封面图片)

页面底部设置一个功能区(点赞，收藏，和评论)

文章内容结束后下方显示对该文章的所用评论(只有短评)

### 新闻发布界面

新闻发布(参考微信发布朋友圈)

### 用户信息修改

#### 头像

在用户界面点击头像，弹出对话框。选择拍照和相册选取之后裁剪图片即可修改

#### 昵称

点击昵称跳转昵称修改界面(参考微信)

#### 性别

点击性别弹出对话框，选择男女即可

#### 个人简介

点击个人简介跳转至修改界面(参考微信)

#### 修改密码

如要修改密码，点击个人信息中的修改密码，跳转至修改密码界面

经过邮箱和原密码验证后即可修改密码

### 忘记密码

在登陆界面选择忘记密码

跳转至忘记密码界面

输入邮箱和验证码后设置新密码

###  项目附加处理

断网状态下给出对应提示信息

项目禁止横屏状态

项目的输入信息格式由前后端按统一标准控制



## 三、项目时间安排(仅供参考)

| 3.7-3.14       | 项目设计文档，接口文档，数据库设计文档与APP项目基本框架搭建 |
| -------------- | ----------------------------------------------------------- |
| **3.14-3.21**  | **后端接口部署与APP设计同步进行**                           |
| **3.21 -3.28** | **后端接口全部部署完毕，前段完成项目主体结构**              |
| **3.28-4.4**   | **项目调试与完善**                                          |

# ITnews
* [ITnews](#itnews)
  * [1、 Project overview](#1-project-overview)
  * [2、 Function details](#2-function-details)
    * [Automatic version detection update](#automatic-version-detection-update)
    * [Login and registration](#login-and-registration)
    * [Bottom navigation bar](#bottom-navigation-bar)
      * [News](#news)
      * [Carousel map](#carousel-map)
      * [Message (local database development)](#message-local-database-development)
      * [Individuals](#individuals)
    * [News details page](#news-details-page)
    * [News release interface](#news-release-interface)
    * [User information modification](#user-information-modification)
      * [Head portrait](#head-portrait)
      * [Nickname](#nickname)
      * [Gender](#gender)
      * [Personal profile](#personal-profile)
      * [Change password](#change-password)
    * [Forget the password](#forget-the-password)
    * [Project additional processing](#project-additional-processing)
  * [3、 Project schedule (for reference only)](#3-project-schedule-for-reference-only)

## 1、 Project overview

- ITnews is a small news app developed by IT studio of Ocean University of China in March 2021. It takes one month from design to product development and testing.

**project name**: ITnews



- **development team member**: UI: Wu Huimin program: Liu Zhao app: Zhang Kai, Wang Ziyi, Huang Bobin

- **Project Manager**: Huang Bobin

- **design objective**: design a news app, which can instantly view and release news, and users can pay attention to the author, collect articles, etc

## 2、 Function details
### Automatic version detection update
When you open the app and enter the welcome interface, check the software version. If it is not the latest version, the pop-up window will prompt you to update.

### Login and registration

If the user has not logged in before, jump to the login interface. If there is no account, click Register to register the account.
When you register an account, fill in the email to get the verification code. When you succeed, fill in the account password to register successfully

### Bottom navigation bar

After login, enter the app main interface, and there is a bottom navigation bar at the bottom of the screen. They are (news, news, my article, personal)

#### News

News is divided into two parts, attention and recommendation (please refer to the homepage of sina Weibo)
There will be a background algorithm for the news of the recommendation part, which has different push for each user
The following section shows the news content published by the author you follow
Each news consists of a title and a cover image. Click news to jump to the news details page
Pull up to load, pull down to refresh news

#### Carousel map
In the recommendation section of the news interface, scroll 4 news pictures

#### Message (local database development)
Prompt information for user operation. (e.g. follow, post, comment)
Prompt when not reading the message (refer to the red dot of QQ)

#### Individuals
Display personal profile, nickname, gender, attention, fans, number of collected articles, profile, email and other information

### News details page
At the top of the news details page, the title of the article, the author, and the portrait of the author are displayed
The content and pictures of the article are displayed below in the form of nine palace grid (the first picture is the cover picture by default)
Comments and favorites (one at the bottom)
After the end of the article, the comments on the article (only short comments) will be displayed below

### News release interface
Press release (refer to wechat publishing circle of friends)

### User information modification

#### Head portrait
Click the avatar in the user interface to pop up the dialog box. Select photo and album, then cut the picture and modify it

#### Nickname

Click the nickname to jump to the nickname modification interface (refer to wechat)
#### Gender
Click gender to pop up the dialog box and select male and female

#### Personal profile
Click personal profile to jump to the modification interface (refer to wechat)

#### Change password
To modify the password, click modify password in personal information to jump to modify password interface

After the mailbox and the original password verification, you can change the password
### Forget the password
Select forget password in login interface
Jump to forget password interface
Set a new password after entering the email and verification code

### Project additional processing
- The corresponding prompt information is given in the state of disconnection
- Item no horizontal screen status
- The input information format of the project is controlled by the front and back end according to the unified standard

## 3、 Project schedule (for reference only)

| **3.7-3.14**   |  **project design documents, interface documents, database design documents and basic framework construction of APP project** |
| -------------- | ----------------------------------------------------------- |
| **3.14-3.21**  | **back end interface deployment is synchronized with App Design**                           |
| **3.21 -3.28** | **all back-end interfaces have been deployed, and the main structure of the project has been completed in the previous stage**              |
| **3.28-4.4**   | **project commissioning and improvement**                                          |









