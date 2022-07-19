package com.example.loginfiina.Tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfiina.R;

public class TutorialMainActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_main);

        inicializarControles();
    }

    Button tutorial;

    private void inicializarControles(){
        tutorial = (Button) findViewById(R.id.btntutorial);
    }

    public void Confirmar(View view) {
        startActivity(new Intent(this, TutorialActivity.class));
    }
}
