# Sorting Visualizer

This is a sorting algorithm speed visualizer built with JavaFX and CSS. It allows users to compare the performance of various sorting algorithms side-by-side on a dynamically updating chart. The application is structured using Apache Maven, and the user interface was designed using Gluon's SceneBuilder.

You do not need to have Apache Maven installed to run the application — just download the packaged release or run it through your IDE.

## Features
- Visualizes Bubble Sort, Insertion Sort, and Quick Sort simultaneously on a live-updating chart.
- Customizable array size, minimum value, and maximum value inputs (with validation).
- Displays real-time performance metrics: sorting time and number of steps.
- Toggle between Light and Dark themes dynamically.
- Responsive UI using background threads for sorting algorithms.

## Getting Started

### Prerequisites
- Java 17 or later
- JavaFX SDK 24 (or compatible version)
- Make sure JavaFX libraries are properly set up in your build environment.

### Running the Application

#### Option 1: Through an IDE
1. Clone the repository:
   ```bash
   git clone https://github.com/DZMIV/algorithm-visualizer.git
   cd algorithm-visualizer

2. Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).
   
3. Run the Main class located in:
   ```bash
   src/main/java/com/github/dzmiv/Main.java
#### Option 2: With Maven
1. If you have Maven installed, you can run the application directly from the terminal:
   ```bash
   mvn clean javafx:run
## Notes
This project does not follow any formal software design patterns. The primary goal was to focus on learning and experimenting with JavaFX to build an interactive UI for future projects. Design patterns may be introduced in later versions as I deepen my understanding.










