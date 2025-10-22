package org.example;

import org.example.CPU.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Command init1= new Command(TypeCommand.init,10,20);
//        Command init2= new Command(TypeCommand.init,11,25);
//        Command ld1  = new Command(TypeCommand.ld,'a',10);
//        Command ld2  = new Command(TypeCommand.ld,'b',11);
//        Command add1 = new Command(TypeCommand.add);
//        Command mv = new Command(TypeCommand.mv,'d','a');
//        Command print = new Command(TypeCommand.print);

        Command[] prog={
                new Command("init 10 20"),
                new Command("init 11 25"),
                new Command("ld 10 a"),
                new Command("ld 11 b"),
                new Command("add"),
                new Command("mv d a"),
                new Command("print")

        };


        Command init1= new Command("init 10 20");
        Command init2= new Command("init 11 25");
        Command ld1  = new Command("ld 10 a");
        Command ld2  = new Command("ld 11 b");
        Command add1 = new Command("add");
        Command mv = new Command("mv d a");
        Command print = new Command("print");



//        Command mult = new Command(TypeCommand.mult);
//        Command print = new Command(TypeCommand.print);
//        Command add = new Command(TypeCommand.add);
//        Command div = new Command(TypeCommand.div);

        ICPU cpu = BCPU.build();
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
            cpu.runCommand(prog);
        }catch (CPUExceptions e){
            System.out.println(e.getMessage());
        }

    }
}