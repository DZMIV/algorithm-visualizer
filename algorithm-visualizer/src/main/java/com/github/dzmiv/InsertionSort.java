package com.github.dzmiv;
import java.util.function.Consumer;

public class InsertionSort extends SortVisualizer{

	public InsertionSort(int[] arr, int delay, Consumer<ChartData> callback) {
		super(arr, delay, callback);
	}
	
	@Override
	public void run() {
        int l = arr.length;
        for(int i = 1; i < l; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
                stepCount++;
                updateUI();
                sleep();
            }
        arr[j+1] = key;
        stepCount++;
        updateUI();
        sleep();
        }
    }
}
