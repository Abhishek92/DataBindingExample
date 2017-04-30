package com.android.databindingexample;

import android.databinding.BaseObservable;

/**
 * Created by hp pc on 30-04-2017.
 */

public class User extends BaseObservable {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyChange();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyChange();
    }
}
