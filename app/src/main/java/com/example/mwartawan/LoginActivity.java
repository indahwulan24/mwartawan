package com.example.mwartawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mwartawan.api.ApiClient;
import com.example.mwartawan.api.ApiInterface;
import com.example.mwartawan.api.model.login.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etid, etpassword;
    ImageButton btnlogin;
    TextView tvor, tvregister;
    ApiInterface apiInterface;
    String Id_wartawan, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etid = findViewById(R.id.etid);
        etpassword = findViewById(R.id.etpassword);

        tvor = findViewById(R.id.tvor);

        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);

        tvregister = findViewById(R.id.tvregister);
        tvregister.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnlogin:
                Id_wartawan = etid.getText().toString();
                Password = etpassword.getText().toString();
                login(Id_wartawan, Password);
                break;
            case R.id.tvregister:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
    };

    }

    private void login(String id_wartawan, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.loginResponse(id_wartawan,password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(LoginActivity.this, response.body().getData().getNamaLengkap(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
