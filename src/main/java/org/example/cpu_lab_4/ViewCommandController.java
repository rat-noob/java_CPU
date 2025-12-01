package org.example.cpu_lab_4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ViewCommandController {
    @FXML
    Label lcommand;

    @FXML
    Label lpar1;

    @FXML
    Label lpar2;

    Program prog = new Program();
    Command cm;

    public void setCommand(Command c){
        this.cm = c;

        switch (cm.command){
            case mv -> {
                lcommand.setText(cm.getCommand().toString());
                lpar1.setText(cm.r1);
                lpar2.setText(cm.r2);
            }
            case init -> {
                lcommand.setText(cm.getCommand().toString());
                lpar1.setText(Integer.toString(cm.val1));
                lpar2.setText(Integer.toString(cm.val2));
            }
            case ld, st ->{
                lcommand.setText(cm.getCommand().toString());
                lpar1.setText(cm.r1);
                lpar2.setText(Integer.toString(cm.val2));
            }
            default -> {
                lcommand.setText(cm.getCommand().toString());
            }
        }
    }
    @FXML
    public void removeCommand(Command c1){
        prog.removeCommand(c1);
    }

    @FXML
    public void del(){
        prog.removeCommand(cm);

    }
}
