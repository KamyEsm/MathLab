package com.example.mathlab;

public class BigInt {
    private int A[];
    private int cA;
    private String sign;
    /// //////////////////////////////////////////////////////////////////contractor
    public BigInt(BigInt V){
        A = new int[1000000];
        cA = 0;
        sign = "+";
        setter(V);
    }

    public BigInt() {
        A = new int[1000000];
        cA=0;
        sign = "+";
    }
    public BigInt(String s) {
        A = new int[1000000];
        cA=0;
        sign = "+";
        setter(s);


    }
    public BigInt(int v){
        A = new int[1000000];
        cA=0;
        sign = "+";
        if(v==0)
            cA=1;
        setter(v);
    }

    /// ////////////////////////////////////////////////////////setter
    public void setter(int index,byte v){
        if(index>cA-1) {
            System.err.println("out of range");
            return;
        }
        A[cA-index-1]=(int)(v);

    }


    public void setter(BigInt a){
        boolean t=zerocheck(this);
        if(!t){
            for(int i=0;i<A.length;i++){
                A[i]=0;
            }
        }
        this.cA=a.cA;
        for (int x=0;x<cA;x++){
            this.A[x]=a.A[x];
        }
        this.sign=a.sign;
    }

    public void setter(int a){
        boolean t=zerocheck(this);
        if(!t){
            for(int i=0;i<A.length;i++){
                A[i]=0;
            }
        }
        if(a<0) {
            a=Math.abs(a);
            sign = "-";
        }


        while (a>0){
            A[cA++]=a%10;
            a=a/10;
        }
    }


    public void setter(String s){
        boolean t=zerocheck(this);
        if(!t){
            for(int i=0;i<A.length;i++){
                A[i]=0;
            }
        }
        boolean test=check(s);
        if(!test){
            System.out.println("error: invalid!");
            return;
        }




        int i=0;
        if(s.charAt(0)=='-'){
            sign = "-";
            i=1;
        }
        if(s.charAt(0)=='+'){
            i=1;
        }
        for(int x=s.length()-1;x>=i;x--) {
            A[s.length() - x - 1] = s.charAt(x)-'0';
            cA++;
        }





    }
    /// ////////////////////////////////////////////////////////getter
    @Override
    public String toString(){
        String s="";
        for (int i=0;i<cA;i++) {
            s=A[i]+s;
        }
        if(sign.equals("-")){
            s=sign+s;
        }
        return s;
    }
    public int[] getArray(){
        return this.A;
    }
    public int DigitAt(int index){
        return this.A[cA-index-1];
    }

    /// ////////////////////////////////////////////////////////////////   Function
    public int sum(BigInt a,BigInt b) {

        boolean negetive=false;
        if(a.sign.equals("-") && b.sign.equals("-")){
            negetive=true;
        }
        if(a.sign.equals("+") && b.sign.equals("-")){
            b.sign="+";
            return this.Minus(a,b);
        }
        if(a.sign.equals("-") && b.sign.equals("+")){
            a.sign="+";
            return this.Minus(b,a);
        }



        int max=0;
        if(a.cA>=b.cA){
            max=a.cA;
        }
        else{
            max=b.cA;
        }

        int q=0;
        for (int i=0;i<max;i++) {
            int t=b.A[i]+a.A[i]+q;
            this.A[i]=t%10;
            q=t/10;
        }
        cA=max;
        if(q>0){
            A[this.cA++]=q%10;
            q/=10;
        }


        if(negetive){
            this.sign="-";
        }

        return cA;
    }


    public int Minus(BigInt a,BigInt b) {
        length(a);
        length(b);
        if(a.sign.equals("-") && b.sign.equals("+")){
            a.sign="+";
            this.sum(a,b);
            this.sign="-";
            return this.cA;
        }
        if (a.sign.equals("-") && b.sign.equals("-")){
            b.sign="+";
            a.sign="+";
            this.Minus(b,a);
            return this.cA;
        }
        boolean negetive=false;
        if(Number(a,b)==-1){
            negetive=true;
            BigInt k=new BigInt(a);
            a.setter(b);
            b.setter(k);
        }
        int max=0;
        if(a.cA>=b.cA){
            max=a.cA;
        }
        else{
            max=b.cA;
        }
        for (int i=0;i<max;i++) {
            if(a.A[i]>=b.A[i]){
                this.A[i]=a.A[i]-b.A[i];

            }
            else{
                if(a.A[i+1]!=0){
                    a.A[i+1]-=1;
                    a.A[i]+=10;
                    this.A[i]=a.A[i]-b.A[i];
                }
                else {

                    int z=i+1;
                    while(z!=a.A.length && a.A[z]==0){
                        a.A[z++]=9;
                    }
                    a.A[z]-=1;
                    a.A[i]+=10;
                    this.A[i]=a.A[i]-b.A[i];

                }

            }


        }
        cA=length(this);
        if(negetive){
            this.sign="-";
        }
        return cA;
    }

    public int Multiple(BigInt a,BigInt b) {

        this.cA=a.cA+ b.cA;
        if(a.sign.equals("-") && b.sign.equals("+")){
            sign="-";
        }
        if (a.sign.equals("+") && b.sign.equals("-")){
            sign="-";
        }
        BigInt G=new BigInt();
        for (int i=0;i<a.cA;i++) {
            int q=0;
            for (int j=0;j<b.cA;j++) {
                int t=a.A[i]*b.A[j]+q+G.A[i+j];
                G.A[i+j]=t%10;
                q=t/10;
            }
            if(q>0){
                G.A[i+b.cA]=q%10;
                q/=10;
            }
        }
        length(G);
        G.sign=this.sign;
        setter(G);


        return this.cA;
    }



