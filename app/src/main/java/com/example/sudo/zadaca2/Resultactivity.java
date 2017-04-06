package com.example.sudo.zadaca2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultactivity extends Activity {

    TextView tvUlaz, tvIzlaz, tvUlaznaJedinica, tvIzlaznaJedinica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultactivity);
        initializeUI();
    }

    private void initializeUI() {
        this.tvUlaz = (TextView) findViewById(R.id.tvUlaz);
        this.tvUlaznaJedinica = (TextView) findViewById(R.id.tvUlaznaJedinica);
        this.tvIzlaz = (TextView) findViewById(R.id.tvIzlaz);
        this.tvIzlaznaJedinica = (TextView) findViewById(R.id.tvIzlaznaJedinica);

        Intent rezultat = this.getIntent();
        if (rezultat.hasExtra(Kut.KEY_ULAZ_VAR)) {
            String inputData = rezultat.getStringExtra(Kut.KEY_ULAZ_VAR);
            tvUlaznaJedinica.setText(getString(R.string.Ulaz) + "\n" + inputData);
        }
        if (rezultat.hasExtra(Kut.KEY_ULAZ)) {
            Double inputValue = rezultat.getDoubleExtra(Kut.KEY_ULAZ, 0);
            tvUlaz.setText(getString(R.string.komentarZaUnos) + "\n" + String.valueOf(inputValue));
        }
        if (rezultat.hasExtra(Kut.KEY_IZLAZ_VAR)) {
            String outputData = rezultat.getStringExtra(Kut.KEY_IZLAZ_VAR);
            tvIzlaznaJedinica.setText(getString(R.string.JedKonv) + "\n" + outputData);
        }
        if (rezultat.hasExtra(Kut.KEY_IZLAZ)) {
            Double outputValue = rezultat.getDoubleExtra(Kut.KEY_IZLAZ, 0);
            tvIzlaz.setText(getString(R.string.Rezultat) + "\n" + String.valueOf(outputValue));
        }
    }

    public void ocReturn(View view) {
        finish();
    }


    public void ocStart(View view) {
        Intent pocetak = new Intent(this, MainActivity.class);
        {
            this.startActivity(pocetak);
        }
    }
}
