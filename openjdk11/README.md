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
    * 深入：深入掌握这块知识需要系统学习JVM的工作原理(也是接下来要做的事情)

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