package com.example.loginfiina.Activitys.Login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfiina.Activitys.MensajeLoginActivity;
import com.example.loginfiina.Entidades.DatosUsuarios;
import com.example.loginfiina.Activitys.Login.LoginActivity;
import com.example.loginfiina.R;
import com.example.loginfiina.Services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarseActivity extends AppCompatActivity {

    EditText nombre,correo,password,apellido,cedula,usuario_id;
    MediaPlayer click, music;
    Intent i;
    int x;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        click = MediaPlayer.create(this, R.raw.click);

        music = MediaPlayer.create(this, R.raw.menumusic);
        music.start();

        i = getIntent();
        x= i.getIntExtra("num",0);

        InicializarControles();
    }

    @Override
    protected void onStart(){
        super.onStart();
        music.start();
    }

    private void InicializarControles() {
        nombre = (EditText)findViewById(R.id.nombre);
        correo = (EditText)findViewById(R.id.correo);
        password = (EditText)findViewById(R.id.Rptpassword);
        apellido = (EditText)findViewById(R.id.apellido);
        cedula = (EditText)findViewById(R.id.cedula);

    }

    public void RegistrarEstudiante(View v){
        try {
            DatosUsuarios estudiante = new DatosUsuarios();
            estudiante.setNombre(nombre.getText().toString());
            estudiante.setCorreo(correo.getText().toString());
            estudiante.setPassword(password.getText().toString());
            estudiante.setApellido(apellido.getText().toString());
            estudiante.setCedula(cedula.getText().toString());
            estudiante.setUsuario_id(3);
            estudiante.setTipo(3);

            Call<Integer> response1 = ApiService.getApiService().postRegistrarDatosUsuarios(estudiante);
            response1.enqueue(new Callback<Integer>(){

                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    if (response.isSuccessful()){
                        int x = 1;
                    }else{
                        int x = 1;
                    }
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Datos del Usuario Creados Correctamente",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    int x = 1;
                }

            });

        }catch (Exception e){
            int x= 1;
        }
    }
    public void Atras(View view) {
        click.start();
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }


    public void Utp(View view) {
        click.start();
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://utp.ac.pa/"));
        startActivity(i);
    }

    public void UtpFisc(View view) {
        click.start();
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fisc.utp.ac.pa/"));
        startActivity(i);
    }

    @Override
    protected void onPause(){
        super.onPause();
        music.pause();
    }
}