import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(result, map, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, Map<Character, String> map, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, map, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        String digits = "23";
        List<String> combinations = letterCombinations.letterCombinations(digits);
        System.out.println(combinations);
    }
}
