import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> q = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!q.isEmpty()) {
                q.offerFirst(q.pollLast());
            }
            q.offerFirst(deck[i]);
        }
        int[] ans = new int[q.size()];
        int index = 0;
        for (int num : q) {
            ans[index++] = num;
        }
        return ans;
    }
}