package map.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapService {

    public void test1(){
        Map<String, String> map = new HashMap<String, String>();

        System.out.println(map.put("아침", "달걀 후라이"));
        System.out.println(map.put("점심", "제육볶음"));
        System.out.println(map.put("저녁", "삼겹살"));
        System.out.println(map.put("저녁", "라면"));
        System.out.println(map);

        System.out.println("------------------------------");

        System.out.println("아침 : " + map.get("아침"));
        System.out.println("점심 : " + map.get("점심"));
        System.out.println("저녁 : " + map.get("저녁"));
        System.out.println("야식 : " + map.get("야식"));

        System.out.println("------------------------------");

        System.out.println("저장된 데이터 수: " + map.size());

        System.out.println("------------------------------");

        System.out.println(map.remove("아침") + " 제거");
        System.out.println(map.remove("야식") + "  제거");
        System.out.println(map);

        System.out.println("------------------------------");

        map.clear();
        if(map.isEmpty()) {
            System.out.println("모두 삭제됨");
            System.out.println(map);
        }

    }

    public void test2(){
        Map<String, Object> student = new HashMap<String, Object>();

        student.put("name", "홍길동");
        student.put("grader", 3);
        student.put("gender", '남');
        student.put("avg", 80.4);


        student.put("avg", 90.4);

        double score = (Double)student.get("avg");

        Set<String> keys = student.keySet();

        Iterator<String> it = keys.iterator();

        while(it.hasNext()) {
            String k = it.next();
            System.out.printf("Key : %s, Value : %s\n",
                    k,student.get(k));
        }

        System.out.println("------------------------------");

        Set<Map.Entry<String, Object>> set  = student.entrySet();

        for(Map.Entry<String, Object> entry : set) {
            System.out.printf("%s : %s\n",
                    entry.getKey(), entry.getValue());
        }
    }



}
