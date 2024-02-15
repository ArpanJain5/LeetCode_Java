class Solution {
    public long largestPerimeter(int[] a) {
        Queue<Long> q = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = Arrays.stream(a).mapToLong(i -> i).sum();
        Arrays.stream(a).boxed().mapToLong(i -> i).forEach(e -> q.offer(e));
        
        while(q.size() >= 3) {
            long e = q.poll();
            sum -= e;
            if(e < sum) {
                return sum + e;
            }
        }
        return -1;
    }
}