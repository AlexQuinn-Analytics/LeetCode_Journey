public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        StringBuilder sb=new StringBuilder();
        while (!q.isEmpty()){
            TreeNode cur=q.poll();
            if (cur==null){
                sb.append("null,");
            }else{
                sb.append(cur.val).append(",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null||data.length()==0) return null;
        String[]arr=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        int i=1;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()&&i<arr.length){
            TreeNode parent=q.poll();
            if (i < arr.length &&!arr[i].equals("null")){
                parent.left=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(parent.left);
            }
            i++;
            if (i < arr.length &&!arr[i].equals("null")){
                parent.right=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(parent.right);
            }
            i++;
        }
        return root;
    }
}
