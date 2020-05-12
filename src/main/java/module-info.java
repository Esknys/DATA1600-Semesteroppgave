
module com.sample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sample.controllers to javafx.fxml;
    opens com.sample.car to javafx.base;

    exports com.sample;
}