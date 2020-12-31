import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String args[]){




       int[] numbers = {2, 2, 1, 5, 7, 5, 3, 2, 3};

       List<Integer> numberss = new ArrayList<>();

       for (int i = 0; i < numbers.length; i++){

           if (numberss.get(numbers[i]) == null){
               numberss.add(numbers[i]);
           }
       }




    }
}
