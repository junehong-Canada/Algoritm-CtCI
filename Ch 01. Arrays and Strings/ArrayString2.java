class ArrayString2 {

  public static String sort(String s){
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
  }

  public static boolean permutationA(String s, String t){
    return sort(s).equals(sort(t));
  }

  public static boolean permutationB(String s, String t){
    if(s.length() != t.length()) return false;

    int[] letters = new int[128]; // Assumption ASCII
    for(int i=0; i<s.length(); i++){
      letters[s.charAt(i)]++;
    }

    for(int i=0; i<t.length(); i++){
      letters[t.charAt(i)]--;
      if(letters[t.charAt(i)] < 0){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args){
    String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
    for(String[] pair : pairs){
      String word1 = pair[0];
      String word2 = pair[1];
      boolean is_permutation = permutationA(word1, word2);
      System.out.println(word1 + ", " + word2 + ": " + is_permutation);
    }
    System.out.println("=======================================");
    for(String[] pair : pairs){
      String word1 = pair[0];
      String word2 = pair[1];
      boolean is_permutation = permutationB(word1, word2);
      System.out.println(word1 + ", " + word2 + ": " + is_permutation);
    }
  }
}
