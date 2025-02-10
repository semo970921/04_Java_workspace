package set.service;

import java.util.HashSet;
import java.util.Set;

public class SetService {

    public void test1(){

        Set<String> set = new HashSet<String>();

        set.add("네이버");
        set.add("카카오");
        set.add("라인");
        set.add("쿠팡");
        set.add("배달의 민족");
        set.add("토스");
        set.add("당근마켓");
        set.add("직방");
        set.add("야놀자");
        System.out.println(set/*.toString()*/);

        set.add("배달의민족");
        set.add("배달의민족");
        System.out.println(set);

        set.add(null);
        set.add(null);
        set.add(null);
        System.out.println("null 중복X : " + set);

        System.out.println("set.size() : " + set.size());

        System.out.println("쿠팡 제거됨? : " + set.remove("쿠팡"));
        System.out.println("삼성 제거됨? : " + set.remove("삼성"));
        System.out.println(set);

        System.out.println("네이버 있음? : " + set.contains("네이버"));
        System.out.println("LG 있음? : " + set.contains("LG"));

        System.out.println("clear() 전 isEmpty() : " + set.isEmpty());
        set.clear();
        System.out.println("clear() 후 isEmpty() : " + set.isEmpty());

        System.out.println("set : " + set);
    }
}
