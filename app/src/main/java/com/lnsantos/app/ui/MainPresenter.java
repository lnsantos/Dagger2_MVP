package com.lnsantos.app.ui;

import android.content.Context;
import android.text.BoringLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.Model model;
    private MainContract.View view;
    private Context context;

    public MainPresenter(MainContract.Model model) {
        this.model = model;
    }

    @Override
    public void handlerCancel() {
        view.showMessage("cancel clicked");
    }

    @Override
    public void handlerStore() {
        Integer acountError = 0;

        if(view.getName().equals("")){
            view.setErrorName("Please, insert your name! ");
            acountError++;
        }

        if(view.getLastname().equals("")){
            view.setErrorLastname("Please, insert your last name! ");
            acountError++;
        }

        if(view.getEmail().equals("")){
            view.setErrorEmail("Please, insert your email! ");
            acountError++;
        }else if(!verifyEmail(view.getEmail())){
            view.setErrorEmail("it not is an email valid ");
            acountError++;
        }

        if(view.getPassword().equals("")){
            view.setErrorPassword("please, insert an password! ");
            acountError++;
        }

        if(view.getConfirmePassword().equals("")){
            view.setErrorConfirmePassword("please, insert an confirm password! ");
            acountError++;
        }

        if(!view.getPassword().equals(view.getConfirmePassword())){
            view.setErrorPassword("Sorry, password not equals with confirm password ");
            view.setErrorConfirmePassword("Sorry, confirm password not equals with password");
            acountError++;
        }

        if(acountError < 1){
            model.storeUser(view.getUser(),context,this);
            view.showMessage("register clicked");
        }
    }

    @Override
    public void handlerLogin() {
        view.showMessage("login clicked");
    }

    @Override
    public void setView(MainContract.View view, Context c) {
        this.context = c;
        this.view = view;
    }

    @Override
    public void onResultStore(Boolean verify) {
        if(verify) view.showMessage("User created with success");
        else view.showMessage("Sorry, Failed in created user");
    }

    private Boolean verifyEmail(String email){
        String regex = "^(.+)@(.+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }

}
