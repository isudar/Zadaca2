package com.example.sudo.zadaca2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Kut extends Activity implements View.OnClickListener {

    public static final String KEY_ULAZ = "Ulaz";
    public static final String KEY_ULAZ_VAR = "ULazna varijabla";
    public static final String KEY_IZLAZ = "Izlaz";
    public static final String KEY_IZLAZ_VAR = "Izlazna varijabla";


    public static final String STUPANJ = "Stupnjevi";
    public static final String RADIAN = "Radijani";


    EditText etUnos;
    Button bKonvertiraj;
    Spinner spUlaz, spIzlaz;
    int ulazVelicina, izlazVelicina;

    double ulaznaVarijabla, izlaznaVarijabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kut);
        initializeUI();
    }

    private void initializeUI() {
        etUnos = (EditText) findViewById(R.id.etUnos);
        bKonvertiraj = (Button) findViewById(R.id.bKonvertiraj);
        spUlaz = (Spinner) findViewById(R.id.spUlaz);
        spIzlaz = (Spinner) findViewById(R.id.spIzlaz);

        ArrayAdapter<CharSequence> Ulazniadapter = ArrayAdapter.createFromResource(this,
                R.array.Kut, android.R.layout.simple_spinner_item);

        Ulazniadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spUlaz.setAdapter(Ulazniadapter);

        ArrayAdapter<CharSequence> Izlazniadapter = ArrayAdapter.createFromResource(this,
                R.array.Kut, android.R.layout.simple_spinner_item);

        Izlazniadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spIzlaz.setAdapter(Izlazniadapter);

        bKonvertiraj.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        ulaznaVarijabla = Double.parseDouble(etUnos.getText().toString());
        long ulazVelicina = spUlaz.getSelectedItemId();
        long izlazVelicina = spIzlaz.getSelectedItemId();
        Intent resultIntent;
        switch ((int) ulazVelicina) {
            case 0:
                if (izlazVelicina == 0) {
                    izlaznaVarijabla = ulaznaVarijabla;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, STUPANJ);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, STUPANJ);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }

                if (izlazVelicina == 1) {
                    izlaznaVarijabla = ulaznaVarijabla / 57.2957795;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, STUPANJ);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, RADIAN);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                break;
            case 1:
                if (izlazVelicina == 0) {
                    izlaznaVarijabla = ulaznaVarijabla * 57.2957795;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, RADIAN);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, STUPANJ);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }

                if (izlazVelicina == 1) {
                    izlaznaVarijabla = ulaznaVarijabla;
                    resultIntent = new Intent(getApplicationContext(), Resultactivity.class);
                    resultIntent.putExtra(KEY_ULAZ_VAR, RADIAN);
                    resultIntent.putExtra(KEY_ULAZ, ulaznaVarijabla);
                    resultIntent.putExtra(KEY_IZLAZ_VAR, RADIAN);
                    resultIntent.putExtra(KEY_IZLAZ, izlaznaVarijabla);
                    this.startActivity(resultIntent);
                }
                break;
        }

    }
}
