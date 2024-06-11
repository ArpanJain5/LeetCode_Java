class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int element : arr1)
        {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        int index = 0;
        for(int key : arr2)
        {
            for(int i = 0; i < map.get(key); i++)
            {
                arr1[index++] = key;
            }

            map.remove(key);
        }

        
        for(int key : map.keySet())
        {
            for(int i = 0; i < map.get(key); i++)
            {
                arr1[index++] = key;
            }
        }

        return arr1;
    }
}