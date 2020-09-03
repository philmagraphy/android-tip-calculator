package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class TipCalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    TextInputEditText cacheCheckAmountView;
    TextInputEditText cachePartySizeView;

    TextView cacheAmountPreTipView;
    TextView cache15TipView;
    TextView cache20TipView;
    TextView cache25TipView;
    TextView cache15TotalView;
    TextView cache20TotalView;
    TextView cache25TotalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cacheCheckAmountView = findViewById(R.id.checkAmountValue);
        cachePartySizeView = findViewById(R.id.partySizeValue);

        cacheAmountPreTipView = findViewById(R.id.amountPreTip);
        cache15TipView = findViewById(R.id.fifteenPercentTipValue);
        cache20TipView = findViewById(R.id.twentyPercentTipValue);
        cache25TipView = findViewById(R.id.twentyfivePercentTipValue);
        cache15TotalView = findViewById(R.id.fifteenPercentTotalValue);
        cache20TotalView = findViewById(R.id.twentyPercentTotalValue);
        cache25TotalView = findViewById(R.id.twentyfivePercentTotalValue);

        Button buttonCompute = findViewById(R.id.buttonCompute);
        buttonCompute.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

            String checkAmountString = cacheCheckAmountView.getText().toString();
            Double checkAmountIntVal = Double.parseDouble(checkAmountString);
            String checkPartySizeString = cachePartySizeView.getText().toString();
            Integer partySizeIntVal = Integer.parseInt(checkPartySizeString);
            if(checkAmountIntVal < 0 || partySizeIntVal < 1) {
                throw new NumberFormatException();
            }
            else {
                Integer perPersonAmount = (int) Math.round(checkAmountIntVal / partySizeIntVal);
                Integer perPersonTip15 = (int) Math.round(perPersonAmount * 0.15);
                Integer perPersonTip20 = (int) Math.round(perPersonAmount * 0.20);
                Integer perPersonTip25 = (int) Math.round(perPersonAmount * 0.25);

                Integer perPersonTotal15 = perPersonAmount + perPersonTip15;
                Integer perPersonTotal20 = perPersonAmount + perPersonTip20;
                Integer perPersonTotal25 = perPersonAmount + perPersonTip25;

                cacheAmountPreTipView.setText(getString(R.string.displayAmount, perPersonAmount.toString()));
                cache15TipView.setText(getString(R.string.displayTip, perPersonTip15.toString()));
                cache20TipView.setText(getString(R.string.displayTip, perPersonTip20.toString()));
                cache25TipView.setText(getString(R.string.displayTip, perPersonTip25.toString()));
                cache15TotalView.setText(getString(R.string.displayTotal, perPersonTotal15.toString()));
                cache20TotalView.setText(getString(R.string.displayTotal, perPersonTotal20.toString()));
                cache25TotalView.setText(getString(R.string.displayTotal, perPersonTotal25.toString()));
            }
        }
        catch (NumberFormatException nfe) {
            Toast badValToast = Toast.makeText(this, "Invalid value(s) provided.", Toast.LENGTH_SHORT);
            badValToast.show();
        }
    }
}
