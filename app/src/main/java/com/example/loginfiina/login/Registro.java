package com.example.loginfiina.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginfiina.R;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    ///variables
    EditText Nombre,Apellido,Correo,Cedula,Password;
    Button Registrar,Volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        startControllers();
    }

    private void startControllers(){
        /////Edittext
        Nombre=(EditText)findViewById(R.id.nombre);
        Apellido=(EditText)findViewById(R.id.apellido);
        Correo=(EditText)findViewById(R.id.correo);
        Cedula=(EditText)findViewById(R.id.cedula);
        Password=(EditText)findViewById(R.id.password);
        //////Btn
        Registrar=(Button)findViewById(R.id.btnRegistar);
        Volver=(Button)findViewById(R.id.btnregresar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:

                break;

            case R.id.Nocuenta:
                Intent i = new Intent(Registro.this, MainActivity.class);
                startActivity(i);
                break;
        }
    }

}