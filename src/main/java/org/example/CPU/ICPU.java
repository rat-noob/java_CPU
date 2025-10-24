package org.example.CPU;

public interface ICPU {
    void runCommand(Command command) throws CPUExceptions;
//    void runCommand(Command[] command) throws CPUExceptions;
}
