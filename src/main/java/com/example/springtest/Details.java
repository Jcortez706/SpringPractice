package com.example.springtest;

import java.util.ArrayList;
import java.util.List;

public class Details {
    // Creating an object of ArrayList
    static List<Integer> Data
            = new ArrayList<Integer>();
    int newNumber;
    int number;
    String name;
    Details(int number)
    {
        this.number = number;
    }
    Details(int number, int newNumber)
    {
        this.number = number;
        this.newNumber = newNumber;
    }

    public static void delete(int number) {
        Data.remove((Integer) number);
    }

    public static void put(int number, int newNumber) {
        int temp = Data.indexOf(number);
        Data.remove((Integer) number);
        Data.set(temp-1, newNumber);
        System.out.println(Data.get(temp));
    }
}
