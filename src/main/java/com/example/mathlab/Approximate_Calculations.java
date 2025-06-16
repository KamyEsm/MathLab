package com.example.mathlab;

public class Approximate_Calculations {
    private StringBuilder Calculation;

    public Approximate_Calculations() {
        this.Calculation = new StringBuilder(0);
    }
    public Approximate_Calculations(String Calculation) {
        this.Calculation = new StringBuilder(Calculation);
    }
    public void SetCalculation(String Calculation) {
        this.Calculation = new StringBuilder(Calculation);
    }


    @Override
    public String toString() {
        return Calculation.toString();
    }


    public void FactorialCalculation() {
        while (Calculation.indexOf("!") != -1) {
            int firsindex = Calculation.indexOf("!") - 1;
            int lastIndex = Calculation.indexOf("!") - 1;
            while (firsindex >= 0 && (Calculation.charAt(firsindex) != '%' && Calculation.charAt(firsindex) != '^' && Calculation.charAt(firsindex) != '*'
                    && Calculation.charAt(firsindex) != '+' && Calculation.charAt(firsindex) != '-' &&
                    Calculation.charAt(firsindex) != '/' && Calculation.charAt(firsindex) != '!')) {
                firsindex--;
            }
            firsindex++;

            BigInt A = new BigInt(Calculation.substring(firsindex, lastIndex + 1));
            BigInt B = new BigInt();
            B.Factorial(A);
            String t = B.toString();
            Calculation.replace(firsindex, lastIndex + 2, t);
        }
    }

