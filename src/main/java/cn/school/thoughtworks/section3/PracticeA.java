package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeA {
    Map<String,Integer> createUpdatedCollection(Map<String,Integer> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        List<String> value = object.get("value");
        collectionA.entrySet().forEach(entry->{
            String key = entry.getKey();
            if(value.contains(key)){
              entry.setValue(entry.getValue()-1);
            }
        });
        return collectionA;
    }
}
