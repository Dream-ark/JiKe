【视频学习Day02_LeetCode70】
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
