package main.java.com.sort.compare;

import main.java.com.heap.Heap;

public class HeapSort implements Sort{

	@Override
	public void sort(int[] A, int length) {
		// TODO Auto-generated method stub
		Heap heap=new Heap(10,1);
		heap.HeapSort(A, length);
	}

	
}
