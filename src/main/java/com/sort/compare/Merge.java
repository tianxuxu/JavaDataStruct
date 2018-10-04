package com.sort.compare;

public class Merge implements Sort {


	public void sort(int[] A, int length) {
		// TODO Auto-generated method stub

		int[] tmp = new int[length];
		MergeSort(A, tmp, 0, length - 1);
	}

	private void MergeSort(int[] A, int[] tmp, int left, int right) {
		int middle;
		if (left < right) {
			middle = (left + right) / 2;
			MergeSort(A, tmp, left, middle);// 左边递归
			MergeSort(A, tmp, middle + 1, right);
			MergeB(A, tmp, left, middle+1, right);
		}
	}

	private void MergeB(int[] A, int[] tmp, int left, int middle, int right) {
		int left_end = middle - 1;
		int size=right-left+1;
		int tmp_pos = left;

		while (left <= left_end && (middle <= right)) {
			if (A[left] <= A[middle]) {
				tmp[tmp_pos] = A[left];
				left++;
				tmp_pos++;
			} else {
				tmp[tmp_pos] = A[middle];
				middle++;
				tmp_pos++;
			}
		}

		while (left <= left_end) {
			tmp[tmp_pos] = A[left];
			left++;
			tmp_pos++;
		}

		while (middle <= right) {
			tmp[tmp_pos] = A[middle];
			middle++;
			tmp_pos++;
		}

		for(int i=0;i<size;i++){
			A[right]=tmp[right];
			right=right-1;
		}
	}
}
