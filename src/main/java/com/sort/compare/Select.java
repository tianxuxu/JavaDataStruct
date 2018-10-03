package main.java.com.sort.compare;

public class Select implements Sort{

	@Override
	public void sort(int[] A, int length) {
		// TODO Auto-generated method stub
		int index;//minidex
		int i;
		int j;
		for(i=0;i<length-1;i++){
			index=i;
			for(j=i+1;j<length;j++){
				if(A[j]<A[index]){
					index=j;
				}
			}
			if(index!=i){
				int tmp=A[index];
				A[index]=A[i];
				A[i]=tmp;
			}
		}
	}

	
}
