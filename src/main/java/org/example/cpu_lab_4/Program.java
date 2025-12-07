package org.example.cpu_lab_4;

import java.util.*;
import java.util.stream.Collectors;

public class Program implements Iterable<Command>{


 //ВОЗМОЖНО УДАЛЮ ПОТОМ
    ArrayList<Command> comarr;
    ArrayList<IObserver> io = new ArrayList<>();
    //

    HashMap<TypeCommand,Integer> handl= new HashMap<>();


 public Program(){
     this.comarr = new ArrayList<>();
 }

 public void event(){
     io.forEach(action->action.event());
 }
 public void add(Command command){

     TypeCommand cm = command.getCommand();
     comarr.add(command);
     if(handl.containsKey(cm)){
         handl.put(cm,handl.get(cm)+1);
     }else{
         handl.put(cm,1);
     }
     event();

 }
 public void removeCommand(Command command){
     TypeCommand cm = command.getCommand();
     comarr.remove(command);
     if(handl.containsKey(cm)){
         handl.put(cm,handl.get(cm)-1);
     }
     event();
 }
 public void addListener(IObserver observer){
     io.add(observer);
     event();
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

    public List<TypeCommand> sorted_com() {
        List<TypeCommand> result = new ArrayList<>(handl.keySet());
        result.sort((t1, t2) -> handl.get(t2) - handl.get(t1));

        System.out.println(result);

//        List<Map.Entry<TypeCommand, Integer>> sortedAsc = handl.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toList());
        return result;
    }

    @Override
    public Iterator<Command> iterator(){
        return  comarr.iterator();
    }
}
