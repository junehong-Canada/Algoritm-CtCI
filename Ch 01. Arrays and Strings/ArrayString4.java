class ArrayString4 {
  public static int getCharNumber(Character c){
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');

    int val = Character.getNumericValue(c);
    if(a <= val && val <= z){
      return val - a;
    }
    return -1;
  }

  public static int[] buildCharFrequencyTable(String phrase){
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for(char c : phrase.toCharArray()){
      int x = getCharNumber(c);
      if(x != -1){
        table[x]++;
      }
    }
    return table;
  }

  public static boolean checkMaxOneOdd(int[] table){
    boolean foundOdd = false;
    for(int count : table){
      if(count % 2 == 1){
        if(foundOdd){
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  public static boolean isPermutationOfPalindromeA(String phrase){
    int[] table = buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(table);
  }
  // --------------------------------------------------------------

  public static boolean isPermutationOfPalindromeB(String phrase){
    int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;

				if (table[x] % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
  }

  /* Toggle the ith bit in the integer. */
	public static int toggle(int bitVector, int index) {
		if (index < 0) return bitVector;

		int mask = 1 << index;
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
	}

	/* Create bit vector for string. For each letter with value i,
	 * toggle the ith bit. */
	public static int createBitVector(String phrase) {
		int bitVector = 0;
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}

	/* Check that at most one bit is set by subtracting one from the
	 * integer and ANDing it with the original integer. */
	public static boolean checkAtMostOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}

	public static boolean isPermutationOfPalindromeC(String phrase) {
		int bitVector = createBitVector(phrase);
		return checkAtMostOneBitSet(bitVector);
	}

  public static void main(String[] args){
    // String pali = "Rats live on no evil star";
		// System.out.println(isPermutationOfPalindromeA(pali));
    //
    // String pali1 = "Ratzs live on no evil starz";
    // System.out.println(isPermutationOfPalindromeB(pali1));
    // String pali2 = "Zeus was deified, saw Suez";
    // System.out.println(isPermutationOfPalindromeB(pali2));
    //
    // System.out.println(isPermutationOfPalindromeC(pali));
    String[] strings = {"Rats live on no evil star",
              "A man, a plan, a canal, panama",
              "Lleve",
              "Tacotac",
              "asda"};
    for (String s : strings) {
      boolean a = isPermutationOfPalindromeA(s);
      boolean b = isPermutationOfPalindromeB(s);
      boolean c = isPermutationOfPalindromeC(s);
      System.out.println(s);
      if (a == b && b == c) {
        System.out.println("Agree: " + a);
      } else {
        System.out.println("Disagree: " + a + ", " + b + ", " + c);
      }
      System.out.println();
    }
  }
}
