package com.example.loginfiina.Jugabilidad_Escojer_Palabra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfiina.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_juego3);

    }


    public void jugar(View view) {

        startActivity(new Intent(this,Jugabilidad3_Activity.class));
    }
}
