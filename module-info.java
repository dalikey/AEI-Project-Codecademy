module AEI.Project.Codecademy {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires jdk.jfr;
    requires org.junit.jupiter.api;

    opens programma.domain to javafx.graphics, javafx.fxml, javafx.base;
    opens programma.ui to javafx.graphics, javafx.fxml, javafx.base;

}