class Solution {
  public int garbageCollection(String[] garbage, int[] travel) {
    final int n = garbage.length;
    int minutes = 0;
    int[] prefix = new int[n];
    for (int i = 1; i < n; i++) {
      prefix[i] += prefix[i - 1] + travel[i - 1];
    }
    boolean[] seen = new boolean[3];
    for (int i = n - 1; i >= 0; i--) {
      for (char c : garbage[i].toCharArray()) {
        minutes++;
        switch (c) {
          case 'M':
            if (!seen[0]) {
              seen[0] = true;
              minutes += prefix[i];
            }
            break;
          case 'P':
            if (!seen[1]) {
              seen[1] = true;
              minutes += prefix[i];
            }
            break;
          default:
            if (!seen[2]) {
              seen[2] = true;
              minutes += prefix[i];
            }
        }
      }
    }
    return minutes;
  }
}