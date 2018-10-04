package com.sort.compare;

public class Shell implements Sort{


	public void sort(int[] A, int length) {
		// TODO Auto-generated method stub
		int i;
		int j;
		int k;
		int tmp;
		int h=1;
		for(h=1;h<length/9;h=3*h+1);
		for(;h>0;h=h/3){
			for(j=h;j<=length;j+=1){
				tmp=A[j];
				for(k=j-h;k>=0;k-=h){
					if(A[k]>tmp){
						A[k+h]=A[k];
					}else{
						break;
					}
				}
				
				A[k+h]=tmp;
			}
		}
	}

}
