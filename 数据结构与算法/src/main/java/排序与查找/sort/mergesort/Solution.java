package 排序与查找.sort.mergesort;

/**
 * 如何将一个数字存到链表中呢？最重要的还是定坐标，定一个last、
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0;
        int num2 = 0;
        int i = 0;
        int j = 0;
        while (l1 != null){
            num1 = num1 +l1.val*(int)Math.pow(10,i++);
            l1 = l1.next;
        }
        while (l2 != null){
            num2 = num2 + l2.val*(int)Math.pow(10,j++);
            l2 = l2.next;
        }
        int sum = num1 +num2;
        System.out.println(num1);
        ListNode ret = new ListNode(sum % 10);
        sum /= 10;
        ListNode last = ret;
        while (sum != 0){
            ListNode newNode = new ListNode(sum %10);
            last.next = newNode;
            last = newNode;
            sum /= 10;
        }

//        while (sum != 0){
//            int data = sum % 10;
//            ListNode newnode = new ListNode(data);
//            if (ret.next == null){
//                ret.next = newnode;
//            }else{
//                ListNode n = ret.next;
//                while (n.next!=null){
//                    n = n.next;
//                }
//                n.next = newnode;
//            }
//            sum = sum /10;
//        }

        return ret;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1,l2).val);
        System.out.println(addTwoNumbers(l1,l2).next.val);
        System.out.println(addTwoNumbers(l1,l2).next.next.val);


    }
}