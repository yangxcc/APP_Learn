# 在这里总结这个购物车项目
首先，购物车的项目结构为：<br>
![](https://github.com/yangxcc/APP_Learn/blob/master/image/%E8%B4%AD%E7%89%A9%E8%BD%A6%E9%A1%B9%E7%9B%AE%E7%BB%93%E6%9E%84.png)<br>
在购物车APP开发过程中用到的方法有:<br>
- JavaBean中的set、get方法，用于设置、获取产品、购物车产品数据
- Adapter中重写的getView()，其中最主要的就是LayoutInflater.from(context).inflate(resourceId,null)，这行代码的主要意思是从context中生成一个填充器，然后根据resourceId来找出xml，通过inflate()将xml布局转化成视图。
- Activity中的setOnClickListener()对button增加监听，弹出对话框时的建造者模式，菜单项监听onOptionsItemSelected()
在购物车APP中要实现数据的串行化，对象的寿命通常随着生成该对象的程序的终止而终止。有时候，可能需要将对象的状态保存下来，在需要时再将对象恢复。我们把对象的这种能记录自己的状态以便将来再生的能力。叫作对象的持续性(persistence)。对象通过写出描述自己状态的数值来记录自己，这个过程叫对象的串行化(Serialization) 。串行化的主要任务是写出对象实例变量的数值。如果交量是另一对象的引用，则引用的对象也要串行化。这个过程是递归的，串行化可能要涉及一个复杂树结构的单行化，包括原有对象、对象的对象、对象的对象的对象等等。对象所有权的层次结构称为图表(graph)。<br>
一个比较细微的知识点：**自动填充功能**，<br>
```
login_input_text = findViewById(R.id.login_input_username);
String[] tips = getResources().getStringArray(R.array.username);  //在Strings.xml文件中定义好了提示字符串
ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tips); //封装好的ArrayAdapter只能传递单个字符串
login_input_text.setAdapter(adapter);
login_input_text.setThreshold(1);   // 输入一个字符便开始提示
```
**项目开发过程中出现主要的问题**
（1）对ListView中的控件添加监听，比如对界面中的购物车按钮添加事件，我最开始是在Shopping这个activity中写的，但是会报错获取不到视图组件，因为findviewbyid()是在当前视图下通过控件id获取控件，所以最简单的方法是在adapter中获取这个控件。<br>
（2）Adapter与Activity之间的数据交互，在一些博客中写到在Adapter中创建一个接口和setlistener函数，这种方面应该可行，但是直接定义静态变量，通过类名.静态变量获得。<br>
**本项目开发的重点在于ListView通过adapter获取数据，以及adapter与activity之间的数据交互**<br>
项目部分结果展示<br>
![](https://github.com/yangxcc/APP_Learn/blob/master/image/购物车效果.gif)<br>
