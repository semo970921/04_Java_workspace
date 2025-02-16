package map.run;

import map.service.MapService;

public class MapRun {
    public static void main(String[] args) {

        // 자바 상식
        // 원래는 이렇게 쓰는건데 너무 기니 import로!
        //map.service.MapService service = new map.service.MapService();
        MapService service = new MapService();

       // service.test1();
        service.test2();

    }
}
