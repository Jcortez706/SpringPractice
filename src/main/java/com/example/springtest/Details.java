package com.example.springtest;

import java.util.ArrayList;
import java.util.List;

public class Details {
    static List<Integer> Data
            = new ArrayList<Integer>();
    int newNumber;
    int number;
    String name;
    Details(){}
    Details(int number)
    {
        this.number = number;
    }
    Details(int number, int newNumber)
    {
        this.number = number;
        this.newNumber = newNumber;
    }
    public String insertData(int number){
        Data.add(number);
        return "Done";
    }
    public String getData(){
        return Data.toString();
    }

    public static void delete(int number) {
        Data.remove((Integer) number);
    }

    public static void put(int number, int newNumber) {
        int temp = Data.indexOf(number);
        if (temp != -1) {
            Data.set(temp, newNumber);
        }
    }
}
