class Solution {
    public int minOperations(String[] logs) {
        int dist=0;
        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("../")){
                if(dist!=0){
                    dist--;
                }
            }else if(logs[i].equals("./")){
                continue;
            }else{
                dist++;
            }
        }
        return dist;
    }
}