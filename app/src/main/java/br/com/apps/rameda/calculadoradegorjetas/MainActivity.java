package br.com.apps.rameda.calculadoradegorjetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed_valor;
    TextView tv_gorgeta,tv_total,tv_valor;
    SeekBar seekBar;
    double porcent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_valor = (EditText)findViewById(R.id.ed_valor);
        tv_gorgeta = (TextView)findViewById(R.id.tv_gorgeta);
        tv_valor = (TextView)findViewById(R.id.tv_valor);
        tv_total = (TextView)findViewById(R.id.tv_total);
        seekBar = (SeekBar)findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               porcent  = seekBar.getProgress();
               tv_valor.setText(porcent+"%");
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

    private void calcular() {
        double valor = Double.parseDouble(ed_valor.getText().toString());
        double gorgeta = valor *(porcent/100);
        double total = gorgeta+valor;

        tv_total.setText("R$"+total);
        tv_gorgeta.setText("R$"+gorgeta);
    }
}
