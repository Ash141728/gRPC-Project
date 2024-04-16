package com.Insppiron.proto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }
    public int add(int a ,int b){
        int sum=a+b;
        return sum;
    }
    @Test
    void addTest(){

        assertEquals(5,add(2,4));


    }
}