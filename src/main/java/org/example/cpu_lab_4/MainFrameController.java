package org.example.cpu_lab_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainFrameController implements IObserver{

    Program pr = new Program();

    @FXML
    GridPane allcommands;

    @FXML
    TextField Fcom;

    @FXML
    void addCommand(){
        Command c = new Command(Fcom.getText());
        pr.add(c);
    }
    @FXML
    void initialize(){
        pr.addListener(this);
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
                cc.setCommand(c);
                allcommands.addColumn(0,pane);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
