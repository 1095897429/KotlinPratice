
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
  a.Java 的相等性 复习【 默认的equals是比较是不是指向同一个对象✅ 重写equals让其对象的结构内容相等】
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
  c.!= 表示引用不相等

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


================================================================== Webview 的一些知识  2020.4.1 看过 ==============================================================================

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


c.获取JS中的返回值
    4.4之前 java调用js，js方法执行完毕，在调用java方法 -- loadUrl
    4.4之后 调用方法中的接口回调返回String类型 -- evaluateJavascript
d.webview滚动事件监听 onScrollChanged

3.setWebChromeClient作用
a.各种事件的回调(通知当前网页进度，定位权限询问，alert弹框等等)
    onJsAlert -- 网页弹框的监听


================================================================== 状态栏 的一些知识 2020.3.23 看过 ==============================================================================

1.要求状态栏透明，内容布局延伸到系统状态栏
    a.Android 5.0 及其以后版本
        设置 View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN + setStatusBarColor()设置透明
    b.Android 6.0 状态栏字体颜色默认是白色
        设置 View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) 可设置黑色



================================================================== RecyclerView 的一些知识 ==============================================================================

1.单/多布局
    a.getItemViewType(position)返回每个item的布局类型 -- onCreateViewHolder参数中的viewType表示布局的类型 -- onBindViewHolder中通过type加载不同数据
    b.BaseRecyclerViewAdapterHelper第三方库
        a.new BaseQuickAdapter()
        b.setNewData(List<T> data)

        c.单布局 -- getItemViewType(position) -- getDefItemViewType(position) -- 调用系统原生的getItemViewType方法
                -- onCreateViewHolder(viewType) -- createBaseViewHolder(viewType) -- new BaseViewHolder(view)[view是item布局]
                -- onBindViewHolder(positions) -- 抽象convert函数

        d.多布局 -- getItemViewType(position) -- getDefItemViewType(position) -- 调用多布局的getDefItemViewType[获取Bean的type]
                -- onCreateViewHolder(viewType) -- 调用多布局的onCreateDefViewHolder函数 -- 调用多布局的createBaseViewHolder() -- 调用多布局getLayoutId函数 -- new BaseViewHolder(view)[view是item布局]
                -- onBindViewHolder(positions) -- 抽象convert函数
                -- addItemType(RIGHT_IMG_TYPE, R.layout.xxx);将布局添加到layouts集合中[layouts类似于[type,resId]]

        e.头布局 -- LinearLayout.add(headView)

    c.什么时候复用view(通过onCreateViewHolder会new 一个ViewHolder)
         a.复用
          a.mAttachedScrap
          b.mCachedViews
         b.回收
          a.放入到mRecyclerPool中的HolderView 会回调adapter中的onViewRecycled函数，将重置后的holder放入到pool中

    d.ItemDecoration
        a.可完成GridView中item间距平分

    e.加载更多(BaseRecyclerViewAdapterHelper)
        a.默认设置了布局，通过设置状态，在适配器中的onCreateView中创建，onBindViewHolder中显示
        b.当potion等于当前数据的长度时：一般走加载更多布局：adjPosition = 20 - 20 = 0
        c.加载完成后，调用notifyItemRangeInserted从指定位置刷新指定个item

================================================================== 圆形头像的一些知识 ==============================================================================


//        1.PorterDuff.Mode.SRC_IN (Android 9.0上绘制有问题)
//        a.先绘制的是目标图
//        b.在两者相交的地方绘制源图
//        2.利用BitmapShader
//        a.
//        3.GradientDrawable(没使用过)
//        a.就是shape的xml布局
//        b.原理就是利用Canvas.drawCircle等等绘制
//
//        String s = "ABC";
//        KLog.d("tag","截取的字符串是【利用fastSubstring】, 从索引处开始截取 " +  s.substring(1));


================================================================== Lrucache/DiskLruCache 的一些知识 ==============================================================================
DiskLruCache
1.一般选择的缓存位置是/sdcard/Android/data/<package>/cache目录下
    a.不会对手机内存存储空间有影响
    b.程序被卸载时，这里的数据也一起被清除掉
2.open()创建一个实例
   a.Editor.edit(key)写入缓存，commit()让其生效
   b.Snapshot.getInputStream(0)获取输入流
   c.flush() 将记录同步到日志journal文件中 -- onPause中调用一次即可
   d.journal日志的写入是dirty前缀，clean是写入成功前缀 remove是写入失败/删除成功前缀，read是读取前缀


Lrucache[androidx.collection包下]
1.Runtime.getRuntime().maxMemory() 获取应用程序最大可用内存

2.loadBitmap 先从内存中获取缓存，没有找到 开启一个任务去异步加载
，加载前先从磁盘中获取缓存，没有找到 从网络上请求图片并写入磁盘缓存，同时添加到内存缓存

