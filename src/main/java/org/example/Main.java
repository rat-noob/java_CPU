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


//        Command init1= new Command("init 10 20");
//        Command init2= new Command("init 11 25");
//        Command ld1  = new Command("ld 10 a");
//        Command ld2  = new Command("ld 11 b");
//        Command add1 = new Command("add");
//        Command mv = new Command("mv d a");
//        Command print = new Command("print");


        ICPU cpu = BCPU.build();
        Executer exec = new Executer(cpu);
//        try {
//            cpu.runCommand(init1);
//            cpu.runCommand(init2);
//            cpu.runCommand(ld1);
//            cpu.runCommand(ld2);
//            cpu.runCommand(add1);
//            cpu.runCommand(mv);
//            cpu.runCommand(print);
//        } catch (CPUExceptions e) {
//            System.out.println(e.getMessage());
//        }
        try {
//            cpu.runCommand(prog);
            exec.run(prog);
        }catch (CPUExceptions e){
            System.out.println(e.getMessage());
        }

    }
}