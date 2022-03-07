import java.util.*;

public class AshtonAndString {
  public static char ashtonString(String s, int k) {
    ArrayList<String> arr = new ArrayList<>();

    // find all substrings of s
    for(int i = 0; i < s.length(); i++) {
      for(int j = i+1; j <= s.length(); j++) {
        arr.add(s.substring(i, j));
      }
    }
    
    // lexicographicaly sort the array of substrings
    Collections.sort(arr);
    // combine the sorted substrings together
    StringBuilder concatString = new StringBuilder();
    for(String str : arr) {
      concatString.append(str);
    }

    // return k-1 element because k is 1-indexed
    return concatString.charAt(k-1);
  }
  public static void main(String[] args) {
    System.out.println(ashtonString("abcd", 5)); // aababcabcdbbcbcdccdd
    System.out.println(ashtonString("dbac", 3)); // aacbbabaccddbdbadbac
    System.out.println(ashtonString("dbac", 20));
    System.out.println(ashtonString("aaa", 5)); // aaaaaaaaaa
    System.out.println(ashtonString("abcdefg", 20)); //aababcabcdabcdeabcdefabcdefgbbcbcdbcdebcdefbcdefgccdcdecdefcdefgddedefdefgeefefgffgg
  }
}
