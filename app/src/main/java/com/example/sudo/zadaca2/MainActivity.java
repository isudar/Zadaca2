package com.example.sudo.zadaca2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void ocKapacitet(View view) {
        Intent Startkapacitet = new Intent(this,Kapacitet.class);{
            this.startActivity(Startkapacitet);
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

    public void ocTezina(View view) {
        Intent StartTezina = new Intent(this,Tezina.class);{
            this.startActivity(StartTezina);
        }
    }
}
