package org.example.cpu_lab_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainFrameController implements IObserver{

    Program pr = new Program();
//    ICPU cpu = BCPU.build();
    CPU cpu = new CPU();
    Executer exec = new Executer(cpu);
    Memory m = new Memory();
    int index=0;
    @FXML
    GridPane allcommands;

    @FXML
    TextField Fcom;
    @FXML
    Pane panereg;
    @FXML
    private RegFrameController regController;
    @FXML
    private MemFrameController memController;

    @FXML
    void addCommand(){
        Command c = new Command(Fcom.getText());
        pr.add(c);
    }
    @FXML
    void runCommand() throws CPUExceptions {
        cpu.runCommand(pr.getComm(index));

        index++;
        regController.setregs(cpu);

    }
    @FXML
    void initialize(){
        pr.addListener(this);
        cpu.setR1(0);
        cpu.setR2(0);
        cpu.setR3(0);
        cpu.setR4(0);
        regController.setregs(cpu);
    }

    @Override
    public void event() {
        allcommands.getChildren().clear();

        for(Command c: pr){
            ViewCommandController cc = new ViewCommandController();
            FXMLLoader fxmlLoader = new FXMLLoader(
                    MainFrameController.class.getResource("ViewCommand.fxml"));
            fxmlLoader.setController(cc);
            try{
                Pane pane = fxmlLoader.load();
                cc.setCommand(c,pr);
                allcommands.addColumn(0,pane);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
