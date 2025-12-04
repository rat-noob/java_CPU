package org.example.cpu_lab_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class MainFrameController implements IObserver{

    Program pr = new Program();
//    ICPU cpu = BCPU.build();
Memory m = new Memory();
    CPU cpu = new CPU();
    Executer exec = new Executer(cpu);

    int index=0;
    @FXML
    GridPane allcommands;

    @FXML
    Label cm1;
    @FXML
    Label cm2;
    @FXML
    Label cm3;
    @FXML
    Label cm4;

    @FXML
    Label cnt1;
    @FXML
    Label cnt2;
    @FXML
    Label cnt3;
    @FXML
    Label cnt4;


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
        stat();
    }
    @FXML
    void runCommand() throws CPUExceptions {
        cpu.getHandler().add(new AExecuter()).add(new MemExecuter()).add(new HExecuter());
        cpu.runCommand(pr.getComm(index));

        index++;
        regController.setregs(cpu);
        memController.updateMemory(cpu.memory);

    }
    @FXML
    void initialize(){
        pr.addListener(this);
        cpu.setMemory(m);
//        cpu.setR1(0);
//        cpu.setR2(0);
//        cpu.setR3(0);
//        cpu.setR4(0);
//        regController.setregs(cpu);
//        memController.updateMemory(cpu.memory);
    }

    public void stat(){
        List<TypeCommand> result = pr.sorted_com();
        cm1.setText(result.get(0).toString());
        cnt1.setText(String.valueOf(pr.handl.get(result.get(1))));
        cm2.setText(result.get(1).toString());
        cnt2.setText(String.valueOf(pr.handl.get(result.get(2))));
        cm3.setText(result.get(2).toString());
        cnt3.setText(String.valueOf(pr.handl.get(result.get(3))));
        cm4.setText(result.get(3).toString());
        cnt4.setText(String.valueOf(pr.handl.get(result.get(4))));
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
