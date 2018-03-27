package tastydew.com.justthetip;

/**
 * Created by tasty on 3/26/2018.
 */

public class BillModel {


    private double billSubTotal;
    private double splitAmount;
    private double tipPercentage;
    private double billGrandTotal;


    public BillModel(){
        billSubTotal=0.00;
        splitAmount=1;
        tipPercentage=0;
        billSubTotal=0.00;
    }

    public BillModel(double billSubTotal, int splitAmount, double tipPercentage, double billGrandTotal){
        this.setBillSubTotal(billSubTotal);
        this.setSplitAmount(splitAmount);
        this.setTipPercentage(tipPercentage);
        this.setBillGrandTotal(billGrandTotal);
    }



    public double getBillSubTotal() {
        return billSubTotal;
    }

    public void setBillSubTotal(double billSubTotal) {
         this.billSubTotal = billSubTotal;
    }

    public double getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(int splitAmount) {
        this.splitAmount = splitAmount;
    }

    public double getTipPercentage() {
        return tipPercentage;
    }

    public void setTipPercentage(double tipPercentage) {

        if (tipPercentage >= 1){
            tipPercentage /= 100;
            this.tipPercentage = tipPercentage;
        }

    }
    public double getBillGrandTotal() {
        return billGrandTotal;
    }

    public void setBillGrandTotal(double billGrandTotal) {
            this.billGrandTotal = billGrandTotal;
    }

    //calculation methods


    public double CalculateTotal(double subTotalAmount, double split, double tip) {

        return billGrandTotal = ((subTotalAmount * tip) + subTotalAmount) / split;
    }

}
