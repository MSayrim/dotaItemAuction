package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dotaitemauction.Models.LoginPojo;
import com.example.dotaitemauction.Models.ProfilPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dotaitemauction.Activitys.LoginActivity.currentUserId;

public class ProfileActivity extends AppCompatActivity {

    TextView profilText;
    TextView steamIdText;
    RatingBar profilRate;
    TextView premiumText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilText = (TextView) findViewById(R.id.profilNameView);
        steamIdText = (TextView) findViewById(R.id.steamIdView);
        profilRate = (RatingBar) findViewById(R.id.profilRate);
        premiumText = (TextView) findViewById(R.id.premiumStatuView);
        login(currentUserId);
    }

    public void login(String userId) {
        final Call<ProfilPojo> request = ManagerAll.getInstance().profil(userId);
        request.enqueue(new Callback<ProfilPojo>() {
            @Override
            public void onResponse(Call<ProfilPojo> call, Response<ProfilPojo> response) {
                profilText.setText(response.body().getNick().toString());
                steamIdText.setText(response.body().getSteamId().toString());
                double rate = response.body().getRate();
                profilRate.setRating(Float.parseFloat(String.valueOf(rate)));
                if (response.body().getPremiumTime() != null) {
                    premiumText.setText(response.body().getPremiumTime().toString());
                }
            }

            @Override
            public void onFailure(Call<ProfilPojo> call, Throwable t) {
            }
        });
    }
}
