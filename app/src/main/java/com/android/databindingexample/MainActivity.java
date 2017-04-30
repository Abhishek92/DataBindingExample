package com.android.databindingexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.databindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements UserInfoViewModel.IUserInfoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        UserInfoViewModel userInfoViewModel = new UserInfoViewModel(this, this);
        binding.setViewModel(userInfoViewModel);

    }

    @Override
    public void onUserAdded(User user) {
        String result = String.format("Email: %s, Password: %s", user.getEmail(), user.getPassword());
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
