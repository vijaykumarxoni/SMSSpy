package com.spy.vksoni.smsspy.DB;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

/**
 * Created by Vksoni on 1/15/2018.
 */

public class DBConnection extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration dbConfiguration =
                new Configuration.Builder(this).
                        setDatabaseName("ConversationModel.db").setModelClasses(ConversationModel.class,SMSModel.class)
                        .create();

        ActiveAndroid.initialize(dbConfiguration);
    }
}
