package com.ericbrooke.photogalley;

import android.os.HandlerThread;
import android.util.Log;

/**
 * Created by ebrooke on 6/23/16.
 */
public class ThumbnailDownloader<T> extends HandlerThread {
    public static final String TAG = "ThumbnailDownloader";

    private boolean mHasQuit = false;

    public ThumbnailDownloader() {
        super(TAG);
    }

    @Override
    public boolean quit() {
        mHasQuit = true;
        return  super.quit();

    }

    public void queueThumbnail(T target, String url) {
        Log.i(TAG, "Got a URL:" + url);
    }
}
