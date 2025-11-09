package org.example.CPU;

public class Executer {
    ICPU cpu;
    public Executer(ICPU cpu){
        this.cpu = cpu;
    }
//    public void run(Command[] prog) throws CPUExceptions {
//        for (int i=0;i< prog.length;i++){
//            cpu.runCommand(prog[i]);
//        }
//    }

    public void run(Program prog) throws CPUExceptions {
        for(Command c: prog) cpu.runCommand(c);
    }
}
