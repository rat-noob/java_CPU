package org.example.cpu_lab_4;

import java.util.Objects;
import jakarta.persistence.*;


@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "CommandCommands")//??
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "Command", nullable = false)
    String strcom;

    TypeCommand command;
    int val1;
    int val2;
    String r1;
    String r2;



//a
    public Command(TypeCommand command) {

        this.command = command;
    }

//    public Command(Command com){
//        this.command = com.command;
//        this.r1 = com.r1;
//        this.r2= com.r2;
//        this.val1= com.val1;
//        this.val2= com.val2;
//    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Command(String str) {
        strcom = str;
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
    public Command(int id,String str) {
        strcom = str;
        this.id= id;
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

    public Command() {
    }

    public TypeCommand getCommand() {
        return command;
    }
    public String getStrcom(){return  strcom;}

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Command{" +
                "command=" + command +
                ", id=" + id +
                ", val1=" + val1 +
                ", val2=" + val2 +
                ", r1='" + r1 + '\'' +
                ", r2='" + r2 + '\'' +
                '}';
    }
}

