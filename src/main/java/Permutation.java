import java.util.HashMap;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(isPermutation("asd", "dsa"));
        System.out.println(isApermutationOfB("abc", "cab"));
    }
    static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] characters = new int[128];
        for (int i = 0; i < a.length(); i++) {
            characters[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            characters[b.charAt(i)] --;
            if (characters[b.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
    static boolean isApermutationOfB(String a, String b){
        HashMap<Character, Integer> temp = new HashMap();
        if (a.length() == b.length()) {
            for (int i = 0; i < b.length(); i++) {
                temp.put(b.charAt(i),i);
            }
            for (int i = 0; i < a.length(); i++) {
                if (!temp.containsKey(a.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
