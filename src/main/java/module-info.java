module com.example.mathlab {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.scripting;
    requires org.graalvm.js;
    requires com.ibm.icu;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.mathlab to javafx.fxml;
    exports com.example.mathlab;
}