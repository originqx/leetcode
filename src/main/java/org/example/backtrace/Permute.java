package org.example.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        solution.permute(nums).forEach(list -> list.forEach(System.out::print));
    }
}


class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backTrace(nums, new LinkedList<>());
        return res;
    }

    private void backTrace(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.push(num);
            backTrace(nums, list);
            list.pop();
        }
    }
}