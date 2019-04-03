##JDK11的重要新特性
+ JEP181:基于嵌套的访问控制
    * 摘要：在private,public,protected的基础上,JVM又提供了一种新的访问控制机制:Nest
    * 目标：如果你在一个类中嵌套了多个子类，那么子类中可以彼此访问彼此的私有成员
    * 代码：com.rc.openjdk11.NestAccessExample

+ JEP309:动态类文件常量(结合 Java Virtual Machine Specification 进行学习)
    * 摘要：增加一个常量类型 - CONSTANT_Dynamic
    * 目标：降低开发新形式的可实现类文件约束带来的成本和干扰
    * 代码：com.rc.openjdk11.DynamicTest
    
+ JEP315:改进Aarch64内联函数
    * 摘要：改进现有的字符串和数组函数，并在Aarch64处理器上为java.lang.Math.sin,cos和log函数实现新的内联函数
    * 目标：专用CPU架构可提高应用程序性能
    * 代码：com.rc.openjdk11.Aarch64Example

+ JEP321:标准HTTP客户端
    * 摘要：在JDK9中就已经引入了HTTPClient，不过一直处于孵化状态，到了JDK11，HTTPClient API结束了孵化状态，作为一个标准API提供在java.net.http包中
    * 目标：取代HttpURLConnection
    * 代码：com.rc.openjdk11.
    
+ JEP323:Lambda参数的本地变量语法
    * 摘要：允许var在声明隐式类型的lambda表达式的形式参数时使用
    * 目标：将隐式类型的lambda表达式中的形式参数声明的语法与局部变量声明的语法对齐
    * 代码：com.rc.openjdk11.LocalVarExample
    
+ JEP327:Unicode10
    * 摘要：升级现有平台的API，支持Unicode10(http://unicode.org/versions/Unicode10.0.0
                                                 unicode.org/versions/Unicode10.0.0/)标准
    + 目标：支持最新版本的Unicode，主要体现在以下类中
        * java.lang包中的Character，String
        * java.awt.font包中的NumericShaper
        * java.text包中的Bidi,BreakIterator,Normalizer
    * 代码：com.rc.openjdk11.Unicode10Example
    
+ JEP330:启动单文件源代码程序
    * 摘要：增强Java启动程序以运行作为单个Java源代码文件提供的程序
    * 目标：使用java HelloWorld.java 运行源代码文件
    * 代码：无具体代码，用法见目标
    
+ JEP333：可伸缩低延迟垃圾收集器
    * 摘要：Z垃圾收集器，也称为ZGC，是一个可伸缩的低延迟垃圾收集器
    * 目标：(最核心)无论开了多大的堆内存(128G,2T),保证低于10ms的JVM停顿，远胜于前一代的G1
    * 需要知道的知识点：垃圾回收，判断对象是否是垃圾的算法，回收垃圾对象的内存算法，垃圾收集器
    * 代码：无代码，只有原理的讲解
    + ZGC的特性
        * 所有阶段几乎都是并发执行的                                                                          
        * 像G1一样划分Region,但更加灵活                                                                          
        * 和G1一样会做Compacting-压缩                                                                          
        * 单代                         
    + 工作过程
        * Pause Mark Start - 初始停顿标记,停顿JVM　标记Root对象
        * Concurrent Mark - 并发标记,并发地递归标记其他对象
        * Relocate - 移动对象  
        * Remap - 修正指针,将指针更新指向新地址.上一阶段的Remap,和下一阶段的Mark是混搭在一起完成
            的，这样非常高效，省掉了重复遍历对象图的开销。
    * 深入：深入掌握这块知识需要系统学习JVM的工作原理(也是接下来要做的事情)
    
+ 垃圾回收
    * 引用
    * 垃圾
    * 回收
    * 发生地点    
    * 发生时间    
    
+ 判断对象是否是垃圾的算法
    + 引用计数器
        * 概念：堆中每个对象都有一个引用计数器。当一个对象被创建并初始化赋值后，该变量计数器设置为1.
            每当有个地方引用它时，计数器加1。当引用失效时，计数器值减1.任何引用计数为0的对象可以被
            当做垃圾回收。
        * 优点：引用计数收集器执行简单，判定效率高，交织在程序中运行。对程序不被长时间打断的实时环境
            比较有利（OC的内存你管理使用该算法）。
        * 缺点：难以检测出对象之间的循环引用。同时，引用计数器增加了程序执行的开销。所以java语言并没
            有选择这种算法进行垃圾回收。                        
    + 根搜索算法            
        * 标记可达对象：JVM中用到的所有现代GC算法在回收前都会先找出所有的仍存活对象。根搜索算法是从
            离散数学中的图论引入的，程序把所有的引用关系看作一张图。（此处缺少具体示例图）
+ 回收垃圾对象的内存算法
    + Tracing 算法（Tracing collector）或标记-清除算法（此处缺少具体示例图）
    + Compacting 算法（Compacting collector）或标记-整理算法（此处缺少具体示例图）   
+ 垃圾收集器
    + 串行垃圾收集器（Serial Garbage Collector）
        * 说明：它为单线程环境设计，只使用一个单独的线程进行垃圾回收。是Client级别默认的GC方式。
        * 使用：通过JVM参数-XX：+UseSerialGC可以使用串行垃圾收集器。
    + 并行垃圾收集器（Parallel Garbage Collector）
        * 说明：它是JVM默认的垃圾收集器。使用多线程进行垃圾回收
        * 使用：可用-XX+：UseParallelGC来强制指定，用-XX:ParallelThreads=4来指定线程数。
    + 并发标记扫描垃圾收集器（CMS Garbage Collector）
        + 说明：并发标记垃圾回收使用多线程扫描内存，标记需要清理的实例并且清理被标记过的实例。并发
            标记扫描回收器只会在下面两种情况下持有应用程序所有线程。
            * 当标记的引用对象ｔｅｒｎａｌ区域
            *　在发生垃圾回收的时候堆内存的数据发生改变
        * 使用：通过JVM参数XX:+UseParNewGC打开并发标记扫描垃圾收集器
    + G1收集器（G1 Garbage Collector)  
        * 说明：G1收集器是当今收集器技术发展最前沿的成果，它是一款面向服务端应用的收集器，它能充分
            利用多CPU,多核环境。因此它是一款并行与并发收集器，并且它能建立可预测的停顿时间模型。
        * 使用：通过JVM参数-XX:+UseG1GC使用G1垃圾收集器 　                          

##JDK其他新特性
JEP318:无操作垃圾收集器
JEP320:移除JavaEE和COBRA模块
JEP324:Curve25519和Curve448算法的密钥协议
JEP328:Flight Recorder
JEP329:ChaCha20和Poly1305加密算法
JEP331:低开销的Heap Profiling
JEP332:支持TLS1.3
JEP335:弃用Nashorn JavaScript引擎
JEP336:弃用Pack200工具和API

##新增加的API
* java.lang.String(对应代码: com.rc.openjdk11.StringExample)
* java.nio.file.Files(对应代码: com.rc.openjdk11.FilesExample)
* java.util.List(对应代码: com.rc.openjdk11.ListExample) 