    public void Multiple(BigInt a,int b) {

    }



    public int[] Divide(BigInt a,BigInt b) {

        if(zerocheck(b)){
            System.err.println("Division by zero");
            BigInt H=new BigInt();
            return H.A;
        }
        if(zerocheck(a)){
            for(int i=0;i<this.cA;i++) {
                A[i]=0;
            }
            this.cA=1;
            BigInt H=new BigInt();
            return H.A;
        }
        if(Number(a,b)==-1){
            for(int i=0;i<this.cA;i++) {
                A[i]=0;
            }
            this.cA=1;
            BigInt H=new BigInt();
            return H.A;
        }


        if(a.sign.equals("-") && b.sign.equals("+")){
            sign="-";
        }
        if (a.sign.equals("+") && b.sign.equals("-")){
            sign="-";
        }


        BigInt Q=new BigInt();
        BigInt R=new BigInt();
        for (int i=a.cA-1;i>=0;i--) {


            for(int y=R.cA-1;y>=0;y--) {
                R.A[y+1]=R.A[y];
            }


            R.A[0]=a.A[i];
            length(R);



            int Lindex=0;
            int Rindex=9;
            int avg;
            int Fctr=0;
            boolean flag2=false;
            while (Rindex>=Lindex) {
                avg = (Rindex+Lindex)/2;
                BigInt D=new BigInt(avg);

                D.Multiple(D,b);
                if(Number(R,D)>=0){
                    Fctr=avg;
                    Lindex=avg+1;
                    flag2=true;
                }
                else {
                    Rindex=avg-1;
                }
            }
            if(Fctr>0 || flag2) {
                Q.A[Q.cA++]=Fctr;
            }
            BigInt T=new BigInt(Fctr);
            T.Multiple(T,b);
            R.Minus(R,T);

        }
        for(int x=0;x< Q.cA/2;x++) {
            int temp=Q.A[x];
            Q.A[x]=Q.A[Q.cA-x-1];
            Q.A[Q.cA-x-1]=temp;
        }
        length(Q);
        setter(Q);
        length(R);
        R.A[R.cA]=R.cA;
        return R.A;
    }


    public void Pow(BigInt a,BigInt b) {
        int c=Integer(b);
        BigInt Q=new BigInt(1);
        for (int i=0;i<c;i++) {
            Q.Multiple(a,Q);
        }
        setter(Q);
        length(this);

    }

    public void Factorial(BigInt a) {
       
            
        zero(this);
        this.A[0]=1;
        BigInt Q=new BigInt(1);
        BigInt R=new BigInt(1);
        while (Number(Q,a)<=0) {
            this.Multiple(Q,this);
            Q.sum(Q,R);
        }
        length(this);
    }


    public int length(){
        boolean flag=false;
        for (int i=this.A.length-1;i>=0;i--) {

            if(this.A[i]!=0){
                this.cA=i+1;
                flag=true;
                break;
            }

        }
        if(!flag){
            this.cA=1;
        }
        return this.cA;

    }
    public void sum(String a,String b){
        BigInt A=new BigInt(a);
        BigInt B=new BigInt(b);
        sum(A,B);
    }
    public int Compare(BigInt a){
        if(Number(this,a)==1)
            return 1;
        if(Number(this,a)==-1)
            return -1;
        return 0;
    }
    public void Mod(BigInt a,BigInt b){
        BigInt C=new BigInt(1);
        int L[]=new int[1000000];
        L=C.Divide(a,b);
        int cL=0;
        for (int i=L.length-1;i>=0;i--) {
            if(L[i]!=0){
                cL=L[i];
                L[i]=0;
                break;
            }
        }
        for (int i=0;i<cL;i++) {
            this.A[i]=L[i];
        }
        length(this);
        if(this.cA==0)
            this.cA=1;
    }
    /// ////////////////////////////////////////////////////////////////other
    private int Integer(BigInt a){
        int s=0;
        int p=1;
        for (int i=0;i<a.cA;i++) {
            s=a.A[i]*p+s;
            p*=10;
        }
        return s;
    }



    private void zero(BigInt a){
        for(int i=0;i<a.cA;i++) {
            A[i]=0;
        }
        a.cA=1;
    }


    private boolean zerocheck(BigInt a){
        for (int i=0;i<a.cA;i++) {
            if(a.A[i]!=0){
                return false;
            }
        }
        return true;
    }


    private int length(BigInt a){
        boolean flag=false;
        for (int i=a.A.length-1;i>=0;i--) {

            if(a.A[i]!=0){
               a.cA=i+1;
                flag=true;
                break;
           }

       }
        if(!flag){
            a.cA=1;
            return 1;
        }
        return a.cA;

    }


    private int Number(BigInt a,BigInt b) {
        if(a.cA>b.cA)
            return 1;
        if(a.cA<b.cA)
            return -1;
        for (int i=a.cA-1;i>=0;i--) {
            if(a.A[i]>b.A[i])
                return 1;
            if(a.A[i]<b.A[i])
                return -1;
        }
        return 0;
    }

    private boolean check(String s){
        int z=0;
        if(s.charAt(z)=='+' || s.charAt(z)=='-'){
            z++;
        }
        for(int i=z;i<s.length();i++) {
            if(!(s.charAt(i)>='0' && s.charAt(i)<='9')){
                return false;
            }
        }
        return true;
    }


}
