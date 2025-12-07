package org.example.cpu_lab_4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Collections;

public class ViewCommandController {
    @FXML
    Label lcommand;

    @FXML
    Label lpar1;

    @FXML
    Label lpar2;

    Program prog;
    Command cm;

    public void setCommand(Command c,Program program){
        this.cm = c;
        this.prog=program;

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
    public void moveup(){
        int index= prog.comarr.indexOf(cm);
        Collections.swap(prog.comarr,index,index-1);
        prog.event();
    }
    @FXML
    public void movedown(){
        int index= prog.comarr.indexOf(cm);
        Collections.swap(prog.comarr,index,index+1);
        prog.event();
    }
    @FXML
    public void removeCommand(Command c1){
        prog.removeCommand(c1);
    }

    @FXML
    public void del(){
        prog.removeCommand(cm);

    }
    @FXML
    public void highlightLabel() {
            lcommand.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
    }
}
