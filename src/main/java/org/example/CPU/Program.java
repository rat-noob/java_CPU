package org.example.CPU;

import java.util.ArrayList;
import java.util.Iterator;

public class Program implements Iterable<Command>{
 int cnt = 0;
// Command[] comm;


 //ВОЗМОЖНО УДАЛЮ ПОТОМ
    ArrayList<Command> comarr;
    //


 public Program(){
//     comm = new Command[15];
     this.comarr = new ArrayList<>();
 }

 public void add(Command command){
     if(cnt<15){
//         comm[cnt++]= command;
     }
     comarr.add(command);
//     else{//возможно работает не так
//         Command[] comm2 = new Command[cnt*2];
//         for(int i=0;i<cnt;i++){
//             comm2[i] = comm[i];
//         }
//         comm = null;
//         comm = comm2;
//     }

 }

    public int getCnt() {
     return comarr.size();
//     return cnt;
    }

    public Command getComm(int index) {
//        return comm[index];
        return comarr.get(index);

    }

    @Override
    public Iterator<Command> iterator() {
        return new Iterator<Command>() {
            int cr;

            @Override
            public boolean hasNext() {
                return cr<getCnt();
            }

            @Override
            public Command next() {
                if(!hasNext()) throw new RuntimeException("err");

                return getComm(cr++);
            }
        };
    }
}
