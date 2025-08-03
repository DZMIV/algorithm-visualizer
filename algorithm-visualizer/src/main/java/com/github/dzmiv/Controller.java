package com.github.dzmiv;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
	
	@FXML
	private Label errorLabel;
	@FXML
	private TextField sizeField;
	@FXML
	private TextField minField;
	@FXML
	private TextField maxField;
	@FXML 
	private Label insertionTime;
	@FXML 
	private Label insertionSteps;
	@FXML 
	private Label quickTime;
	@FXML 
	private Label quickSteps;
	@FXML 
	private Label bubbleTime;
	@FXML 
	private Label bubbleSteps;
	
	@FXML
	private LineChart<Number,Number> chart;
	
	private XYChart.Series<Number,Number> bubble = new XYChart.Series<>();
	private XYChart.Series<Number,Number> insertion = new XYChart.Series<>();
	private XYChart.Series<Number,Number> quick = new XYChart.Series<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bubble.setName("Bubble sort");
		insertion.setName("Insertion sort");
		quick.setName("Quick sort");
		chart.getData().addAll(bubble, insertion, quick);
		chart.setCreateSymbols(false);
		
		bubble.getData().add(new XYChart.Data<>(0, 0));
        insertion.getData().add(new XYChart.Data<>(0, 0));
        quick.getData().add(new XYChart.Data<>(0, 0));

	}
	
	@FXML
	private void handleStart(ActionEvent e) {
		try {
	        bubble.getData().clear();
	        insertion.getData().clear();
	        quick.getData().clear();
	        bubble.getData().add(new XYChart.Data<>(0, 0));
	        insertion.getData().add(new XYChart.Data<>(0, 0));
	        quick.getData().add(new XYChart.Data<>(0, 0));

	        executeSort();
	    } catch (NumberFormatException ex) {}
	}

	public void executeSort() {
		
		
		try {
			int size = Integer.parseInt(sizeField.getText());
			int max = Integer.parseInt(maxField.getText());
			
			if (size >= 200) {
		        throw new IllegalArgumentException("Size must be less than 200.");
		    }
			
			int[] randomArray = generateArray(size,0,max);
			errorLabel.setText("");

			BubbleSort bubbleSort = new BubbleSort(randomArray.clone(), 1, new Consumer<ChartData>() {
			    @Override
			    public void accept(ChartData dataPoint) {
			        bubble.getData().add(new XYChart.Data<>(dataPoint.getTimeElapsed(), dataPoint.getStepCount()));
			    }
			});
			
			InsertionSort insertionSort = new InsertionSort(randomArray.clone(), 1, new Consumer<ChartData>() {
			    @Override
			    public void accept(ChartData dataPoint) {
			        insertion.getData().add(new XYChart.Data<>(dataPoint.getTimeElapsed(), dataPoint.getStepCount()));
			    }
			});

			QuickSort quicksort = new QuickSort(randomArray.clone(), 1, new Consumer<ChartData>() {
			    @Override
			    public void accept(ChartData dataPoint) {
			        quick.getData().add(new XYChart.Data<>(dataPoint.getTimeElapsed(), dataPoint.getStepCount()));
			    }
			});
			Thread quickThread = new Thread(new Runnable() {
			    @Override
			    public void run() {
			        quicksort.run();  // triggers updates and stores lastData
			        ChartData finalData = quicksort.lastData;  // access after run

			        if (finalData != null) {
			            Platform.runLater(new Runnable() {
			                @Override
			                public void run() {
			                    quickTime.setText(Math.round(finalData.getTimeElapsed()) + "ms");
			                    quickSteps.setText(finalData.getStepCount() + "");
			                }
			            });
			        }
			    }
			});
			Thread insertionThread = new Thread(new Runnable() {
			    @Override
			    public void run() {
			        insertionSort.run();  
			        ChartData finalData = insertionSort.lastData;  

			        if (finalData != null) {
			            Platform.runLater(new Runnable() {
			                @Override
			                public void run() {
			                    insertionTime.setText(Math.round(finalData.getTimeElapsed()) + "ms");
			                    insertionSteps.setText(finalData.getStepCount() + "");
			                }
			            });
			        }
			    }
			});
			Thread bubbleThread = new Thread(new Runnable() {
			    @Override
			    public void run() {
			        bubbleSort.run();  
			        ChartData finalData = bubbleSort.lastData;  

			        if (finalData != null) {
			            Platform.runLater(new Runnable() {
			                @Override
			                public void run() {
			                    bubbleTime.setText(Math.round(finalData.getTimeElapsed()) + "ms");
			                    bubbleSteps.setText(finalData.getStepCount() + "");
			                }
			            });
			        }
			    }
			});
			quickThread.setDaemon(true);
			quickThread.start();
			insertionThread.setDaemon(true);
			insertionThread.start();
			bubbleThread.setDaemon(true);
			bubbleThread.start();
			
			new Thread(bubbleSort).start();
			new Thread(insertionSort).start();
			new Thread(quicksort).start();
		} catch (NumberFormatException e) {
			errorLabel.setText("Error: Invalid Input.");
			
		} catch(IllegalArgumentException e) {
			errorLabel.setText("Error: Array must be less than 200.");
		}
	}
	
	public int[] generateArray(int size, int min, int max) {
		Random rand = new Random();
		int[] array = new int[size];
		
		for(int i = 0; i < size; i++) {
			array[i] = rand.nextInt(max - min + 1) + min;
		}
		return array;
	}
}
