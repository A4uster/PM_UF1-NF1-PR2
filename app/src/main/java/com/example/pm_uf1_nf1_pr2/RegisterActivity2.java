package com.example.pm_uf1_nf1_pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class RegisterActivity2 extends AppCompatActivity {

    private EditText mET_nombreCompleto, mET_username, mET_correos , mET_password, mET_NewPassword;
    private Button mBT_NRegistro;
    private FrameLayout mFL_RegistDades;
    private TextView mTV_IExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        InicializarComponents();

        String CorreoRecibidoSMV = getIntent().getStringExtra("correo");
        mTV_IExtra.setText(CorreoRecibidoSMV);

        /*
        mBT_NRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });*/

        getSupportFragmentManager().beginTransaction().replace(R.id.FL_Register, new RegisterFragment()).commit();


    }
    private void InicializarComponents() {
        /*
        mET_nombreCompleto = findViewById(R.id.ET_MNombre);
        mET_username = findViewById(R.id.ET_MUsername);
        mET_correos = findViewById(R.id.ET_MCorreo);
        mET_password = findViewById(R.id.ET_MPassword);
        mET_NewPassword = findViewById(R.id.ET_MnewPassword);

        mBT_NRegistro = findViewById(R.id.BT_MRegist);
        mFL_RegistDades = findViewById(R.id.FL_Register);
*/

        mTV_IExtra = findViewById(R.id.TV_IExtraRecibido);


    }
}