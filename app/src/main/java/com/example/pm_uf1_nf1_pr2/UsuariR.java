package com.example.pm_uf1_nf1_pr2;

public class UsuariR {

    private String mRNom, mRUser, mRCorreo, mRPassword, mRUid;

    public UsuariR(String nom, String username, String correo, String password, String uid){
        mRNom = nom;
        mRUser = username;
        mRCorreo = correo;
        mRPassword = password;
        mRUid = uid;
    }


    public String getmRCorreo() {
        return mRCorreo;
    }
    public String getmRNom() {
        return mRNom;
    }
    public String getmRPassword() {
        return mRPassword;
    }
    public String getmRUser() {
        return mRUser;
    }

    public String getmRUid() {
        return mRUid;
    }

    public void setmRCorreo(String mRCorreo) {
        this.mRCorreo = mRCorreo;
    }
    public void setmRNom(String mRNom) {
        this.mRNom = mRNom;
    }
    public void setmRPassword(String mRPassword) {
        this.mRPassword = mRPassword;
    }
    public void setmRUser(String mRUser) {
        this.mRUser = mRUser;
    }
    public void setmRUid(String mRUid) {
        this.mRUid = mRUid;
    }


    @Override
    public String toString() {
        return "UsuariR{" +
                "mRNom='" + mRNom + '\'' +
                ", mRUser='" + mRUser + '\'' +
                ", mRCorreo='" + mRCorreo + '\'' +
                ", mRPassword='" + mRPassword + '\'' +
                ", mRUID='" + mRUid + '\'' +
                '}';
    }
}
