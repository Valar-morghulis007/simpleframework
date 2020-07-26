package demo.reflect;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class reflectTargetClass = Class.forName("demo.reflect.ReflectTarget");

        //1.获取所有共有的字段
        System.out.println("************************获取所有公有的字段***************************");
        Field[] fieldArray = reflectTargetClass.getFields();
        for (Field field : fieldArray) {
            System.out.println(field);
        }

        //2.获取所有的字段
        System.out.println("************************获取所有的字段(包括私有、受保护、默认)***************************");
        fieldArray=reflectTargetClass.getDeclaredFields();
        for (Field field : fieldArray) {
            System.out.println(field);
        }

        //3.获取单个特定共有的filed
        System.out.println("************************获取所有公有的字段并调用***************************");
        Field field=reflectTargetClass.getField("name");
        System.out.println("公有的field name:"+field);

        ReflectTarget reflectTarget = (ReflectTarget) reflectTargetClass.getConstructor()
                .newInstance();
        //4.给获取到的field赋值
        field.set(reflectTarget,"待反射一号");
        //5.验证对应的name
        System.out.println("验证name:"+reflectTarget.name);

        //6.获取单个私有的Field
        System.out.println("************************获取私有字段targetInfo并调用***************************");
        field=reflectTargetClass.getDeclaredField("targetInfo");
        System.out.println(field);
        field.setAccessible(true);
        field.set(reflectTarget,"13113955234");
        System.out.println("验证信息"+reflectTarget);
    }
}
