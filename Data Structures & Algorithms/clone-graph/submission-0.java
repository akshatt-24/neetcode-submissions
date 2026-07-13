    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    */

    class Solution {
        public Node cloneGraph(Node node) {
            if(node == null) return null;
            Node dummy = new Node(); //val = 0 
            Node temp = new Node(node.val);  //node.val = 1 
            dummy.neighbors.add(temp);

            Queue<Node> queue = new LinkedList<>();
            // Set<Node> set = new HashSet<>();
            Map<Node, Node> map = new HashMap<>(); // original -> clone 

            queue.offer(node);
            // set.add(new Node(node));
            map.put(node , temp);

            while(!queue.isEmpty()) {
                Node curr = queue.poll();
                temp = map.get(curr);

                for(Node neighbor : curr.neighbors) {
                    if(!map.containsKey(neighbor)) {
                        Node n = new Node(neighbor.val);
                        map.put(neighbor, n);
                        temp.neighbors.add(n);
                        queue.offer(neighbor);
                    }
                    else {
                        map.get(curr).neighbors.add(map.get(neighbor));
                    }
                }
            }
            return dummy.neighbors.get(0);
        }
    }