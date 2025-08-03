package com.github.dzmiv;

public class ChartData {
    private final double timeElapsed;
    private final int stepCount;

    public ChartData(double timeElapsed, int stepCount) {
        this.timeElapsed = timeElapsed;
        this.stepCount = stepCount;
    }
    public double getTimeElapsed() {
        return timeElapsed;
    }
    public int getStepCount() {
        return stepCount;
    }
}