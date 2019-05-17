package cn.school.thoughtworks.section3;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeD {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Long> temp = collectionA.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        HashMap<String,Integer> collection3 = new HashMap<>();
        //解析-
        temp.entrySet().forEach(entry->{
            String key = entry.getKey();
            if(key.contains("-")){
                int splitIndex = key.indexOf("-");
                String newKey = key.substring(0,splitIndex);
                Integer num = Integer.parseInt(key.substring(splitIndex+1));
                if(collection3.containsKey(newKey)){
                    collection3.put(newKey,collection3.get(newKey)+num);
                }else{
                    collection3.put(newKey,num);
                }
            }else{
                collection3.put(key,Integer.parseInt(entry.getValue().toString()));
            }
        });
        //获取所有的value
        List<String> collection2 = object.entrySet().stream().map(Map.Entry::getValue)
                .flatMap(Collection::stream).collect(Collectors.toList());
        //逢三减一
        collection3.entrySet().forEach(entry->{
            String key = entry.getKey();
            if (collection2.contains(key)){
                entry.setValue(entry.getValue()-entry.getValue()/3);
            }
        });
        return collection3;
    }
}
