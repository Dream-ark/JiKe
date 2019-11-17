  
【视频学习Day04_LeetCode88】
//思路：1.1.nums2中的n个元素，覆盖nums1从m位置开始的n个元素。2.使用Arrays.sort方法排序nums1。

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}
