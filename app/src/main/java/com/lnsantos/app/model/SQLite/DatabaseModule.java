package com.lnsantos.app.model.SQLite;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    public Context getContext (){
        return getContext();
    }

    @Provides
    public DatabaseDefault provideDatabase(Context context){
        return new DatabaseDefault(context);
    }

}
