package org.example.cpu_lab_4;

public class AExecuter extends MyHandler{
    @Override
    void runCommand(Command command, CPU cpu) throws CPUExceptions {
        switch (command.getCommand()){
            case mult -> {
                cpu.r3 = cpu.r1 * cpu.r2;
            }
            case add -> {
                cpu.r3 = cpu.r1 + cpu.r2;
            }
            case div -> {
                cpu.r3 = cpu.r1 / cpu.r2;
            }
            case  sub -> {
                cpu.r3 = cpu.r1 - cpu.r2;
            }
            default -> {
                super.runCommand(command, cpu);
            }
        }


    }
}
