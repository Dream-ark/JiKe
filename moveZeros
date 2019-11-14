
【视频学习Day02_LeetCode283】
//思路：1.用一个下标j记录，元素为0，存储；2.将j下标之后的元素，补齐0

public class Solution{
 public void moveZeros(int[] nums){
   int j=0;
   for(int i=0;i<nums.length;i++){
    if(nums[i]!=0){
      nums[j]=nums[i];
      j++;
    }
   }
   for(int k=j;k<nums.length;k++){
      nums[k]=0;
   }
 }

}
