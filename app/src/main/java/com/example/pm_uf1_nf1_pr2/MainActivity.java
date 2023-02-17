package com.example.pm_uf1_nf1_pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText mET_correo, mET_password;
    private Button mBT_Register, mBT_Login;

    private FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InicializarComponents();

        mBT_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity2.class);

                intent.putExtra("correo", "Recuerda que estos datos seran tratados por firebase.");

                startActivity(intent);

            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.FL_Login, new LoginFragment()).commit();

    }

    private void InicializarComponents() {
        mET_correo = findViewById(R.id.ET_ICorreo);
        mET_password = findViewById(R.id.ET_IPassword);

        mBT_Login = findViewById(R.id.BT_Login);
        mBT_Register =findViewById(R.id.BT_Regist);

    }
}