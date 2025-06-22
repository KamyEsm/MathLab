package com.example.mathlab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
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
    private String Polynomial1="0";
    private String Polynomial2="0";
    @FXML
    private TextArea PResult;
    @FXML
    private TextArea Polynomial1TextArea;
    @FXML
    private TextArea Polynomial2TextArea;
    @FXML
    private ComboBox<String> Operation1;
    private boolean FirstOrSecond=false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Operation1.getItems().addAll("Sum","Minus","Multiple","Division","Power","Mod","Derivative","Integral");
        Polynomial1TextArea.setText(Polynomial1);
        Polynomial2TextArea.setText(Polynomial2);
        PResult.setText("0");
    }

    public void ComboAction(ActionEvent actionEvent) {
        if(Operation1.getSelectionModel().getSelectedItem().equals("Derivative") || Operation1.getSelectionModel().getSelectedItem().equals("Integral"))
            Polynomial1TextArea.setVisible(false);
        else
            Polynomial1TextArea.setVisible(true);
    }

    public void PEnter(ActionEvent actionEvent) {
        if(FirstOrSecond) FirstOrSecond=false;
        else FirstOrSecond=true;
    }

    public void PSet0(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")) return;
            Polynomial2+='0';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")) return;
            Polynomial1+='0';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSet1(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")){
                Polynomial2="1";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2+='1';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")){
                Polynomial1="1";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1+='1';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSet2(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")){
                Polynomial2="2";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2+='2';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")){
                Polynomial1="2";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1+='2';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSet3(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")){
                Polynomial2="3";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2+='3';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")){
                Polynomial1="3";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1+='3';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSet4(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")){
                Polynomial2="4";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2+='4';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")){
                Polynomial1="4";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1+='4';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSet5(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")){
                Polynomial2="5";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2+='5';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")){
                Polynomial1="5";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1+='5';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSet6(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")){
                Polynomial2="6";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2+='6';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")){
                Polynomial1="6";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1+='6';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSet7(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")){
                Polynomial2="7";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2+='7';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")){
                Polynomial1="7";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1+='7';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSet8(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")){
                Polynomial2="8";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2+='8';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")){
                Polynomial1="8";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1+='8';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSet9(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")){
                Polynomial2="9";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2+='9';
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")){
                Polynomial1="9";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1+='9';
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PDelete(ActionEvent actionEvent) {
        if(FirstOrSecond){
            if (Polynomial2.equals("0")) return;
            Polynomial2=Polynomial2.substring(0,Polynomial2.length()-1);
            if(Polynomial2.equals("")) {
                Polynomial2="0";
                Polynomial2TextArea.setText(Polynomial2);
                return;
            }
            Polynomial2TextArea.setText(Polynomial2);
        }
        else {
            if (Polynomial1.equals("0")) return;
            Polynomial1=Polynomial1.substring(0,Polynomial1.length()-1);
            if(Polynomial1.equals("")) {
                Polynomial1="0";
                Polynomial1TextArea.setText(Polynomial1);
                return;
            }
            Polynomial1TextArea.setText(Polynomial1);
        }
    }

    public void PSetX(ActionEvent actionEvent) {
    }

    public void PSetPowSign(ActionEvent actionEvent) {

    }

    public void PSetPlusSign(ActionEvent actionEvent) {
    }

    public void PSetMinusSign(ActionEvent actionEvent) {
    }


    public void PClear(ActionEvent actionEvent) {
    }

    public void PEquals(ActionEvent actionEvent) {
    }



}///class