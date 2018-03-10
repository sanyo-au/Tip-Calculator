package com.example.sanyo.hw1_groups24;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Double tipValue, totalValue, billValue;
    int tipValuePercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative); 
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        setTitle("Tip Calculator");

        final EditText bill = findViewById(R.id.etBillValue);
        final RadioGroup rg = findViewById(R.id.radioGroupTip);
        final TextView tip = findViewById(R.id.tvTipValue);
        final TextView total = findViewById(R.id.tvTotalValue);
        final TextView progress = findViewById(R.id.tvSeekBarValue);

        final SeekBar sb = findViewById(R.id.seekBarCustom);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress.setText(""+i+"%");
                if(rg.getCheckedRadioButtonId() == R.id.rbCustom){
                    int tipPercent = sb.getProgress();
                    tipValue = billValue * tipPercent / 100;
                    totalValue = billValue + tipValue;
                    tip.setText(tipValue.toString());
                    total.setText(totalValue.toString());
                    
                } 
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bill.getText().toString().equals("")) {
                    bill.setError("Enter Bill Value");
                    tip.setText("0.0");
                    total.setText("0.0");
                } else if(bill.getText() != null){
                    billValue = Double.parseDouble(bill.getText().toString());
                    if (R.id.rb10 == rg.getCheckedRadioButtonId()) {
                        tipValue = billValue * 0.10;
                        totalValue = billValue + tipValue;
                    } else if (R.id.rb15 == rg.getCheckedRadioButtonId()) {
                        tipValue = billValue * 0.15;
                        totalValue = billValue + tipValue;
                    } else if (R.id.rb18 == rg.getCheckedRadioButtonId()) {
                        tipValue = billValue * 0.18;
                        totalValue = billValue + tipValue;
                    } else if (R.id.rbCustom == rg.getCheckedRadioButtonId()) {
                        int tipPercent = sb.getProgress();
                        tipValue = billValue * tipPercent / 100;
                        totalValue = billValue + tipValue;

                    }
                    tip.setText(tipValue.toString());
                    total.setText(totalValue.toString());
                }

            }


        });
        bill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (bill.getText().toString().equals("")) {
                    bill.setError("Enter Bill Value");
                    tip.setText("0.0");
                    total.setText("0.0");
                } else {
                    rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            if (bill.getText().toString().equals("")) {
                                bill.setError("Enter Bill Value");
                                tip.setText("0.0");
                                total.setText("0.0");
                            } else {
                                billValue = Double.parseDouble(bill.getText().toString());
                                if (R.id.rb10 == rg.getCheckedRadioButtonId()) {
                                    tipValue = billValue * 0.10;
                                    totalValue = billValue + tipValue;
                                } else if (R.id.rb15 == rg.getCheckedRadioButtonId()) {
                                    tipValue = billValue * 0.15;
                                    totalValue = billValue + tipValue;
                                } else if (R.id.rb18 == rg.getCheckedRadioButtonId()) {
                                    tipValue = billValue * 0.18;
                                    totalValue = billValue + tipValue;
                                } else if (R.id.rbCustom == rg.getCheckedRadioButtonId()) {
                                    int tipPercent = sb.getProgress();
                                    tipValue = billValue * tipPercent / 100;
                                    totalValue = billValue + tipValue;
                                }
                                tip.setText(tipValue.toString());
                                total.setText(totalValue.toString());

                            }
                        }

                    });
                }
            }
        });
        Button button = findViewById(R.id.buttonExit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }




}
