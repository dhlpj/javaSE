package cn.school.thoughtworks.section1;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeB {
    List<String> collectSameElements(List<String> collection1, List<List<String>> collection2) {
        //实现练习要求，并改写该行代码。
        List<String> collection2New = collection2.stream().flatMap(Collection::stream).collect(Collectors.toList());//抽取底层元素
        return collection1.stream().filter(collection2New::contains).collect(Collectors.toList());
    }
}
