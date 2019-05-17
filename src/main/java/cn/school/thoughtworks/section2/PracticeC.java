package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String, Long> collection = collection1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String,Integer> map = new HashMap<>();
        collection.entrySet().forEach(entry->{
            String key = entry.getKey();
            if(key.contains("-")){
                String[] splitString = key.split("-");
                String newKey = splitString[0];
                Integer num = Integer.parseInt(splitString[1]);
                if(map.containsKey(newKey)){
                    map.put(newKey,map.get(newKey)+num);
                }else{
                    map.put(newKey,num);
                }
            }else if(key.contains(":")){
                String[] splitString = key.split(":");
                String newKey = splitString[0];
                Integer num = Integer.parseInt(splitString[1]);
                if(map.containsKey(newKey)){
                    map.put(newKey,map.get(newKey)+num);
                }else{
                    map.put(newKey,num);
                }
            }else if(key.contains("[")){
                int begin = key.indexOf("[");
                int end = key.indexOf("]");
                int num = Integer.parseInt(key.substring(begin+1, end));
                String newKey = key.substring(0,begin);
                if(map.containsKey(newKey)){
                    map.put(newKey,map.get(newKey)+num);
                }else{
                    map.put(newKey,num);
                }
            }else{
                map.put(key,Integer.parseInt(String.valueOf(entry.getValue())));
            }
        });
        return map;
    }
}
