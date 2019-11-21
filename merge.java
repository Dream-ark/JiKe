  
【视频学习Day04_LeetCode88】
/*
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
//思路：1.nums2中的n个元素，覆盖nums1从m位置开始的n个元素。2.使用Arrays.sort方法排序nums1。

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    //法1：时间复杂度高O(n)
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
    
    //法2：3指针法（时间复杂度低）O(1)【面试】
     public void merge(int[] nums1, int m, int[] nums2, int n) {
         int i=m-1;
		int j=n-1;
		int k = m+n-1;
		while(i >=0 && j>=0)
		nums1[k--]=nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
		while(j>=0)
			nums1[k--] = nums2[j--];
    
    }
}
