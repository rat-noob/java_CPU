package org.example.cpu_lab_4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MemFrameController {
    @FXML
    private GridPane memoryGrid;

    private Label[][] memoryCells = new Label[10][5];
    @FXML
     void initialize() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 5; col++) {
                Label label = new Label("0");
                label.setMinWidth(30);
                label.setMinHeight(5);
                label.setStyle("-fx-alignment: center; -fx-border-color: gray; -fx-padding: 3;");
                memoryGrid.add(label, col, row );
                memoryCells[row][col] = label;
            }
        }
    }

    public void updateMemoryValue(int row, int col, String value) {
            memoryCells[row][col].setText(value);
    }
    public void updateMemory(Memory memory){
        for(int row=0; row<10;row++){
            for (int col = 0; col<5;col++){
                int elem = memory.mem[row*5+col];
                memoryCells[row][col].setText(Integer.toString(elem));
            }
        }
    }
}
