module com.example.lotto.lotto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lotto.lotto to javafx.fxml;
    exports com.example.lotto.lotto;
}