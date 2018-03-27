package tastydew.com.justthetip;

import android.app.Activity;
import android.view.View;
import android.widget.SeekBar;

/**
 * Created by tasty on 3/26/2018.
 */

public class BillController {

    private BillModel bModel;
    private MainActivity bView;
    public int splitAmount;

    public int getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(int splitAmount) {
        this.splitAmount = splitAmount;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = tipAmount;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double subTotal;
    public double tipAmount;
    public double grandTotal;

    public BillController(final MainActivity bView, final BillModel bModel){
        this.bModel = bModel;
        this.bView = bView;

        subTotal = bModel.getBillSubTotal();
        splitAmount = bModel.getSplitAmount();
        tipAmount = bModel.getTipPercentage();
        grandTotal = bModel.getBillGrandTotal();




        bView.billSubTotalView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if (!bView.billSubTotalView.getText().toString().equals("")) {
                    subTotal = Double.parseDouble(bView.billSubTotalView.getText().toString());
                }

            }
        });

        this.bView.splitSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setSplitAmount(progress);
                bModel.setTipPercentage(bView.tipSeeker.getProgress());
                bModel.setSplitAmount(getSplitAmount());

                if (!bView.billSubTotalView.getText().toString().equals("")) {
                    bModel.setBillSubTotal(getSubTotal());
                    bModel.setBillGrandTotal(calculateAndSetGrandTotal());
                }

                if (getSplitAmount() == 1){
                    bView.personIndicator.setText("Person");
                }
                else {
                    bView.personIndicator.setText("People");
                }

                splitAmount = bModel.getSplitAmount();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                splitAmount = bView.splitSeeker.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                splitAmount = bView.splitSeeker.getProgress();
            }
        });

        this.bView.tipSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                bModel.setTipPercentage(bView.tipSeeker.getProgress());

                if (!bView.billSubTotalView.getText().toString().equals("")) {
                    bModel.setBillSubTotal(getSubTotal());

                    bModel.setBillGrandTotal(calculateAndSetGrandTotal());
                }
                tipAmount = bModel.getTipPercentage();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                tipAmount = bModel.getTipPercentage();            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tipAmount = bModel.getTipPercentage();            }
        });


    }

    private double calculateAndSetGrandTotal() {

        double subTotal = this.subTotal;
        double tip = this.tipAmount;
        double splitAmt = this.splitAmount;
        return this.grandTotal = bModel.CalculateTotal(subTotal, splitAmt,tip);
    }

}
