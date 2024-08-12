import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Sorting {

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(7);
        list.add(1);
        list.add(2);

        //ascending order
        Collections.sort(list);
        System.out.println(list);

        //descending order using collection
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }
}