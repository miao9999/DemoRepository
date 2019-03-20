package com.limiao.daggerdemo;

import android.app.Application;
import android.provider.Telephony;

import dagger.Component;

/**
 * Created by miao on 2019/3/11.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        inject(this);


    }
    private void inject(MyApplication myApplication){
        ApplicationComponent applicationComponent =
                DaggerApplicationComponent.builder().appModule(new AppModule(myApplication)).build();
        ComponentHolder.setApplicationComponent(applicationComponent);
    }

   static class ComponentHolder{
        public static ApplicationComponent applicationComponent;

       public static ApplicationComponent getApplicationComponent() {
           return applicationComponent;
       }

       public static void setApplicationComponent(ApplicationComponent applicationComponent) {
           ComponentHolder.applicationComponent = applicationComponent;
       }
   }
}
