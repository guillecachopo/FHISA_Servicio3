package com.example.guill.fhisa_servicio3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;

import com.example.guill.fhisa_servicio3.Objetos.BaseOperativa;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by guill on 11/11/2017.
 */

public class AutoArranque extends BroadcastReceiver {

    private LocationUpdatesService mService = null;
    private boolean mBound = false;

    private Location mLocation;

    SharedPreferences preferences;

    ArrayList<BaseOperativa> listaBasesOperativas;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    final DatabaseReference areasRef = database.getReference("areas");

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            //saveAreas(context);
            context.startService(new Intent(context, MyIntentService.class));

        }
    }

    /*
    public void saveAreas(Context context) {

        preferences = PreferenceManager.getDefaultSharedPreferences(context);

        areasRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                SharedPreferences.Editor editor = preferences.edit();
                ArrayList<BaseOperativa> listaBasesOperativas = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    snapshot.getValue().getClass();
                    BaseOperativa areaFirebase = snapshot.getValue(BaseOperativa.class);
                    listaBasesOperativas.add(areaFirebase);
                }
                Gson gson = new Gson();
                String jsonListaAreas = gson.toJson(listaBasesOperativas);
                editor.putString("jsonListaAreas", jsonListaAreas);
                editor.commit();
                Log.i("CamionDentro", "ListaAreas: " + listaBasesOperativas.size());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    */
}
