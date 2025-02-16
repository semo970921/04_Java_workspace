package section02;

import java.io.IOException;

public class ThrowsTest {

    public void method1() throws IOException{
        method2();
    }
    public void method2() throws IOException{
        method3();
    }
    public void method3() throws IOException{
        throw new RuntimeException();
      //  throw new IOException();
    }

    // ================================

    public void test1() throws IOException{
        throw new IOException();
    }

    public void test2(){
        int num = 3/0;
    }


}