    public void PowCalculation() {
        while(Calculation.indexOf("^")!=-1){
            int Powindex=Calculation.indexOf("^");
            int firsindex=Powindex-1;
            while (firsindex>=0 && (Calculation.charAt(firsindex)!='%' && Calculation.charAt(firsindex)!='^' && Calculation.charAt(firsindex)!='*'
                    && Calculation.charAt(firsindex)!='+' && Calculation.charAt(firsindex)!='-' && Calculation.charAt(firsindex)!='/')){
                firsindex--;
            }
            firsindex++;
            int lastIndex=Powindex+1;
            while (lastIndex<Calculation.length() && (Calculation.charAt(lastIndex)!='%' && Calculation.charAt(lastIndex)!='^' && Calculation.charAt(lastIndex)!='*'
                    && Calculation.charAt(lastIndex)!='+' && Calculation.charAt(lastIndex)!='-' && Calculation.charAt(lastIndex)!='/')){
                lastIndex++;

            }
            lastIndex--;
            BigInt A = new BigInt(Calculation.substring(firsindex,Powindex));
            BigInt B =new BigInt(Calculation.substring(Powindex+1,lastIndex+1));
            BigInt C=new BigInt();
            C.Pow(A, B);

            Calculation.replace(firsindex,lastIndex+1,C.toString());

        }
    }
    public void Mod_Multiple_DivisionCalculation() {
        while(Calculation.indexOf("*")!=-1 || Calculation.indexOf("/")!=-1 || Calculation.indexOf("%")!=-1){
            int Divindex=Calculation.indexOf("/");
            int Modindex=Calculation.indexOf("%");
            int Mltindex=Calculation.indexOf("*");
            if(Divindex==-1)
                Divindex=Calculation.length()-1;
            if(Mltindex==-1)
                Mltindex=Calculation.length()-1;
            if(Modindex==-1)
                Modindex=Calculation.length()-1;
            while(Divindex<Modindex && Divindex<Mltindex && Divindex>0){
                int firsindex=Divindex-1;
                while (firsindex>=0 && (Calculation.charAt(firsindex)!='%' && Calculation.charAt(firsindex)!='^' && Calculation.charAt(firsindex)!='*'
                        && Calculation.charAt(firsindex)!='+' && Calculation.charAt(firsindex)!='-' && Calculation.charAt(firsindex)!='/')){
                    firsindex--;

                }
                firsindex++;
                if(firsindex!=0 && Calculation.charAt(firsindex-1)=='-')
                    firsindex--;
                int lastIndex=Divindex+1;
                if(Calculation.charAt(lastIndex)=='-')
                    lastIndex++;
                while (lastIndex<Calculation.length() && (Calculation.charAt(lastIndex)!='%' && Calculation.charAt(lastIndex)!='^' && Calculation.charAt(lastIndex)!='*'
                        && Calculation.charAt(lastIndex)!='+' && Calculation.charAt(lastIndex)!='-' && Calculation.charAt(lastIndex)!='/')){
                    lastIndex++;

                }
                lastIndex--;
                BigInt A = new BigInt(Calculation.substring(firsindex,Divindex));
                BigInt B =new BigInt(Calculation.substring(Divindex+1,lastIndex+1));
                BigInt C=new BigInt();
                C.Divide(A, B);
                StringBuilder J=new StringBuilder(C.toString());
                for (int i = lastIndex+1; i < Calculation.length(); i++) {
                    J.append(Calculation.charAt(i));
                }
                Calculation=J;
                Divindex=Calculation.indexOf("/");
                Modindex=Calculation.indexOf("%");
                Mltindex=Calculation.indexOf("*");
                if(Divindex==-1)
                    Divindex=Calculation.length()-1;
                if(Mltindex==-1)
                    Mltindex=Calculation.length()-1;
                if(Modindex==-1)
                    Modindex=Calculation.length()-1;
            }



            while(Mltindex<Modindex && Mltindex<Divindex && Mltindex>0){
                int firsindex=Mltindex-1;
                while (firsindex>=0 && (Calculation.charAt(firsindex)!='%' && Calculation.charAt(firsindex)!='^' && Calculation.charAt(firsindex)!='*'
                        && Calculation.charAt(firsindex)!='+' && Calculation.charAt(firsindex)!='-' && Calculation.charAt(firsindex)!='/')){
                    firsindex--;

                }
                firsindex++;
                if(firsindex!=0 && Calculation.charAt(firsindex-1)=='-')
                    firsindex--;
                int lastIndex=Mltindex+1;
                if(Calculation.charAt(lastIndex)=='-')
                    lastIndex++;
                while (lastIndex<Calculation.length() && (Calculation.charAt(lastIndex)!='%' && Calculation.charAt(lastIndex)!='^' && Calculation.charAt(lastIndex)!='*'
                        && Calculation.charAt(lastIndex)!='+' && Calculation.charAt(lastIndex)!='-' && Calculation.charAt(lastIndex)!='/')){
                    lastIndex++;
                }
                lastIndex--;
                BigInt A = new BigInt(Calculation.substring(firsindex,Mltindex));
                BigInt B =new BigInt(Calculation.substring(Mltindex+1,lastIndex+1));
                BigInt C=new BigInt();
                C.Multiple(A, B);
                StringBuilder J=new StringBuilder(C.toString());
                for (int i = lastIndex+1; i < Calculation.length(); i++) {
                    J.append(Calculation.charAt(i));
                }
                Calculation=J;
                Divindex=Calculation.indexOf("/");
                Modindex=Calculation.indexOf("%");
                Mltindex=Calculation.indexOf("*");
                if(Divindex==-1)
                    Divindex=Calculation.length()-1;
                if(Mltindex==-1)
                    Mltindex=Calculation.length()-1;
                if(Modindex==-1)
                    Modindex=Calculation.length()-1;
            }






            while(Modindex<Mltindex && Modindex<Divindex && Modindex>0){
                int firsindex=Modindex-1;
                while (firsindex>=0 && (Calculation.charAt(firsindex)!='%' && Calculation.charAt(firsindex)!='^' && Calculation.charAt(firsindex)!='*'
                        && Calculation.charAt(firsindex)!='+' && Calculation.charAt(firsindex)!='-' && Calculation.charAt(firsindex)!='/')){
                    firsindex--;

                }
                firsindex++;
                if(firsindex!=0 && Calculation.charAt(firsindex-1)=='-')
                    firsindex--;
                int lastIndex=Modindex+1;
                if(Calculation.charAt(lastIndex)=='-')
                    lastIndex++;
                while (lastIndex<Calculation.length() && (Calculation.charAt(lastIndex)!='%' && Calculation.charAt(lastIndex)!='^' && Calculation.charAt(lastIndex)!='*'
                        && Calculation.charAt(lastIndex)!='+' && Calculation.charAt(lastIndex)!='-'&& Calculation.charAt(lastIndex)!='/')){
                    lastIndex++;

                }
                lastIndex--;
                BigInt A = new BigInt(Calculation.substring(firsindex,Modindex));
                BigInt B =new BigInt(Calculation.substring(Modindex+1,lastIndex+1));
                BigInt C=new BigInt();
                C.Mod(A, B);
                StringBuilder J=new StringBuilder(C.toString());
                for (int i = lastIndex+1; i < Calculation.length(); i++) {
                    J.append(Calculation.charAt(i));
                }
                Calculation=J;
                Divindex=Calculation.indexOf("/");
                Modindex=Calculation.indexOf("%");
                Mltindex=Calculation.indexOf("*");
                if(Divindex==-1)
                    Divindex=Calculation.length()-1;
                if(Mltindex==-1)
                    Mltindex=Calculation.length()-1;
                if(Modindex==-1)
                    Modindex=Calculation.length()-1;
            }
        }
    }



    public void SumAndMinusCalculation(){
        String T[]=Calculation.toString().split("(?=[+-])");
        BigInt B=new BigInt("0");
        for (int idx = 0; idx < T.length; idx++) {
            BigInt V=new BigInt(T[idx]);
            B.sum(V,B);
        }
        Calculation.setLength(0);
        Calculation.append(B.toString());
    }




    public void FinallyCalculation(){
        this.ParenthesisCalculation();
        this.FactorialCalculation();
        this.PowCalculation();
        this.Mod_Multiple_DivisionCalculation();
        this.SumAndMinusCalculation();
    }

    public void ParenthesisCalculation(){
        int firsIndex=0;
        int lastIndex=0;
        while(Calculation.indexOf("(")!=-1 && Calculation.indexOf(")")!=-1){
            firsIndex=Calculation.lastIndexOf("(");
            for (int x=firsIndex+1; x<Calculation.length(); x++){
                if(Calculation.charAt(x)==')'){
                    lastIndex=x;
                    break;
                }
            }
            Approximate_Calculations Calculation4=new Approximate_Calculations(Calculation.substring(firsIndex+1,lastIndex));
            Calculation4.FactorialCalculation();
            Calculation4.PowCalculation();
            Calculation4.Mod_Multiple_DivisionCalculation();
            Calculation4.SumAndMinusCalculation();
            Calculation.replace(firsIndex,lastIndex+1,Calculation4.toString());
        }
    }


}
