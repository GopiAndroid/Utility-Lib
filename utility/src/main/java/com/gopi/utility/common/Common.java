package com.gopi.utility.common;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

public class Common {

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = null;
        try {
            cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public static void showToast(Context context, String toastMessage){

        try {
            Toast.makeText(context,toastMessage,Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openUrlInBrowser(Context context, String url){
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showLayout(View layoutToShow, View layoutToHide){

        try {
            layoutToShow.setVisibility(View.VISIBLE);
            layoutToHide.setVisibility(View.GONE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void hideLayout(View layoutToHide, View layoutToShow){
        try {
            layoutToShow.setVisibility(View.VISIBLE);
            layoutToHide.setVisibility(View.GONE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float calculatePercentage(float amount, float percentage){

        try {

            return (amount/100) * percentage;

        } catch (Exception e) {

            e.printStackTrace();

            return 0;
        }
    }
}
