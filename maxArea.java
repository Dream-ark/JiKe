【视频学习Day02_LeetCode11】
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
