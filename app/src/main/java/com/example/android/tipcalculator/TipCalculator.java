package com.example.android.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculator extends AppCompatActivity {
    private EditText Bill;
    private EditText costOfDiner;
    private CheckBox split;
    private TextView owedAmount;
    private SeekBar SeekB;
    private TextView outputView;
    private TextView barLabeling;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        owedAmount = findViewById(R.id.owedAmount);
        barLabeling = findViewById(R.id.barLabeling);
        split=findViewById(R.id.split);
        Bill=findViewById(R.id.Bill);
        outputView = findViewById(R.id.outputView);

        resultView=findViewById(R.id.resultView);
        resultView.setOnEditorActionListener(
                new TextView.OnEditorActionListener(){
                    @Override
                    public boolean onEditorAction(TextView textview, int i, KeyEvent keyEvent){
                        String rush = resultView.getText().getString();
                        int progression = Integer.parseInt(rush);
                        SeekB.setProgress(progression);
                        return false;
                    }
                }
        );
        costOfDiner=findViewById(R.id.costOfDiner);
        SeekB = findViewById(R.id.SeekB);
        SeekB.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){
                    @Override
                    public void onProgressChanged(SeekBar SeekB){
                        SeekB.setMax(50);
                        barLabeling.setText(String.valueOf(i));
                    }
                }
        );

    }


    public void buttonPressed(View v){
        int bp = SeekB.getProgress();
        Toast.makeText(this,"Finished",Toast.LENGTH_SHORT).show();
        double result;
        double result2;
        String userBillInput = Bill.getText().toString();
        double  uBI = Double.parseDouble(userBillInput);
        String userDinerInput = costOfDiner.getText().toString();
        double  uDI = Double.parseDouble(userDinerInput);

        if(split.isChecked()){
            result=(uBI/uDI)*(bp/100);
            result2=result+uBI;
        }
        else{
            result=uBI*(bp/100);
            result2=result+uBI;
        }
        owedAmount.setText(result2+"");
        resultView.setText(result+"");

    }
}
