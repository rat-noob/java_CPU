package org.example.cpu_lab_4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RegFrameController {

    @FXML
    Label lrega;

    @FXML
    Label lregb;
    @FXML
    Label lregc;

    @FXML
    Label lregd;

    CPU cp;
    public void setregs(CPU proc){
        this.cp = proc;
//        proc.setR1(r1);
//        proc.setR2(r2);
//        proc.setR3(r3);
//        proc.setR4(r4);

        lrega.setText(Integer.toString(cp.getR1()));
        lregb.setText(Integer.toString(cp.getR2()));
        lregc.setText(Integer.toString(cp.getR3()));
        lregd.setText(Integer.toString(cp.getR4()));
    }
}
