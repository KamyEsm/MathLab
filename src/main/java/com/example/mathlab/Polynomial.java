package com.example.mathlab;

public class Polynomial {
    private double[] coefficients=new double[1000];
    private int ccoefficients;

    public Polynomial() {
        ccoefficients=1;
    }

    public Polynomial(String polynomial) {
        this.SetPolynomial(polynomial);
    }


    public void SetPolynomial(String polynomial) {
        String A1[]=polynomial.trim().split("(?=[-+])");
        ccoefficients=this.AnalizString(A1);
    }

    @Override
    public String toString(){
        return this.ArraytoString(ccoefficients);
    }


/// //////////////////////////////////////////////////////////////////
public void PSum(Polynomial S1 , Polynomial S2) {

    int max=Math.max(S1.ccoefficients, S2.ccoefficients);
    for(int x=0;x<max;x++) {
        double temp=S1.coefficients[x]+S2.coefficients[x];
        String Coefficient=String.format("%.10f",temp);
        this.coefficients[x]=Double.parseDouble(Coefficient);

        if(this.coefficients[x]!=0)
            this.ccoefficients=x+1;
    }

}


    public void PMinus(Polynomial S1 , Polynomial S2) {


        int max=Math.max(S1.ccoefficients,S2.ccoefficients);
        for(int x=0;x<max;x++) {
            double temp=S1.coefficients[x]-S2.coefficients[x];
            String Coefficient=String.format("%.10f",temp);
            this.coefficients[x]=Double.parseDouble(Coefficient);

            if(this.coefficients[x]!=0)
                this.ccoefficients=x+1;

        }

    }


    public void PMultiple(Polynomial S1,Polynomial S2) {

        for(int x=0;x<S2.coefficients.length;x++) {
            for(int y=0;y<S1.coefficients.length;y++) {
                if(S1.coefficients[y]!=0 && S2.coefficients[x]!=0) {
                    double temp=S1.coefficients[y]*S2.coefficients[x];
                    String Coefficient=String.format("%.10f",temp);
                    this.coefficients[x+y]+=Double.parseDouble(Coefficient);
                    if(x+y+1>this.ccoefficients)
                        this.ccoefficients=x+y+1;
                }
            }
        }
    }



    public void PDiv(Polynomial S1,Polynomial S2) {
        if(S1.PCompare(S2)==-1) {
            this.SetPolynomial("0");
            return;
        }
        else if(S1.PCompare(S2)==0) {
            this.SetPolynomial("1");
            return;
        }



        Polynomial R=new Polynomial(S1.toString());

        Polynomial Q=new Polynomial();
        while(R.PCompare(S2)>=0) {

            Q.ccoefficients=R.ccoefficients-S2.ccoefficients+1;
            Q.coefficients[Q.ccoefficients-1]=R.coefficients[R.ccoefficients-1]/S2.coefficients[S2.ccoefficients-1];
            Polynomial temp=new Polynomial();
            temp.PMultiple(Q,S2);
            R.PMinus(R,temp);

        }
        this.SetPolynomial(Q.toString());
    }



    public void PMoD(Polynomial S1,Polynomial S2) {
        Polynomial Q=new Polynomial();
        Q.PDiv(S1,S2);
        Polynomial mlt=new Polynomial();
        mlt.PMultiple(Q, S2);
        this.PMinus(S1,mlt);
    }



    public void PDerivative(Polynomial S1) {

        for(int x=0;x<S1.coefficients.length-1;x++) {
            S1.coefficients[x]=S1.coefficients[x+1]*(x+1);
            double temp=S1.coefficients[x];
            String Coefficient=String.format("%.10f",temp);
            S1.coefficients[x]=Double.parseDouble(Coefficient);
        }
        for(int x=S1.coefficients.length-1;x>=0;x--) {
            if(S1.coefficients[x]!=0) {
                S1.ccoefficients=x+1;
                break;
            }

        }
        this.SetPolynomial(S1.toString());
    }


    public void PIntegral(Polynomial S1) {
        for(int x=S1.coefficients.length-2;x>=0;x--) {
            S1.coefficients[x+1]=S1.coefficients[x];
            S1.coefficients[x+1]/=x+1;
            double temp=S1.coefficients[x+1];
            String Coefficient=String.format("%.10f",temp);
            S1.coefficients[x+1]=Double.parseDouble(Coefficient);

        }
        S1.coefficients[0]=0;

        for(int x=S1.coefficients.length-1;x>=0;x--) {
            if(S1.coefficients[x]!=0) {
                S1.ccoefficients=x+1;
                break;
            }
        }
        this.SetPolynomial(S1.toString());
    }


/// ///////////////////////////////////////////////////////////////////other
public int PCompare(Polynomial S1) {

    if(this.ccoefficients>S1.ccoefficients)
        return 1;
    else if(this.ccoefficients<S1.ccoefficients)
        return -1;
    for(int x=this.coefficients.length-1;x>=0;x--) {
        if(this.coefficients[x]>S1.coefficients[x])
            return 1;
        else if(this.coefficients[x]<S1.coefficients[x])
            return -1;

    }


    return 0;
}


    private int AnalizString(String B[])
    {

        int cA=0;
        for(int x=0;x<B.length;x++) {
            String temp=B[x];
            temp=temp.trim();
            if(temp.equals(""))
                return 0;

            if(temp.indexOf("x")==-1) {
                this.coefficients[0]+=Double.parseDouble(temp);
            }


            if(temp.indexOf("^")==-1 && temp.indexOf("x")>=0) {
                if(temp.equals("x"))
                    temp=1+temp;
                if(temp.equals("+x"))
                    temp=temp.charAt(0)+"1";

                if(temp.equals("-x"))
                    temp=temp.charAt(0)+"1";

                temp=temp.replace("x","");

                this.coefficients[1]+=Double.parseDouble(temp);
            }


            if(temp.indexOf("^")>=0 && temp.indexOf("x")>=0) {
                String power=temp.substring(temp.indexOf("^")+1,temp.length());
                if(temp.equals("x^"+power))
                    temp=1+temp;
                if(temp.equals("+x^"+power))
                    temp=temp.charAt(0)+"1"+temp.substring(temp.indexOf("x"),temp.length());

                if(temp.equals("-x^"+power))
                    temp=temp.charAt(0)+"1"+temp.substring(temp.indexOf("x"),temp.length());
                String Coefficient=temp.substring(0,temp.indexOf("x"));
                this.coefficients[Integer.parseInt(power)]+=Double.parseDouble(Coefficient);

            }

        }

        for(int x=this.coefficients.length-1;x>=0;x--)
        {
            if(this.coefficients[x]!=0)
            {
                cA=x+1;
                break;
            }
        }
        return cA;
    }


    private String ArraytoString(int cC) {
        String result="";
        if(this.coefficients[0]!=0)
            result=this.coefficients[0]+result;
        if(this.coefficients[0]>0)
            result="+"+result;
        if(this.coefficients[1]!=0)
            result=this.coefficients[1]+"x"+result;
        if(this.coefficients[1]>0)
            result="+"+result;
        for(int x=2;x<cC;x++) {
            if(this.coefficients[x]!=0)
                result=this.coefficients[x]+"x^"+x+result;
            if(this.coefficients[x]>0 && x!=cC-1)
                result="+"+result;

        }



        if(result.equals(""))
            return "0";

        if(result.charAt(0)!='+' && result.charAt(0)!='-')
            result="+"+result;



        return result;
    }



}///Class
