package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dotaitemauction.Models.ResultPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dotaitemauction.Activitys.LoginActivity.currentUserId;

public class SettingsActivity extends AppCompatActivity {

    Button mailChange;
    Button passChange;
    Button nickChange;
    Button langChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_settings );
        mailChange = (Button) findViewById ( R.id.changeMail );
        passChange = (Button) findViewById ( R.id.changePassword );
        nickChange = (Button) findViewById ( R.id.changeNick );
        langChange = (Button) findViewById ( R.id.changeLanguage );

        final AlertDialog dialogBuilder1 = new AlertDialog.Builder(SettingsActivity.this).create();
        final LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_mail, null);

        final AlertDialog dialogBuilder2 = new AlertDialog.Builder(SettingsActivity.this).create();
        final LayoutInflater inflater2 = this.getLayoutInflater();
        final View dialogView2 = inflater2.inflate(R.layout.dialog_nick, null);

        final AlertDialog dialogBuilder3 = new AlertDialog.Builder(SettingsActivity.this).create();
        final LayoutInflater inflater3 = this.getLayoutInflater();
        final View dialogView3 = inflater3.inflate(R.layout.dialog_password, null);

        final AlertDialog dialogBuilder4 = new AlertDialog.Builder(SettingsActivity.this).create();
        final LayoutInflater inflater4 = this.getLayoutInflater();
        final View dialogView4 = inflater.inflate(R.layout.dialog_mail, null);

        mailChange.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                final EditText editText1 = (EditText) dialogView.findViewById(R.id.changeMailText);
                final EditText editText2 = (EditText) dialogView.findViewById(R.id.changeMailTextAgain);
                final EditText editText3 = (EditText) dialogView.findViewById(R.id.changeMailPassword);
                Button button1 = (Button) dialogView.findViewById(R.id.changeMailButton);
                Button button2 = (Button) dialogView.findViewById(R.id.changeMailButtonDissmiss);

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogBuilder1.dismiss();
                    }
                });
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // DO SOMETHINGS
                        if(editText1.getText ().toString ().equals ( editText2.getText ().toString () ) || editText3.getText ().toString () != null || editText1.getText ().toString () != null) {
                            mailchanger ( currentUserId, editText3.getText ().toString (), editText1.getText ().toString () );
                            dialogBuilder1.dismiss ();
                        }
                    }
                });

                dialogBuilder1.setView(dialogView);
                dialogBuilder1.show();

            }


        } );
        passChange.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                final EditText editText1 = (EditText) dialogView3.findViewById(R.id.changePasswordText);
                final EditText editText2 = (EditText) dialogView3.findViewById(R.id.changePasswordTextAgain);
                final EditText editText3 = (EditText) dialogView3.findViewById(R.id.changePassword);
                Button button1 = (Button) dialogView3.findViewById(R.id.changePasswordButton);
                Button button2 = (Button) dialogView3.findViewById(R.id.changePasswordButtonDismiss);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogBuilder3.dismiss();
                    }
                });
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(editText1.getText ().toString ().equals ( editText2.getText ().toString () ) || editText3.getText ().toString () != null || editText1.getText ().toString () != null) {
                            passwordChanger ( currentUserId, editText3.getText ().toString (), editText1.getText ().toString () );
                            dialogBuilder3.dismiss ();
                        }
                    }
                });
                dialogBuilder3.setView(dialogView3);
                dialogBuilder3.show();

            }
        } );
        nickChange.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                final EditText editText1 = (EditText) dialogView2.findViewById(R.id.changeNickText);
                final EditText editText2 = (EditText) dialogView2.findViewById(R.id.changeNickTextAgain);
                final EditText editText3 = (EditText) dialogView2.findViewById(R.id.changeNickPassword);
                Button button1 = (Button) dialogView2.findViewById(R.id.changeNickButton);
                Button button2 = (Button) dialogView2.findViewById(R.id.changeNickButtonDismiss);

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogBuilder2.dismiss();
                    }
                });
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(editText1.getText ().toString ().equals ( editText2.getText ().toString () ) || editText3.getText ().toString () != null || editText1.getText ().toString () != null) {
                            nickChanger ( currentUserId, editText3.getText ().toString (), editText1.getText ().toString () );
                            dialogBuilder2.dismiss ();
                        }
                    }
                });
                dialogBuilder2.setView(dialogView2);
                dialogBuilder2.show();

            }
        } );
        langChange.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
            }
        } );
    }

    public void passwordChanger(String id ,String password , String newPassword)
    {
        final Call<ResultPojo> request = ManagerAll.getInstance ().updatePass ( id,password,newPassword);
        request.enqueue ( new Callback<ResultPojo> () {
            @Override
            public void onResponse(Call<ResultPojo> call, Response<ResultPojo> response) {
            }
            @Override
            public void onFailure(Call<ResultPojo> call, Throwable t) {
            }
        } );
    }

    public void mailchanger(String id ,String password , String newMail)
    {
        final Call<ResultPojo> request = ManagerAll.getInstance ().updateMail ( id,password,newMail);
        request.enqueue ( new Callback<ResultPojo> () {
            @Override
            public void onResponse(Call<ResultPojo> call, Response<ResultPojo> response) {
                String result = response.body ().getResult ().toString ();
                Toast toast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG);
                toast.setGravity( Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
            @Override
            public void onFailure(Call<ResultPojo> call, Throwable t) {
            }
        } );
    }

    public void nickChanger(String id ,String password , String newNick)
    {
        final Call<ResultPojo> request = ManagerAll.getInstance ().updateNick ( id,password,newNick);
        request.enqueue ( new Callback<ResultPojo> () {
            @Override
            public void onResponse(Call<ResultPojo> call, Response<ResultPojo> response) {
                String result = response.body ().toString ();
                Toast toast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG);
                toast.setGravity( Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();

            }
            @Override
            public void onFailure(Call<ResultPojo> call, Throwable t) {
            }
        } );
    }








}
