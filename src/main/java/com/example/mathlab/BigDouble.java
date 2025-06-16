package com.example.mathlab;

public class BigDouble implements BigDoubleStandard {

    private int A[];
    private int cA;
    private int DotIndex=-1;
    private enum Sign {
        PLUS,
        MINUS
    }
    Sign sign;

    public BigDouble() {
        A = new int[1000000];
        cA = 1;
        DotIndex = -1;
        sign = Sign.PLUS;
    }
    public BigDouble(double N) {
        A = new int[1000000];
        this.SetNumber(N);
    }
    public BigDouble(float N) {
        A = new int[1000000];
        this.SetNumber(N);
    }
    public BigDouble(String N) {
        A = new int[1000000];
        this.SetNumber(N);
    }

    /// /////////////////////////////////////////Getter

    @Override
    public int[] toArray() {
        return this.A;
    }

    @Override
    public String toString() {
        String Result="";
        for (int i = cA-1; i >=0; i--) {
            if(this.A[i]==-1) Result+='.';
            else Result+=this.A[i];
        }
        if(sign==Sign.MINUS) Result='-'+Result;
        return Result;

    }

    @Override
    public void SetNumber(double N) {
        String Num = String.valueOf(N);
        
        this.cA=Num.length();
        if(Num.charAt(0)=='+') {
            this.sign = Sign.PLUS;
            Num = Num.substring(1);
        }
        else if (Num.charAt(0)=='-') {
            this.sign = Sign.MINUS;
            Num = Num.substring(1);
        }
        else this.sign = Sign.PLUS;
        for (int i = 0; i < Num.length(); i++) {
            if(Num.charAt(Num.length()-i-1)=='.') {
                this.A[i]=-1;
                this.DotIndex=i;
            }
            else {
                this.A[i] = Character.getNumericValue(Num.charAt(Num.length()-i-1));
            }
        }
    }



    @Override
    public void SetNumber(float N) {
        String Num = String.valueOf(N);
        this.DotIndex=Num.indexOf(".");
        this.cA=Num.length();
        if(Num.charAt(0)=='+') {
            this.sign = Sign.PLUS;
            Num = Num.substring(1);
        }
        else if (Num.charAt(0)=='-') {
            this.sign = Sign.MINUS;
            Num = Num.substring(1);
        }
        else this.sign = Sign.PLUS;
        for (int i = 0; i < Num.length(); i++) {
            if(Num.charAt(Num.length()-i-1)=='.') {
                this.A[i]=-1;
            }
            else {
                this.A[i] = Character.getNumericValue(Num.charAt(Num.length()-i-1));
            }
        }
    }

    @Override
    public void SetNumber(String N) {
        if(N.equals("0")){
            this.DotIndex=-1;
            this.sign = Sign.PLUS;
            this.cA=1;
            return;
        }
        if(N.equals("0.0")) {
            this.DotIndex = 1;
            this.sign = Sign.PLUS;
            this.cA=3;
            this.A[1]=-1;
            return;
        }


        if(N.charAt(0)=='+') {
            this.sign = Sign.PLUS;
            N = N.substring(1);
        }
        else if (N.charAt(0)=='-') {
            this.sign = Sign.MINUS;
            N = N.substring(1);
        }
        else this.sign = Sign.PLUS;
        this.DotIndex=N.indexOf(".");
        if(this.DotIndex!=-1){
            int Index=-1;
            for (int i = N.length()-1; i >= 0; i--) {
                if(N.charAt(i)!='0') {
                    Index=i;
                    break;
                }
            }
            N=N.substring(0,Index+1);
        }
        int Index=-1;
        for (int i=0; i<N.length(); i++) {
            if(N.charAt(i)!='0' && N.charAt(i)!='.') {
                Index=i;
                break;
            }
            if(N.charAt(i)=='.' && Index==-1) {
                Index=i-1;
                break;
            }
        }
        if(Index!=-1)
            N=N.substring(Index);
        this.cA=N.length();
        for (int i = 0; i < N.length(); i++) {
            if(N.charAt(N.length()-i-1)=='.') {
                this.A[i]=-1;
                this.DotIndex=i;
            }
            else {
                this.A[i] = Character.getNumericValue(N.charAt(N.length()-i-1));
            }
        }


    }



    @Override
    public void SetSum(BigDouble a, BigDouble b) {
        int aIndex=a.DotIndex;
        int bIndex=b.DotIndex;

        BigDouble F1=new BigDouble(a.toString());
        BigDouble F2=new BigDouble(b.toString());
        Equal(F1,F2);
        F1.DeleteDot();
        F2.DeleteDot();
        BigInt A1=new BigInt(F1.toString());
        BigInt A2=new BigInt(F2.toString());
        BigInt A3=new BigInt();
        A3.sum(A1,A2);
        this.SetNumber(A3.toString());
        if(a.DotIndex<0 && b.DotIndex>0) {
            this.SetDot(b.DotIndex);
            return;
        }
        if (bIndex<0 && aIndex>0) {
            this.SetDot(aIndex);
            return;
        }
        if(aIndex<0 && bIndex<0) {
            return;
        }
        if(aIndex>=bIndex) {
            this.SetDot(aIndex);
        }
        else
            this.SetDot(bIndex);


    }

