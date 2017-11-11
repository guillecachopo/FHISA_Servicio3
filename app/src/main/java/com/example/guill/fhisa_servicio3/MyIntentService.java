package com.example.guill.fhisa_servicio3;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;


public class MyIntentService extends IntentService {


    private Context mContext;
    private boolean mBound = false;
    private LocationUpdatesService mService = null;


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("MyIntentService", "Dentro del Intent Service");
        mContext = getApplicationContext();
        mContext.bindService(new Intent(this, LocationUpdatesService.class), mServiceConnection, Context.BIND_AUTO_CREATE);
        Intent intentone = new Intent(mContext.getApplicationContext(), LocationUpdatesService.class);
        intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startService(intentone);
    }

    private final ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("MyIntentService", "onServiceConnected");
            LocationUpdatesService.LocalBinder binder = (LocationUpdatesService.LocalBinder) service;
            mService = binder.getService();
            mService.requestLocationUpdates();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("MyIntentService", "onServiceDisconnected");
            mService = null;
            mBound = false;
        }
    };
}
