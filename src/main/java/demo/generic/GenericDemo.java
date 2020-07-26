package demo.generic;

import java.util.LinkedList;
import java.util.List;

public class GenericDemo {

    public static void main(String[] args) {
        GenericClassExample<String> stringExample=new
                GenericClassExample<>("abc");

        GenericClassExample<Integer> integerExample=new
                GenericClassExample<>(123);

        System.out.println(stringExample.getMember().getClass());
        System.out.println(integerExample.getMember().getClass());
    }
}
