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

    private double subTotal;
    private double tipAmount;
    private double grandTotal;

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
        return bModel.getBillGrandTotal();
    }



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
                setSplitAmount(0);
                setSplitAmount(progress);
                bModel.setTipPercentage(bView.tipSeeker.getProgress());
                bModel.setSplitAmount(getSplitAmount());

                if (!bView.billSubTotalView.getText().toString().equals("")) {
                    bModel.setBillSubTotal(getSubTotal());
                    bModel.getBillGrandTotal();
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
                setSplitAmount(splitAmount);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                splitAmount = bView.splitSeeker.getProgress();
                setSplitAmount(splitAmount);
            }
        });

        this.bView.tipSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                bModel.setTipPercentage(bView.tipSeeker.getProgress());

                if (!bView.billSubTotalView.getText().toString().equals("")) {
                    bModel.setBillSubTotal(getSubTotal());

                    bModel.getBillGrandTotal();
                }
                tipAmount = bModel.getTipPercentage();
                setTipAmount(tipAmount);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                tipAmount = bModel.getTipPercentage();
                setTipAmount(tipAmount);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


    }

}
