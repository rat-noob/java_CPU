package org.example;

import org.example.CPU.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Command[] prog={
                new Command("init 10 20"),
                new Command("init 11 25"),
                new Command("ld 10 a"),
                new Command("ld 11 b"),
                new Command("add"),
                new Command("mv d a"),
                new Command("print")

        };


        ICPU cpu = BCPU.build();
        Executer exec = new Executer(cpu);
//
        try {
//
            exec.run(prog);
        }catch (CPUExceptions e){
            System.out.println(e.getMessage());
        }

    }
}