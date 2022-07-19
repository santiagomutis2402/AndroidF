package com.example.loginfiina.Jugabilidad_Escojer_Palabra;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfiina.R;

public class Jugabilidad3_Activity extends AppCompatActivity {
    TextView lblPregunta;
    EditText txtRespuesta;
    Button btnRes1, btnRes2, btnRes3, btnRes4, btnRes5, btnRes6;
    String Respuesta ="", rest;
    String n1 = "", n2 = "", n3 = "", n4 = "", n5 = "", n6 = "";
    String res2;

    String pregunta="", respuesta="";
    int numpregunta;

    String [] preguntas = {"Ventajas del Patron Command",
            "¿Dónde nace el término scrum?",
            "¿En qué año nació el manifiesto ágil?",
            "¿Qué lenguaje utiliza el Proceso Unificado?"};
    String [] respuestas = {"Deshacer y Rehacer",
            "en 1986 en Japón",
            "nació en el año 2001",
            "lenguaje unificado de modelado"};

    MediaPlayer mp;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugabilidad3);


        inicializar();

    }



    private void inicializar() {
        numpregunta = (int) (Math.random() * 4);
        pregunta = preguntas[numpregunta];
        respuesta = respuestas[numpregunta];
        String[] respuestaseparadas = respuesta.split(" ");
        int i = respuestaseparadas.length;
        int ii;
        res2= respuesta+" ";
        Toast.makeText( this, "i: " +i, Toast.LENGTH_LONG).show();



        for (ii=0; ii<i; ii=ii+1)
        {
            //Toast.makeText( this, " ii: "+ ii, Toast.LENGTH_LONG).show();
            switch (ii) {
                case 0:
                    n1 = respuestaseparadas[0];
                    break;
                case 1:
                    n2 = respuestaseparadas[1];
                    break;
                case 2:
                    n3 = respuestaseparadas[2];
                    break;
                case 3:
                    n4 = respuestaseparadas[3];
                    break;
                case 4:
                    n5 = respuestaseparadas[4];
                    break;
                case 5:
                    n6 = respuestaseparadas[5];
                    break;
            }
        }




        lblPregunta = (TextView) findViewById(R.id.lbloracion);
        lblPregunta.setText(pregunta);
        txtRespuesta = (EditText) findViewById(R.id.txtRespuesta);
        btnRes1 = (Button) findViewById(R.id.btnRes1);
        btnRes1.setText(n1);
        btnRes2 = (Button) findViewById(R.id.btnRes2);
        btnRes2.setText(n2);
        btnRes3 = (Button) findViewById(R.id.btnRes3);
        btnRes3.setText(n3);
        btnRes4 = (Button) findViewById(R.id.btnRes4);
        btnRes4.setText(n4);
        btnRes5 = (Button) findViewById(R.id.btnRes5);
        btnRes5.setText(n5);
        btnRes6 = (Button) findViewById(R.id.btnRes6);
        btnRes6.setText(n6);
    }

    public void Comprobar(View view) {
        rest = txtRespuesta.getText().toString();

        if (rest.isEmpty()) {
            Alert alert = new Alert("Campos vacios. Ingrese la respuesta");
            alert.show(getSupportFragmentManager(), "Rellenar");
        } else {
            if (rest.equals(res2)) {
                Toast.makeText( this, "correcto: "+res2, Toast.LENGTH_SHORT).show();
                Alerta2 alert = new Alerta2("Respuesta correcta");
                alert.show(getSupportFragmentManager(), "Felicidades");

            } else {
                Toast.makeText(this, "respuesta correcta: " + res2 + ". Respuesta ingresada: " + rest, Toast.LENGTH_SHORT).show();

                Alerta2 alert = new Alerta2("Respuesta incorrecta");
                alert.show(getSupportFragmentManager(), "Incorrecto");
            }
        }
        mp = MediaPlayer.create(this,R.raw.confirm);
        mp.start();

    }




    public void btn1(View view) {


        if (Respuesta == ""){
            Respuesta = n1+" ";
            txtRespuesta.setText(Respuesta);
        }else {
            Respuesta = Respuesta + n1 + " ";
            txtRespuesta.setText(Respuesta);
        }

        mp = MediaPlayer.create(this,R.raw.gallatin);
        mp.start();
    }
    public void btn2(View view) {
        // res = btnRes2.getText().toString();
        if (Respuesta == ""){
            Respuesta = n2+" ";
            txtRespuesta.setText(Respuesta);
        }else {
            Respuesta = Respuesta + n2 + " ";
            txtRespuesta.setText(Respuesta);
        }

        mp = MediaPlayer.create(this,R.raw.gallatin);
        mp.start();

    }
    public void btn3(View view) {

        if (Respuesta == ""){
            Respuesta = n3+" ";
            txtRespuesta.setText(Respuesta);
        }else {
            Respuesta = Respuesta + n3 + " ";
            txtRespuesta.setText(Respuesta);
        }

        mp = MediaPlayer.create(this,R.raw.gallatin);
        mp.start();
    }
    public void btn4(View view) {

        if (Respuesta == ""){
            Respuesta = n4+" ";
            txtRespuesta.setText(Respuesta);
        }else {
            Respuesta = Respuesta + n4 + " ";
            txtRespuesta.setText(Respuesta);
        }

        mp = MediaPlayer.create(this,R.raw.gallatin);
        mp.start();
    }
    public void btn5(View view) {

        if (Respuesta == ""){
            Respuesta = n5+" ";
            txtRespuesta.setText(Respuesta);
        }else {
            Respuesta = Respuesta + n5 + " ";
            txtRespuesta.setText(Respuesta);
        }

        mp = MediaPlayer.create(this,R.raw.gallatin);
        mp.start();
    }
    public void btn6(View view) {

        if (Respuesta == ""){
            Respuesta = n6+" ";
            txtRespuesta.setText(Respuesta);
        }else {
            Respuesta = Respuesta + n6 + " ";
            txtRespuesta.setText(Respuesta);

        }
        mp = MediaPlayer.create(this,R.raw.gallatin);
        mp.start();


    }

}
