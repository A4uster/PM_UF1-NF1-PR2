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

public class RegisterFragment extends Fragment {

    private EditText mET_RFNombre, mET_RFUsername, mET_RFCorreo, mET_RFPassword, mET_RFNewPassword;
    private itemModelView mItemModelView;
    private CheckBox mCB_FRModelView;
    private Button mBT_FRButon;
    private boolean isChecked = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        //Declaracion de variables utilizadas
        mET_RFCorreo = v.findViewById(R.id.ET_FCorreo);
        mET_RFPassword = v.findViewById(R.id.ET_FPassword);
        mET_RFNewPassword = v.findViewById(R.id.ET_FnewPassword);
        mCB_FRModelView = v.findViewById(R.id.CB_ViewModel);
        mBT_FRButon = v.findViewById(R.id.BT_FRegist);

        //

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
}