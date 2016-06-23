package com.ericbrooke.photogalley;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;

/**
 * Created by ebrooke on 6/23/16.
 */
public class PollService extends IntentService {
    private static final String TAG = "PollService";

    public static Intent newIntent(Context context) {
        return new Intent(context, PollService.class);
    }

    public PollService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent){
        if (!isNetworkAvailableAndConnected()) {
            return;
        }
        Log.i(TAG, "Received an intent: " + intent);
    }

    private boolean isNetworkAvailableAndConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        boolean isNetworkAvilable = cm.getActiveNetworkInfo() != null;
        boolean isNetworkConnected = isNetworkAvilable && cm.getActiveNetworkInfo().isConnected();

        return isNetworkConnected;
    }
}
