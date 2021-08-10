class ArrayString5 {
  public static boolean isOneWay(String s, String t) {

  }
  public static void main(String[] args) {
    String[][] pairs = {{"pale", "ple"},
                        {"pales", "pale"},
                        {"pale", "bale"},
                        {"pale", "bake"}};
    for(String[] pair : pairs) {
        System.out.println(pair[0] + ", " + pair[1]);
    }
  }
}
