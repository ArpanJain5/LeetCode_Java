class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, int[]> adjacencyMap = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < adjacentPairs.length; i++){
            updateMap(adjacencyMap, adjacentPairs[i][0], adjacentPairs[i][1]);
            updateMap(adjacencyMap, adjacentPairs[i][1], adjacentPairs[i][0]);
            updateSet(hs, adjacentPairs[i][0]);
            updateSet(hs, adjacentPairs[i][1]);
        }
        int[] ans = new int[adjacentPairs.length+1];
        ans[0] = (int)hs.toArray()[0];
        for(int i = 0; i < adjacentPairs.length; i++){         
            int[] temp = adjacencyMap.get(ans[i]);
            if(i == 0)
                ans[i+1] = temp[0];
            else
                ans[i+1] = (ans[i-1] != temp[0]) ? temp[0] : temp[1];
        }
        return ans;
    }
    public void updateSet(HashSet<Integer> hs, int val){
        if(hs.contains(val)){
            hs.remove(val);
        }else{
            hs.add(val);
        }
    }
    public void updateMap(HashMap<Integer, int[]> adjacencyMap, int val1, int val2){
        if(!adjacencyMap.containsKey(val1)){
            int[] temp = new int[2];
            temp[0] = val2;
            adjacencyMap.put(val1, temp);
        }else{
            adjacencyMap.get(val1)[1] = val2;
        }
    }
}