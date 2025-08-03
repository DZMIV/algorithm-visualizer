package com.github.dzmiv;
import java.util.function.Consumer;

public class BubbleSort extends SortVisualizer {
	
	public BubbleSort(int[] arr, int delay, Consumer<ChartData> callback) {
		super(arr, delay, callback);
	}
	
	@Override
	public void run() {
		int l = arr.length;
		for(int i = 0; i < l -1; i++) {
			for( int k = 0; k < l - i - 1; k++) {
				if(arr[k] > arr[k + 1]) {
					int temp = arr[k];
	                arr[k] = arr[k + 1];
	                arr[k + 1] = temp;
	                stepCount++;
	                updateUI();
	                sleep();
				}
			}
		}
	}
}
