package org.example.substr;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void main(String[] args) {
        new Solution3().subarraySum(new int[]{1,1,1},2);
    }
}


class Solution3 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        //2. 前N项和，
        int length = nums.length;
        int sums = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < length; i++) {
            sums += nums[i];
            int target = sums - k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            map.put(sums, map.getOrDefault(sums, 0) + 1);
        }
        System.out.println(res);
        return res;
    }
}

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        //2. 前N项和
        int length = nums.length;
        int[] sums = new int[length];
        sums[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sums[i] = nums[i]+ sums[i-1];
        }
        for (int i = 0; i < length; i++) {
            if (sums[i] == k) {
                res++;
            }
            for (int j = i + 1; j < length; j++) {
                if (sums[j] - sums[i] == k) {
                    res++;
                }
            }
        }
        System.out.println(res);
        return res;
    }
}


class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        //1. 暴力遍历，超时
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == k) {
                res++;
            }
            for (int j = i + 1; j < length; j++) {
                if (sum(nums, i, j) == k) {
                    res++;
                }
            }
        }
        System.out.println(res);
        return res;
    }

    int sum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}

