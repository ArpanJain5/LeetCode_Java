class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] parents = new List[n];
        for (int[] e : edges) {
            if (parents[e[1]] != null)
                parents[e[1]].add(e[0]);
            else {
                parents[e[1]] = new ArrayList<>(){{add(e[0]);}};
            }
        }

        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (parents[i] == null) {
                ans.add(i , new ArrayList<>());
            } else {
                set.addAll(parents[i]);
                q.addAll(set);
                ans.add(i, new ArrayList(set));

                while (!q.isEmpty()) {
                    if (parents[q.peek()] != null) {
                        for (int m : parents[q.poll()]) {
                            if (set.add(m)) {
                                ans.get(i).add(m);
                                q.offer(m);
                            }
                        }
                    } else
                        q.poll();
                }

                Collections.sort(ans.get(i));
                set.clear();
                q.clear();
            }
        }
        return ans;
    }

}