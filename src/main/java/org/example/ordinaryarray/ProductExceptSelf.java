package org.example.ordinaryarray;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {

        // 测试代码
        int[] nums = {-1,1,0,-3,3};
        int[] result = new Solution8().productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}


class Solution8 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        L[0] = 1;
        R[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            L[i] = nums[i-1] * L[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = L[i] * R[i];
        }
        return nums;
    }
}

class Solution7 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        // 计算所有数的乘积
        int sum = 1;
        // 与0的个数相关
        int zeroCount = 0;
        int zeroIndex = -1;

        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                sum *= nums[i];
            }else {
                zeroIndex = i;
                zeroCount++;
            }
        }
        int[] res = new int[length];
        Arrays.fill(res, 0);
        if (zeroCount >= 2) {
            //全是0
        } else if (zeroCount == 1) {
            res[zeroIndex] = sum;
        } else {
            for (int i = 0; i < length; i++) {
                res[i] = sum / nums[i];
            }
        }
        return res;
    }
}
