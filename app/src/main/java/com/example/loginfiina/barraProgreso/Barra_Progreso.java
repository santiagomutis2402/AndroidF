package com.example.loginfiina.barraProgreso;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.example.loginfiina.R;
public class Barra_Progreso extends AppCompatActivity {

    Button btn;
    ProgressBar pb;
    ImageView anim;//para dar el efecto de animacion
    boolean activo;//para controlar que mientras no se complete el aumento de la barra no permite llamar al metodo aumentar barra nuevamente
    int i;//para controlar la estructura do while, como se utiliza en varios hilos es necesario que sea global


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barra_progreso);
        InicializarControles();
        InicializarVariables();
        AttachEvents();

    }

    private void InicializarVariables() {
        activo = false;
        i = 1;
    }

    private void InicializarControles() {
        btn = (Button) findViewById(R.id.bt);
        pb = (ProgressBar) findViewById(R.id.pgBar);
        anim = (ImageView) findViewById(R.id.animation);

    }

    private void AttachEvents() {
        btn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick  (View v){
                {
                    if(!activo) {
                        activo = true;
                        AumetarPB();
                    }
                }
            }
        });


    }


    //metodo para aumetar la barra
    private void AumetarPB() {
        new Thread(){
            @Override
            public void run() {
                try{
                    //hilo para animar el imageview y simular un efecto ripple a la barra
                    runOnUiThread(() ->
                            anim.animate().scaleX(1.2f).scaleY(1.2f).alpha(0f).setDuration(1000)
                                    .withEndAction(() -> {
                                        anim.setScaleX(1f);
                                        anim.setScaleY(1f);
                                        anim.setAlpha(1f);
                                    }));
                    //hilo para que aumente el progreso de la barra
                    do {
                        //se duerme el hilo por 50 millis para que la barra suba lentamente
                        Thread.sleep(50);
                        runOnUiThread(() -> {
                            pb.incrementProgressBy(1);
                            i++;
                        });
                    } while (i < 10);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        //se cambian las variables para poder realizar nuevamente el llamado
        activo = false;
        i = 1;
    }


}