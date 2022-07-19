package com.example.loginfiina.Activitys.Resumen;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.loginfiina.BaseDeDatos.ProcesosDB;
import com.example.loginfiina.Entidades.Partida;
import com.example.loginfiina.R;
import com.example.loginfiina.Request.PartidaRequest;
import com.example.loginfiina.Services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResumenActivity extends AppCompatActivity {

    TextView jugador,puntaje;

    List<Partida> _partidas = new ArrayList<>();
    MediaPlayer click, music;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        int partida = getIntent().getIntExtra("Partida",0);
        LoadListView(partida);
        InicializarControles();
        MapearCampos();
        GuardarPartidaApi(_partidas);

        i = getIntent();

        click = MediaPlayer.create(this, R.raw.click);

        music = MediaPlayer.create(this, R.raw.resum);
        music.start();
    }


    private void GuardarPartidaApi(List<Partida> partidas) {
        PartidaRequest request = new PartidaRequest();
        request.setNombre(partidas.get(0).getJugador());
        request.setPuntaje(ObtenerPuntaje(partidas));

            Call<Integer> response = ApiService.getApiService().postRegistrarPartida(request);
            response.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    if (response.isSuccessful()) {
                        int registrado = response.body();
                        if (registrado > 0) {

                        }
                    } else {
                        int x = 1;
                    }
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {
                    int x = 1;
                }
            });

    }

    public void RegresarJuegos(View v){
        click.start();
        //Intent i = new Intent(getApplicationContext(), MenuLoginActivity.class);
        startActivity(i);
    }

    private void MapearCampos() {
        jugador.setText(_partidas.get(0).getJugador());
        puntaje.setText(Integer.toString(ObtenerPuntaje(_partidas)));
    }

    private int ObtenerPuntaje(List<Partida> partidas){
        int puntaje = 0;
        for (Partida part : partidas){
            puntaje = puntaje + part.getPuntaje();
        }

        return puntaje;
    }
    private void LoadListView(int partida) {
        ProcesosDB db = new ProcesosDB(getApplicationContext());

        _partidas = db.ObtenerPartidaById(partida);
    }

    private void InicializarControles(){

        jugador = (TextView)findViewById(R.id.txtJugador);
        puntaje = (TextView)findViewById(R.id.txtPuntos);
    }


    @Override
    protected void onPause(){
        super.onPause();
        music.pause();
    }
}