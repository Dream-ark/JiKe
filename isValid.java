【视频学习Day07_LeetCode20】
//思路：1.暴力：依次遍历字符串元素：左括号存在list中；遇到右括号，先判断list中是否存有元素，有元素再判断在list中的最后一个元素是否和其匹配：
//1.1匹配，将元素从list中删除；1.2不匹配，无效括号对。2.如果都是配对的，那么最后list为空。
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
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
//2.使用栈存储，复杂度O(n)
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
