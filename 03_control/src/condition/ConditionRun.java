package condition;

import service.ConditionService;

public class ConditionRun {

    // main method
    public static void main(String[] args){

        // ConditionService 객체 생성
        ConditionService service  =  new  ConditionService();

        // service.method1();
        // service.method2();
        // service.method3();
        service.displayMenu();
    }
}
