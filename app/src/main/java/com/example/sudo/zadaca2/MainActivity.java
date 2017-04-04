package com.example.sudo.zadaca2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void ocKut(View view) {
        Intent StartKut = new Intent(this,Kut.class);{
            this.startActivity(StartKut);
        }
    }

    public void ocUdaljenost(View view) {
        Intent StartUdaljenost = new Intent(this,Udaljenost.class);{
            this.startActivity(StartUdaljenost);
        }
    }

    public void ocTemperatura(View view) {
        Intent StartTemperatura = new Intent(this,Temperatura.class);{
            this.startActivity(StartTemperatura);
        }
    }

    public void ocVrijeme(View view) {
        Intent StartTezina = new Intent(this,Vrijeme.class);{
            this.startActivity(StartTezina);
        }
    }
}
