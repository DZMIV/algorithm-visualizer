module com.github.dzmiv {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.github.dzmiv to javafx.fxml;
    exports com.github.dzmiv;
}
