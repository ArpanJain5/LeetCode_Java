class Solution {
    public int[] findArray(int[] pref) {
      int prev=pref[0];
        for(int curr=1;curr<pref.length;curr++){
         int Xor=prev^pref[curr];
         prev=pref[curr];
         pref[curr]=Xor;
        }
        return pref;
    }
}