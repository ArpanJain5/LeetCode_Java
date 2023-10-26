class Solution {
    int mod = (int)1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        if(arr.length == 0) return 0;
        Arrays.sort(arr);
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            long count = 1l;
            int v1 = arr[i];
            for(int j = 0; j < i; j++){
                int v2 = arr[j];
                if(v1 % v2 == 0 && map.containsKey((v1 / v2))){
                    count += map.get(v2) * map.get(v1/v2);
                }
            }
            map.put(v1, count);
        }
        long total = 0l;
        for(Map.Entry<Integer, Long> entry : map.entrySet()){
            total += entry.getValue();
        }
        return (int)(total % mod);       
    }
}