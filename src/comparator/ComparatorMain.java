package comparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparatorMain {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Janusz");
        list.add("Grażyna");
        list.add("Sebastian");
        list.add("Karyna");

        System.out.println("Before sorting: " + list);

        Collections.sort(list);

        System.out.println("After JAVA sorting: " + list);

        Collections.sort(list, new SignAmountComparator());
        System.out.println("After my sorting: " + list);
    }
}
