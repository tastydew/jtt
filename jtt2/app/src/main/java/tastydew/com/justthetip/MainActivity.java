package tastydew.com.justthetip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    BillModel billModel;
    EditText billSubTotalView;
    TextView tipAmountView;
    SeekBar splitSeeker;
    SeekBar tipSeeker;
    TextView splitAmountCounter;
    TextView billGrandTotalView;
    BillController billController;
    DecimalFormat tipFormat;
    NumberFormat gtFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billSubTotalView = findViewById(R.id.txt_BillAmt);
        tipAmountView = findViewById(R.id.txt_TipAmount);
        splitSeeker = findViewById(R.id.seekBar_SplitAmount);
        splitAmountCounter = findViewById(R.id.text_SplitCounter);
        tipSeeker =  findViewById(R.id.seekBar_TipAmount);
        billGrandTotalView = findViewById(R.id.text_TotalBillAmount);
        billModel = new BillModel();
        billController = new BillController(this, billModel);

        tipFormat = new DecimalFormat("##");
        gtFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());

        billGrandTotalView.setOnTouchListener(this);
        billSubTotalView.setOnTouchListener(this);
        splitSeeker.setOnTouchListener(this);
        tipSeeker.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        billGrandTotalView.setText(gtFormat.format(billController.grandTotal));
        tipAmountView.setText(tipFormat.format(billController.tipAmount * 100) + "%");
        splitAmountCounter.setText(tipFormat.format(billController.splitAmount));
        return false;
    }
}
