class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
      HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(!hm.containsKey(nums1[i])){
                hm.put(nums1[i],1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(hm.containsKey(nums2[i])){
                hm.put(nums2[i],2);
            }
        }
      Arrays.sort(nums1);
      for(int i : nums1){
          if(hm.containsKey(i)){
              int val = hm.get(i);
          if(val>=2){
              return i;
          } 
            }
      }
      return -1;
    }
}