package com.lnsantos.app.ui;

import android.app.Activity;
import android.content.Context;

import com.lnsantos.app.model.domain.User;

public interface MainContract {

    interface View{
        void showMessage(String message);
        void onNextActivity(Activity next);

        User getUser();
        void setUser(User u);

        String getName();
        String getLastname();
        String getPassword();
        String getConfirmePassword();
        String getEmail();

        void setName(String name);
        void setLastname(String lastname);
        void setPassword(String password);
        void setCOnfirmePassword(String confirmePasswordpassword);
        void setEmail(String email);

        void setErrorName(String error);
        void setErrorLastname(String error);
        void setErrorPassword(String error);
        void setErrorConfirmePassword(String error);
        void setErrorEmail(String error);

    }

    interface Presenter{

        void handlerCancel();
        void handlerStore();
        void handlerLogin();

        void onResultStore(Boolean verify);

        void setView(MainContract.View view,Context c);

    }

    interface Model{
        void storeUser(User user, Context c, MainContract.Presenter presenter);


    }

}
