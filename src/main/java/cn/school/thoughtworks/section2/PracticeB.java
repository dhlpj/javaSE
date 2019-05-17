package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeB {
    Map<String, Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String, Long> collection = collection1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String,Integer> map = new HashMap<>();
        collection.entrySet().forEach(entry->{
            String key = entry.getKey();
            if(key.length()==3){
                String[] splitString = key.split("-");
                map.put(splitString[0],Integer.parseInt(String.valueOf(splitString[1])));
            }else {
                map.put(key,Integer.parseInt(String.valueOf(entry.getValue())));
            }
        });
        return map;
    }
}
