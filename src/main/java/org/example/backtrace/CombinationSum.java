package org.example.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {8,7,4,3};
        int target = 11;
        Solution8  solution7 = new Solution8 ();
        List<List<Integer>> lists = solution7.combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

class Solution8 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        backTrack(candidates, target, list, ans,0);
        return ans;
    }

    private void backTrack(int[] candidates, int target, LinkedList<Integer> list, List<List<Integer>> ans, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new LinkedList<>(list));
            return;
        }
        backTrack(candidates, target, list, ans, index + 1);
        if (target - candidates[index] >= 0) {
            list.push(candidates[index]);
            backTrack(candidates, target - candidates[index], list, ans, index);
            list.pop();
        }

    }


}


//有问题
class Solution7 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        backTrack(candidates, target, list, ans);
        return ans;
    }

    private void backTrack(int[] candidates, int target, LinkedList<Integer> list, List<List<Integer>> ans) {
        if (getSum(list) == target) {
            // 去重
            list.sort(Integer::compareTo);
            if (!havaSame(ans, list)) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }else if(getSum(list) > target) {
            // 剪枝
            return;
        }
        for (int candidate : candidates) {
            list.push(candidate);
            backTrack(candidates, target, list, ans);
            list.pop();
        }
    }

    private boolean havaSame(List<List<Integer>> ans, LinkedList<Integer> list) {
        for (List<Integer> an : ans) {
            if (an.equals(list)) {
                return true;
            }
        }
        return false;
    }

    private int getSum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }
}