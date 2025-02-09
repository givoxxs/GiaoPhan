package Tuan2;

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) {this.val = val;}
	ListNode(int val, ListNode next) { 
		this.val = val; 
		this.next = next; 
	}
}

public class Merge2SortedLists {
	public ListNode mergoTwoLists(ListNode list1, ListNode list2) {
		ListNode temp = new ListNode();
		ListNode current = temp;
		
		while(list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				current.next = list1;
				list1 = list1.next;
			} else {
				current.next = list2;
				list2 = list2.next;
			}
			
			current = current.next;
		}
		
		if (list1 != null ) {
			current.next = list1;
		} else {
			current.next = list2;
		}
		
		return temp.next;
	}
}
