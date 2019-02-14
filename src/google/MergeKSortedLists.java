package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author rexthk
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode start = new ListNode(Integer.MIN_VALUE);
        Arrays.stream(lists).filter(Objects::nonNull).forEach(heap::add);

        ListNode next = start;
        while (!heap.isEmpty()) {
            ListNode nextMin = heap.poll();
            next.next = new ListNode(nextMin.val);
            next = next.next;
            if (nextMin.next != null) heap.add(nextMin.next);
        }

        return start.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
