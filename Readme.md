@[力扣练习题](这里写自定义目录标题)

- 70
- 20
- 11
- 88
- 21
- 283
- 26
- 189
- 15
 
# 70.爬楼梯
## 题目描述

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？注意：给定 n 是一个正整数。
输入： 2，有两种方法可以爬到楼顶。输入： 3，有三种方法可以爬到楼顶。


## 解题思路
归纳法，当n=0,1,2，输出分别是0,1,2。当n>=3,f(n)=f(n-1)+f(n-2)
```java
public class Solution{
 public void climbStairs(int n){
  if(n==0){return 0;}
  if(n==1){return 1;}
  if(n==2){return 2;}
  
  int one_step=1;
  int two_step=2;
  int all_steps=0;
  for(int i=2;i<n;i++){
    all_steps=one_step+two_step;
    one_step=two_step;
    two_step=all_steps;
  }
  return all_steps;
 }
}
```

# 20.括号匹配
## 题目描述

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。注意空字符串可被认为是有效字符串。例如，输入: "()"，输出: true。输入: "(]"，输出: false。


## 解题思路
1.暴力：依次遍历字符串元素，左括号存在list中；遇到右括号，先判断list中是否存有元素，有元素再判断在list中的最后一个元素是否和其匹配。没有元素，直接返回false。
1.1匹配，将元素从list中删除；1.2不匹配，无效括号对。2.如果都是配对的，那么最后list为空。

```java
class Solution{
  public boolean isValid(String s){
    List<Character> list =new ArrayList<>();
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
          list.add(s.charAt(i));
      }
      if(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']'){
          if(list.size()==0){
              return false;
          }
          char ch=list.get(list.size()-1).charValue();
          if(s.charAt(i)-ch!=1||s.charAt(i)-ch!=2){
              return false;
          }
          list.remove(list.size()-1);
      }
    }
      if(list.size()==0){
        return true;
      }
        return false;
  }
}
```
2.使用栈存储，复杂度O(n)
```java
class Solution{
  public boolean isValid(String s){
    Stack<Character> stack=new Stack<>();
    if(s.length()==0){
        return true;
    }
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='('){
        stack.push(')');
      }else if(s.charAt(i)=='{'){
        stack.push('}');
      }else if(s.charAt(i)=='['){
        stack.push(']');
      }else{
        if(stack.isEmpty()||stack.pop()!=s.charAt(i)){
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

```
# 11.最大面积
## 题目描述

给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。说明：你不能倾斜容器，且 n 的值至少为 2。
![Alt](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg)
图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
## 解题思路
1.双指针移动分别从l=0和r=length-1开始；2.指针得到较小的高度；3.宽度为r-l；4.移动指针条件为左边数小于右边数，左指针++，右边数小于左边数，右指针--。
```java
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
```
# 88.合并有序数组
## 题目描述

给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。说明:初始化 nums1 和 nums2 的元素数量分别为 m 和 n。你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。示例:输入:nums1 = [1,2,3,0,0,0], m = 3，nums2 = [2,5,6],n = 3。输出: [1,2,2,3,5,6]。

## 解题思路
1.nums2中的n个元素，覆盖nums1从m位置开始的n个元素。2.使用Arrays.sort方法排序nums1。
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    //法1：时间复杂度高O(n)
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}
```
法2：3指针法（时间复杂度低）O(1)【面试】
```java
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
```
# 21.合并有序链表
## 题目描述

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 示例：
输入：1->2->4, 1->3->4。输出：1->1->2->3->4->4

## 解题思路
1.链表的数据结构；2.依次比较链表的节点值，移动值小的链表节点；3.链表最后节点判断，不为null的赋值为最后元素。
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        
        ListNode cur=pre;
       
          while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                cur.next=l2;
                l2=l2.next;
            }else{
                cur.next=l1;
                l1=l1.next;
            }
        cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return head.next;       
    }
}
```
# 283.移动0值
## 题目描述

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。示例:
输入: [0,1,0,3,12]，
输出: [1,3,12,0,0]。
说明:
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
## 解题思路
1.用一个下标j记录，元素不为0，存储；2.将j下标之后的元素，补齐0
```java
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
```
# 26.删除有序数组中的重复元素
## 题目描述

给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

## 解题思路
1.新的下标id记录，当相邻元素不相等，存储在id位置；2.返回id为去重后的数组长度
```java
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
```
# 189.旋转数组
## 题目描述

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

输入: [1,2,3,4,5,6,7] 和 k = 3

输出: [5,6,7,1,2,3,4]

解释:

向右旋转 1 步: [7,1,2,3,4,5,6]

向右旋转 2 步: [6,7,1,2,3,4,5]

向右旋转 3 步: [5,6,7,1,2,3,4]

示例 2:

输入: [-1,-100,3,99] 和 k = 2

输出: [3,99,-1,-100]

解释: 

向右旋转 1 步: [99,-1,-100,3]

向右旋转 2 步: [3,99,-1,-100]

说明:
尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
## 解题思路
1.数组分为长度k和length-k的两部分；2.倒置0到length-k-1和length-k到length-1；3.整个数组倒置
```java
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
```
# 15.找出所有的三元和为0
## 题目描述

给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：

[

  [-1, 0, 1],
  
  [-1, -1, 2]
  
]
## 解题思路
1.暴力破解：依次遍历，寻找是否有-nums[i]==nums[j]+nums[k]，isInList和isSame用来去重。
2.双指针+排序：将数组排序；lo指针从前向后，hi指针从后向前,条件为三数和的大小是否等于0，如小于0，则lo++；反之hi--。
```java
class Solution {
//法：双指针+排序
   public List<List<Integer>> threeSum(int[] nums) {
      List <List <Integer>> list = new ArrayList <>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length() - 2; i++) {
			if (nums[i] != nums[i - 1] || i == 0) {
				int lo = i + 1, hi = nums.length - 1;
				while(lo<hi){
					if (nums[i] + nums[lo] + nums[hi] == 0) {
						list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (nums[lo] == nums[lo + 1] && lo < hi) {
							lo++;
						}
						while (nums[hi] == nums[hi + 1] && lo < hi) {
							hi--;
						}
						lo++;
						hi--;
					} else if (nums[i] + nums[lo] + nums[hi] < 0) {
						lo++;
					} else {
						hi--;
					}
				}
				
			}
		}
		return list;
   }
}
```
