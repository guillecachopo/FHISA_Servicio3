package com.example.guill.fhisa_servicio3;

/**
 * Created by guill on 11/11/2017.
 */

import android.content.Context;
import android.location.Location;
import android.preference.PreferenceManager;

import java.text.DateFormat;
import java.util.Date;

class Utils {

    static final String KEY_REQUESTING_LOCATION_UPDATES = "requesting_locaction_updates";

    static final String FIREBASE_CAMIONES_REFERENCE = "camiones";
    static final String FIREBASE_POSICIONES_REFERENCE = "posiciones";
    static final String PASSWORD = "fhisahormigones";
    static final String PASSWORD_REQUIRED = "Contraseña requerida";
    static final String WRITE_PASSWORD = "Escriba la contraseña para dejar de ejecutar el servicio.";
    static final String WRONG_PASSWORD = "La contraseña introducida es incorrecta.";
    static final String CORRECT_PASWORD = "La contraseña es correcta, se ha dejado de ejecutar el servicio.";

    /**
     * Returns true if requesting location updates, otherwise returns false.
     *
     * @param context The {@link Context}.
     */
    static boolean requestingLocationUpdates(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_REQUESTING_LOCATION_UPDATES, false);
    }

    /**
     * Stores the location updates state in SharedPreferences.
     * @param requestingLocationUpdates The location updates state.
     */
    static void setRequestingLocationUpdates(Context context, boolean requestingLocationUpdates) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_REQUESTING_LOCATION_UPDATES, requestingLocationUpdates)
                .apply();
    }

    /**
     * Returns the {@code location} object as a human readable string.
     * @param location  The {@link Location}.
     */
    static String getLocationText(Location location) {
        return location == null ? "Unknown location" :
                "(" + location.getLatitude() + ", " + location.getLongitude() + ")";
    }

    static String getLocationTitle(Context context) {
        return context.getString(R.string.location_updated,
                DateFormat.getDateTimeInstance().format(new Date()));
    }
}