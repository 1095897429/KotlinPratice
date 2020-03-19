
================================================================== Kotlin 基本语法 =============================================================================
1.数据类型
 a.数值类型 Numbers[Byte,Short,Int,Long,Float,Double]
 b.字符类型 Characters[Char]
 c.字符串类型 Strings[String]
    字符串模板 $ 表示一个变量名
 b.布尔类型 Boolean
 e.数组类型 Arrays
    创建 arrayOf  || Array()

2.类
 a.class 类名(参数1：参数类型，参数2：参数类...){}
 b.主构造函数
    采用constructor关键字 init代码块初始化代码 【可省略关键字】
 c.次构造函数
    必须constructor关键字

 3.类的属性
  a.var 读写 is 可数据类型判断
  b.val 只读 is 可数据类型判断
  c.: 继承 open关键字表示可被继承 ✅
  d.默认父类方法不可重写，需加上open以及子类加上override

 4.其他特殊
  a.inner 关键字  类部类
  b.interface 关键字 接口可以有方法体【区别于Java】
  c.data 关键字 数据类
  d.enum 关键字 枚举类

  5.函数
  a.fun 关键字
  b.参数的可以设置默认值
  c.when 相当于 switch[Java]
  d.for in 相当于 for[Java]

  6.范围使用
  a.in 1...5 在...范围内 闭包
  b.1 until 5 在...范围内 不包含最后一个

  7.Java 相等性判断 [复习了一下Java的值传递 值的拷贝 空间地址的传递]
  a.Java 的相等性 复习【 默认的是比较是不是同一个对象✅ 重写equals让其对象的内容相等】
    【哈希表/散列表 可以理解成竖直的列表 数组中存放的是链表结构Entry/Node对象】
        -- 通过key的hashCode算出在数组的索引，在通过key + value + bucketIndex 利用createEntry添加Node

  b.Java的equals hashCode的关系【复习】
    hashCode相等，它们不一定相等 -- 哈希冲突
    equal相等，它们一定相等
  c.HashSet的复习[疑问：是如何不加载重复数据的]
    add(E) -- HashMap.put(E,new Object) -- 疑问解答

  8.Kotlin相等性判断
  a.=== 表示 是不是指向同一个对象
  b.==  表示 同Java的equals一样，表示结构内容

  9.空处理
  a.在条件中检查null
  b.安全调用 ?.
  c.?:相当于Java中的三目运算符
  d.!!非空则返回，否则抛出NPE异常


  0.String的复习
  a.字符串常量池【1.直接赋值 是在常量池中创建对象 2.str1 + str2 构建stringBuild累加 3.new String() 在堆上构建一个对象】

  1.嵌套类 内部类 匿名类
  a.没有inner的类部类是不可获取外部类的信息
  b.匿名类通常使用lambda表达式【仅留下方法的参数】💖

================================================================== Webview 的一些知识 ==============================================================================

1.setWebViewClient作用
a.各种事件的回调（页面加载开始/完成,拦截url跳转）
    shouldOverrideUrlLoading 此函数是WebView加载URL前回调的
        return true -- webview不再继续加载URL，不会触发系统默认行为
        return false -- 会触发系统默认行为
    onReceivedError 加载错误时产生这个回调

2.Js交互
a.addJavascriptInterface(对象1，对象1别名) -- 对象1是注入到WebView中的对象，通过名称来调用对象中的方法
    sendMessage(Js传递json字符串给Native)
b.javascript:让h5知道需要调用JS函数
    toGiveToken(项目中给token给Js)
c.传递值


c.获取JS中的返回值
    4.4之前 java调用js，js方法执行完毕，在调用java方法 -- loadUrl
    4.4之后 调用方法中的接口回调返回String类型 -- evaluateJavascript
d.webview滚动事件监听 onScrollChanged

3.setWebChromeClient作用
a.各种事件的回调(通知当前网页进度，定位权限询问，alert弹框等等)
    onJsAlert -- 网页弹框的监听






















