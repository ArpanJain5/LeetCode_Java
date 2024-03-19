class Solution {

    public class Task {
        char name;
        int count;
        int nextStart;

        public Task(char c, int count, int nextStart){
            name = c;
            this.count = count;
            this.nextStart = nextStart;
        }
    }
    public int leastInterval(char[] tasks, int n) {       
        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        PriorityQueue<Task> pTasks = new PriorityQueue<>((a, b) -> {
            if(a.nextStart == b.nextStart) {
                if(a.count == b.count) {
                    return a.name - b.name;
                }
                return b.count - a.count;
            }
            return a.nextStart - b.nextStart;
        });


        for(Map.Entry<Character, Integer> e: map.entrySet()) {
            pTasks.add(new Task(e.getKey(), e.getValue(), 0));
        }

        int timeClock = 0;

        while(pTasks.size() > 0) {
            if(pTasks.peek().nextStart <= timeClock) {
                Task t = pTasks.poll();
                if(t.count > 1){
                    pTasks.offer(new Task(t.name, t.count - 1, t.nextStart + n + 1));
                }                
            }
            timeClock++;
        }
        return timeClock;
    }
}