package org.example.CPU;

public class CPUExceptions extends Exception{
    public CPUExceptions() {
    }

    public CPUExceptions(String message) {
        super(message);
    }


    @Override
    public String getMessage(){
        return "CPUException:" + super.getMessage();
    }
}
