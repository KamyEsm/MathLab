package com.example.mathlab;

public class Decimals_Calculation {
    private StringBuilder Calculation;

    public Decimals_Calculation() {
        this.Calculation = new StringBuilder(0);
    }
    public Decimals_Calculation(String Calculation) {
        this.Calculation = new StringBuilder(Calculation);
    }
    public void SetCalculation(String Calculation) {
        this.Calculation = new StringBuilder(Calculation);
    }


    @Override
    public String toString() {
        return Calculation.toString();
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
            BigDouble A = new BigDouble(Calculation.substring(firsindex,Powindex));
            int a1=Integer.parseInt(Calculation.substring(Powindex+1,lastIndex+1));
            BigDouble C=new BigDouble();
            C.SetPow(A,a1);

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
                BigDouble A = new BigDouble(Calculation.substring(firsindex,Divindex));
                BigDouble B =new BigDouble(Calculation.substring(Divindex+1,lastIndex+1));
                BigDouble C=new BigDouble();
                C.SetDiv(A, B);
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
                BigDouble A = new BigDouble(Calculation.substring(firsindex,Mltindex));
                BigDouble B =new BigDouble(Calculation.substring(Mltindex+1,lastIndex+1));
                BigDouble C=new BigDouble();
                C.SetMultiple(A, B);
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
                BigDouble A = new BigDouble(Calculation.substring(firsindex,Modindex));
                BigDouble B =new BigDouble(Calculation.substring(Modindex+1,lastIndex+1));
                BigDouble C=new BigDouble();
                C.SetMod(A, B);
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
        BigDouble B=new BigDouble();
        for (int idx = 0; idx < T.length; idx++) {
            BigDouble V=new BigDouble(T[idx]);
            B.SetSum(V,B);
        }
        Calculation.setLength(0);
        Calculation.append(B.toString());
    }




    public void FinallyCalculation(){
        this.ParenthesisCalculation();
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
