class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
       Map<Integer, Integer> t= new HashMap<>();
       for(int i: target){
        if(t.containsKey(i)){
            int count= t.get(i);
            count++;
            t.replace(i, count);
        }
        else{
            t.put(i, 1);
        }
       }
       Map<Integer, Integer> a= new HashMap<>();
       for(int j: arr){
        if(a.containsKey(j)){
            int count= a.get(j);
            count++;
            a.replace(j, count);
        }
        else{
            a.put(j, 1);
        }
       }
       for(int i: t.keySet()){
        if(!a.containsKey(i)){
            return false;
        }
        else{
            int count1= t.get(i);
            int count2= a.get(i);
            if(count1!= count2){
                return false;
            }
        }
       }
       return true;
    }
}