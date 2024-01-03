class Solution {
  public int numberOfBeams(String[] bank) {
    var onesA = 0;
    var cnt = 0;
    for (var row : bank) {
      var onesB = 0;
      for (var c : row.toCharArray())
        if (c == '1') onesB++;
      if (onesB == 0) continue;
      cnt += onesA * onesB;
      onesA = onesB;
    }
    return cnt;
  }
}