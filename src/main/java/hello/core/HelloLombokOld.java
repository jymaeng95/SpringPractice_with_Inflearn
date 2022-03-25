package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombokOld {
    private String name;
    private int age;

    public static void main(String[] args) {
       HelloLombokOld helloLombok = new HelloLombokOld();
       helloLombok.setName("Test");

       String name = helloLombok.getName();
       System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);
    }

}
