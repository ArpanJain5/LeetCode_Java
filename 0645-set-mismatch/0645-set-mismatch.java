class Solution {
    public int[] findErrorNums(int[] nums) {
        int n= nums.length;
        int arr[] = new int[2];    
        HashMap< Integer,Integer > map = new HashMap<>();
        for( int i=0;i<n;i++ ) { 
            map.put( nums[i] , map.getOrDefault( nums[i],0 )+1 );   
        }
        for( int i=0;i<n;i++ ) { 
            if(map.get(i+1) == null )  arr[1]=i+1; 
            if(map.get(i+1) != null && map.get(i+1) == 2 )  arr[0]=i+1;        
        }
        return arr;
    }
}