    @Override
    public void SetSum(String a, String b) {
        this.SetSum(new BigDouble(a), new BigDouble(b));
    }

    @Override
    public void SetMinus(BigDouble a, BigDouble b) {
        BigDouble F1=new BigDouble(a.toString());
        BigDouble F2=new BigDouble(b.toString());
        Equal2(F1,F2);
        F1.DeleteDot();
        F2.DeleteDot();
        BigInt A1=new BigInt(F1.toString());
        BigInt A2=new BigInt(F2.toString());
        BigInt A3=new BigInt();
        A3.Minus(A1,A2);
        A3.length();
        this.SetNumber(A3.toString());
        if(a.DotIndex<0 && b.DotIndex>0) {
            this.SetDot(b.DotIndex);
            return;
        }
        if (b.DotIndex<0 && a.DotIndex>0) {
            this.SetDot(a.DotIndex);
            return;
        }
        if(a.DotIndex<0 && b.DotIndex<0) {
            return;
        }
        if(a.DotIndex>=b.DotIndex) {
            this.SetDot(a.DotIndex);
        }
        else
            this.SetDot(b.DotIndex);
    }

    @Override
    public void SetMinus(String a, String b) {
        this.SetMinus(new BigDouble(a), new BigDouble(b));
    }

    @Override
    public void SetMultiple(BigDouble a, BigDouble b) {
        int aIndex=a.DotIndex;
        int bIndex=b.DotIndex;
        BigDouble F1=new BigDouble(a.toString());
        BigDouble F2=new BigDouble(b.toString());
        F1.DeleteDot();
        F2.DeleteDot();
        BigInt A1=new BigInt(F1.toString());
        BigInt A2=new BigInt(F2.toString());
        BigInt A3=new BigInt();
        A3.Multiple(A1,A2);
        A3.length();
        this.SetNumber(A3.toString());
        if(aIndex<0 && bIndex>0) {
            this.SetDot(bIndex);
        }
        else if (bIndex<0 && aIndex>0) {
            this.SetDot(aIndex);
        }
        else if (aIndex>0 && bIndex>0) {
            this.SetDot(aIndex+bIndex);
        }
    }

    @Override
    public void SetMultiple(String a, String b) {
        this.SetMultiple(new BigDouble(a), new BigDouble(b));
    }

    @Override
    public int[] SetDiv(BigDouble a, BigDouble b) {
        BigDouble F1=new BigDouble(a.toString());
        BigDouble F2=new BigDouble(b.toString());


        if (F1.sign==F2.sign) {
            this.sign= Sign.PLUS;
        }
        else {
            this.sign= Sign.MINUS;
        }

        int F1DotIndex;
        if (F1.DotIndex ==-1)
            F1DotIndex=0;
        else
            F1DotIndex=F1.DotIndex;

        int F2DotIndex;
        if (F2.DotIndex ==-1)
            F2DotIndex=0;
        else
            F2DotIndex=F2.DotIndex;



        F1.DeleteDot();
        F2.DeleteDot();

        int Accuracy=15;
        String F11=F1.toString();
        for (int x=0; x<Accuracy; x++) {
            F11+=0;

        }
        F1.SetNumber(F11);



        BigInt A1=new BigInt(F1.toString());
        BigInt A2=new BigInt(F2.toString());
        BigInt A3=new BigInt();
        int A[]=new int[1000000];

        A=A3.Divide(A1,A2);
        A3.length();
        this.SetNumber(A3.toString());
        int shift = Accuracy + F1DotIndex - F2DotIndex;
        if (shift > 0) {
            this.SetDot(shift);
        }
        while (this.cA > 1 && this.A[0] == 0 && this.DotIndex != 0) {
            for (int i = 0; i < this.cA - 1; i++) {
                this.A[i] = this.A[i + 1];
            }
            this.cA--;
            if (this.DotIndex > 0) this.DotIndex--;
        }



        A[shift]=-1;
        if(this.A[0]==-1){
            for (int x=cA-1; x>=0; x--) {
                this.A[x]=this.A[x+1];
            }
            this.DotIndex--;
            this.cA--;
        }
        return A;
    }

    @Override
    public void SetDiv(String a, String b) {
        this.SetDiv(new BigDouble(a), new BigDouble(b));
    }

