module com.mycompany.cadastrocliente {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;

    // abre para o FXMLLoader e para o Gson
    opens com.mycompany.cadastrocliente to javafx.fxml, com.google.gson;

    exports com.mycompany.cadastrocliente;
}
