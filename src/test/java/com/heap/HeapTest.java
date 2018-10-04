package com.heap;

import java.util.Arrays;
import java.util.Random;

import main.java.com.heap.Heap;

public class HeapTest {

	@org.junit.Test
	public void Test(){
		Heap h=new Heap(20,1);
		Random random=new Random();
		int []A=new int[20];
		for(int i=0;i<20;i++){
			A[i]=Math.abs(random.nextInt()%100);
		}
		
		
		/*for(int i=0;i<5;i++){
			h.Insert(A[i]);
		}
		System.out.println(h.DelMaxOrMum());
		System.out.println(h.DelMaxOrMum());
		System.out.println(h.DelMaxOrMum());
		System.out.println(h.DelMaxOrMum());
		System.out.println(h.DelMaxOrMum());
		System.out.println(h.DelMaxOrMum());*/
		
		

		System.out.println(Arrays.toString(A));
		h.HeapSort(A, 18);//排序之后堆被破坏

	}
}
