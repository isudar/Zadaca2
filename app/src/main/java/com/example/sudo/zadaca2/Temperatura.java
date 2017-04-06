package com.example.sudo.zadaca2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Temperatura extends Activity implements View.OnClickListener {
    EditText etUnos;
    Button bKonvertiraj;
    Spinner spUlaz, spIzlaz;
    Double ulaznaVarijabla;
    Double izlaznaVarijabla;

    public static final String KEY_ULAZ = "Ulaz";
    public static final String KEY_ULAZ_VAR = "ULazna varijabla";
    public static final String KEY_IZLAZ = "Izlaz";
    public static final String KEY_IZLAZ_VAR = "Izlazna varijabla";


    public static final String KELVIN = "Kelvin";
    public static final String CELSIUS = "Stupanje Celzijev";
    public static final String FAHRENHEIT = "Fahrenhajt";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        initializeUI();


    }

    private void initializeUI() {
        this.etUnos = (EditText) findViewById(R.id.etUnos);
        this.bKonvertiraj = (Button) findViewById(R.id.bKonvertiraj);
        this.spUlaz = (Spinner) findViewById(R.id.spUlaz);
        this.spIzlaz = (Spinner) findViewById(R.id.spIzlaz);

        ArrayAdapter<CharSequence> Ulazniadapter = ArrayAdapter.createFromResource(this,
                R.array.Temperatura, android.R.layout.simple_spinner_item);

        Ulazniadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spUlaz.setAdapter(Ulazniadapter);

        ArrayAdapter<CharSequence> Izlazniadapter = ArrayAdapter.createFromResource(this,
                R.array.Temperatura, android.R.layout.simple_spinner_item);

        Izlazniadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spIzlaz.setAdapter(Izlazniadapter);

        this.bKonvertiraj.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        ulaznaVarijabla = Double.parseDouble(etUnos.getText().toString());
        int ulazVelicina = (int) spUlaz.getSelectedItemId();
        int izlazVelicina = (int) spIzlaz.getSelectedItemId();
        Intent resultIntent;

        if (ulaznaVarijabla == null){
            ulaznaVarijabla = Double.valueOf(0);
        }
        switch (ulazVelicina) {
            case 0:
                if (izlazVelicina == 0) {
                    izlaznaVarijabla = ulaznaVarijabla;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, KELVIN);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, KELVIN);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                if (izlazVelicina == 1) {
                    izlaznaVarijabla = ulaznaVarijabla - 273.15;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, KELVIN);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, CELSIUS);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                if (izlazVelicina == 2) {
                    izlaznaVarijabla = ulaznaVarijabla * ((9 / 5) - 459.67);
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, KELVIN);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, FAHRENHEIT);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                break;
            case 1:
                if (izlazVelicina == 0) {
                    izlaznaVarijabla = ulaznaVarijabla + 273.15;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, CELSIUS);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, KELVIN);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                if (izlazVelicina == 1) {
                    ulaznaVarijabla = izlaznaVarijabla;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, CELSIUS);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, CELSIUS);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                if (izlazVelicina == 2) {
                    ulaznaVarijabla = izlaznaVarijabla * 9 / 5 + 32;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, CELSIUS);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, FAHRENHEIT);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                break;
            case 2:
                if (izlazVelicina == 0) {
                    ulaznaVarijabla = (izlaznaVarijabla + 459.67) * 5 / 9;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, FAHRENHEIT);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, KELVIN);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                if (izlazVelicina == 1) {
                    ulaznaVarijabla = (izlaznaVarijabla - 32) * 5 / 9;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, FAHRENHEIT);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, CELSIUS);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                if (izlazVelicina == 2) {
                    ulaznaVarijabla = izlaznaVarijabla;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, FAHRENHEIT);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, FAHRENHEIT);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                break;
        }
    }


}

