class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String>tm=new TreeMap<Integer,String>();
        for(int i=0;i<names.length;i++){
            tm.put(heights[i],names[i]);
        }int j=heights.length-1;
        for(int i:tm.keySet()){
            names[j]=tm.get(i);
            j--;
        }
        return names;
    }
}