package comparator;

import java.util.Comparator;

public class SignAmountComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int lengthOne = o1.toCharArray().length;
        int lengthTwo = o2.toCharArray().length;

        if (lengthOne > lengthTwo) {
            return -1;
        } else if (lengthOne == lengthTwo) {
            return o2.compareTo(o1);
        } else {
            return 1;
        }
    }
}
