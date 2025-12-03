package org.example.cpu_lab_4;

public class CPU implements ICPU{
    int r1=0;
    int r2=0;
    int r3=0;
    int r4=0;
    MyHandler handler = new MyHandler();
    Memory memory;

    @Override
    public void runCommand(Command command) throws CPUExceptions {
        handler.runCommand(command, this,memory);
    }


    public MyHandler getHandler() {
        return handler;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public void setR3(int r3) {
        this.r3 = r3;
    }

    public void setR4(int r4) {
        this.r4 = r4;
    }

    public int getR1() {
        return r1;
    }

    public int getR2() {
        return r2;
    }

    public int getR3() {
        return r3;
    }

    public int getR4() {
        return r4;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}
