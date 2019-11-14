【视频学习Day02_LeetCode189】
//思路：1.数组分为长度k和length-k的两部分；2.倒置0到length-k-1和length-k到length-1；3.整个数组倒置

public class Solution{
 public void rotate(int[] nums,int k){
   int n=nums.length;
   reverse(nums,0,n-k-1);
   reverse(nums,n-k,n-1);
   reverse(nums,0,n-1);
 }
 private void reverse(int[] nums,int start,int end){
    int temp;
    while(start<end){
      temp=nums[start];
      nums[start]=nums[end];
      nums[end]=temp;
      end--;
      start++;
 }

}
