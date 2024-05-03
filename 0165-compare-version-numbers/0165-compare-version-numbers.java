class Solution {
    public int compareVersion(String version1, String version2) {
        
        ArrayList<String> arr1 = new ArrayList<>();

        for(int i=0; i<version1.length(); i++){
            if(version1.charAt(i)!='.'){
                String k = "";
                while(version1.charAt(i)!='.'){
                    k=k+version1.charAt(i);
                    i++;
                    if(i==version1.length()) break;
                }
                arr1.add(k);
            }
        }

        ArrayList<String> arr2 = new ArrayList<>();

        for(int i=0; i<version2.length(); i++){
            if(version2.charAt(i)!='.'){
                String k = "";
                while(version2.charAt(i)!='.'){
                    k=k+version2.charAt(i);
                    i++;
                    if(i==version2.length()) break;
                }
                arr2.add(k);
            }
        }


        int n1 = arr1.size();
        int n2 = arr2.size();
        int n = Math.min(n1,n2);

        int ans = 0;
        for(int i=0; i<n; i++){
            int a = Integer.valueOf(arr1.get(i));
            int b = Integer.valueOf(arr2.get(i));

            if(a==b) continue;
            else if(a>b){
                return 1;
            }else return -1;
        }

        if(n1>n2){
            for(int i=n2; i<n1; i++){
                if(Integer.valueOf(arr1.get(i))>0) return 1;
            }
        }
        if(n2>n1){
            for(int i=n1; i<n2; i++){
                if(Integer.valueOf(arr2.get(i))>0) return -1;
            }
        }

        return 0;
    }
}