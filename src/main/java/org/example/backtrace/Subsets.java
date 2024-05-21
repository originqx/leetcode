package org.example.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            subset.forEach(System.out::print);
            System.out.println();
        }
    }
}

class Solution3 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            list.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    list.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}

class Solution2 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        backTrack(0, nums, new LinkedList<>());
        return res;
    }

    private void backTrack(int curr, int[] nums, LinkedList<Integer> list) {

        if (curr == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.push(nums[curr]);
        backTrack(curr + 1, nums, list);
        list.pop();
        backTrack(curr + 1, nums, list);
    }
}