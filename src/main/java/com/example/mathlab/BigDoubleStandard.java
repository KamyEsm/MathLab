package com.example.mathlab;

public interface BigDoubleStandard {
    public void SetNumber(double N);
    public void SetNumber(float N);
    public void SetNumber(String N);
    public String toString();
    public int[] toArray();
    public void SetSum(BigDouble a, BigDouble b);
    public void SetSum(String a, String b);
    public void SetMinus(BigDouble a, BigDouble b);
    public void SetMinus(String a, String b);
    public void SetMultiple(BigDouble a, BigDouble b);
    public void SetMultiple(String a, String b);
    public int[] SetDiv(BigDouble a, BigDouble b);
    public void SetDiv(String a, String b);
    public void SetMod(BigDouble a, BigDouble b);
    public void SetMod(String a, String b);
    public void SetPow(BigDouble a, int b);
    public void SetPow(String a, String b);
    public void SetMultiple(BigDouble a, double b);



}