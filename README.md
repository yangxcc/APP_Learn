# APP_Learn
### 项目结构
![]()首先认识项目结构，在Andriod项目目录下，manifests文件夹下有AndroidManifests.xml文件，该文件是整个项目的清单文件，在里面可以设置项目名称，项目图标，启动项目时的首页面，项目主题等内容；java文件夹下用来存放java代码，保存app内部的业务逻辑；res是资源文件夹，这下面用于存放app开发过程中使用到的各种类型的资源。<br>
Android系统自动为每个资源分配一个十六进制的整型数，用以表明每个资源，保存在名为R.java的文件中(Project视图下)<br>
![](https://github.com/yangxcc/APP_Learn/blob/master/image/R.java.png)<br>
- 布局文件夹res/layout项目的布局文件夹res/layout用来存放扩展名为.xml的布局文件，由某种布局管理器管理的若干控件对象组成，供Activity组件使用。 
- 值文件夹 res/values 值文件夹 res/values 里的 strings.xml 是非常重要的文件，通常存放着布局文件中的控件对象的属性值。
- 软件设计的国际化，国际化是指在软件设计过程中将特定语言及区域脱钩的过程。当软件移植到不同的语言及区域时，软件本身不需要做任何的修改。Android SDK并没有提供专门的API来实现国际化，而是通过对不同的资源文件进行不同的命名来达到国际化的目的。例如，在布局文件中，定义文本框控件的代码： <TextView …android:text="@string/hello"/> 就是符合国际化的做法，控件值来源于文件res/values/strings.xml，通过键名hello来引用。 如果不通过引用字符串变量的方式，而是直接把字符串常量写在TextView控件的android:text属性后，即<TextView …android:text="字符串常量"/>这种写法，对程序运行没有任何影响，只是它不符合国际化的做法。注意：使用软件设计的国际化，能有效实现程序员与 UI 设计人员工作的分工协作。 
- 图像文件夹res/drawable与Windows应用程序一样，每个Android应用工程都有一个图标。Android应用默认使用的图标文件ic_launcher是一个绿色的机器人，其文件格式是.xml，存放在文件夹res/mipmap里。更改Android应用默认图标的一种方法是，右键 mipmap 文件夹→New→ Vector Asset→选择 Clip Art。另一种方法，将.png 格式的文件，复制到文件夹 res/drawable， 然后通过 R 文件引用该图像文件。 
- 音乐文件夹 res/raw 项目使用的音频文件，通常存放在 res/raw 文件夹里。 
#### Gradle构建Scripts与依赖管理 
gradle是一种依赖管理工具，基于Groovy语言，主要面向Java应用，它抛弃了基于XML的各种繁琐的配置，取而代之的是一种基于Groovy的内部领域特定语言(DSL)。
- 一个Android应用中的每个Module都对应一个名为build.gradle的脚本文件，它包含了该Module使用的API版本、仓库(repositories)和依赖等(dependences)
- 脚本文件setting.gradle声明一些需要加入gradle的Module
- 脚本文件gradle-wrapper.properties用来配置Gradle及其版本
- 项目构建脚本是面向所有Module的，文件settings包含了项目的所有Module名称。
### Android体系机构
![](https://github.com/yangxcc/APP_Learn/blob/master/image/Android%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84.png)
#### Linux内核（Linux Kernel）
是硬件和其他软件堆层之间的一个抽象隔离层(其中包含很多的驱动程序)，提供由操作系统内核管理的 底层基础功能，主要有安全机制、内存管理、进程管理、网络协议栈和驱动程序等。 <br>
**Android手机内部存储的文件系统分区格式与Linux系统相同，而外部存储采用FAT**
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
* Dalvik是基于寄存器Register-based的虚拟机，Dalvik执行的是dex文件，在执行过程中，每一个应用程序就是一个进程
* Java VM是以基于栈Stack-based的虚拟机，执行的是Java class文件（字节码文件 bytecode）
**Dalvik最大的好处在于可以根据硬件实现更大的优化，这更适合移动设备**
#### 应用框架层
应用程序框架层提供了 Android 平台的管理功能和组件重用机制，包括 Activity 管理、资源管理、位置管理、通知消息管理、View 系统和内容提供者等。**Android 的三大核心功能如下：**
* View：提供了绘制图形，处理触摸、按键事件等功能。 
* Activity Manager Service：简称为AMS，其主要功能是管理所有应用程序的Activity、内存管理等。AMS 作为一种系统级服务管理所有 Activity，当操作（启动或停止） 某个 Activity 时，必须报告给 AMS，而不能“擅自处理”。在内存不足时，AMS 可能主动杀死后台的 Activity
* Window Manager Service：简称为WMS，其主要功能是为所有应用程序分配窗口，并管理这些窗口。 
#### 应用程序层
* 应用程序层提供了一系列核心应用程序，如打电话、浏览器、联系人、相册、地图和电子市场等。 
* 应用程序存储在手机的内部存储区，且按包名存放，需要特定的程序才能查看。
### Android应用程序的基本组成
Android应用程序是由组件组成的，组件可以调用相互独立的功能模块，根据完成的功能，组件可以划分为四类核心组件，即Activity、Service、BroadcastReceiver和ContentProvider，值得注意的是：
* 在结构上，Android应用程序与C语言程序不同，它是**基于组件编程的**
* Android四大组件中除了ContentProvider外，都是通过Intent激活的
* Android四大组件均需要在项目清单文件AndroidManifests.xml中使用相关标签进行注册
#### Acticity组件与视图View
Activity是Android中最重要的组件，负责用户界面设计。Activity用户界面框架采用MVC模式(Model View Controller)。控制器负责接受并响应程序的外部动作；通过视图反馈应用程序给用户的信息(通常通过UI界面来反馈信息)；模型是应用程序的核心，用于保存数据和代码。Activity组件在清单文件中使用<activity>标签来注册。
#### Service组件
Service是Android提供的无用户界面、长时间在后台运行的组件。Android提供了许多系统服务程序。Service组件需要在清单文件中使用<service>标签注册
#### BroadcastReciver组件
在Android系统中，当有特定事件发生时就会产生相应的广播。例如，开机启动完成、短信到来、电池电量改变、网络状态改变等。<br>
BroadcastReciver，即广播接收者，用来接收来自系统或其他应用程序的广播并作出响应。广播接收者组件BroadcastReciver与Service组件一样都没有UI界面。该组件要在清单文件中使用<reciver>组件来进行注册。
#### ContentProvider组件
为了跨进程共享数据，Android提供ContentProvider接口，可以在无需了解数据源、路径的情况下，对共享数据进行查询、添加、删除、更新等操作，该组件要在清单文件中使用<provider>标签来注册。
  
#### Application、Context、Intent
- **应用对象Application**，当Android程序启动时系统会创建一个Application类型的对象，用来存储系统的一些信息，完成数据的传递、共享和存储等一系列操作。Application对象的生命周期是整个程序中最长的，他的生命周期就等于这个程序的生命周期，且是全局、单例的，即在不同的Activity、Service中获得的对象都是同一对象。
- **上下文对象Context**，Activity和Service都是Context的子类，通过Context提供的方法getApplicationContext()方法就能获到Context对象。Broadcast Receiver，Content Provider并不是Context的子类，他们所持有的Context都是其他组件传递过来的。 Android 组件及通信机制，如下图所示：<br>
![](https://github.com/yangxcc/APP_Learn/blob/master/image/Android组件之间的通信机制.png)<br>
- **意图对象Intent**，Android提供轻量级的进程间通信机制Intent，使跨进程通信组件和发送系统广播成为可能，组件Activity、Service、BroadcastReciver都是通过消息机制被激活的，其使用的消息就封装在对象Intent中。<br>
`Context 是一个抽象类且为Activity的超类，提供了startActivity()方法，并以Intent对象作为参数，用于实现窗体的跳转。 `<br>
#### Android虚拟机Dalvik
尽管Android的编程语言是Java，但是Android使用的虚拟机Dalvik与Java使用的虚拟机JVM不能兼容，因为Dalvik是基于寄存器的架构，而JVM是基于栈的架构，此外，Dalvik能根据硬件实现最大的优化，更适合于移动设备。<br>
运行用户开发的Android应用程序时，如果在系统目录\data\dalvik里存放相应的.odex文件，Android的Dalvik虚拟机会直接从.odex中加载指令和数据后执行，若没有odex的话，需要从.apk包中提取class.dex并生成.odex文件，然后再加载并执行，`因为真正在Android虚拟机上运行的是odex文件`，那么就不会再从.apk里面去解压、提取，显然，这种预先提取的方式可以加快软件的启动速度，减少对RAM的占用。
### Activity的生命周期
Activity作为Android中的最重要的组件，用于设计应用程序的用户界面，其内容来源于布局文件。在一个Activity的onCreate()方法中，使用父类的setContentView()呈现内容视图，并以布局文件作为参数，Activity包含了响应界面事件的代码，即具有控制器功能。<br>
复杂的Android应用中可能包含多个Activity，当打开一个新的Activity时，先前的那个Activity会被置于暂停状态，并压入历史堆栈中，用户可以通过返回键退回到之前的那个Activity。<br>
Activity是由Android系统维护的，每个Activity除了有创建onCreate()、销毁onDestroy() 两个基本方法外，还有激活方法onStart()、恢复方法onResume()、暂停方法onPause()、停止方法onStop()和onRestart()。 <br>
Activity在其生命周期中存在三种不同的状态：运行态、暂停态和停止态。运行态是指Activity调用onStart()方法后出现在屏幕的最上层的状态，此时用户通常可以获取焦点；暂停态是指Activity调用onPause()方法之后出现的状态，其上还有处于运行态的Activity存在，并且Activity没有被完全挡住，即处于暂停态的Activity有一部分视图被用户所见；停止态是指当前Activity调用onStop()之后所处的状态，此时他完全被处于运行态的Activity挡住，即程序界面完全不被用户所见。<br>
![](https://github.com/yangxcc/APP_Learn/blob/master/image/activity生命周期.png)<br>
从上图可以看出，当某个Activity首次运行时，肯定会调用的三个方法依次是onCreate()，onStart()，onResume()，执行完这三个方法后的Activity肯定会显示在界面上，此时的Activity处于运行态。若此时的界面被隐藏(退出到后台)，则会依次调用onPause(),onStop()，对于处于运行态的Activity，当用户按返回键退出时，将调用方法onStop()。 
**处于暂停态或停止态的Activity在系统资源缺乏时，可能被杀死，以释放其占用的资源。这就是为什么有时按返回键会调用destory方法的原因**<br>
android.util.Log类使用如下方法输出不同级别的日志信息：
* Log.v("TAG", "Verbose level message");----Verbose详细
* Log.d("TAG", "Debug level message");------Debug调试
* Log.i("TAG","Information level message");---Information信息
* Log.w("TAG", "Warning level message");-----Warning警告
* Log.e("TAG", "Error level message");-----Error错误
* Log.wtf("TAG", "Assert level message");----Assert断言
按照严重程度从小到大排序：Verbose<Debug<Information<Warning<Error<Assert，选择等级低的可以显示出所有比其等级高的日志信息。Assert是最严重的错误，很少出现，这种错误会使系统崩溃，用Log.wtf去写。wtf的意思是：What a Terrible Failure.而且在Android开发中，一般是通过Log.x打印信息，因为使用`Log比使用System.out.print的效率高`，原因在于，Log调用的是native层C语言，而System.out是Java语言，C的执行效率要比Java高。<br>
##### 对TextView的操作
常用的Text类控件是TextView和EditText。TextView是用来显示字符的控件，而EditText 是用来输入和编辑字符的控件。(注意：EditView 是 TextView 的子类，EditText 是一个具有编辑功能的 TextView 控件。)，当 TextView 的内容特别多时，可使用它的一个重要方法 setMovementMethod(new ScrollingMovementMethod())实现滑动，即可以通过手指的上下滑动来查看内容。在[MyWork2](https://github.com/yangxcc/APP_Learn/tree/master/MyWork2)中共实现了对TextView的8中操作，包括长文本情况下的“走马灯式”效果实现、阴影效果实现、文字缩放效果实现、在文本周围添加图像、文本框背景前景边框的实现、同一个TextView中文字的不同效果(大小、颜色)以及图文混排的实现。实现效果见[image](https://github.com/yangxcc/APP_Learn/tree/master/image)文件夹中。
