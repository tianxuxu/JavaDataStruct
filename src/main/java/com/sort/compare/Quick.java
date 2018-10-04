package com.sort.compare;

public class Quick implements Sort {

	public void sort(int[] A, int length) {
		// TODO Auto-generated method stub
		QuickSort(A, 0, length - 1);
	}

	private void QuickSort(int[] A, int i, int j) {
		// TODO Auto-generated method stub
		int pivot;
		if (i < j) {
			pivot = Partition(A, i, j);
			QuickSort(A, i, pivot - 1);
			QuickSort(A, pivot + 1, j);
		}
	}

	private int Partition(int[] A, int low, int high) {
		// TODO Auto-generated method stub
		int tmp = A[low];
	
		while (low < high) {
			// 当item<p 移动左边指针
			while (low < high && A[high] > tmp) {
				high--;
			}
			A[low] = A[high];
			// 当item>p移动右指针
			while (low < high && A[low] < tmp) {
				low++;
			}
			A[high] = A[low];
		}
		A[low] = tmp;
		return low;
	}

}
