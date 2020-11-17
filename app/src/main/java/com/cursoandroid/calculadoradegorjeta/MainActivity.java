package com.cursoandroid.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editValue;
    private TextView textPercent;
    private TextView textTip;
    private TextView textTotal;
    private SeekBar seekBarTip;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue = findViewById(R.id.editValue);
        textTip = findViewById(R.id.textTip);
        textPercent = findViewById(R.id.textPercent);
        textTotal = findViewById(R.id.textTotal);
        seekBarTip = findViewById(R.id.seekBarTip);

        //Add listener Seekbar
        seekBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPercent.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular() {
        String valorRecuperado = editValue.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro!", Toast.LENGTH_LONG).show();
        } else {
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //calcula gorjeta
            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = gorjeta + valorDigitado;

//            textTip.setText("R$ " + Math.round(gorjeta));
            textTip.setText("R$ " + gorjeta);
            textTotal.setText("R$ " + total);
        }
    }
}