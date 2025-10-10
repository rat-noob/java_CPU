package org.example.CPU;

public class HExecuter extends MyHandler{
    @Override
    void runCommand(Command command, CPU cpu) throws CPUExceptions{
        if(command.getCommand()==TypeCommand.print){
            System.out.println(cpu.r1);
            System.out.println(cpu.r2);
            System.out.println(cpu.r3);
            System.out.println(cpu.r4);
        }

        else{
            super.runCommand(command,cpu);
        }
    }
}
