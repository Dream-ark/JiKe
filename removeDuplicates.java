【视频学习Day01_LeetCode26】
//思路：1.新的下标id记录，当相邻元素不相等，存储；2.返回id为去重后的数组长度
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int id=1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]){
                nums[id++]=nums[i];
            }
        }
        return id;
    }
}