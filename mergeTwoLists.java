【视频学习Day03_LeetCode21】
//思路：1.链表的数据结构；2.依次比较链表的节点值，并且链表节点向后移动，值小的链表；3.链表最后节点判断，不为null的赋值为最后元素。
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