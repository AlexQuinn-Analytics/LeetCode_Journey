static Map<Node, Node> memo = new HashMap<>();

    static Node copyRandomList(Node head) {
        Node newNode=copy(head);
        return newNode;
    }
    static Node copy(Node head){
        if (head==null) return null;
        if (memo.containsKey(head)) return memo.get(head);
        Node newNode=new Node(head.val);
        memo.put(head, newNode);
        newNode.next=copy(head.next);
        newNode.random=copy(head.random);
        return newNode;
    }