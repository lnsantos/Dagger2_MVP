package com.lnsantos.app.ui;

import com.lnsantos.app.model.MainRepository;
import com.lnsantos.app.model.domain.User;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public User provideUser(){
        return new User();
    }

    @Provides
    public MainContract.Model provideModel(){
        return new MainRepository();
    }
    @Provides
    public MainContract.Presenter providePresenter(MainContract.Model model){
        return new MainPresenter(model);
    }


}
