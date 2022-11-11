module org.itique.indecy.ui {
    requires javafx.controls;
    requires javafx.fxml;

    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.itique.indecy.ui to javafx.fxml;
    exports org.itique.indecy.ui;
    exports org.itique.indecy.ui.controller;
    opens org.itique.indecy.ui.controller to javafx.fxml;
}