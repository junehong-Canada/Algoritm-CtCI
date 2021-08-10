
class ArrayString1 {
  public static boolean isUniqueCharsA(String str) {
    if(str.length() > 128) {
      return false;
    }
    boolean[] char_set = new boolean[128];
    for(int i=0; i<str.length(); i++) {
      int val = str.charAt(i);
      if(char_set[val]) return false;
      char_set[val] = true;
    }
    return true;
  }
  public static boolean isUniqueCharsB(String str) {
    if(str.length() > 26) { // Assumes only letters a through z.
      return false;
    }
    int checker = 0;
    for(int i=0; i<str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if((checker & (1 << val)) > 0) return false;
      checker |= (1 << val);
    }
    return true;
  }

  public static void main(String[] args) {
    String[] words = {"abcde", "hello", "apple", "kite", "padle"};
    // for(String word : words) {
    //     System.out.println(word + ": " + isUniqueCharsA(word));
    // }
    // for(String word : words) {
    //     System.out.println(word + ": " + isUniqueCharsB(word));
    // }
    for (String word : words) {
			boolean wordA =  isUniqueCharsA(word);
			boolean wordB =  isUniqueCharsB(word);
			if (wordA == wordB) {
				System.out.println(word + ": " + wordA);
			} else {
				System.out.println(word + ": " + wordA + " vs " + wordB);
			}
		}
  }
}
