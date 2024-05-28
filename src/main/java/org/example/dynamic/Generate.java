package org.example.dynamic;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        List<List<Integer>> generate = solution5.generate(5);
        for (List<Integer> list : generate) {
            System.out.println(list);
        }
    }
}

class Solution5 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }else {
                    list.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
