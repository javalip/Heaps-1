import java.util.PriorityQueue;

public class MergeKsortedLists {
     public class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    //Iterate through
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        return dummyNode.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode merged = new ListNode(Integer.MIN_VALUE);

        for (ListNode list : lists) {
            merged = merge(merged, list);
        }
        return merged.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next =  l1!=null?l1:l2;
        return dummy.next;
    }
}
