package com.example.mathlab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    /// ///////////////////////////////////////////BigInt

    @FXML
    private TextArea ResultText;
    @FXML
    private TextArea HistoryText;
    private String Calculations1="";
    String BigIntHistory="";



    public void Set0(ActionEvent actionEvent) {
        Calculations1=Calculations1+"0";
        ResultText.setText(Calculations1);
    }
    public void Set1(ActionEvent actionEvent) {
        Calculations1=Calculations1+"1";
        ResultText.setText(Calculations1);
    }

    public void Set2(ActionEvent actionEvent) {
        Calculations1=Calculations1+"2";
        ResultText.setText(Calculations1);
    }

    public void Set3(ActionEvent actionEvent) {
        Calculations1=Calculations1+"3";
        ResultText.setText(Calculations1);
    }

    public void Set4(ActionEvent actionEvent) {
        Calculations1=Calculations1+"4";
        ResultText.setText(Calculations1);
    }

    public void Set5(ActionEvent actionEvent) {
        Calculations1=Calculations1+"5";
        ResultText.setText(Calculations1);
    }


    public void Set6(ActionEvent actionEvent) {
        Calculations1=Calculations1+"6";
        ResultText.setText(Calculations1);
    }
    public void Set7(ActionEvent actionEvent) {
        Calculations1=Calculations1+"7";
        ResultText.setText(Calculations1);
    }

    public void Set8(ActionEvent actionEvent) {
        Calculations1=Calculations1+"8";
        ResultText.setText(Calculations1);
    }

    public void Set9(ActionEvent actionEvent) {
        Calculations1=Calculations1+"9";
        ResultText.setText(Calculations1);
    }

    public void SetMinus(ActionEvent actionEvent) {
        if (Calculations1.charAt(Calculations1.length()-1)!='-' && Calculations1.charAt(Calculations1.length()-1)!='+'&&
        Calculations1.charAt(Calculations1.length()-1)!='*' && Calculations1.charAt(Calculations1.length()-1)!='/'
         && Calculations1.charAt(Calculations1.length()-1)!='%'
        && Calculations1.charAt(Calculations1.length()-1)!='^')
            Calculations1=Calculations1+"-";
        ResultText.setText(Calculations1);
    }

    public void SetSum(ActionEvent actionEvent) {
        if (Calculations1.charAt(Calculations1.length()-1)!='-' && Calculations1.charAt(Calculations1.length()-1)!='+'&&
                Calculations1.charAt(Calculations1.length()-1)!='*' && Calculations1.charAt(Calculations1.length()-1)!='/'
                && Calculations1.charAt(Calculations1.length()-1)!='%'
                && Calculations1.charAt(Calculations1.length()-1)!='^')
            Calculations1=Calculations1+"+";
        ResultText.setText(Calculations1);
    }

    public void SetMultiple(ActionEvent actionEvent) {if (Calculations1.charAt(Calculations1.length()-1)!='-' && Calculations1.charAt(Calculations1.length()-1)!='+'&&
            Calculations1.charAt(Calculations1.length()-1)!='*' && Calculations1.charAt(Calculations1.length()-1)!='/'
            && Calculations1.charAt(Calculations1.length()-1)!='%'
            && Calculations1.charAt(Calculations1.length()-1)!='^')
            Calculations1=Calculations1+"*";
        ResultText.setText(Calculations1);
    }

    public void SetMod(ActionEvent actionEvent) {
        if (Calculations1.charAt(Calculations1.length()-1)!='-' && Calculations1.charAt(Calculations1.length()-1)!='+'&&
                Calculations1.charAt(Calculations1.length()-1)!='*' && Calculations1.charAt(Calculations1.length()-1)!='/'
                && Calculations1.charAt(Calculations1.length()-1)!='%'
                && Calculations1.charAt(Calculations1.length()-1)!='^')
            Calculations1=Calculations1+"%";
        ResultText.setText(Calculations1);
    }

    public void SetFactorial(ActionEvent actionEvent) {
        if (Calculations1.charAt(Calculations1.length()-1)!='-' && Calculations1.charAt(Calculations1.length()-1)!='+'&&
                Calculations1.charAt(Calculations1.length()-1)!='*' && Calculations1.charAt(Calculations1.length()-1)!='/'
                && Calculations1.charAt(Calculations1.length()-1)!='!' && Calculations1.charAt(Calculations1.length()-1)!='%'
                && Calculations1.charAt(Calculations1.length()-1)!='^')
            Calculations1=Calculations1+"!";
        ResultText.setText(Calculations1);
    }

    public void SetEquals(ActionEvent actionEvent) {
        Approximate_Calculations Calc=new Approximate_Calculations(Calculations1);
        Calc.FinallyCalculation();

        ResultText.setText(Calc.toString());
        BigIntHistory+=Calculations1+"="+Calc.toString()+"\n";
        HistoryText.setText(BigIntHistory);
        Calculations1=Calc.toString();
    }

    public void SetClearResult(ActionEvent actionEvent) {
        Calculations1="";
        ResultText.setText(Calculations1);
    }

    public void SetDelete(ActionEvent actionEvent) {
        if (Calculations1.length()!=0)
            Calculations1=Calculations1.substring(0,Calculations1.length()-1);
        ResultText.setText(Calculations1);
    }

    public void HistoryClean(ActionEvent actionEvent) {
        this.BigIntHistory="";
        HistoryText.setText(this.BigIntHistory);
    }

    public void SetLeftPR(ActionEvent actionEvent) {
        Calculations1=Calculations1+"(";
        ResultText.setText(Calculations1);
    }

    public void SetRightPR(ActionEvent actionEvent) {
        Calculations1=Calculations1+")";
        ResultText.setText(Calculations1);
    }
    public void SetPower(ActionEvent actionEvent) {
        if (Calculations1.charAt(Calculations1.length()-1)!='-' && Calculations1.charAt(Calculations1.length()-1)!='+'&&
                Calculations1.charAt(Calculations1.length()-1)!='*' && Calculations1.charAt(Calculations1.length()-1)!='/'
                && Calculations1.charAt(Calculations1.length()-1)!='%'
                && Calculations1.charAt(Calculations1.length()-1)!='^')
            Calculations1=Calculations1+"^";
        ResultText.setText(Calculations1);
    }
    public void SetDiv(ActionEvent actionEvent) {
        if (Calculations1.charAt(Calculations1.length()-1)!='-' && Calculations1.charAt(Calculations1.length()-1)!='+'&&
                Calculations1.charAt(Calculations1.length()-1)!='*' && Calculations1.charAt(Calculations1.length()-1)!='/'
                && Calculations1.charAt(Calculations1.length()-1)!='%'
                && Calculations1.charAt(Calculations1.length()-1)!='^')
            Calculations1=Calculations1+"/";
        ResultText.setText(Calculations1);
    }


    /// ////////////////////////////////////////////////////////////////////////////////BigDouble
    @FXML
    private TextArea DResultText;
    @FXML
    private TextArea DHistoryText;
    private String Calculation0="";
    private String DHistory="";


    public void DSet0(ActionEvent actionEvent) {
        Calculation0=Calculation0+"0";
        DResultText.setText(Calculation0);
    }


    public void DSet2(ActionEvent actionEvent) {
        Calculation0=Calculation0+"2";
        DResultText.setText(Calculation0);
    }

    public void DSet3(ActionEvent actionEvent) {
        Calculation0=Calculation0+"3";
        DResultText.setText(Calculation0);
    }

    public void DSet1(ActionEvent actionEvent) {
        Calculation0=Calculation0+"1";
        DResultText.setText(Calculation0);
    }

    public void DSet5(ActionEvent actionEvent) {
        Calculation0=Calculation0+"5";
        DResultText.setText(Calculation0);
    }

    public void DSet6(ActionEvent actionEvent) {
        Calculation0=Calculation0+"6";
        DResultText.setText(Calculation0);
    }

    public void DSet4(ActionEvent actionEvent) {
        Calculation0=Calculation0+"4";
        DResultText.setText(Calculation0);
    }

    public void DSet8(ActionEvent actionEvent) {
        Calculation0=Calculation0+"8";
        DResultText.setText(Calculation0);
    }

    public void DSet9(ActionEvent actionEvent) {
        Calculation0=Calculation0+"9";
        DResultText.setText(Calculation0);
    }

    public void DSet7(ActionEvent actionEvent) {
        Calculation0=Calculation0+"7";
        DResultText.setText(Calculation0);
    }

    public void DDiv(ActionEvent actionEvent) {
        if (Calculation0.charAt(Calculation0.length()-1)!='-' && Calculation0.charAt(Calculation0.length()-1)!='+'&&
                Calculation0.charAt(Calculation0.length()-1)!='*' && Calculation0.charAt(Calculation0.length()-1)!='/'
                && Calculation0.charAt(Calculation0.length()-1)!='%'
                && Calculation0.charAt(Calculation0.length()-1)!='^')
            Calculation0=Calculation0+"/";
        DResultText.setText(Calculation0);
    }

    public void DMultiple(ActionEvent actionEvent) {
        if (Calculation0.charAt(Calculation0.length()-1)!='-' && Calculation0.charAt(Calculation0.length()-1)!='+'&&
                Calculation0.charAt(Calculation0.length()-1)!='*' && Calculation0.charAt(Calculation0.length()-1)!='/'
                && Calculation0.charAt(Calculation0.length()-1)!='%'
                && Calculation0.charAt(Calculation0.length()-1)!='^')
            Calculation0=Calculation0+"*";
        DResultText.setText(Calculation0);
    }

    public void DPow(ActionEvent actionEvent) {
        if (Calculation0.charAt(Calculation0.length()-1)!='-' && Calculation0.charAt(Calculation0.length()-1)!='+'&&
                Calculation0.charAt(Calculation0.length()-1)!='*' && Calculation0.charAt(Calculation0.length()-1)!='/'
                && Calculation0.charAt(Calculation0.length()-1)!='%'
                && Calculation0.charAt(Calculation0.length()-1)!='^')
            Calculation0=Calculation0+"^";
        DResultText.setText(Calculation0);
    }

    public void DSetClearResult(ActionEvent actionEvent) {
        Calculation0="";
        DResultText.setText(Calculation0);
    }

    public void DSetDelete(ActionEvent actionEvent) {
        if (Calculation0.length()!=0)
            Calculation0=Calculation0.substring(0,Calculation0.length()-1);
        DResultText.setText(Calculation0);
    }

    public void DSetLeftPR(ActionEvent actionEvent) {
        Calculation0=Calculation0+"(";
        DResultText.setText(Calculation0);
    }

    public void DSetRightPR(ActionEvent actionEvent) {
        Calculation0=Calculation0+")";
        DResultText.setText(Calculation0);
    }

    public void DMod(ActionEvent actionEvent) {
        if (Calculation0.charAt(Calculation0.length()-1)!='-' && Calculation0.charAt(Calculation0.length()-1)!='+'&&
                Calculation0.charAt(Calculation0.length()-1)!='*' && Calculation0.charAt(Calculation0.length()-1)!='/'
                && Calculation0.charAt(Calculation0.length()-1)!='%'
                && Calculation0.charAt(Calculation0.length()-1)!='^')
            Calculation0=Calculation0+"%";
        DResultText.setText(Calculation0);
    }

    public void DDot(ActionEvent actionEvent) {
        Calculation0=Calculation0+".";
        DResultText.setText(Calculation0);
    }

    public void DSum(ActionEvent actionEvent) {
        if (Calculation0.charAt(Calculation0.length()-1)!='-' && Calculation0.charAt(Calculation0.length()-1)!='+'&&
                Calculation0.charAt(Calculation0.length()-1)!='*' && Calculation0.charAt(Calculation0.length()-1)!='/'
                && Calculation0.charAt(Calculation0.length()-1)!='%'
                && Calculation0.charAt(Calculation0.length()-1)!='^')
            Calculation0=Calculation0+"+";
        DResultText.setText(Calculation0);
    }

    public void DMinus(ActionEvent actionEvent) {
        if (Calculation0.charAt(Calculation0.length()-1)!='-' && Calculation0.charAt(Calculation0.length()-1)!='+'&&
                Calculation0.charAt(Calculation0.length()-1)!='*' && Calculation0.charAt(Calculation0.length()-1)!='/'
                && Calculation0.charAt(Calculation0.length()-1)!='%'
                && Calculation0.charAt(Calculation0.length()-1)!='^')
            Calculation0=Calculation0+"-";
        DResultText.setText(Calculation0);
    }

    public void DHistoryClean(ActionEvent actionEvent) {
        DHistory="";
        DHistoryText.setText(DHistory);
    }

    public void DSetEqual(ActionEvent actionEvent) {
        Decimals_Calculation Calc=new Decimals_Calculation(Calculation0);
        Calc.FinallyCalculation();

        DResultText.setText(Calc.toString());
        DHistory+=Calculation0+"="+Calc.toString()+"\n";
        DHistoryText.setText(DHistory);
        Calculation0=Calc.toString();
    }


    /// ///////////////////////////////////////////////////////////////////////////////Polynomial
    private String FirstP="";
    private String SecondP="";
    private boolean T=false;
    @FXML
    private TextArea PResult;


    public void PSet0(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '0';
            PResult.setText(FirstP);
        }

        else {
            SecondP += '0';
            PResult.setText(SecondP);
        }
    }

    public void PSet1(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '1';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '1';
            PResult.setText(SecondP);
        }
    }

    public void PSet2(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '2';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '2';
            PResult.setText(SecondP);
        }
    }

    public void PSet3(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '3';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '3';
            PResult.setText(SecondP);
        }
    }

    public void PSet4(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '4';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '4';
            PResult.setText(SecondP);
        }
    }

    public void PSet5(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '5';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '5';
            PResult.setText(SecondP);
        }
    }

    public void PSet6(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '6';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '6';
            PResult.setText(SecondP);
        }
    }

    public void PSet7(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '7';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '7';
            PResult.setText(SecondP);
        }
    }

    public void PSet8(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '8';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '8';
            PResult.setText(SecondP);
        }
    }

    public void PSet9(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '9';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '9';
            PResult.setText(SecondP);
        }
    }

    public void PSetX(ActionEvent actionEvent) {
        if(!T) {
            if (FirstP.charAt(FirstP.length() - 1) != '^')
                FirstP += 'X';
            PResult.setText(FirstP);
        }
        else {
            if (SecondP.charAt(SecondP.length() - 1) != '^')
                SecondP += 'X';
            PResult.setText(SecondP);
        }
    }

    public void PSetPowSign(ActionEvent actionEvent) {
        if(!T) {
            FirstP += '^';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '^';
            PResult.setText(SecondP);
        }
    }

    public void PSetPlusSign(ActionEvent actionEvent) {
        if (!T){
            FirstP += '+';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '+';
            PResult.setText(SecondP);
        }
    }

    public void PSetMinusSign(ActionEvent actionEvent) {
        if (!T){
            FirstP += '-';
            PResult.setText(FirstP);
        }
        else {
            SecondP += '-';
            PResult.setText(SecondP);
        }
    }

    public void PSum(ActionEvent actionEvent) {
    }

    public void PMinus(ActionEvent actionEvent) {
    }

    public void PPower(ActionEvent actionEvent) {
    }

    public void PDiv(ActionEvent actionEvent) {
    }

    public void PMod(ActionEvent actionEvent) {
    }

    public void PDerivative(ActionEvent actionEvent) {
    }

    public void PIntegral(ActionEvent actionEvent) {
    }

    public void PDelete(ActionEvent actionEvent) {
    }

    public void PClear(ActionEvent actionEvent) {
    }

    public void PEquals(ActionEvent actionEvent) {
    }


    /// /////////////////////////////////////////////////////////Polynomial



}///class