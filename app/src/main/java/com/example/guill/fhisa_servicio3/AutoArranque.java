package com.example.guill.fhisa_servicio3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.guill.fhisa_servicio3.Objetos.Area;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by guill on 11/11/2017.
 */

public class AutoArranque extends BroadcastReceiver {

    private LocationUpdatesService mService = null;
    private boolean mBound = false;

    private Location mLocation;

    SharedPreferences preferences;

    ArrayList<Area> listaAreas;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    final DatabaseReference areasRef = database.getReference("areas");

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            //guardarAreas(context);
            context.startService(new Intent(context, MyIntentService.class));

        }
    }

    public void guardarAreas(Context context) {

        preferences = PreferenceManager.getDefaultSharedPreferences(context);

        areasRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                SharedPreferences.Editor editor = preferences.edit();
                ArrayList<Area> listaAreas = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    snapshot.getValue().getClass();
                    Area areaFirebase = snapshot.getValue(Area.class);
                    listaAreas.add(areaFirebase);
                }
                Gson gson = new Gson();
                String jsonListaAreas = gson.toJson(listaAreas);
                editor.putString("jsonListaAreas", jsonListaAreas);
                editor.commit();
                Log.i("CamionDentro", "ListaAreas: " + listaAreas.size());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
