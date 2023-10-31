class Solution {
public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> result = new ArrayList<>();
    List<int[]> list = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());   
    for(int[] build: buildings){
        int start = build[0], end = build[1], height = build[2];
        list.add(new int[] {start, -height});
        list.add(new int[] {end, height});
    }
    Collections.sort(list, (a,b) -> {
        if(a[0] != b[0])
            return a[0] - b[0];
        else
            return a[1]- b[1];
        });
    int currHt = 0;
    pq.offer(0);
    for(int[] temp : list){
        int x = temp[0], ht = temp[1];
        if(ht < 0)
            pq.offer(-ht);
        else
            pq.remove(ht);
        if(currHt != pq.peek()){
            List<Integer> li = new ArrayList<>();
            li.add(x);
            li.add(pq.peek());
            result.add(li);
            currHt = pq.peek();
        }
    }
    return result;
}
}