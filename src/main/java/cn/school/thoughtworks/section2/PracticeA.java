package cn.school.thoughtworks.section2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String, Long> collection = collection1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return collection.entrySet().stream().
                collect(Collectors.toMap(Map.Entry::getKey,entry->Integer.parseInt(String.valueOf(entry.getValue()))));
    }
}
