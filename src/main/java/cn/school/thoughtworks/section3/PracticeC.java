package cn.school.thoughtworks.section3;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeC {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        //统计
        Map<String, Long> temp = collectionA.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //转化为integer
        Map<String, Integer> collection3 = temp.entrySet().stream().
                collect(Collectors.toMap(Map.Entry::getKey, entry -> Integer.parseInt(String.valueOf(entry.getValue()))));
        //获取所有的value
        List<String> list = object.entrySet().stream().map(Map.Entry::getValue)
                .flatMap(Collection::stream).collect(Collectors.toList());
        collection3.entrySet().forEach(entry->{
            String key = entry.getKey();
            if(list.contains(key)){
                entry.setValue(entry.getValue()-entry.getValue()/3);
            }
        });
        return collection3;
    }
}
