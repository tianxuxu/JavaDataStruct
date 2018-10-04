package com.hash;

public class HashTableOperations {

	public final static int LOADFATOR = 5;

	public static HashTable createHashTable(int size) {// on
		HashTable h = new HashTable();
		h.setSize(size / LOADFATOR);
		h.setCount(0);
		/*
		 * HashTableNode[] htbs=new HashTableNode[size]; for(int
		 * i=0;i<size;i++){ htbs[i]=new HashTableNode();
		 * htbs[i].setBlockCount(0); htbs[i].setStartNode(null); }
		 * h.setTable(htbs);;
		 */
		for (int i = 0; i < h.getSize(); i++) {
			h.getTable()[i].setStartNode(null);
		}
		return h;
	}

	public static int hashSerch(HashTable h, int data) {
		int key = hash(data, h.getSize());
		HashTableNode hashTableNode = h.getTable()[key];
		ListNode tmpNode = hashTableNode.getStartNode();
		while (tmpNode != null) {
			if (tmpNode.getData() == data) {
				return 1;
			} else {
				tmpNode = tmpNode.getNext();
			}
		}
		return -1;
	}

	public static void hashInsert(HashTable h, int data) {
		int key = hash(data, h.getSize());
		HashTableNode hashTableNode = h.getTable()[key];
		int flags = HashTableOperations.hashSerch(h, data);
		if (flags > 0) {
			return;
		}
		ListNode startNode = hashTableNode.getStartNode();

		ListNode newNode = new ListNode();
		newNode.setData(data);
		newNode.setKey(key);
		newNode.setNext(startNode);

		hashTableNode.setStartNode(newNode);
		hashTableNode.setBlockCount(hashTableNode.getBlockCount() + 1);
		if(h.getCount()/h.getSize()>LOADFATOR){
			rehash(h);
		}
		
	}

	public static boolean hashDelete(HashTable h, int data) {//删不掉
		if (hashSerch(h, data) < 0) {
			return false;
		}
		int key = hash(data, h.getSize());
		HashTableNode htNode = h.getTable()[key];
		ListNode tmpNode = htNode.getStartNode();
		ListNode SNode = htNode.getStartNode();
		ListNode previousNode = null;
		while (tmpNode != null) {
			if (tmpNode.getData() == data) {
				if (previousNode != null) {
					previousNode.setNext(tmpNode.getNext());
				}
				
				tmpNode = null;
				htNode.setBlockCount(htNode.getBlockCount() - 1);
				//htNode.setStartNode(SNode);
				h.setCount(h.getCount() - 1);
				System.out.println("has Delete" + data);
				if(htNode.getStartNode()==null){
					System.out.println("OK");
				}
				return true;
			}
			previousNode = tmpNode;
			tmpNode = tmpNode.getNext();
		}

		
		return true;
	}

	public static void rehash(HashTable h) {
		int oldSize=h.getSize();
		ListNode tmp;
		HashTableNode oldTable[]=h.getTable();
		HashTableNode htNode;
		h=new HashTable();
		h.setSize(oldSize*2);
		for(int i=0;i<oldSize;i++){
			for(tmp=oldTable[i].getStartNode();tmp!=null;tmp=tmp.getNext()){
				int index=hash(tmp.getData(),h.getSize());//需要从新计算
				ListNode currentNode=tmp;
				
				htNode=h.getTable()[i];
				currentNode.setNext(htNode.getStartNode().getNext());
				htNode=h.getTable()[index];
				htNode.getStartNode().setNext(currentNode);
				
			
				
				
			}
		}
		
	}

	private static int hash(int data, int len) {
		return data % len;
	}
}
