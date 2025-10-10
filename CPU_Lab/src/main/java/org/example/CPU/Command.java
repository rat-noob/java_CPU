package org.example.CPU;

import java.util.Objects;

public class Command {
    TypeCommand command;
    int val1;
    int val2;
    char r1;
    char r2;


//a
    public Command(TypeCommand command) {

        this.command = command;
    }

    //init
    public Command(TypeCommand command, int val1, int val2) {
        this.command = command;
        this.val1 = val1;
        this.val2 = val2;
    }
    //st
    public Command(TypeCommand command, char r1, int val1) {
        this.command = command;
        this.val1 = val1;
        this.r1 = r1;
    }
    public Command(TypeCommand command, int val1 , char r1 ) {
        this.command = command;
        this.val1 = val1;
        this.r1 = r1;
    }
    //mv
    public Command(TypeCommand command, char r1, char r2) {
        this.command = command;
        this.r2 = r2;
        this.r1 = r1;
    }



    public TypeCommand getCommand() {
        return command;
    }



}
