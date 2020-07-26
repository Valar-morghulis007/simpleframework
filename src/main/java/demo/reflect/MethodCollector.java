package demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.获取Class对象
        Class reflectTargetClass = Class.forName("demo.reflect.ReflectTarget");
        //2.获取所有共有方法
        System.out.println("************************获取所有public方法，包括父类和Object***************************");
        Method[] methodArray = reflectTargetClass.getMethods();
        for (Method method : methodArray) {
            System.out.println(method);
        }

        //3.获取该类的所有方法
        System.out.println("************************获取所有的方法，包括私有的***************************");
        methodArray=reflectTargetClass.getDeclaredMethods();
        for (Method method : methodArray) {
            System.out.println(method);
        }

        //4.获取单个共有方法
        System.out.println("************************获取单个共有方法***************************");
        Method method = reflectTargetClass.getMethod("show1", String.class);
        System.out.println(method);
        //5.调用show1并执行
        ReflectTarget reflectTarget= (ReflectTarget) reflectTargetClass.getConstructor().newInstance();
        method.invoke(reflectTarget,"待反射方法一号");
        //6.获取一个私有的成员方法
        System.out.println("************************获取私有的show4()方法***************************");
        method=reflectTargetClass.getDeclaredMethod("show4",int.class);
        System.out.println(method);
        method.setAccessible(true);
        String result= (String) method.invoke(reflectTarget,20);
        System.out.println("返回值："+result);

    }
}
