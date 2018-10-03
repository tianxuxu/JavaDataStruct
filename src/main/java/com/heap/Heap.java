package main.java.com.heap;

import java.util.Arrays;

/*
 * 这里直接采用大根堆
 * 
 * 
 * */
public class Heap {

	private int[] array;
	// 堆中元素的个数
	private int count;
	// 堆的大小
	private int capacity;// 1 big
	// 堆的类型
	private int heap_type;

	public Heap(int capacity, int heap_type) {
		this.capacity = capacity;
		this.count = 0;
		this.heap_type = heap_type;//
		this.array = new int[capacity];
	}

	public int Parent(int i) {
		if (i < 0 || i > this.count) {
			return -1;
		}
		return (i - 1) / 2;
	}

	public int LeftChild(int i) {
		int left = 2 * i + 1;
		if (left >= this.count) {
			return -1;
		}
		return left;
	}

	public int RightChild(int i) {
		int right = 2 * i + 2;
		if (right >= this.count) {
			return -1;
		}
		return right;
	}

	public int GetMaxOrMum() {
		if (this.count == 0) {
			return -1;
		}

		return this.array[0];
	}

	public int GetMaxiMum(int i) {
		return 0;// 返回第几大（小）
	}

	public void PercolateDown(int i) {
		int left;
		int right;
		int max;
		int tmp;

		left = LeftChild(i);
		right = RightChild(i);

		if (left != -1) {
			if (this.array[left] > this.array[i]) {
				max = left;
			} else {
				max = i;
			}
			if (right != -1) {
				if (this.array[right] > this.array[max]) {
					max = right;
				}
			} else {
				return;
			}
		} else {
			return;
		}

		/*
		 * if(left!=-1&&this.array[left]>this.array[i]){ max=left; } else{
		 * max=i; }
		 * 
		 * if(right!=-1&&this.array[right]>this.array[max]){ max=right; }
		 */

		/// 不满足条件时交换
		if (max != i) {
			tmp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = tmp;
		} else {
			return;
		}
		PercolateDown(max);
	}

	public int DelMaxOrMum() {
		if (this.count == 0) {
			return -1;
		}
		int data = this.array[0];
		this.array[0] = this.array[count - 1];
		this.count--;

		PercolateDown(0);
		return data;
	}

	public void Insert(int data) {
		int i;
		if (this.count == this.capacity) {
			ResizeHeap();
		}
		this.count++;

		i = this.count - 1;// need per

		while (i >= 0 && data > this.array[(i - 1) / 2]) {
			this.array[i] = this.array[(i - 1) / 2];

			if (i == 0) {
				break;
			}
			i = (i - 1) / 2;
		}
		this.array[i] = data;

	}

	void ResizeHeap() {
		int[] oldArray = new int[this.capacity];
		if (this.count != 0) {
			System.arraycopy(array, 0, oldArray, 0, this.count - 1);
			if (this.array == null) {
				System.out.println("memory err");
				return;
			}
			for (int i = 0; i < this.capacity; i++) {
				this.array[i] = oldArray[i];
			}

		}
		this.array = new int[this.capacity * 2];
		this.capacity = this.capacity * 2;
		oldArray = null;
	}

	void DestoryHeap() {
		this.count = 0;
		this.array = null;
	}

	public void BuildHeap(Heap h, int A[], int n) {
		if (h == null) {
			h = new Heap(10, 1);
		}
		while (n > h.capacity) {
			h.ResizeHeap();
			System.out.println(n+"sHL" + h.capacity);
		}
		for (int i = 0; i < n; i++) {
			h.array[i] = A[i];
		}
		h.count = n;//
		for (int i = (n - 1) / 2; i >= 0; i--) {
			h.PercolateDown(i);
		}

	}

	public void HeapSort(int[] A, int n) {
		Heap h = new Heap(n, 1);
		int old_size;
		int i;
		int tmp;
		BuildHeap(h, A, n);
		System.out.println(Arrays.toString(h.array));
		old_size = h.count;
		int count = 0;
		for (i = n - 1; i > 0; i--) {// h.array[0]寸最大元素
			if (h.count == 0) {
				break;
			}
			// tmp=h.array[0];
			A[count++] = h.array[0];
			// System.out.println(tmp);

			h.array[0] = h.array[h.count - 1];

			h.count--;

			h.PercolateDown(0);
		}
		h.count = old_size;
		System.out.println(Arrays.toString(A));
	}
}
