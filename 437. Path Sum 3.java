class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null) return 0;
        HashMap<Long, Integer>map=new HashMap<>();
        map.put(0L,1);
        int res=dfs(root,targetSum,0,map);
        return res;
    }

    private int dfs(TreeNode root, int targetSum, long currSum, HashMap<Long, Integer>map){
        if (root==null) return 0;
        currSum+=root.val;
        int res=map.getOrDefault(currSum-targetSum,0);
        map.put(currSum,map.getOrDefault(currSum,0)+1);
        res+=dfs(root.left,targetSum,currSum,map);
        res+=dfs(root.right,targetSum,currSum,map);
        map.put(currSum,map.get(currSum)-1);
        return res;
    }
    }