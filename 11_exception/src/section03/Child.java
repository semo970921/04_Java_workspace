package section03;

import java.io.EOFException;
import java.io.IOException;

public class Child extends Parent{

    @Override
    // public void method1() throws IOException{}
    public void method1() throws EOFException {}

    // @Override
    // public void method2() throws Exception{}

    @Override
    public void method3(){
        System.out.println("예외 발생할 코드가 없다.");
    }
}
