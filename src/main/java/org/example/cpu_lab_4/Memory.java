package org.example.cpu_lab_4;

public class Memory {
    int[] mem = new int[50];
    public void stMem(int r1 ,int ind){
        mem[ind]= r1;
    }
    public void ldMem(int ind, int r1){
        r1 = mem[ind];
    }
    public void initMem(int ind, int val){
        mem[ind] = val;
    }
    public int Getval(int i){
        return mem[i];
    }
}
