package com.bala.singleton;

public class LazySingleton {
    /*
    instance变量被volatile关键字所修饰，但是如果去掉该关键字，就不能保证该代码执行的正确性。
    这是因为“instance = new Singleton();”这行代码并不是原子操作，其在JVM中被分为如下三个阶段执行：
        1.为instance分配内存
        2.初始化instance
        3.将instance变量指向分配的内存空间
    由于JVM可能存在重排序，上述的二三步骤没有依赖的关系，可能会出现先执行第三步，后执行第二步的情况。
    也就是说可能会出现instance变量还没初始化完成，其他线程就已经判断了该变量值不为null，
    结果返回了一个没有初始化完成的半成品的情况。而加上volatile关键字修饰后，可以保证instance变量的操作不会被JVM所重排序，
    每个线程都是按照上述一二三的步骤顺序的执行，这样就不会出现问题。

    需要说明的一点是，volatile关键字在jdk1.5以前的版本使用的话可能会出现意想不到的结果，在jdk1.5以后完善了该关键字的功能。所以如果要使用上面的双
    重检查加锁的方式来实现单例，请确保jdk的版本大于1.5。
    ————————————————
    版权声明：本文为CSDN博主「天瑕」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/weixin_30342639/article/details/91356608
     */
    private volatile static LazySingleton lazySingleton=null;//加上volatile关键字修饰后，可以保证instance变量的操作不会被JVM所重排序
    private LazySingleton(){
        System.out.println("123");
    }

    public static LazySingleton getInstance() {
        if (lazySingleton==null){
            synchronized (LazySingleton.class){
                if (lazySingleton==null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        LazySingleton.getInstance();
    }
}
