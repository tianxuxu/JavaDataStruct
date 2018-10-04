package com.sort.compare;

public class Insert implements Sort {


	public void sort(int[] A, int length) {
		// TODO Auto-generated method stub

		int tmp;
	int j;
		for(int i=1;i<length;i++){
			tmp=A[i];
			for(j=i-1;j>=0;j--){
				if(A[j]>tmp){
					A[j+1]=A[j];
				}
				else{//A[j]>A[j-1]  
					break;
				}
			}
			A[j+1]=tmp;
		}
	}

}
