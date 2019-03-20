package com.yege.remyday1306;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * @author nongsini
 * @version 1.0.0
 * @since 2017-02-08 10:57
 */


public class XiaomiService extends Service {

    @Override
    public void onCreate() {
        Log.e("yy", "1306onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("yy", "1306onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("yy", "1306onBind");
        return new XiaomiBinder();
    }


    @Override
    public void unbindService(ServiceConnection conn) {
        Log.e("yy", "1306unbindService");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        Log.e("yy", "1306onDestroy");
        super.onDestroy();
    }

    String zhifu(int money) {

        String s = "";

        if (money > 100) {
            s = "购买成功";
        } else {
            s = "购买失败";
        }

        return s;
    }

    class XiaomiBinder extends XiaomiAIDL.Stub {


        @Override
        public String xiaomizhifu(int money) throws RemoteException {
            return zhifu(money);
        }
    }

}
