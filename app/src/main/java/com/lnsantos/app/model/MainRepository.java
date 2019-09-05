package com.lnsantos.app.model;

import android.content.Context;

import com.lnsantos.app.model.SQLite.DatabaseModule;
import com.lnsantos.app.model.domain.User;
import com.lnsantos.app.ui.MainContract;

import javax.inject.Inject;

public class MainRepository implements MainContract.Model {

    @Inject
    DatabaseModule db;

    @Override
    public void storeUser(User user, Context context,MainContract.Presenter presenter) {
        presenter.onResultStore(db.provideDatabase(context).newUser(user));
    }


}
