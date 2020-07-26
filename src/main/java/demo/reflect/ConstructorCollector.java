package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("demo.reflect.ReflectTarget");

        //1.获取所有的构造方法
        System.out.println("*******************所有共有构造方法***************************");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor constructor : conArray) {
            System.out.println(constructor);
        }

        //2.获取所有构造方法
        System.out.println("*******************所有所有构造方法(包括私有，受保护，默认，共有)***************************");
        conArray = clazz.getDeclaredConstructors();
        for (Constructor constructor : conArray) {
            System.out.println(constructor);
        }

        //3.获取单个带参数的共有方法
        System.out.println("*******************获取共有、有两个参数的构造方法***************************");
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        System.out.println("constructor=" + constructor);

        //获取单个私有的构造方法
        System.out.println("*******************所有私有的构造方法***************************");
        constructor = clazz.getDeclaredConstructor(int.class);
        System.out.println("private constructor= " + constructor);

        System.out.println("*******************调用私有构造方法创建实例***************************");
        //暴力访问，忽略掉访问修饰符
        constructor.setAccessible(true);
        ReflectTarget reflectTarget = (ReflectTarget) constructor.newInstance(1);
    }
}
