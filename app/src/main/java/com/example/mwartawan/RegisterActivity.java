package com.example.mwartawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etid, etnama, etpassword, etemail, etnohp, etjkelamin;
    ImageButton btnregister;
    String Id_wartawan, namalengkap, password, email, no_hp, jenis_kelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etid = findViewById(R.id.etid);
        etnama = findViewById(R.id.etnama);
        etpassword = findViewById(R.id.etpassword);
        etemail = findViewById(R.id.etemail);
        etnohp = findViewById(R.id.etnohp);
        etjkelamin = findViewById(R.id.etjkelamin);

        btnregister = findViewById(R.id.btnregister);
        btnregister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnregister:
                Id_wartawan = etid.getText().toString();
                namalengkap = etnama.getText().toString();
                password = etpassword.getText().toString();
                email = etemail.getText().toString();
                no_hp = etnohp.getText().toString();
                jenis_kelamin = etjkelamin.getText().toString();
                register(Id_wartawan, namalengkap, password, email, no_hp, jenis_kelamin);
                break;
        }
    }

    private void register(String id_wartawan, String namalengkap, String password, String email, String no_hp, String jenis_kelamin) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
