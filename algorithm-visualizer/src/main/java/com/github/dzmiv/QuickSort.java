package com.github.dzmiv;
import java.util.function.Consumer;

public class QuickSort extends SortVisualizer {
	
	public QuickSort(int[] arr, int delay, Consumer<ChartData> callback) {
		super(arr, delay, callback);

	}
	
	public void sort(int start, int end){
	       if(start >= end){
	           return;
	       }
	       int pivot = arr[start];
	       int left = start;
	       int right = end;
	       while(left < right){
	           while(left <= right && arr[left] <= pivot){
	               left++;
	           }
	           while(left <= right && arr[right] > pivot){
	               right --;
	           }
	           if(left < right){
	               int temp = arr[left];
	               arr[left] = arr[right];
	               arr[right] = temp;
	               stepCount++;
	               updateUI();
	               sleep();
	           }
	       }
	       arr[start] = arr[right];
	       arr[right] = pivot;
	       stepCount++;
	       updateUI();
	       sleep();

	       sort(start, right -1);
	       sort(right + 1, end);
	   }
	
	public void run() {
		sort(0, arr.length -1);
	}
}
