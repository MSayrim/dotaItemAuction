package com.example.dotaitemauction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

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


        registerPassword.addTextChangedListener(new TextWatcher () {
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