Lrucache的实现
a.LinkHashMap是HashMap的子类，一些put,get,remove方法都在父类中实现
    a.特殊的地方：使用双向链表 记录了元素的添加和访问顺序
        a.双向链表：
            a.head头节点
            b.tail尾节点
            c.before直接前驱
            d.after直接后驱
    b.特殊实现的函数：newNode,afterNodeAccess等等
b.trimToSize
    a.toEvict获取到第一个节点 evict[i'vikt 驱逐]


================================================================== comparator/comparable 的一些知识 ==============================================================================

a.如果某类本身不支持排序，可建立一个”该类的比较器“进行排序 comparator
    a.需实现compare函数 ， equals函数[这个类中可以在单独的Bean实现]
b.一个类实现Comparable接口，意味着”该类支持排序“ comparable
c.配合TreeMap使用，来对需要加密的参数进行升序/降序操作

================================================================== TreeMap 的一些知识 ==============================================================================

a.红黑树的特点
  + 每个节点红色或者黑色
  + 路径上不能有两个连续的红色节点
  + 根节点是黑色
  + 每个红色节点的两个子节点一定都是黑色

  判断当前节点的父节点是祖父节点的左子树还是右子树

  + 左子树

    + 判断叔父节点颜色
      + 红色 -- 设置父节点/叔父节点都为黑色，祖父节点为红色 -- 最后设置根节点为黑色
      + 黑色/没有 -- 判断当前节点是左子树插入 还是 右子树插入
        + 左子树插入 -- 设置父节点为黑色，祖父节点为红色 -- 以祖父节点右旋转
        + 右子树插入 -- 以父节点左旋转，并将x重新赋值 -- 左子树插入逻辑

  + 右子树

    + 判断叔父节点颜色
      + 红色  -- 同上
      + 黑色/没有 -- 判断当前节点是左子树插入 还是 右子树插入
        + 右子树插入 -- 设置父节点为黑色，祖父节点为红色 -- 以祖父节点左旋转
        + 左子树插入 -- 以父节点右旋转，并将x重新赋值 -- 右子树插入逻辑


​================================================================== 加密 的一些知识 ==============================================================================

a.MD5 信息摘要算法
    a.单向摘要算法
    b.任意长度数据，算出的md5长度是固定的
    c.MD5加盐操作
        a.string + key(盐为key)
        b.string明文的hashcode作为盐
    d.md5算法返回的是一个128位整数,128位二进制等于32位十六进制,十六进制是取四合一【4位二进制数合成一个1位十六进制数】
        a.二进制 -- 十进制 每个乘以2的n次方
        b.十进制 --二进制 除以2，反向取余数
b.消息摘要
    a.消息的摘要 - 保证消息的完整性
c.数字签名
    a.包括 签名算法 + 验证算法
    b.公钥密码体制 --  RSA
    c.对称加密算法
    d.非对称加密算法
d.数字证书
    a.保证公钥安全


================================================================== Map 的一些知识 ==============================================================================

a.HashMap是Map的一个实现
    a.数组 + 链表 + 红黑树

b.HashSet
    a.内部是利用HashMap添加数据，将将入的数据作为key

c.TreeMap 👆
    a.红黑树
    b.添加的时候通过comparator或者comparable比较

d.TreeSet
    a.基于TreeMap的实现的
    b.提供有序的Set集合
    c.put的时候将对象作为key，object作为value存储到treemap中


================================================================== iterator  的一些知识 ==============================================================================

a.迭代器
    a.hasNext 判断游标右边是否有数据
    b.next 返回游标右边数据
    c.remove 删除游标左边数据，每次只能执行一次,并且在next之后操作
    d.iterator() -- 返回一个迭代器对象，对集合容器内元素进行遍历操作
b.Foreach 与 它的关系
    a.foreach是语法糖
    b.iterator是针对有删除操作，同时也是对集合的遍历
c.hashMap的3种遍历
    a.for map.entrySet() -- 获取EntrySet对象
    b.iterator()调用 -- 具体定义的Iterator对象
    c.for map.keySet() -- 获取KeySet对象


================================================================== 截取  的一些知识 ==============================================================================

a.substring 是从索引开始截取，默认的是substring(0),这样就很好理解
    a.start开始的位置 包括该位置的字符
    b.end 结束的位置
b.indexOf 相当于源字符串 和 目标字符串 两行比较，获取到刚开始相等的索引



================================================================== 传值  的一些知识 ==============================================================================

a.Java按值传递还是按引用传递 [https://blog.csdn.net/zzp_403184692/article/details/8184751]
    a.基本数据类型 值的拷贝，传递后就互不相关了
    b.引用类型  传递引用地址，同指向内存空间地址

================================================================== 泛型  的一些知识 ==============================================================================






































