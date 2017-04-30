package com.android.databindingexample;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

/**
 * Created by hp pc on 30-04-2017.
 */

public class UserInfoViewModel {

    private User user;
    private Context context;
    private IUserInfoListener listener;

    public UserInfoViewModel(Context context, IUserInfoListener listener)
    {
        this.context = context;
        this.user = new User();
        this.listener = listener;
    }

    public TextWatcher emailTextWatcher()
    {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                user.setEmail(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    public TextWatcher passwordTextWatcher()
    {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                user.setPassword(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }


    public void onAddUser(View view)
    {
        if(validate()) {
            if(null != listener)
                listener.onUserAdded(user);
        }
    }

    private boolean validate()
    {
        if(TextUtils.isEmpty(user.getEmail()))
        {
            Toast.makeText(context, "Email not valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(TextUtils.isEmpty(user.getPassword()))
        {
            Toast.makeText(context, "Password not valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public interface IUserInfoListener
    {
        public void onUserAdded(User user);

    }

}
