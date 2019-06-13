import java.util.Hashtable;
import java.util.Scanner;

public class IsUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (!s.isEmpty()) {
            System.out.println(isUniqueCharWithBooleanArray(s) + " :with boolean use");
            System.out.println(checkStringForUniqueWithHashMap(s) + " :hashTable");
            System.out.println(checkStringForUnique(s) + " :brute-force solution");
        }
    }
    private static boolean checkStringForUniqueWithHashMap(String s) {
        Hashtable<Integer, Character> uniqCharacters = new Hashtable();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (!uniqCharacters.contains(s.charAt(i))) {
                uniqCharacters.put(i, s.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    //brute-force
    private static boolean checkStringForUnique(String s) {
        int []charNumbers = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == 0 && j == 0) {
                    charNumbers[i] = s.charAt(i);
                    break;
                } else {
                    if (charNumbers[j] != s.charAt(i)) {
                        charNumbers[i] = s.charAt(i);
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isUniqueCharWithBooleanArray(String s) {
        if (s.length() > 128) {
            return false;
        }
        boolean chars[] = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int charNum = s.charAt(i);
            if (chars[charNum]) {
                return false;
            }
            chars[charNum] = true;
        }
        return true;
    }
}
