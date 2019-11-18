  
【视频学习Day04_LeetCode88】
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
