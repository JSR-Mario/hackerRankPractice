package hackerRank.sorting.sortingBubbleSort;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * gfunction accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
        if(a==null || a.size()==0){
            System.out.printf("Array is sorted in %d swaps.%nFirst Element: %nLast Element: ", 0);
        }

        int swaps = 0;
        int n = a.size();

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n-1 ; j++){
                if(a.get(j)>a.get(j+1)){
                    swap(a, j, j+1);
                    swaps++;
                }
            }
        }
        
            System.out.printf("Array is sorted in %d swaps.%nFirst Element: %d%nLast Element: %d", swaps,a.get(0),a.get(n-1));        
    }

    public static void swap(List<Integer> a, int i, int j){
        int temp = a.get(i);

        a.set(i,a.get(j));
        a.set(j,temp);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}
