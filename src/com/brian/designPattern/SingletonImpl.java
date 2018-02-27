package com.brian.designPattern;

public class SingletonImpl {
    /**
     * 懒汉式，不初始化instance，线程安全
     * 注意构造函数, synchronized
     */
    public static class Singleton01{
        private static Singleton01 instance = null;

        private static void Singleton01(){}

        public static synchronized Singleton01 getInstance() {
            instance = new Singleton01();
            return instance;
        }
    }

    /**
     * 饿汉式，线程安全
     * 但是在类加载时instance就被初始化了，不好
     */
    public static class Singleton02{
        private static Singleton02 instance = new Singleton02();

        private static void Singleton02(){}

        public static Singleton02 getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式，双重锁，线程安全
     * 程序员称其为双重检查锁，因为会有两次检查 instance == null，一次是在同步块外，一次是在同步块内。
     * 为什么在同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
     * 也就是说，当多个线程在synchronized块外等待，如果锁解除进入块中，需要判断instance是不是已经被实例化，因为之前锁住块的进程可能已经实例化过了
     * 缺点：指令重排问题
     */
    public static class Singleton03{
        private static Singleton03 instance = null;

        private static void Singleton03(){}

        public static Singleton03 getInstance() {
            if (instance == null) {
                synchronized (Singleton03.class) {
                    if (instance == null) {
                        instance = new Singleton03();
                    }
                }
            }

            return instance;
        }
    }

    /**
     * 使用volatile修饰instance，避免指令重排
     * JVM中初始化对象的步骤：
     * 1. 在内存中分配空间
     * 2. 初始化对象
     * 3. 设置指针指向对象
     * 如果2和3的步骤反了，那么当A线程加载singleton的时候instance会指向空对象，这时instance已经不为null了，会直接返回instance。
     * 当B线程获得锁之后会因为instance不为null而返回一个指向空对象的instance
     */
    public static class Singleton04{
        private static volatile Singleton04 instance = null;

        private static void Singleton04(){}

        public static Singleton04 getInstance() {
            if (instance == null) {
                synchronized(Singleton04.class) {
                    if (instance == null) {
                        instance = new Singleton04();
                    }
                }
            }

            return instance;
        }
    }

    /**
     * 静态内部类，最好，线程安全
     * 内部类在使用时才会被加载，满足了懒加载的要求
     * 当多个线程想要初始化instance时，JVM会自动加锁保证只有一个线程来初始化它
     * 『同一个类加载器下，一个类型只会初始化一次』
     */
    public static class Singleton05{
        private static class SingletonHolder{
            private static Singleton05 instance = new Singleton05();
        }

        private static void Singleton05(){}

        public static Singleton05 getInstance() {
            return SingletonHolder.instance;
        }
    }
}
