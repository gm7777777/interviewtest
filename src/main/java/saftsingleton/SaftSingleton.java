package saftsingleton;

public class SaftSingleton {
    private SaftSingleton(){

    }

    private static class InnerClass{
        private static final SaftSingleton singleton = new SaftSingleton();
    }

    public static SaftSingleton getInstance(){
        return InnerClass.singleton;
    }


    //双重检查
//    // 静态可见的实例
//    private static volatile SaftSingleton instance = null;
//    // 无参构造器
//    private SaftSingleton(){}
//
//    public SaftSingleton getInstance() {
//        if (instance == null) {
//            synchronized (SaftSingleton.class) {
//                if (instance == null) {
//                    instance = new SaftSingleton();
//                }
//            }
//        }
//        return instance;
//    }
}
