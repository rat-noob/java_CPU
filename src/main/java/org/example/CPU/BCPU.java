package org.example.CPU;

public class BCPU extends CPU{
    static CPU cpu;

    public static ICPU build(){
        if (cpu==null) {
            cpu = new CPU();
            cpu.getHandler().add(new AExecuter()).add(new MemExecuter()).add(new HExecuter());
        }
            return cpu;
    }
}
