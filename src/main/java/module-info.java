module org.example.cpu_lab_4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires javafx.graphics;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens org.example.cpu_lab_4 to javafx.fxml,org.hibernate.orm.core;
    opens org.example.test_db to org.hibernate.orm.core;
    exports org.example.cpu_lab_4;
    exports org.example.test_db;


    // Зависимости от Hibernate и Jakarta Persistence
    requires java.naming;
    requires org.slf4j;
    requires jakarta.persistence;
}