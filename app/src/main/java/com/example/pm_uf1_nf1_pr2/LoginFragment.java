package com.example.pm_uf1_nf1_pr2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class LoginFragment extends Fragment {
    private EditText mET_ICorreo, mET_IPassword;
    private itemModelView mET_IModelView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mET_ICorreo = view.findViewById(R.id.ET_ICorreo);
        mET_IPassword = view.findViewById(R.id.ET_IPassword);

        mET_IModelView = new ViewModelProvider(this).get(itemModelView.class);
        mET_IModelView.getCorreoLiveData().observe(getViewLifecycleOwner(), itemObservat -> {
            mET_ICorreo.setText(itemObservat);
        });
        mET_IModelView.getPasswordLiveData().observe(getViewLifecycleOwner(), item ->{
            mET_IPassword.setText(item);
        });
        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        //Ingresar el get model view model
    }
}