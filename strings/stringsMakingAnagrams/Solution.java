package hackerRank.strings.stringsMakingAnagrams;

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
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        if((a==null && b==null) || (a.length()==0 && b.length()==0)){
            return 0;
        }

        HashMap<Character,Integer> lettersOfA= new HashMap<>();
        int numOfDelitions = 0;

        for(int i=0 ; i<a.length() ; i++){
            if(lettersOfA.containsKey(a.charAt(i))){
                lettersOfA.replace(a.charAt(i), lettersOfA.get(a.charAt(i))+1);
            }else{
                lettersOfA.put(a.charAt(i), 1);
            }
        }

        for(char letter : b.toCharArray()){
            if(lettersOfA.containsKey(letter)){
                if(lettersOfA.get(letter)==1){
                    lettersOfA.remove(letter);
                }else{
                    lettersOfA.replace(letter, lettersOfA.get(letter)-1);
                }
            }else{
                numOfDelitions++;
            }
        }

        for(HashMap.Entry<Character, Integer> entry : lettersOfA.entrySet() ){
            numOfDelitions+=entry.getValue();
        }

        return numOfDelitions;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
