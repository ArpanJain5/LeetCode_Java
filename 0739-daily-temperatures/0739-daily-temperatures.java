class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[] = new int[temperatures.length];
        Stack<Integer> nextGreaterIndex = new Stack<Integer>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!nextGreaterIndex.isEmpty() && temperatures[nextGreaterIndex.peek()] <= temperatures[i]) {
                nextGreaterIndex.pop();
            }
            ans[i] = nextGreaterIndex.isEmpty() ? 0 : nextGreaterIndex.peek() - i;
            nextGreaterIndex.push(i);
        }
        return ans;
    }
}