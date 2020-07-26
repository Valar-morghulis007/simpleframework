package demo.generic;

import lombok.Data;

@Data
public class GenericClassExample<T> {

    //member这个成员变量的类型为T，T的类型由外部指定
    private T member;

    public GenericClassExample(T member){
        this.member=member;
    }

    public T handleSomething(T target){
        return target;
    }
}
