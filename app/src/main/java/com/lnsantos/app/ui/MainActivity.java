package com.lnsantos.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.lnsantos.app.R;
import com.lnsantos.app.dagger.DaggerApplicationComponent;
import com.lnsantos.app.model.domain.User;

import javax.inject.Inject;

import static com.lnsantos.app.R.drawable.ic_account;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener{

    public EditText name, lastname, email, password, confirmPassword;
    Button register, notRegister, login;

    @Inject
    MainContract.Presenter presenter;

    @Inject
    User user;
    private int img_1 = ic_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerApplicationComponent.create().inject(this);

        setListener();
        onFindIds();

        presenter.setView(this,getApplicationContext());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                presenter.handlerStore();
                break;
            case R.id.btn_notRegister:
                presenter.handlerCancel();
                break;
            case R.id.btn_login:
                presenter.handlerLogin();
                break;
        }
    }

    private void setListener(){
        name = findViewById(R.id.edt_name);
        lastname = findViewById(R.id.edt_lastname);
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        confirmPassword = findViewById(R.id.edt_confirmPassword);

        register = findViewById(R.id.btn_register);
        notRegister = findViewById(R.id.btn_notRegister);
        login = findViewById(R.id.btn_login);
    }


    @Override
    public void setErrorLastname(String error) {
        lastname.setError(error);
    }

    @Override
    public void setErrorPassword(String error) {
        password.setError(error);
    }

    @Override
    public void setErrorConfirmePassword(String error) {
        confirmPassword.setError(error);
    }

    @Override
    public void setErrorEmail(String error) {
        email.setError(error);
    }

    @Override
    public void setErrorName(String error) {
        name.setError(error);
    }

    public void onFindIds(){
        register.setOnClickListener(this);
        notRegister.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public User getUser() {
        addUser();
        return user;
    }

    @Override
    public void setUser(User u) {
        this.user = u;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNextActivity(Activity next) {

    }

    @Override
    public String getName() {
        return name.getText().toString();
    }

    @Override
    public String getLastname() {
        return lastname.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public String getConfirmePassword() {
        return confirmPassword.getText().toString();
    }

    @Override
    public String getEmail() {
        return email.getText().toString();
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname.setText(lastname);
    }

    @Override
    public void setPassword(String password) {
        this.password.setText(password);
    }

    @Override
    public void setCOnfirmePassword(String confirmePasswordpassword) {
        this.confirmPassword.setText(confirmePasswordpassword);
    }

    @Override
    public void setEmail(String email) {
        this.email.setText(email);
    }

    private void addUser(){
        user.setName(name.getText().toString());
        user.setLastname(lastname.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
    }
}
