package org.example.cpu_lab_4;

class MyHandler {
    MyHandler next;
    void runCommand(Command command, CPU cpu) throws CPUExceptions{
        if(next!=null){

            next.runCommand(command,cpu);

        }
        else{
            throw new CPUExceptions("error");
        };
    }
    MyHandler add(MyHandler next){
        this.next = next;
        return next;
    }
}
