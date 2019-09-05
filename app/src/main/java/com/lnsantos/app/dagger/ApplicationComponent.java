package com.lnsantos.app.dagger;

import com.lnsantos.app.model.SQLite.DatabaseModule;
import com.lnsantos.app.ui.MainActivity;
import com.lnsantos.app.ui.MainModule;

import dagger.Component;

@Component( modules = { MainModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
