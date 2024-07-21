class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];
        int[] rowSort = topoSort(k, rowConditions);
        int[] colSort = topoSort(k, colConditions);
        int[] col = new int[k + 1];
        for(int i=0;i<k;i++){
            if(colSort[i]==0)return new int[][]{};
            col[colSort[i]]=i;
        }
        for(int i=0;i<k;i++){
             if(rowSort[i]==0)return new int[][]{};
            ans[i][col[rowSort[i]]]=rowSort[i];
        }
        return ans;
    }
    private int[] topoSort(int k, int[][] grid) {
        int[] ans = new int[k];
        int x = 0;
        int[] inDegree = new int[k];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : grid) {
            if (!map.containsKey(a[0])) {
                map.put(a[0], new ArrayList<>());
            }
            map.get(a[0]).add(a[1]);
            inDegree[a[1] - 1]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                ans[x++] = i + 1;
                qu.add(i + 1);
            }
        }
        while (!qu.isEmpty()) {
            int node = qu.poll();
            if (map.get(node) != null) {
                List<Integer> list = map.get(node);
                for (int val : list) {
                    inDegree[val - 1]--;
                    if (inDegree[val - 1] == 0) {
                        ans[x++] = val;
                        qu.add(val);
                    }
                }
            }
        }
        return ans;
    }
}