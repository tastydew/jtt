package tastydew.com.justthetip;

import android.app.Activity;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by tasty on 3/26/2018.
 */

public class BillView {

     EditText billSubTotalView;
     TextView tipAmountView;
     SeekBar splitSeeker;
     SeekBar tipSeeker;
     TextView billGrandTotalView;


    public BillView(Activity activity) {

        activity.setContentView(R.layout.activity_main);


    }
}
