【视频学习Day02_LeetCode11】
/*
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。



图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

 

示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



*/
//思路：1.双指针移动分别从l=0和r=length-1开始；2.指针得到较小的高度；
//3.宽度为r-l；4.移动指针条件为左边数小于右边数，左指针++，右边数小于左边数，右指针--
public class Solution{
 public void maxArea(int[] height){
  int l=0,r=height.length-1,area=0;
  while(l<r){
    int h=Math.min(height[l],height[r]);
    area=Math.max(area,h*(r-l));
    if(height[l]<height[r]){
      l++;
    }else{
      r--;
    }
  }
  return area;
 }

}
