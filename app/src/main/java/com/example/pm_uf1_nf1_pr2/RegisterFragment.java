package com.example.pm_uf1_nf1_pr2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegisterFragment extends Fragment {

    private EditText mET_RFNombre, mET_RFUsername, mET_RFCorreo, mET_RFPassword, mET_RFNewPassword;
    private itemModelView mItemModelView;
    private CheckBox mCB_FRModelView;
    private Button mBT_FRButon;
    private boolean isChecked = false;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        //Declaracion de variables utilizadas
        mET_RFNombre = v.findViewById(R.id.ET_FNombre);
        mET_RFUsername = v.findViewById(R.id.ET_FUsername);
        mET_RFCorreo = v.findViewById(R.id.ET_FCorreo);
        mET_RFPassword = v.findViewById(R.id.ET_FPassword);
        mET_RFNewPassword = v.findViewById(R.id.ET_FnewPassword);
        mCB_FRModelView = v.findViewById(R.id.CB_ViewModel);
        mBT_FRButon = v.findViewById(R.id.BT_FRegist);


        //Inicializar Base de datos Firebase
        mDatabase = FirebaseDatabase.getInstance("https://pm-uf1-nf1-pr2-default-rtdb.firebaseio.com/");
        mReference = mDatabase.getReference();

        //Item model View hacer set

        mItemModelView = new ViewModelProvider(this).get(itemModelView.class);

        mCB_FRModelView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked2) {
                //Deben de respetarse las variables
                isChecked = isChecked2;
                //isChecked2 = compoundButton.isChecked();
            }
        });
        mBT_FRButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Hacemos un set de las variables del model view
                //1. Comprobamos si las contraseñas coinciden
                String F_password = mET_RFPassword.getText().toString();
                String F_password2 = mET_RFNewPassword.getText().toString();
                if (F_password.equals(F_password2)) {
                    //2. Comprobacion del checkbox seleccionado
                    // 2.1 El checkbox está seleccionado
                    if (isChecked) {
                        //En caso de que funcione debe de guardar la informacion con MVVM
                        mItemModelView.setCorreoLiveData(mET_RFCorreo.getText().toString());
                        mItemModelView.setPasswordLiveData(mET_RFPassword.getText().toString());
                    }
                    //2.2 El checkbox no está seleccionado
                    else {
                    }
                    RegistrarUsuarios();
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                    //Intent intent = new Intent(RegisterActivity2.this, MainActivity.class);
                    //startActivity(intent);
                }else{
                    Toast.makeText(getActivity(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return v;
        //return inflater.inflate(R.layout.fragment_register, container, false);
    }

    private void RegistrarUsuarios() {

        String mRnom = mET_RFNombre.getText().toString();
        String mRusername = mET_RFUsername.getText().toString();
        String mRcorreo = mET_RFCorreo.getText().toString();
        String mRpassword = mET_RFPassword.getText().toString();
        String mRuid = UUID.randomUUID().toString();

        UsuariR usuari = new UsuariR(mRnom, mRusername, mRcorreo, mRpassword, mRuid);

        mReference.child("Usuario").child(mRuid).setValue(usuari);


    }
}