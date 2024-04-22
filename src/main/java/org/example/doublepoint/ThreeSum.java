package org.example.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        new Solution5().threeSum(new int[]{-1,0,1,2,-1,-4});
//        int i = new Solution4().testTry();
//        System.out.println(i);

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

    public int testTry() {
        int i = 2;
        try {
            i = 6;
            return i;
        } catch (Exception e) {
            return i;
        }finally {
            i = 3;
//            return i;
        }
    }
}

class Solution5 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序，在进行双指针
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int one = 0; one < n; one++) {
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }
            int three = n - 1;
            int target = -nums[one];
            for (int two = one + 1; two < n; two++) {
                if (two > one + 1 && nums[two] == nums[two - 1]) {
                    continue;
                }
                while (two < three && nums[two] + nums[three] > target) {
                    three--;
                }
                if (two == three) {
                    break;
                }
                if (nums[two] + nums[three] == target) {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[one]);
                    integers.add(nums[two]);
                    integers.add(nums[three]);
                    res.add(integers);
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
