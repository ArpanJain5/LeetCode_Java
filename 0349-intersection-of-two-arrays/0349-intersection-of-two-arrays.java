class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
         Arrays.sort(nums1);
         List<Integer> l = new ArrayList<>();

         int i=0;int j=0;
         while(i<nums1.length && j< nums2.length){
            if(nums1[i]==nums2[j]){
               if(!l.contains(nums1[i])) { l.add(nums1[i]);}
               
                i++;j++;}
            else if(nums1[i]<nums2[j]){i++;}
            else{j++;}
         }
         int [] res = new int[l.size()];
         for( i =0; i<l.size();i++){
             res[i]=l.get(i);
         }
         return res;
    }
}