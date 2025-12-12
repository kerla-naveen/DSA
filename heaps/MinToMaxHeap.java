package heaps;

import java.util.Arrays;

class Solution {
    public int[] minToMaxHeap(int[] nums) {
        int n=nums.length;
        for(int k=n/2;k>=1;k--){
            int i=k, j=i*2;
            while(j<=n){
                if(j<n && nums[j]>nums[j-1]) j+=1;

                if(nums[i-1]<nums[j-1]){
                    //swap
                    int temp=nums[i-1];
                    nums[i-1]=nums[j-1];
                    nums[j-1]=temp;

                    //shift i,j
                    i=j;
                    j=i*2;
                }
                else break;
            }
        }
    return nums;
    }
}

public class MinToMaxHeap{
    public static void main(String...arrs){
        Solution sol= new Solution();
        int[] arr=new int[]{10, 20, 30, 21, 23};
        int[] res=sol.minToMaxHeap(arr);

        System.out.println(Arrays.toString(res));
    }
}