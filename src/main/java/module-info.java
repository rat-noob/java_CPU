module org.example.cpu_lab_4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires javafx.graphics;

    opens org.example.cpu_lab_4 to javafx.fxml;
    exports org.example.cpu_lab_4;
}