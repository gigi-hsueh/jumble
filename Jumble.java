
import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class Jumble{
	private static String[] words; 

	private static void perms(String p, String w){
		int n = w.length();
		if (n == 0 && SpellCheck.check(p)) StdOut.println(p);
		else {
			for (int i = 0; i < n; i++){
				perms(p + w.charAt(i), w.substring(0,i) + w.substring(i+1,n));
			}
		}
	}

	public static void perms( String s ){
		perms("", s);
		//perms2(s);
	}

	private static void perms2(String g){
		char[] cha = g.toCharArray();
		Arrays.sort(cha);
		for (int i=0; i<99171; i++){
			char[] dic = words[i].toCharArray();
			Arrays.sort(dic);
			if (Arrays.equals(cha, dic)){
				StdOut.println(words[i]);
			}
		}
	}

	public static void main(String[] args){
		String[] testwords= {"granama", "nelir", "gurpe", "notair", "bahcle", "cat"};
		words = SpellCheck.words;
		for (String word: testwords){
			StdOut.println(word);
			perms(word);
		}

	}
}