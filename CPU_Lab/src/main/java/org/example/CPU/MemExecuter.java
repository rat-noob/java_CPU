package org.example.CPU;

public class MemExecuter extends MyHandler{
    Memory memory = new Memory();
    @Override
    void runCommand(Command command, CPU cpu) throws CPUExceptions {
        switch(command.getCommand()){
            case ld -> {
                if(command.r1=='a') {
                    memory.ldMem(command.val1, cpu.r1);
                    cpu.r1 = memory.Getval(command.val1);
                }
                else if(command.r1=='b'){
                    memory.ldMem(command.val1,cpu.r2);
                cpu.r2 = memory.Getval(command.val1);}
                else if(command.r1=='c'){
                    memory.ldMem(command.val1,cpu.r3);
                cpu.r3 = memory.Getval(command.val1);}

                else if(command.r1=='d') {
                    memory.ldMem(command.val1, cpu.r4);
                    cpu.r4 = memory.Getval(command.val1);
                }
            }
            case st -> {
                if(command.r1=='a')
                    memory.stMem(cpu.r1, command.val1);
                else if(command.r1=='b')
                    memory.stMem(cpu.r2, command.val1);
                else if(command.r1=='c')
                    memory.stMem(cpu.r3, command.val1);
                else if(command.r1=='d')
                    memory.stMem(cpu.r4, command.val1);
            }
            case init -> {
                memory.initMem(command.val1, command.val2);
            }
            case mv -> {
                if(command.r1=='a'){
                    if(command.r2 =='b')
                        cpu.r1=cpu.r2;
                    if(command.r2 =='c')
                        cpu.r1=cpu.r3;
                    if(command.r2 =='d')
                        cpu.r1=cpu.r4;
                }
                if(command.r1=='b'){
                    if(command.r2 =='a')
                        cpu.r2=cpu.r1;
                    if(command.r2 =='c')
                        cpu.r2=cpu.r3;
                    if(command.r2 =='d')
                        cpu.r2=cpu.r4;
                }
                if(command.r1=='c'){
                    if(command.r2 =='b')
                        cpu.r3=cpu.r2;
                    if(command.r2 =='a')
                        cpu.r3=cpu.r1;
                    if(command.r2 =='d')
                        cpu.r3=cpu.r4;
                }
                if(command.r1=='d'){
                    if(command.r2 =='b')
                        cpu.r4=cpu.r2;
                    if(command.r2 =='c')
                        cpu.r4=cpu.r3;
                    if(command.r2 =='a')
                        cpu.r4=cpu.r1;
                }
            }
            default -> super.runCommand(command, cpu);
        }

    }
}
