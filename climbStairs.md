【视频学习Day02_LeetCode70】
/*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
//思路：1.分情况讨论，n=0,1,2，输出分别是0,1,2.n>=3,f(n)=f(n-1)+f(n-2)
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
