module com.example.projet_toupie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projet_toupie to javafx.fxml;
    exports com.example.projet_toupie;
}