package com.fungdoo.project.fungdoo;//package com.ServiceDesk.ServiceDesk;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;


public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        Load_data();
    }

    private void Load_data() {
        // TODO Auto-generated method stub

        if (isOnline()) {

                Load_USER();


        } else {


                intent_activity();


        }


    }

    private void intent_activity() {




        Gson gson = new Gson();
        SharedPreferences database_list = getSharedPreferences("DATABASEUSER", 0);
        String str = database_list.getString("databaseuser", "");
        Debug.out(str);



        List_User  data_list_user=   gson.fromJson(str, List_User.class);
        File_Confix_Data.data_list_user= data_list_user.getOutput();


        SharedPreferences database_list_cat = getSharedPreferences("DATABASECAT", 0);
        String str_cat = database_list_cat.getString("databaseCategory", "");


        List_Category  data_Category=   gson.fromJson(str_cat, List_Category.class);
        File_Confix_Data.data_Category= data_Category.getOutput();


        Intent intent = new Intent(FullscreenActivity.this, Login.class);
        startActivity(intent);
        finish();
    }

    private void Load_USER() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://projectandroid.top/Review-Travel/index.php/APISaleProduct/getUser", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
                String str = null;
                try {
                    str = new String(response, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                SharedPreferences settings = getSharedPreferences("DATABASEUSER", 0);
                SharedPreferences.Editor prefsEd = settings.edit();
                prefsEd.putString("databaseuser", str);
                prefsEd.commit();

                Load_SearchCategory();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried http://projectandroid.top/Travel
            }
        });
    }
    private void Load_SearchCategory() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://projectandroid.top/Travel/index.php/APITravel/getDataSearchCategory", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
                String str = null;
                try {
                    str = new String(response, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                SharedPreferences settings = getSharedPreferences("DATABASECAT", 0);
                SharedPreferences.Editor prefsEd = settings.edit();
                prefsEd.putString("databaseCategory", str);
                prefsEd.commit();

                intent_activity();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried http://projectandroid.top/Travel
            }
        });
    }
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @SuppressWarnings("deprecation")
    public static boolean isGpsEnabled(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            String providers = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            if (TextUtils.isEmpty(providers)) {
                return false;
            }
            return providers.contains(LocationManager.GPS_PROVIDER);
        } else {
            final int locationMode;
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            switch (locationMode) {

                case Settings.Secure.LOCATION_MODE_HIGH_ACCURACY:
                case Settings.Secure.LOCATION_MODE_SENSORS_ONLY:
                    return true;
                case Settings.Secure.LOCATION_MODE_BATTERY_SAVING:
                case Settings.Secure.LOCATION_MODE_OFF:
                default:
                    return false;
            }
        }
    }
    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Goto Settings Page To Enable GPS If Android KITKAT Settings LOCATION MODE",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){

                                Intent callGPSSettingIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);

                            }
                        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

}
