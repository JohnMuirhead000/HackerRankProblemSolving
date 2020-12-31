import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Arrays{



    //This function takes in an array, reverses it, and prints those elements
    //"Arrays-DS" - EASY
    static int[] reverseArray(int[] a) {

        int[] finalP = new int[a.length];

        for (int i = 0; i < a.length; i++){
            finalP[i] = a[a.length-1-i];
        }
        return finalP;
    }



    //This function calculates the max 'hourglass' in a 2D array
    //"2D Arrays-DS" - EASY
    static int hourglassSum(int[][] arr) {

        int currentMax = grabGlass(arr, 1, 1);

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if(grabGlass(arr, i, j) > currentMax){
                    currentMax = grabGlass(arr, i, j);
                }
            }
        }
        return currentMax;
    }
    static private int grabGlass(int[][] arr, int i, int j) {

        int total = arr[i][j] + arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i+1][j-1]+ arr[i+1][j] + arr[i+1][j+1];
        return total;
    }





    //Exeremly poorly worded and contrived question about who knows what - got this solution from online
    //"Dynamic Array" - EASY
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<>();
        Integer lastAnswer = 0;

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++){
            seqList.add(new ArrayList<Integer>());
        }

        for (List<Integer> query : queries){

            int index = (query.get(1) ^ lastAnswer) % seqList.size();
            int y = query.get(2);

            switch(query.get(0)){
                case 1:
                    seqList.get(index).add(y);
                    break;
                case 2:
                    lastAnswer = seqList.get(index).get(y % seqList.get(index).size());
                    answer.add(lastAnswer);
                    break;
            }
        }
        return answer;
    }


    //Gives an array and an int; shifts every elements over the the left as many places as int.
    //"Left Rotation" - EASY
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {

        List<Integer> result = new LinkedList<Integer>();

        for (int i = d; i < arr.size() + d; i++) {

            if (i < arr.size()){
                result.add(arr.get(i));
            } else {
                result.add(arr.get(i-arr.size()));
            }
        }
        return result;
    }

    //Gives 2 arrays, calculated how many occurrences of element from bottom array(queries) are in top array(strings).  Does this
    //for each element in the bottom array. Returns an array of int representing it.
    //"Sparse Arrays" - MEDIUM
    static int[] matchingStrings(String[] strings, String[] queries) {

        int[] sol = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int counter = 0;
            for (int j = 0; j < strings.length; j++) {

                if (strings[j].equals(queries[i])){

                    counter ++;

                }
            }
            sol[i] = counter;
        }
        return sol;
    }

    //Hard to describe.  Takes length, N, and a bunch of 3 length arrays (the queries).  Runs a calculation in which
    //for each query, from index 0 to 1 on arrays length N, you add index 2 value.  After all queries, returns max.
    //"Array Manipulation" - HARD
    static long arrayManipulation(int n, int[][] queries) {
        long[] computation = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1] - 1;
            int k = queries[i][2];

            computation[a] += k;
            if (b + 1 < n ) {
                computation[b + 1] -= k;
            }
        }

        long max = 0; long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += computation[i];
            max = Math.max(max, sum);
        }

        return max;
    }
    //Definitely a very hard problem.  I was able to do it with a double for loop.  The issue was, however, it took
    //too much time to run. When n got big, runtime error was inevitable.  This solution managed to use only 1 for loop.
    //It loops through each query and properly manipulates an array of length N.  It adds k to the start index, and
    //add -k to the end index.  Then, a function can be performed wherein each element in N = itself plus the previous.
    //Sounds bizarre but completely works.  Would not have been able to think of it on my own.  I think this one takes
    //a  maturity of coding problem solving to see.



















}

