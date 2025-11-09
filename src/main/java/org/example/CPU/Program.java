package org.example.CPU;

import java.util.*;

public class Program implements Iterable<Command>{
 int cnt = 0;

 //ВОЗМОЖНО УДАЛЮ ПОТОМ
    ArrayList<Command> comarr;
    //

    HashMap<TypeCommand,Integer> handl= new HashMap<>();


 public Program(){
     this.comarr = new ArrayList<>();
 }

 public void add(Command command){

     TypeCommand cm = command.getCommand();
     comarr.add(command);
     if(handl.containsKey(cm)){
         handl.put(cm,handl.get(cm)+1);
     }else{
         handl.put(cm,1);
     }

 }

    public int getCnt() {
     return comarr.size();
    }

    public Command getComm(int index) {
        return comarr.get(index);
    }

    public void most_used_command(){
        TypeCommand most_used = null;
        int maxCount = 0;

        for (HashMap.Entry<TypeCommand, Integer> entry : handl.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                most_used = entry.getKey();
            }
        }
        System.out.println(most_used);
    }

    public void addr_range(){
        int min = comarr.get(0).val1;
        int max = comarr.get(0).val1;

        for (Command cmd : comarr) {
            int addr = cmd.val1;
            if (addr < min) min = addr;
            if (addr > max) max = addr;
        }

        System.out.println("min: "+min +" max: "+ max);

    }

    public void sorted_com() {
        List<TypeCommand> result = new ArrayList<>(handl.keySet());
        result.sort((t1, t2) -> handl.get(t2) - handl.get(t1));

        System.out.println(result);

    }

//    @Override
//    public Iterator<Command> iterator1() {
//        return new Iterator<Command>() {
//            int cr;
//
//            @Override
//            public boolean hasNext() {
//                return cr<getCnt();
//            }
//
//            @Override
//            public Command next() {
//                if(!hasNext()) throw new RuntimeException("err");
//
//                return getComm(cr++);
//            }
//        };
//    }
    @Override
    public Iterator<Command> iterator(){
        return  comarr.iterator();
    }
}
