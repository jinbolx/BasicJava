package leetcode;


import java.util.ArrayList;
import java.util.List;

public class AddLinkList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1=l1;
        ListNode listNode2=l2;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.x);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.x);
            l2 = l2.next;
        }
        if (list1.size()>list2.size()){
            for (int i = 0; i <list2.size() ; i++) {
                int sum=list1.get(i)+list2.get(i);
                list1.set(i,sum%10);
            }
            for (int i = 0; i <list1.size(); i--) {
                listNode1.x=list1.get(i);
                listNode1=listNode1.next;
            }
        }else {
            for (int i = list2.size()-1; i >=0; i--) {
                int sum=list1.get(i)+list2.get(i);
                list2.set(i,sum%10);
            }
        }
return null;
    }

    public static class ListNode {

        int x;
        ListNode next;

        public ListNode(int x) {
            this.x = x;
        }
    }
}
