//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long inversionCount(long arr[], long N)
    {
        int n=arr.length;
        long[] temp=new long[n];
        return mergeSort(arr,temp,0,(n-1));
    }
    
 public static long mergeSort(long arr[],long temp[],int lb,int ub)
{
    long inv_count = 0;
    if(lb<ub)
    {
        int mid = (lb + ub)/2;
        inv_count+=mergeSort(arr,temp,lb,mid);
        inv_count+=mergeSort(arr,temp,mid+1,ub);
        inv_count+=merge(arr,temp,lb,mid,ub);
    }
    return inv_count;
}
public static long merge(long arr[],long temp[],int lb,int mid,int ub){
    long inv_count=0;
    int i = lb,j = mid+1,k = lb;
    while((i <=mid) && (j <= ub))
        if(arr[i] <= arr[j])
            temp[k++] = arr[i++];
        else{
            temp[k++] = arr[j++];
            inv_count+=(mid-i+1);
        }
    while(i <=mid)
        temp[k++] = arr[i++];
    while(j <= ub)
        temp[k++] = arr[j++];
    for(i = lb ; i <= ub ; i++)
        arr[i] = temp[i];
    return inv_count;
    }
}