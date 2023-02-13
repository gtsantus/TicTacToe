module aber.ac.uk.tictactoevone {
    requires javafx.controls;
    requires javafx.fxml;


    opens aber.ac.uk.tictactoe to javafx.fxml;
    exports aber.ac.uk.tictactoe;
}