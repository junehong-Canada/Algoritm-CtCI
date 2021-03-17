class Solution {

  public static boolean isSubstring(String big, String small){
      if( big.indexOf(small) >= 0 )
        return true;
      else
        return false;
  }

  // 1.9 String Rotation
  public static boolean isRotation(String s1, String s2) {
      int len = s1.length();
      if(len == s2.length() && len > 0){
        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
      }
      return false;
  }
}

public class ArrayString {
  public static void main(String[] args) {

    // 1.9 String Rotation
    System.out.println(Solution.isRotation("apple", "pleap"));
    System.out.println(Solution.isRotation("waterbottle", "erbottlewat"));
    System.out.println(Solution.isRotation("camera", "macera"));
  }
}
