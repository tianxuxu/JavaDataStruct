package com.link;



import main.java.com.link.base.ListNode;
import main.java.com.link.realize.MyLinkedList;
import org.junit.Test;

public class MyLinkedListTest {

	@Test
	public void test() {
		
		MyLinkedList list=new MyLinkedList();
		for(int i=1;i<10;i++){
			ListNode node=new ListNode(i);
			list.InsertHeadLinkedList(node);
		}
		System.out.println(list);
		list.DeleteNodeHeadLinkedList();
		System.out.println(list);
		list.DeleteNodeInLinkedList(5);
		System.out.println(list);
		list.InsertInLinkedList(new ListNode(5), 3);
		System.out.println(list);
	}

}
