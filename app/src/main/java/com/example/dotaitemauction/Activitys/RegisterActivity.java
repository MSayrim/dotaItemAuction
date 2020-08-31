package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dotaitemauction.Models.LoginPojo;
import com.example.dotaitemauction.Models.RegisterPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText registerMail;
    EditText registerSteamId;
    EditText registerNick;
    EditText registerPassword;
    EditText registerPasswordAgain;
    Button registerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_register );

        registerMail            = (EditText) findViewById ( R.id.registerMail          );
        registerSteamId         = (EditText) findViewById ( R.id.registerSteamId       );
        registerNick            = (EditText) findViewById ( R.id.registerNick          );
        registerPassword        = (EditText) findViewById ( R.id.passwordField );
        registerPasswordAgain   = (EditText) findViewById ( R.id.registerPasswordAgain );
        registerButton          = (Button)   findViewById ( R.id.registerButton        );

        registerButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if(registerMail!=null&&registerNick!=null&&registerPassword!=null&&registerPasswordAgain!=null&&registerSteamId!=null) {
                    register ( registerMail.getText ().toString (), registerPassword.getText ().toString (), registerNick.getText ().toString (), registerSteamId.getText ().toString () );
                }
            }
        } );



        registerPasswordAgain.addTextChangedListener(new TextWatcher () {
            public void afterTextChanged(Editable s) {

                if(isPasswordSame () ==true && isUserNameValid (registerMail.getText ().toString () )==true && isPasswordValid (registerPassword.getText ().toString ())==true && isNickVaild ( registerNick.getText ().toString () )==true
                && isSteamId ( registerSteamId.getText ().toString () )==true)
                {registerButton.setEnabled ( true );}
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }

    public boolean register (String userMail , String userPass, String userNick , String userSteamId)
    {
        final Call<RegisterPojo> request = ManagerAll.getInstance ().register ( userMail,userPass,userNick,userSteamId );

        request.enqueue ( new Callback<RegisterPojo> () {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                Toast.makeText ( getApplicationContext (),response.body ().getResult (),Toast.LENGTH_LONG ).show ();

                if(response.body ().getResult ().equals ( "kayit basarili" )){
                Intent intent = new Intent ( getApplicationContext (),LoginActivity.class );
                startActivity ( intent );}
            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {

            }
        } );

        return true;
    }


    public boolean isPasswordSame(){

        boolean result = false;
        if(registerPassword.getText ().toString ().equals ( registerPasswordAgain.getText ().toString () ))
        {
            result = true;

        }
        return result;
    }

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

    private boolean isPasswordValid(String password) {
        return password != null && password.trim ().length () > 5;
    }

    private boolean isNickVaild(String nick) {
        return nick != null && nick.trim ().length () > 2;
    }

    private boolean isSteamId(String steamId) {
        return steamId != null && steamId.trim ().length () > 6;
    }
}
