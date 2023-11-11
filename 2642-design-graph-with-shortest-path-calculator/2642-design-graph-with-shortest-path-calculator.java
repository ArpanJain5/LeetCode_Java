class Graph {
    LinkedList<int[]> gr[];
    int vis[];
    int cur = 0;

    public Graph(int n, int[][] edges) {
      vis = new int[n];
      gr = new LinkedList[n];
    
      for(int i = 0; i != n; i++)
        gr[i] = new LinkedList<>();
        
      for(int[] e: edges) gr[e[0]].add(new int[]{e[1], e[2]});
    }
    
    public void addEdge(int[] edge) {
      gr[edge[0]].add(new int[]{edge[1], edge[2]});  
    }
    
    public int shortestPath(int node1, int node2) {
      PriorityQueue<int[]> q = new PriorityQueue<>(100, (o1, o2) -> o1[0] - o2[0]);
      q.add(new int[]{0, node1});
      cur++;

      while(!q.isEmpty())
        for(int n = q.size(); n != 0; n--){
          int[] tmp = q.poll(); 
          int node = tmp[1], weight = tmp[0];

          if( node == node2) return weight;

          if( vis[node] == cur) continue;
          vis[node] = cur;

          for(int[] next : gr[node]) 
            if(vis[next[0]] != cur) q.add(new int[]{weight + next[1], next[0]});
      }

      return -1;
  }  
}     
/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */