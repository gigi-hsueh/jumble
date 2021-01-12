
import edu.princeton.cs.algs4.*;

public class SpellCheck{
    public static String[] words = In.readStrings("/usr/share/dict/words");
    private static String[] testWords = {"bear", "abandonment", "happy", "zebra"};

    public static boolean check(String query){
        //return lcheck(query);
        return bcheck(query, 0 , 235885);
     }
         
    // linear search
    public static boolean lcheck(String query){
        boolean correct = false;
        for (int i=0; i<235886; i++){
            if (words[i].equals(query)){
                return correct = true; 
            }
        }
        return correct;
    }


    // binary search
    public static boolean bcheck(String query, int low, int hi){
        while (low <= hi){
            int mid = low + ((hi-low)/2);
            if (words[mid].compareToIgnoreCase(query) > 0) hi = mid -1;
            else if (words[mid].compareToIgnoreCase(query) < 0) low = mid+1;
            else  return true;
        }
        return false;
    }    

    public static void main(String[] args){
        for (String word: testWords){
            if (check(word)){
                StdOut.println("found " + word);
            }
            else{
                StdOut.println(word + " not found");
            }
        }
    }
}