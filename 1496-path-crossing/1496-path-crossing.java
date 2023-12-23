class Solution {
    public boolean isPathCrossing(String path) {
        Set<List<Integer>> set = new HashSet<>();
        int x=0,y=0;
        set.add(Arrays.asList(0,0));
        for(char ch:path.toCharArray()){
            if(ch == 'N') y++;
            if(ch == 'S') y--;
            if(ch == 'E') x++;
            if(ch == 'W') x--;
            if(set.contains(Arrays.asList(x,y))) return true;
            else set.add(Arrays.asList(x,y));
        }
        return false;
    }
}