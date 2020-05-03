# APP_Learn
### 项目结构
![]()首先认识项目结构，在Andriod项目目录下，manifests文件夹下有AndroidManifests.xml文件，该文件是整个项目的清单文件，在里面可以设置项目名称，项目图标，启动项目时的首页面，项目主题等内容；java文件夹下用来存放java代码，保存app内部的业务逻辑；res是资源文件夹，这下面用于存放app开发过程中使用到的各种类型的资源。
### Android体系机构
![](https://github.com/yangxcc/APP_Learn/blob/master/image/Android%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84.png)
#### Linux内核（Linux Kernel）
是硬件和其他软件堆层之间的一个抽象隔离层(其中包含很多的驱动程序)，提供由操作系统内核管理的 底层基础功能，主要有安全机制、内存管理、进程管理、网络协议栈和驱动程序等。 
#### Andriod函数库及运行时环境
Android 函数库和运行时环境是第二层，位于 Linux 内核之上，也称中间件层，由函数 库和 Android 运行时环境构成。 由于 Linux 操作系统的内核使用及其组件使用 C 语言编写（少部分使用汇编语言），因 此，开发人员可以通过应用程序框架调用一组基于 C/C++的函数库，主要包括以下几个：
- Surface Manager：支持显示子系统的访问，为多个应用程序提供 2D、3D 图像层的 平滑连接。 
- Media Framework：基于 OpenCORE 的多媒体框架，实现音频、视频的播放与录制功能。 
- SQLite：关系型数据库引擎。 
- OpenGL | ES：基于硬件的 3D 图像加速。
- FreeType：位图与矢量字体渲染。 
- WebKit：Web 浏览器引擎。 
- SSL：数据加密与安全传输的函数库。 
- libc：标准 C 运行库，是 Linux 系统中底层的应用程序开发接口。 
Android 运行时环境由**核心库和 Dalvik 虚拟机**构成。核心库为开发人员提供了 Android 系统的特有函数功能和 Java 语言的基本函数功能，Dalvik 虚拟机采用适合内存和处理器受限的专用格式。 <br>
**Dalvik与Java VM的区别**<br>
二者最大的区别在于：
* Dalvik是基于寄存器Register-based的虚拟机，Dalvik执行的是dex文件，在执行过程中，每一个应用程序就是一个进程
* Java VM是以基于栈Stack-based的虚拟机，执行的是Java class文件（字节码文件 bytecode）
**Dalvik最大的好处在于可以根据硬件实现更大的优化，这更适合移动设备**
#### 应用框架层
应用程序框架层提供了 Android 平台的管理功能和组件重用机制，包括 Activity 管理、资源管理、位置管理、通知消息管理、View 系统和内容提供者等。Android 的三大核心功能如下：
* View：提供了绘制图形，处理触摸、按键事件等功能。 
* Activity Manager Service：简称为AMS，其主要功能是管理所有应用程序的Activity、内存管理等。AMS 作为一种系统级服务管理所有 Activity，当操作（启动或停止） 某个 Activity 时，必须报告给 AMS，而不能“擅自处理”。在内存不足时，AMS 可能主动杀死后台的 Activity
* Window Manager Service：简称为WMS，其主要功能是为所有应用程序分配窗口，并管理这些窗口。 
#### 应用程序层
* 应用程序层提供了一系列核心应用程序，如打电话、浏览器、联系人、相册、地图和电子市场等。 
* 应用程序存储在手机的内部存储区，且按包名存放，需要特定的程序才能查看。
## 线性布局的嵌套    seekbar改变透明度和背景颜色
![](https://github.com/yangxcc/APP_Learn/blob/master/image/线性布局的嵌套.png)，LinearLayout按照垂直(Vertical)或者水平(Horizontal)的顺序依次排列子元素，同时想要改变某个控件的形状需要在drawable文件夹下添加shape.xml文件，通过控件的background属性来改变其形状。<br>
透过拉动活动条来改变透明度，这里需要给seekbar添加一个监听，重写其方法，注意process代表此时活动条的值
![](https://github.com/yangxcc/APP_Learn/blob/master/image/seekbar改变透明度与背景.png)
![](https://github.com/yangxcc/APP_Learn/blob/master/image/seekbar改变透明度与背景2.png)
## Activity的生命周期
Activity作为Android中的最重要的组件，用于设计应用程序的用户界面，其内容来源于布局文件。在一个Activity的onCreate()方法中，使用父类的setContentView()呈现内容视图，并以布局文件作为参数，Activity包含了响应界面事件的代码，即具有控制器功能。<br>
复杂的Android应用中可能包含多个Activity，当打开一个新的Activity时，先前的那个Activity会被置于暂停状态，并压入历史堆栈中，用户可以通过返回键退回到之前的那个Activity。<br>
Activity是由Android系统维护的，每个Activity除了有创建onCreate()、销毁onDestroy() 两个基本方法外，还有激活方法onStart()、恢复方法onResume()、暂停方法onPause()、停止方法onStop()和onRestart()。 <br>
Activity在其生命周期中存在三种不同的状态：运行态、暂停态和停止态。运行态是指Activity调用onStart()方法后出现在屏幕的最上层的状态，此时用户通常可以获取焦点；暂停态是指Activity调用onPause()方法之后出现的状态，其上还有处于运行态的Activity存在，并且Activity没有被完全挡住，即处于暂停态的Activity有一部分视图被用户所见；停止态是指当前Activity调用onStop()之后所处的状态，此时他完全被处于运行态的Activity挡住，即程序界面完全不被用户所见。<br>
![](https://github.com/yangxcc/APP_Learn/blob/master/image/activity生命周期.png)
