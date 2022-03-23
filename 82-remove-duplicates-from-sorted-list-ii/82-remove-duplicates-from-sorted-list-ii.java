/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode leftPointer, rightPointer;
        leftPointer = new ListNode(101, head);
        rightPointer = head;
        
        while (leftPointer.next != null) {
            while (rightPointer != null && rightPointer.val == leftPointer.next.val) {
                rightPointer = rightPointer.next;
            }
            if (leftPointer.next.next != rightPointer) {
                if (leftPointer.next == head) {
                    head = rightPointer;
                    leftPointer.next = head;
                } else {
                    leftPointer.next = rightPointer;
                }
            } else {
                leftPointer = leftPointer.next;
            }
        }
        
        return head;
    }
}