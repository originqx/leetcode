package org.example.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        List<String> letterCombinations = solution6.letterCombinations("23");
        for (String letterCombination : letterCombinations) {
            System.out.println(letterCombination);
        }
    }
}

class Solution6 {
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        //新建MAP映射
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r','s'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});

        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        ans = new ArrayList<>();

        backTrack(0, digits, new StringBuffer(),map);
        return ans;
    }

    private void backTrack(int curr, String digits, StringBuffer list,Map<Character, Character[]> map) {
        if (curr == digits.length()) {
            ans.add(list.toString());
            return;
        }

        char digit = digits.charAt(curr);
        Character[] values = map.get(digit);
        for (Character value : values) {
            list.append(value);
            backTrack(curr + 1, digits, list, map);
            list.deleteCharAt(curr);
        }
    }
}