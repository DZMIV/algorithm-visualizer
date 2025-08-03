package com.github.dzmiv;
import java.util.function.Consumer;
import javafx.application.Platform;

public abstract class SortVisualizer implements Runnable {
	protected int[] arr;
	protected int delay;
	protected Consumer<ChartData> callback;
	protected int stepCount; 
	protected long startTime;
	protected ChartData lastData;
	
	public SortVisualizer(int[] arr, int delay, Consumer<ChartData> callback) {
		this.arr = arr;
		this.delay = delay;
		this.callback = callback;
		this.stepCount = 0;
		this.startTime = System.nanoTime();
	}
	
	protected void sleep() {
		try {
			Thread.sleep(delay);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	protected void updateUI() {
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	long elapsedTime = System.nanoTime() - startTime;
		    	double elapsedMs = elapsedTime / 1000000.0;
		    	lastData = new ChartData(elapsedMs, stepCount);
		        callback.accept(lastData);
		    }
		});
	}

	@Override
	public abstract void run();
}
