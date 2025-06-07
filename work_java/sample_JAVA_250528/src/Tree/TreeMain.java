package Tree;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMain {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(23);
        ts.add(10);
        ts.add(48);
        ts.add(15);
        ts.add(7);
        ts.add(22);
        ts.add(56);
        for(int e : ts) System.out.println(e+" ");

        Iterator<Integer> iter = ts.iterator();
        while(iter.hasNext()) System.out.println(iter.next()+" ");
        //10이상 20미만의 요소들만 포함하는 부분집합
        System.out.println(ts.subSet(10,20));

        TreeMap<Integer, String> scoreMap = new TreeMap<>();
        scoreMap.put(165,"바쿠고");
        scoreMap.put(205,"엔데버");
        scoreMap.put(201,"올마이트");

//        for(Map.Entry)

    }
}
