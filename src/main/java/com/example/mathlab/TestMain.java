package com.example.mathlab;

public class TestMain {
    public static void main(String[] args) {
        Polynomial P1=new Polynomial("6x");
        Polynomial P2=new Polynomial("3x-5");
        Polynomial P3=new Polynomial();
        P3.PMoD(P1,P2);
        System.out.println(P3);
    }
}
