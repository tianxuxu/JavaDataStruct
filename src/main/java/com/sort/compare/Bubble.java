package main.java.com.sort.compare;

public class Bubble implements Sort{

	
	public void sort(int[] A, int length) {
		// TODO Auto-generated method stub
		for(int i=0;i<length;i++){
			for(int j=0;j<length-i-1;j++){
				if(A[j]>A[j+1]){
					int tmp=A[j];
					A[j]=A[j+1];
					A[j+1]=tmp;
				}
			}
		}
	}

	
}
