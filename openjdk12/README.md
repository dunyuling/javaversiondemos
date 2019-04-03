##JDK12的重要新特性
+ JEP230:微基准测试
    * 摘要：Microbenchmark作为常规性能测试的一部分，在JDK源代码中添加一组基础的微基准测试
    * 目标：可以基于Java Microbenchmark Harness(JMH)轻松测试JDK的性能
    * 代码：com.rc.openjdk12.BenchmarkTest
    
+ JEP325:增强的switch语句
    * 摘要：扩展switch语句，使其可以用作语句或表达式，并且“传统”和“简化”两种都可以使用
    * 目标：简化switch语句的书写形式
    * 代码：com.rc.openjdk12.SwitchExample
    + 执行方式(cmd)
        + type 1
            * 打包 mvn clean verify
            * 执行 java --enable-preview -jar target/openjdk12-1.0-SNAPSHOT.jar
        + type 2(单文件执行，无package概念)
            * javac --release 12 --enable-preview SwitchExample.java
            * java --enable-preview SwitchExample           
        
+ JEP341:默认的类数据共享
    * 摘要：在64位平台上使用默认类列表，增进了JDK生成的类共享(CDS),改善了开箱即用的启动时间
    * 目标：取消了用户必须运行-Xshare:dump,才能使用CDS的的功能
    * 代码：无代码，只概念
    + 关于类数据共享：
        * JVM启动   
        * 高速缓存访问   
        * 高速缓存动态更新   
        * 高速缓存安全性   
        * 高速缓存生存时间   
    
+ JEP344:可终止的G1垃圾收集器
    * 摘要：如果G1收集器有可能超过预期的暂停时间，则可以使用终止选项
    * 目标：G1可以中止可选部分的回收以达到停顿时间目标
    * 代码：无
    
+ JEP346:G1归还未使用的内存
    * 摘要：如果应用程序活动非常低，G1应该在合理的时间段内释放未使用的java堆内存
    * 目标：可以在空闲时自动将java堆内存返回给操作系统
    * 代码：无
    
+ G1垃圾收集器
    + Garbage-First Garbage Collector  
        + 核心概念
            * 面向大内存
            * 多核系统收集器
            * 软停顿目标
            * 可预测停顿时间
        + 长期目标
            * 取代CMS
        + 堆内存结构
            + Region的大小
                * -XX:G1HeapRegionSize
                * 1,2,4,8,16,32M
                * MIN_REGION_SIZE(1024*1024->1M)
                * MAX_REGION_SIZE(32*1024*1024->32M)
                * TARGET_REGION_NUMBER(2048)
        + GC模式
            + young gc
                * 年轻代的GC算法
                * 拷贝到survior region
                * 晋升到old region中
            + mixed gc
                * 避免堆内存耗尽
                * 不是old gc,而是young + old region gc
                    * 是部分老年代，不是全部老年代
            + full gc
                * 对象分配速度过快
                * old region 被填满
                * 单线程执行
        + 总结
            + 属性
                + 服务器风格的垃圾回收器
                    * 并行和并发
                    * 分代处理                      
                    * 紧凑内存（碎片整理）
                    * 预见性
            + 应用场景
                * 垃圾收集与应用线程并发执行                                                                               
                * 空闲内存压缩暂停时间短                                                                                
                * 可预测的GC暂停时间                                                                                
                * 不需要很大的java堆     
                                                                                   
##JDK其他新特性
JEP189:低暂停的垃圾收集器-Shenandoah
JEP334:JVM常量API
JEP340:保留AArch64端口

