package hackerRank.warmUp.ReapetedString;

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
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        if(s == null || s.isEmpty() ||  n <= 0){
            return 0;
        }

        long numOfA = 0;
        int size = s.length();
        int aInS = 0;

        for(int i=0; i<size; i++){
            if(s.charAt(i)=='a'){
                aInS +=1;
            }
        }

        long times =  n/size;
        numOfA += aInS*times ;
        n -= times * size;

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='a'){
                numOfA+=1;
            }
        }

        return numOfA;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
