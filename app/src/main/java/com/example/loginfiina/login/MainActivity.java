package com.example.loginfiina.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loginfiina.R;
import com.example.loginfiina.login.Interface.JsonPlaceHolder;
import com.example.loginfiina.login.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // variables
    EditText email, password;
    TextView error;
    Button btnLogin, Nocuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.startControllers();
        getPosts();
    }


    private void startControllers() {
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        error = (TextView) findViewById(R.id.error);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        Nocuenta = (Button) findViewById(R.id.Nocuenta);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                login();
                break;

            case R.id.Nocuenta:
                Intent i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);
                break;
        }
    }

    private void login() {
        String user, pass;
        user = "hola";
        pass = "1234";

        String email2 = email.getText().toString();
        String password2 = password.getText().toString();

        try {
            if (email2.equals(user) && pass.equals(password2)) {
                error.setText("Awebo");
            } else {
                error.setText("chanfle");
            }
        } catch (Exception e) {

        }
    }

    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        Call<List<Posts>> Call = jsonPlaceHolder.getPosts();

        Call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Posts>> call, Response<List<Posts>> response) {

                if (!response.isSuccessful()) {
                    error.setText("Codigo: " + response.code());
                    return;
                }
                List<Posts> postsList=response.body();

                for (Posts post:postsList){
                    String content="";
                    content +="userId:"+post.getUserId()+"\n";
                    content +="id:"+post.getId()+"\n";
                    content +="title:"+post.getTitle()+"\n";
                    content +="body:"+post.getBody()+"\n";
                    error.append(content);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<Posts>> call, Throwable t) {
                error.setText(t.getMessage());
            }
        });

    }

}