package com.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class HashTableTest {
	
	@Test
	public void test(){//删除有问题
		HashTable hashTable=HashTableOperations.createHashTable(10);
		Random random=new Random();
		int []A=new int[40];
		for(int i=0;i<6;i++){
			A[i]=Math.abs(random.nextInt()%100);
		}
		System.out.println(Arrays.toString(A));
		//for(int i=0;i<10;i++){
			HashTableOperations.hashInsert(hashTable, A[5]);
		//}
		int flags=HashTableOperations.hashSerch(hashTable, A[5]);
		System.out.println("BeforeDeleteflags:"+flags);
		HashTableOperations.hashDelete(hashTable, A[5]);
		flags=HashTableOperations.hashSerch(hashTable, A[5]);
		System.out.println("AfteDeleteflags:"+flags);
	}

}
