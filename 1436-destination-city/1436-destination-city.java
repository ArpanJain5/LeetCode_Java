class Solution {
    public String destCity(List<List<String>> paths) {
        for(int i=0;i<paths.size();i++){
            for(int j=0;j<paths.get(i).size();j++){
                String s=paths.get(i).get(j);
                int count=findcount(paths,s);
                if(count ==1 && j==1){
                    return s;
                }
            }
        }
        List<String> r=paths.get(paths.size()-1);
        return r.get(r.size()-1);
    }
    public static int findcount(List<List<String>> paths,String target){
        int count=0;
         for (List<String> row : paths) {
            count += row.stream().filter(target::equals).count();
        }
        return count;
    }
}