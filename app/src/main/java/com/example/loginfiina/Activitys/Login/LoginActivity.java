package com.example.loginfiina.Activitys.Login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfiina.Activitys.MensajeLoginActivity;
import com.example.loginfiina.BaseDeDatos.ProcesosDB;
import com.example.loginfiina.Entidades.Usuarios;
import com.example.loginfiina.R;
import com.example.loginfiina.Request.UsuarioRequest;
import com.example.loginfiina.Response.UsuarioResponse;
import com.example.loginfiina.Services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText u, p;
    int tipo;
    ProcesosDB _db;
    MediaPlayer click, music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _db = new ProcesosDB(getApplicationContext());

        u = (EditText)findViewById(R.id.email);
        p = (EditText)findViewById(R.id.password);

        click = MediaPlayer.create(this, R.raw.click);

        music = MediaPlayer.create(this, R.raw.menumusic);
        music.start();

        ValidarSession();

    }

    @Override
    protected void onStart(){
        super.onStart();
        music.start();
    }

    private void ValidarSession() {
        Usuarios user = _db.ObtenerUsuarioSession();
        if (user != null){
            startActivity(new Intent(getApplicationContext(), MensajeLoginActivity.class));
        }
    }

    public void IniciarSesion(View v){
        try {
            click.start();
            String user = u.getText().toString();
            String pass = p.getText().toString();
            UsuarioRequest request = new UsuarioRequest();
            request.setCorreo(user);
            request.setPassword(pass);

            Call<UsuarioResponse> response = ApiService.getApiService().login(request);
            response.enqueue(new Callback<UsuarioResponse>() {
                @Override
                public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                    if (response.isSuccessful()){
                        UsuarioResponse estudiante = response.body();
                        if (estudiante != null){

                            Usuarios user =
                                    new Usuarios(
                                            estudiante.getId(),
                                            estudiante.getCorreo(),
                                            "",
                                            estudiante.getNombre()

                                    );

                            _db.GuardarSessionUsuario(user);

                            Toast.makeText(getApplicationContext(),"Login Exitoso",Toast.LENGTH_LONG).show();

                            estudiante.setTipo(3);

                            Intent i = new Intent(getApplicationContext(), MensajeLoginActivity.class);

                            i.putExtra("Nombre", estudiante.getNombre());
                            i.putExtra("Tipaje", estudiante.getTipo());

                            startActivity(i);

                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Error Al Iniciar Sesión",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Error Al Iniciar Sesión",Toast.LENGTH_LONG).show();
                    int x = 1;
                }
            });
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error Al Iniciar Sesión",Toast.LENGTH_LONG).show();
            int x = 1;
        }
    }

    public void Registrarse(View v){
        click.start();
        Intent i = new Intent(getApplicationContext(), RegistrarseActivity.class);
        i.putExtra("num", 1);
        startActivity(i);
    }

    public void RecuperarContraseña(View view) {
        click.start();
        startActivity(new Intent(getApplicationContext(), RecuperarContrasenaActivity.class));
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