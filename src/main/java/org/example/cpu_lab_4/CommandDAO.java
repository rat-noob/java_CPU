package org.example.cpu_lab_4;

import java.util.ArrayList;

public class CommandDAO {
    ArrayList<Command> comarr = new ArrayList<>();

    public ArrayList<Command> getComarr() {
        return comarr;
    }
    public void add(Command c){
        comarr.add(c);
    }
    public void  remove(Command c){
        comarr.remove(c);
    }
    public Command get(int index){
        return comarr.get(index);
    }
    public int size(){
        return comarr.size();
    }

}
