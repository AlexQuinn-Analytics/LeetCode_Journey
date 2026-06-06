class Solution {
    // 1. 存储 节点 -> 父节点
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 第一步：遍历树，记录每个节点的父节点
        dfsParent(root, null);
        
        // 第二步：BFS 队列（层序遍历）
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        
        int dist = 0;
        // 第三步：走 k 层
        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k) {
                // 队列里剩下的就是距离 = k 的所有节点
                List<Integer> res = new ArrayList<>();
                for (TreeNode node : q) res.add(node.val);
                return res;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                // 三个方向：左、右、父
                if (cur.left != null && !visited.contains(cur.left)) {
                    q.offer(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    q.offer(cur.right);
                    visited.add(cur.right);
                }
                TreeNode p = parent.get(cur);
                if (p != null && !visited.contains(p)) {
                    q.offer(p);
                    visited.add(p);
                }
            }
            dist++;
        }
        return new ArrayList<>();
    }
    
    // 建立父节点关系
    private void dfsParent(TreeNode node, TreeNode p) {
        if (node == null) return;
        parent.put(node, p);
        dfsParent(node.left, node);
        dfsParent(node.right, node);
    }
}