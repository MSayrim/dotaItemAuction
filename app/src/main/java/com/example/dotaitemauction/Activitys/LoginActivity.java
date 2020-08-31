package com.example.dotaitemauction.Activitys;

import android.content.Intent;
import android.os.Bundle;

import com.example.dotaitemauction.Models.LoginPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    Button loginButton;
    boolean result;
    LoginPojo currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );

        userName = (EditText) findViewById ( R.id.username );
        password = (EditText) findViewById ( R.id.passwordField );
        loginButton = (Button) findViewById ( R.id.login );
        buttonActivate ();

        loginButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if(isDataValid () == true) {
                    login ( userName.getText ().toString (), password.getText ().toString () );
                }
                else {
                    register ();
                }

            }
        } );



    }


    public boolean login (String userName , String password)
    {
        final Call<LoginPojo> request = ManagerAll.getInstance ().login ( userName,password );
        request.enqueue ( new Callback<LoginPojo> () {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {

                 boolean result = response.isSuccessful ();
                 currentUser = response.body ();

                if(response.isSuccessful ())
                {


                    if(response.body ().getId () !=null && response.body ().getUserName () !=null){
                        Intent intent = new Intent ( getApplicationContext (),MarketActivity.class );
                        intent.putExtra ( "id" , currentUser.getId ().toString () );
                        startActivity ( intent );
                        Toast.makeText ( getApplicationContext (),"giriş başarılı",Toast.LENGTH_LONG ).show ();
                        finish ();
                    }
                    else {

                        Toast.makeText ( getApplicationContext (),"Hatalı şifre veya Kullanıcı adı",Toast.LENGTH_LONG ).show ();
                    }

                }


            }
            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {
            }
        } );
        return result;
    }


    private void register(){
        Intent intent2 = new Intent ( getApplicationContext (),RegisterActivity.class );
        startActivity ( intent2 );
    }

    private void buttonActivate(){

        userName.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if(isDataValid () ==true || isEmpty (userName.getText ().toString (), password.getText ().toString ())==true) {

                    loginButton.setEnabled (true  );
                }else {

                    loginButton.setEnabled (false  );
                }

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(isDataValid () ==true || isEmpty (userName.getText ().toString (), password.getText ().toString ())==true) {

                    loginButton.setEnabled (true  );
                }else {

                    loginButton.setEnabled (false  );
                }
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(isDataValid () ==true || isEmpty (userName.getText ().toString (), password.getText ().toString ())==true) {

                    loginButton.setEnabled (true  );
                }else {

                    loginButton.setEnabled (false  );
                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if(isDataValid () ==true || isEmpty (userName.getText ().toString (), password.getText ().toString ())==true) {

                    loginButton.setEnabled (true  );
                }else {

                    loginButton.setEnabled (false  );
                }

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(isDataValid () ==true || isEmpty (userName.getText ().toString (), password.getText ().toString ())==true) {

                    loginButton.setEnabled (true  );
                }else {

                    loginButton.setEnabled (false  );
                }
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(isDataValid () ==true || isEmpty (userName.getText ().toString (), password.getText ().toString ())==true) {

                    loginButton.setEnabled (true  );
                }else {

                    loginButton.setEnabled (false  );
                }
            }
        });
    }


    private boolean isDataValid(){

        boolean result = true;
        if(isUserNameValid ( userName.getText ().toString ()) == true &&
                isPasswordValid ( password.getText ().toString () ) == true)
        {
            result = true;

        }
        else {
            result = false;
        }



        return result;
    }
    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains ( "@" )) {
            return Patterns.EMAIL_ADDRESS.matcher ( username ).matches ();
        } else {
            return !username.trim ().isEmpty ();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim ().length () > 5;
    }

    private boolean isEmpty(String username , String password){
        result = true;

        if(username == null || password ==null ) {
            result = true;
        }
        else {
            result = false;
        }

        return  result;
    }

}
