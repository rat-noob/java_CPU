package org.example;

import org.example.CPU.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


//        Command[] prog={
//                new Command("init 10 20"),
//                new Command("init 11 25"),
//                new Command("ld 10 a"),
//                new Command("ld 11 b"),
//                new Command("add"),
//                new Command("mv d a"),
//                new Command("print")
//
//        };
        Program progr = new Program();

        progr.add(new Command("init 10 20"));
        progr.add(new Command("init 11 25"));
        progr.add(new Command("ld 10 a"));
        progr.add(new Command("ld 11 b"));
        progr.add(new Command("add"));
        progr.add(new Command("mv d a"));
        progr.add(new Command("print"));

        for(Command command: progr) System.out.println(command);


        ICPU cpu = BCPU.build();
        Executer exec = new Executer(cpu);
//
        try {
//
            exec.run(progr);
        }catch (CPUExceptions e){
            System.out.println(e.getMessage());
        }

    }
}