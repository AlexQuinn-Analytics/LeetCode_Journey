import java.util.*;

// 题目自带的接口（不用管实现）
interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // 第一步：求最大深度 👈 就是你说的多出来的步骤
        int maxDepth = getMaxDepth(nestedList, 1);
        
        // 第二步：计算反向加权和
        return calculateSum(nestedList, 1, maxDepth);
    }
    
    // 第一遍 DFS：求最大深度
    private int getMaxDepth(List<NestedInteger> list, int depth) {
        int max = depth;
        
        for (NestedInteger ni : list) {
            if (!ni.isInteger()) {
                max = Math.max(max, getMaxDepth(ni.getList(), depth + 1));
            }
        }
        return max;
    }
    
    // 第二遍 DFS：计算权重和
    private int calculateSum(List<NestedInteger> list, int depth, int maxDepth) {
        int sum = 0;
        int weight = maxDepth - depth + 1; // 反向权重
        
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * weight;
            } else {
                sum += calculateSum(ni.getList(), depth + 1, maxDepth);
            }
        }
        return sum;
    }
}