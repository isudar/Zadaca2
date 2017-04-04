package com.example.sudo.zadaca2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Temperatura extends Activity {
    EditText etUnos;
    Button bKonvertiraj;
    Spinner spUlaz, spIzlaz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        etUnos = (EditText) findViewById(R.id.etUnos);
        bKonvertiraj = (Button) findViewById(R.id.bKonvertiraj);
        spUlaz = (Spinner) findViewById(R.id.spUlaz);
        spIzlaz= (Spinner) findViewById(R.id.spIzlaz);

        ArrayAdapter<CharSequence> Ulazniadapter = ArrayAdapter.createFromResource(this,
                R.array.Temperatura, android.R.layout.simple_spinner_item);

        Ulazniadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spUlaz.setAdapter(Ulazniadapter);

        ArrayAdapter<CharSequence> Izlazniadapter = ArrayAdapter.createFromResource(this,
                R.array.Temperatura, android.R.layout.simple_spinner_item);

        Izlazniadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spIzlaz.setAdapter(Izlazniadapter);

    }
}
