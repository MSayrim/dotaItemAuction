package com.example.dotaitemauction;

import android.content.Intent;
import android.os.Bundle;

import com.example.dotaitemauction.Models.LoginPojo;
import com.example.dotaitemauction.WebApi.ManagerAll;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );

        userName = (EditText) findViewById ( R.id.username );
        password = (EditText) findViewById ( R.id.password );
        loginButton = (Button) findViewById ( R.id.login );

        loginButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                login ( userName.getText ().toString (),password.getText ().toString () );
            }
        } );


    }

    public void login (String userName , String password)
    {
        final Call<LoginPojo> request = ManagerAll.getInstance ().login ( userName,password );
        request.enqueue ( new Callback<LoginPojo> () {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {




                if(response.isSuccessful ())
                {
                    if(response.body ().getId () !=null && response.body ().getUserName () !=null){
                        Intent intent = new Intent ( getApplicationContext (),MainActivity.class );
                        startActivity ( intent );

                    }
                }
                else{
                    Toast.makeText ( getApplicationContext (),"Hatalı kullanıcı adı/şifre", Toast.LENGTH_LONG );
                }

            }

            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {

            }
        } );


    }

}
