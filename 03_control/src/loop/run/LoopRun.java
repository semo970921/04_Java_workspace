package loop.run;

import loop_service.LoopService1;
import loop_service.LoopService2;

/**
 * @author 정승원
 */

public class LoopRun {

    public static void main(String[] args) {

        // LoopService1 객체 생성
        // LoopService1 service1 = new LoopService1();
        // service1.displayMenu();

        LoopService2 service2  = new LoopService2();
        service2.displayMenu();
    }
}
