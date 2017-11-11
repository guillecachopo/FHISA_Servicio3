package com.example.guill.fhisa_servicio3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by guill on 11/11/2017.
 */

public class AutoArranque extends BroadcastReceiver {

    private LocationUpdatesService mService = null;
    private boolean mBound = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
         /*   Intent intentone = new Intent(context.getApplicationContext(), LocationUpdatesService.class);
            intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(intentone); */
            context.startService(new Intent(context, MyIntentService.class));

        }
    }
}
