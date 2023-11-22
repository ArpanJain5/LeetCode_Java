class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.size(); i++) {
            int diag = i;
            for (int j = 0; j < nums.get(i).size(); j++) {
                pq.add(new Node(i, j, diag, nums.get(i).get(j)));
                diag++;
            }
        }
        int[] res = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) 
            res[i++] = pq.poll().val;
        return res;
    }
}
class Node implements Comparable<Node> {
    int row, col, diag, val;
    public Node(int row, int col, int diag, int val) {
        this.row = row;
        this.col = col;
        this.diag = diag;
        this.val = val;
    }
    @Override
    public int compareTo(Node n) {
        if (this.diag == n.diag) {
            return n.row - this.row;
        } else {
            return this.diag - n.diag;
        }
    }
}