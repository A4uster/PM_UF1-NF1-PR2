package com.example.pm_uf1_nf1_pr2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class itemModelView extends ViewModel{
    private static final MutableLiveData<String> correoLiveData = new MutableLiveData<>();
    private static final MutableLiveData<String> passwordLiveData = new MutableLiveData<>();

    //Definimos el set y get de los atributos de correoLiveData

    public void setCorreoLiveData(String correo_MVVM){
        correoLiveData.setValue(correo_MVVM);
    }
    public LiveData<String> getCorreoLiveData(){
        return correoLiveData;
    }

    //Definimos el set y get de los atributos de passwordLiveData

    public void setPasswordLiveData(String password_MVVM){
        passwordLiveData.setValue(password_MVVM);
    }
    public LiveData<String> getPasswordLiveData(){
        return passwordLiveData;
    }

}