    @Override
    public void SetMod(BigDouble a, BigDouble b) {
        BigDouble F1=new BigDouble(a.toString());
        BigDouble F2=new BigDouble(b.toString());
        BigDouble F3=new BigDouble();
        int G[]=F3.SetDiv(F1,F2);
        int cG=0;
        for (int x=G.length-1; x>=0; x--) {
            if(G[x]!=0 && G[x]!=-1) {
                cG=x+1;
                break;
            }
            if (G[x]==-1) {
                cG=x+2;
                break;
            }
        }
        String DecimalNumber="";
        for (int x=cG-1; x>=0; x--) {
            if(G[x]!=-1) {
                DecimalNumber += G[x];
            }
            else {
                DecimalNumber += '.';
            }
        }
        int subIndex=0;
        for (int x=DecimalNumber.length()-1; x>=0; x--) {
            if(DecimalNumber.charAt(x)!='0') {
                subIndex=x;
                break;
            }
        }

        DecimalNumber=DecimalNumber.substring(0,subIndex+1);

        BigDouble A1=new BigDouble(DecimalNumber);
        this.SetNumber(A1.toString());


    }

    @Override
    public void SetMod(String a, String b) {
        this.SetMod(new BigDouble(a), new BigDouble(b));
    }

    @Override
    public void SetPow(BigDouble a, int b) {
        BigDouble F1=new BigDouble(a.toString());
        BigDouble F2=new BigDouble("1");
        for (int x=0; x<b; x++) {
            F2.SetMultiple(F1,F2);
        }
        this.SetNumber(F2.toString());
    }



    @Override
    public void SetPow(String a, String b) {
        this.SetPow(new BigDouble(a),Integer.parseInt(b));
    }
/// Divide and Conquer
    @Override
    public void SetMultiple(BigDouble a, double b) {
        String FullNumber=String.valueOf(b);
        String Decimal=FullNumber.substring(FullNumber.indexOf('.')+1);
        int Dec=Integer.parseInt(Decimal);
        BigInt A1=new BigInt(a.toString());
        BigInt A2=new BigInt();

        String Num=FullNumber.substring(0,FullNumber.indexOf('.'));

    }


    public void Length(){
        for (int x=this.A.length-1; x>=0; x--) {
            if (this.A[x] == -1 && this.A[x]!=0) {
                this.DotIndex=x;
                this.cA=x+2;
                break;
            }
            if (this.A[x] != -1 && this.A[x]!=0) {
                this.cA=x+1;
                break;
            }
        }
    }


    /////////////////////////////////////////////////////Other
    private void DeleteDot(){
        if(DotIndex==-1)
            return;
        for (int i=this.DotIndex; i<this.cA; i++) {
            this.A[i]=this.A[i+1];
        }
        this.DotIndex=-1;
        this.A[cA-1]=0;
        this.cA--;
    }
    private void Equal(BigDouble a, BigDouble b){
        if(a.DotIndex==b.DotIndex){
            return;
        }
        else if (a.DotIndex>b.DotIndex) {
            while(a.DotIndex!=b.DotIndex){
                for (int i=b.cA-1; i>=0; i--) {
                    b.A[i+1]=b.A[i];
                }
                b.DotIndex++;
                b.cA++;
                b.A[0]=0;
            }

        }
        else {
            while(a.DotIndex!=b.DotIndex){
                for (int i=a.cA-1; i>=0; i--) {
                    a.A[i+1]=a.A[i];
                }
                a.DotIndex++;
                a.cA++;
                a.A[0]=0;
            }
        }
        if(a.cA!=b.cA){
            if(a.cA>b.cA){
                b.cA=a.cA;
            } else if (a.cA<b.cA) {
                a.cA=b.cA;
            }
        }
    }
    private void Equal2(BigDouble a, BigDouble b){
        if(a.DotIndex==b.DotIndex){
            return;
        }
        else if (a.DotIndex>b.DotIndex) {
            while(a.DotIndex!=b.DotIndex){
                for (int i=b.cA-1; i>=0; i--) {
                    b.A[i+1]=b.A[i];
                }
                b.DotIndex++;
                b.cA++;
                b.A[0]=0;
            }

        }
        else {
            while(a.DotIndex!=b.DotIndex){
                for (int i=a.cA-1; i>=0; i--) {
                    a.A[i+1]=a.A[i];
                }
                a.DotIndex++;
                a.cA++;
                a.A[0]=0;
            }
        }
    }


    public void SetDot(int dotIndex){
        if (this.DotIndex==-1) {
        for (int i=this.cA-1; i>=dotIndex; i--) {
            this.A[i+1]=this.A[i];
        }
        this.A[dotIndex]=-1;
        this.Length();
        this.DotIndex=dotIndex;
        }
        else{
            this.DeleteDot();
            this.SetDot(dotIndex);
        }
    }
    private void Delete(){
        this.DotIndex=-1;
        this.cA=1;
        this.sign=Sign.PLUS;
        for (int i=0; i<this.A.length; i++) {
            this.A[i]=0;
        }
    }


}


