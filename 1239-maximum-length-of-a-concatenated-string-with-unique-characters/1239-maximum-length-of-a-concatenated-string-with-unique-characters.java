class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, 0 , "");
    }
    int helper(List<String> arr, int i, String res){
        if(i == arr.size()){
            return res.length();
        }
        int inclu=0;
        if(isValid(res+arr.get(i)))
            inclu= helper(arr, i+1, res+arr.get(i));
        int exclu= helper(arr, i+1, res);
        return Math.max(inclu, exclu);
    }
    boolean isValid(String cur){
        int[] arr=new int[26];
        for(int i=0;i< cur.length();i++){
            arr[cur.charAt(i)-'a']++;
            if(arr[cur.charAt(i)-'a'] > 1)
                return false;
        }
        return true;
    }
}