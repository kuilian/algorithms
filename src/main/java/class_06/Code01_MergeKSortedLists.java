package class_06;

import java.util.Comparator;
import java.util.PriorityQueue;

// 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
public class Code01_MergeKSortedLists {

	public static class ListNode {
		public int val;
		public ListNode next;
	}

//	public static class reserverComparator implements Comparator<Integer>{
//
//		/**
//		 * Compares its two arguments for order.  Returns a negative integer,
//		 * zero, or a positive integer as the first argument is less than, equal
//		 * to, or greater than the second.<p>
//		 * <p>
//		 * In the foregoing description, the notation
//		 * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
//		 * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
//		 * <tt>0</tt>, or <tt>1</tt> according to whether the value of
//		 * <i>expression</i> is negative, zero or positive.<p>
//		 * <p>
//		 * The implementor must ensure that <tt>sgn(compare(x, y)) ==
//		 * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
//		 * implies that <tt>compare(x, y)</tt> must throw an exception if and only
//		 * if <tt>compare(y, x)</tt> throws an exception.)<p>
//		 * <p>
//		 * The implementor must also ensure that the relation is transitive:
//		 * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
//		 * <tt>compare(x, z)&gt;0</tt>.<p>
//		 * <p>
//		 * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
//		 * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
//		 * <tt>z</tt>.<p>
//		 * <p>
//		 * It is generally the case, but <i>not</i> strictly required that
//		 * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
//		 * any comparator that violates this condition should clearly indicate
//		 * this fact.  The recommended language is "Note: this comparator
//		 * imposes orderings that are inconsistent with equals."
//		 *
//		 * @param o1 the first object to be compared.
//		 * @param o2 the second object to be compared.
//		 * @return a negative integer, zero, or a positive integer as the
//		 * first argument is less than, equal to, or greater than the
//		 * second.
//		 * @throws NullPointerException if an argument is null and this
//		 *                              comparator does not permit null arguments
//		 * @throws ClassCastException   if the arguments' types prevent them from
//		 *                              being compared by this comparator.
//		 */
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			return o2-o1;
//		}
//	}

	public static class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val; 
		}

	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				heap.add(lists[i]);
			}
		}
		if (heap.isEmpty()) {
			return null;
		}
		ListNode head = heap.poll();
		ListNode pre = head;
		if (pre.next != null) {
			heap.add(pre.next);
		}
		while (!heap.isEmpty()) {
			ListNode cur = heap.poll();
			pre.next = cur;
			pre = cur;
			if (cur.next != null) {
				heap.add(cur.next);
			}
		}
		return head;
	}

}