package org.example.CPU;

import java.util.Objects;




public class Command {
    TypeCommand command;
    int val1;
    int val2;
    String r1;
    String r2;


//a
    public Command(TypeCommand command) {

        this.command = command;
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Command(String str) {

        String[] parts = str.split(" ");
        this.command= TypeCommand.valueOf(parts[0]);
        if(parts.length!=1) {
            if (isInteger(parts[1])) {
                this.val1 = Integer.parseInt(parts[1]);
            } else {
                this.r1 = parts[1];
            }
            if (isInteger(parts[2])) {
                this.val2 = Integer.parseInt(parts[2]);
            } else {
                this.r2 = parts[2];
            }
        }
    }

    //init
    public Command(TypeCommand command, int val1, int val2) {
        this.command = command;
        this.val1 = val1;
        this.val2 = val2;
    }
    //st
    public Command(TypeCommand command, String r1, int val1) {
        this.command = command;
        this.val1 = val1;
        this.r1 = r1;
    }
    //ld    если все сломается поменять this.r2 = r2 на this.r1=r2
    public Command(TypeCommand command, int val1 , String r2 ) {
        this.command = command;
        this.val1 = val1;
        this.r2 = r2;
    }
    //mv
    public Command(TypeCommand command, String r1, String r2) {
        this.command = command;
        this.r2 = r2;
        this.r1 = r1;
    }



    public TypeCommand getCommand() {
        return command;
    }



}

