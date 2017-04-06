package com.example.sudo.zadaca2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Vrijeme extends Activity implements View.OnClickListener {
    EditText etUnos;
    Button bKonvertiraj;
    Spinner spUlaz, spIzlaz;

    public static final String KEY_ULAZ = "Ulaz";
    public static final String KEY_ULAZ_VAR = "ULazna varijabla";
    public static final String KEY_IZLAZ = "Izlaz";
    public static final String KEY_IZLAZ_VAR = "Izlazna varijabla";

    public static final String SEKUNDA = "Sekundi";
    public static final String SAT = "Sati";
    public static final String DAN = "Dana";


    int ulazVelicina, izlazVelicina;

    double ulaznaVarijabla, izlaznaVarijabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrijeme);
        initializeUI();
    }

    private void initializeUI() {
        etUnos = (EditText) findViewById(R.id.etUnos);
        bKonvertiraj = (Button) findViewById(R.id.bKonvertiraj);
        spUlaz = (Spinner) findViewById(R.id.spUlaz);
        spIzlaz = (Spinner) findViewById(R.id.spIzlaz);

        ArrayAdapter<CharSequence> Ulazniadapter = ArrayAdapter.createFromResource(this,
                R.array.Vrijeme, android.R.layout.simple_spinner_item);

        Ulazniadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spUlaz.setAdapter(Ulazniadapter);

        ArrayAdapter<CharSequence> Izlazniadapter = ArrayAdapter.createFromResource(this,
                R.array.Vrijeme, android.R.layout.simple_spinner_item);

        Izlazniadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spIzlaz.setAdapter(Izlazniadapter);

        bKonvertiraj.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ulaznaVarijabla = Double.parseDouble(etUnos.getText().toString());
        int ulazVelicina = (int) spUlaz.getSelectedItemId();
        int izlazVelicina = (int) spIzlaz.getSelectedItemId();
        Intent resultIntent;
        switch ((int) ulazVelicina) {
            case 0:
                if (izlazVelicina == 0) {
                    izlaznaVarijabla = ulaznaVarijabla;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, SEKUNDA);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, SEKUNDA);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }

                if (izlazVelicina == 1) {
                    izlaznaVarijabla = ulaznaVarijabla / 3600;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, SEKUNDA);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, SAT);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                if (izlazVelicina == 2) {
                    izlaznaVarijabla = ulaznaVarijabla / (3600 * 24);
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, SEKUNDA);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, DAN);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                break;
            case 1:
                if (izlazVelicina == 0) {
                    izlaznaVarijabla = ulaznaVarijabla * 3600;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, SAT);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, SEKUNDA);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }

                if (izlazVelicina == 1) {
                    izlaznaVarijabla = ulaznaVarijabla;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, SAT);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, SAT);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                if (izlazVelicina == 2) {
                    izlaznaVarijabla = ulaznaVarijabla / 24;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, SAT);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, DAN);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                break;
            case 2:
                if (izlazVelicina == 0) {
                    izlaznaVarijabla = ulaznaVarijabla * 3600 * 24;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, DAN);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, SEKUNDA);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }

                if (izlazVelicina == 1) {
                    izlaznaVarijabla = ulaznaVarijabla * 24;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, DAN);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, SAT);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                if (izlazVelicina == 2) {
                    izlaznaVarijabla = ulaznaVarijabla;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, DAN);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, DAN);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                break;
        }
    }
}
