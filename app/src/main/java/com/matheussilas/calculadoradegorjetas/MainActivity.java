package com.matheussilas.calculadoradegorjetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrice;
    private TextView textPorc;
    private SeekBar seekPorc;
    private TextView textGorj;
    private TextView textTotal;

    private double porc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrice = findViewById(R.id.editPrice);
        seekPorc = findViewById(R.id.seekPorc);
        textPorc = findViewById(R.id.textPorc);
        textGorj = findViewById(R.id.textGorj);
        textTotal = findViewById(R.id.textTotal);

        seekPorc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                porc = i;
                textPorc.setText(Math.round(porc) + "%");
                calculate();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculate() {

        DecimalFormat format = new DecimalFormat("0.00");

        String price = editPrice.getText().toString();
        if (price == null || price.equals("")) {
            Toast.makeText(getApplicationContext(), "Digite o valor da conta", Toast.LENGTH_SHORT).show();
        } else {

            double number = Double.parseDouble(price);

            double resultGorj = number * (porc / 100);

            textGorj.setText("R$ " + format.format(resultGorj));

            double resultTotal = number + resultGorj;

            textTotal.setText("R$ " + format.format(resultTotal));

        }
    }
}
