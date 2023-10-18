class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
    List<List<Integer>> al = new ArrayList<>();
    int[] prereq = new int[n], lead = new int[n];
    for (int i = 0; i < n; ++i)
        al.add(new ArrayList<Integer>());    
    for (var r : relations) {
        ++prereq[r[1] - 1];
        al.get(r[0] - 1).add(r[1] - 1);
    }
    List<Integer> q = new ArrayList<>();
    for (int i = 0; i < n; ++i)
        if (prereq[i] == 0)
            q.add(i);        
    while(!q.isEmpty()) {
        List<Integer> q1 = new ArrayList<>();
        for (int i : q) {
            lead[i] += time[i];
            for (int j : al.get(i)) {
                lead[j] = Math.max(lead[j], lead[i]);
                if (--prereq[j] == 0)
                    q1.add(j);
            }
        }
        q = q1;
    }
    return Arrays.stream(lead).max().getAsInt();
}
}