package org.example.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        new Solution4().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}

class Solution4 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 暴力解法 三层For循环 注意去重
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.sort(Integer::compareTo);
                        if (!res.contains(list)) {
                            res.add(list);
                        }
                    }
                }
            }
        }
        res.forEach(list -> {
            list.forEach(it -> System.out.print(it + " "));
            System.out.println();
        });
        return res;
    }
}

class Solution5 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 使用contains减少一轮循环



        res.forEach(list -> {
            list.forEach(it -> System.out.print(it + " "));
            System.out.println();
        });
        return res;
    }
}
