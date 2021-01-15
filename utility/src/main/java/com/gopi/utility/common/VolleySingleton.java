package com.gopi.utility.common;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static VolleySingleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private VolleySingleton(Context context){
        try {
            ctx = context;
            requestQueue = getRequestQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        try {

            if (instance == null) {
                instance = new VolleySingleton(context);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        try {

            if (requestQueue == null) {
                // getApplicationContext() is key, it keeps you from leaking the
                // Activity or BroadcastReceiver if someone passes one in.
                requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        try {

            getRequestQueue().add(req);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
