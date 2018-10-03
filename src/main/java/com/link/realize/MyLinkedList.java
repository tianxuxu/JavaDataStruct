package main.java.com.link.realize;

import java.util.Iterator;

import main.java.com.link.base.ListNode;


public class MyLinkedList{

	private ListNode headNode=null;
	public Iterator iterator(){
		return new Itr();
	}
	private class Itr implements Iterator{

		private int cnt=0;

		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			int size=ListLength();
			
			return size>cnt+1?true:false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			cnt++;//..................去下一个元素
			return null;
		}
		
	} 
	public int ListLength() {
		// TODO Auto-generated method stub
		int length=0;
		ListNode  node=headNode;
		while(node!=null){
			node=node.getNext();
			length++;
		}
		return length;
	}

	
	public ListNode InsertInLinkedList(ListNode nodeToInset, int postion) {
		// TODO Auto-generated method stub
		if(headNode==null){
			return nodeToInset;
		}//若链表为空直接插入
		int size=ListLength();
		if(postion<1 || postion>size+1){
			System.out.println("Postion invalid");
			return headNode;
		}
		if(postion==1){
			nodeToInset.setNext(headNode);
			headNode=nodeToInset;
			return headNode;
		}
		ListNode node=headNode;
		for(int i=1;i<postion-1;i++){
			node=node.getNext();
		}
		ListNode currentNode=node.getNext();
		nodeToInset.setNext(currentNode);
		node.setNext(nodeToInset);
		return headNode;
	}

	
	public ListNode InsertHeadLinkedList(ListNode nodeToInset) {
		// TODO Auto-generated method stub
		headNode=InsertInLinkedList(nodeToInset, 1);
		return headNode;
	}

	public ListNode InsertTailLinkedList(ListNode headNode, ListNode nodeToInset) {
		// TODO Auto-generated method stub
		int size=ListLength();
		headNode=InsertInLinkedList(nodeToInset,size);
		return headNode;
	}

	
	public ListNode DeleteNodeInLinkedList( int postion) {
		// TODO Auto-generated method stub
		int size=ListLength();
		if(postion<1||postion>size){
			System.out.println("del postion invalid");
			return headNode;
		}
		if(postion==1){
			ListNode currentNode=headNode.getNext();
			headNode=currentNode;
			return currentNode;
		}
		ListNode previousNode=headNode;
		for(int i=1;i<postion;i++){
			previousNode=previousNode.getNext();
		}
		ListNode currentNode=previousNode.getNext();
		previousNode.setNext(currentNode.getNext());
		return headNode;
		
	}

	
	public ListNode DeleteNodeHeadLinkedList() {
		// TODO Auto-generated method stub
		return DeleteNodeInLinkedList(1);
	}

	
	public ListNode DeleteNodeTailLinkedList(ListNode headNode) {
		// TODO Auto-generated method stub
		return DeleteNodeInLinkedList(ListLength());
	}

	
	public ListNode DeleteNodeLinkedList() {
		// TODO Auto-generated method stub
		ListNode iterator=headNode;
		ListNode auxilaryNode=null;
		while(iterator!=null){
			auxilaryNode=iterator.getNext();
			iterator=null;
			iterator=auxilaryNode;
		}
		return null;
	}

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder("LinkedList:[");
		ListNode iterator=headNode;
		while(iterator!=null){
			stringBuilder.append(iterator.getData()+",");
			iterator=iterator.getNext();
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
