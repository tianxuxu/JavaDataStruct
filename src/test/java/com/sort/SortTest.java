package com.sort;

import com.sort.compare.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;




//only compare sort
public class SortTest {

	@Test
	public void BubbleSort(){
		
		Random random=new Random();
		int []A=new int[20];
		for(int i=0;i<20;i++){
			A[i]=Math.abs(random.nextInt()%100);
		}
		System.out.println(Arrays.toString(A));
		BeanFactory beanFactory=new BeanFactory();
		Sort sort=beanFactory.getBean(Bubble.class);
		sort.sort(A, A.length);
		System.out.println("BubbleSort\n"+Arrays.toString(A));
	}
	
	@Test
	public void QuickSort(){//has else
		
		Random random=new Random();
		int []A=new int[20];
		for(int i=0;i<20;i++){
			A[i]=Math.abs(random.nextInt()%100);
		}
		System.out.println(Arrays.toString(A));
		BeanFactory beanFactory=new BeanFactory();
		Sort sort=beanFactory.getBean(Quick.class);
		//sort.sort(A, A.length);
		System.out.println("QuickSort\n"+Arrays.toString(A));
	}
	
	@Test
	public void SelectSort(){
		
		Random random=new Random();
		int []A=new int[20];
		for(int i=0;i<20;i++){
			A[i]=Math.abs(random.nextInt()%100);
		}
		System.out.println(Arrays.toString(A));
		BeanFactory beanFactory=new BeanFactory();
		Sort sort=beanFactory.getBean(Select.class);
		sort.sort(A, A.length);
		System.out.println("SelectSort\n"+Arrays.toString(A));
	}
	@Test
	public void HeapSort(){//error
		
		Random random=new Random();
		int []A=new int[20];
		for(int i=0;i<20;i++){
			A[i]=Math.abs(random.nextInt()%100);
		}
		System.out.println(Arrays.toString(A));
		BeanFactory beanFactory=new BeanFactory();
		Sort sort=beanFactory.getBean(com.sort.compare.HeapSort.class);
		sort.sort(A, A.length);
		System.out.println("HeapSort\n"+Arrays.toString(A));
	}
	
	@Test
	public void InsertSort(){
		
		Random random=new Random();
		int []A=new int[20];
		for(int i=0;i<20;i++){
			A[i]=Math.abs(random.nextInt()%100);
		}
		System.out.println(Arrays.toString(A));
		BeanFactory beanFactory=new BeanFactory();
		Sort sort=beanFactory.getBean(Insert.class);
		sort.sort(A, A.length);
		System.out.println("InsertSort\n"+Arrays.toString(A));
	}
	
	@Test
	public void MergeSort(){//has else
		
		Random random=new Random();
		int []A=new int[20];
		for(int i=0;i<20;i++){
			A[i]=Math.abs(random.nextInt()%100);
		}
		System.out.println(Arrays.toString(A));
		BeanFactory beanFactory=new BeanFactory();
		Sort sort=beanFactory.getBean(Merge.class);
		sort.sort(A, A.length);
		System.out.println("MergeSort\n"+Arrays.toString(A));
	}
	
	@Test
	public void ShellSort(){//error
		
		Random random=new Random();
		int []A=new int[20];
		for(int i=0;i<20;i++){
			A[i]=Math.abs(random.nextInt()%100);
		}
		System.out.println(Arrays.toString(A));
		BeanFactory beanFactory=new BeanFactory();
		Sort sort=beanFactory.getBean(Shell.class);
		//sort.sort(A, A.length);
		System.out.println("ShellSort\n"+Arrays.toString(A));
	}
}
