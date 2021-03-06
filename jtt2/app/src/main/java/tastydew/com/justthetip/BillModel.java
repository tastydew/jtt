package tastydew.com.justthetip;

/**
 * Created by tasty on 3/26/2018.
 */

public class BillModel {


    private double billSubTotal;
    private int splitAmount;
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
    }



    public double getBillSubTotal() {
        return billSubTotal;
    }

    public void setBillSubTotal(double billSubTotal) {
         this.billSubTotal = billSubTotal;
    }

    public int getSplitAmount() {
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
        return (getBillSubTotal() * (1 + getTipPercentage())) / getSplitAmount();
    }


}
