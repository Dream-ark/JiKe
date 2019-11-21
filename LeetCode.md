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
## 如何改变文本的样式

*强调文本* _强调文本_

**加粗文本** __加粗文本__

==标记文本==

~~删除文本~~

> 引用文本

H~2~O is是液体。

2^10^ 运算结果是 1024.

## 插入链接与图片

链接: [link](https://mp.csdn.net).

图片: ![Alt](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9hdmF0YXIuY3Nkbi5uZXQvNy83L0IvMV9yYWxmX2h4MTYzY29tLmpwZw)

带尺寸的图片: ![Alt](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9hdmF0YXIuY3Nkbi5uZXQvNy83L0IvMV9yYWxmX2h4MTYzY29tLmpwZw =30x30)

居中的图片: ![Alt](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9hdmF0YXIuY3Nkbi5uZXQvNy83L0IvMV9yYWxmX2h4MTYzY29tLmpwZw#pic_center)

居中并且带尺寸的图片: ![Alt](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9hdmF0YXIuY3Nkbi5uZXQvNy83L0IvMV9yYWxmX2h4MTYzY29tLmpwZw#pic_center =30x30)


## 如何插入一段漂亮的代码片

去[博客设置](https://mp.csdn.net/configure)页面，选择一款你喜欢的代码片高亮样式，下面展示同样高亮的 `代码片`.
```javascript
// An highlighted block
var foo = 'bar';
```


### 设定内容居中、居左、居右
使用`:---------:`居中
使用`:----------`居左
使用`----------:`居右
| 第一列       | 第二列         | 第三列        |
|:-----------:| -------------:|:-------------|
| 第一列文本居中 | 第二列文本居右  | 第三列文本居左 | 



##  注释也是必不可少的

Markdown将文本转换为 HTML。

*[HTML]:   超文本标记语言

## KaTeX数学公式

您可以使用渲染LaTeX数学表达式 [KaTeX](https://khan.github.io/KaTeX/):

Gamma公式展示 $\Gamma(n) = (n-1)!\quad\forall
n\in\mathbb N$ 是通过欧拉积分

$$
\Gamma(z) = \int_0^\infty t^{z-1}e^{-t}dt\,.
$$

> 你可以找到更多关于的信息 **LaTeX** 数学表达式[here][1].
