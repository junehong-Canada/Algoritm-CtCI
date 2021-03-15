class Solution {
  ///////////////////////////////////////////
  // 1.1 Is Unique
  public static boolean isUnique(String s) {
    if(s.length() > 128) return false;

    boolean[] char_set = new boolean[128];
    for(int i=0; i<s.length(); i++) {
      int val = s.charAt(i);
      if(char_set[val]){
        return false;
      }
      char_set[val] = true;
    }
    return true;
  }

  // Assumption: The string uses the lowercase letters a through z. => reduce space
  public static boolean isUnique1(String s) {
    int checker = 0;
    for(int i=0; i<s.length(); i++) {
      int val = s.charAt(i) - 'a';
      if((checker & (1 << val)) > 0){
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }

  // O(n^2) time, O(1) space
  public static boolean isUnique2(String s) {
    if(s.length() > 128) return false;

    for(int i=0; i<s.length(); i++) {
      for(int j=0; j<i; j++){
        if(s.charAt(j)==s.charAt(i)) return false;
      }
    }
    return true;
  }

  // O(n log(n)) time
  public static boolean isUnique3(String s) {
    // sort
    char charArray[] = s.toCharArray();
    java.util.Arrays.sort(charArray);

    for(int i=0; i<charArray.length-1; i++) {
      if(charArray[i]==charArray[i+1]) return false;
    }
    return true;
  }

  ///////////////////////////////////////////
  // 1.2 Check Permutation
  static String sort(String s){
      char[] content = s.toCharArray();
      java.util.Arrays.sort(content);
      return new String(content);
  }

  static boolean permutation(String s, String t){
    if(s.length()!=t.length()){
      return false;
    }
    return sort(s).equals(sort(t));
  }

  static boolean permutation2(String s, String t){
    if(s.length()!=t.length()) return false;  // Permutation must be same length

    int[] letters = new int[128]; // Assumption: ASCII
    for(int i=0; i<s.length(); i++){
      letters[s.charAt(i)]++;
    }

    for(int i=0; i<t.length(); i++){
      letters[t.charAt(i)]--;
      if(letters[t.charAt(i)]<0){
        return false;
      }
    }
    return true;  // letters has no no neg values, and therefore no pos values either.
  }

  ///////////////////////////////////////////
  // 1.3 URLify
  static void replaceSpace(char[] str, int trueLength){
    int spaceCount = 0, index, i = 0;
    for(i=0; i<trueLength; i++){
      if(str[i] == ' '){
        spaceCount++;
      }
    }
    index = trueLength + spaceCount * 2;
    if(trueLength < str.length) str[trueLength] = '\0'; // End array
    for(i=trueLength-1; i>=0; i--){
      if(str[i] == ' '){
        str[index-1] = '0';
        str[index-2] = '2';
        str[index-3] = '%';
        index = index - 3;
      } else {
        str[index-1] = str[i];
        index--;
      }
    }
  }


}

public class ArrayString {

  Solution solution;

  public void start() {
    // 1.1 Is Unique
    // String str = "abcdef";
    // System.out.println("Result=> " + solution.isUnique(str));
    // System.out.println("Result=> " + solution.isUnique1(str));
    // System.out.println("Result=> " + solution.isUnique2(str));
    // System.out.println("Result=> " + solution.isUnique3(str));

    // 1.2 Check Permutation
    // String str1 = "god";
    // String str2 = "dog";
    // System.out.println("Result=> " + solution.permutation(str1, str2));
    // System.out.println("Result=> " + solution.permutation2(str1, str2));

    // 1.3 URLify
    String str_in = "Mr John Smith    ";
    char[] chars = str_in.toCharArray();
    solution.replaceSpace(chars, 13);
    String str_out = new String(chars);
    System.out.println("Result=> " + str_out);
  }

  public static void main(String[] args) {
    ArrayString arrayString = new ArrayString();
    arrayString.start();
  }

}
