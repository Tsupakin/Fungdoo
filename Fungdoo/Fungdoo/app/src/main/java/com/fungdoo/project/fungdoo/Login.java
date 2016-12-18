package com.fungdoo.project.fungdoo;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.DetectedActivity;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import io.nlopez.smartlocation.OnActivityUpdatedListener;
import io.nlopez.smartlocation.OnGeofencingTransitionListener;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.OnReverseGeocodingListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.geofencing.utils.TransitionGeofence;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;


public class Login extends AppCompatActivity      {
       boolean check_load=false;
	private LocationGooglePlayServicesProvider provider;
	private static final int LOCATION_PERMISSION_ID = 1001;

	 JSONArray jo  ;
		JSONArray jsonarray= null;
		 JSONObject obj= null;

	Database data_;
	 EditText User,Passpord;
	// private ProgressDialog progressDialog;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.login_layout);
            User = (EditText)findViewById(R.id.username_edtext);
            Passpord = (EditText)findViewById(R.id.passwd_edtext);

			data_=new Database(Login.this);

			Load_List();

			Button buttonEnter = (Button)findViewById(R.id.login_button);
			buttonEnter.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if (ContextCompat.checkSelfPermission(Login.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
						ActivityCompat.requestPermissions(Login.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_ID);
						return;
					}




					if(User.getText().toString()==null||User.getText().toString().equals("")
							||Passpord.getText().toString()==null||Passpord.getText().toString().equals("")){
						Toast.makeText(getApplicationContext(), "กรุณากรอก user password", Toast.LENGTH_LONG).show();

					}else{
						LoginPass();
						
					}
					  
				}

			
			});
			
			Button buttonEnterregister = (Button)findViewById(R.id.regist);
			buttonEnterregister.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {

					 Intent i = new Intent(Login.this, Register.class);
			           startActivity(i);	 
					  
				}

			
			});

		    
		}

	@Override
	protected void onStart() {
		super.onStart();



	}

	private void LoginPass() {
			// TODO Auto-generated method stub

			String username=User.getText().toString();
			String password=Passpord.getText().toString();

            boolean check_user_login=false;
			for(int i=0;i<File_Confix_Data.data_list_user.size();i++){
				if(File_Confix_Data.data_list_user.get(i).getReg_username().equals(username)&&File_Confix_Data.data_list_user.get(i).getReg_pass().equals(password)){
					check_user_login=true;
					File_Confix_Data.position_id_regist=i;
				}

			}

			if(check_user_login){
				 if(check_load){
					 Intent i = new Intent(Login.this, MainActivity.class);
					 startActivity(i);
				 }else{
					 Toast.makeText(getApplicationContext(), "กำลังโหลดข้อมูล กด login ใหม่อีกรอบ", Toast.LENGTH_LONG).show();
				 }

			}else{
				Toast.makeText(getApplicationContext(), "User or Passpord  ผิด", Toast.LENGTH_LONG).show();
			}

		}
		@Override
		public void onBackPressed() {
			Intent intent = new Intent(Intent.ACTION_MAIN);
    		intent.addCategory(Intent.CATEGORY_HOME);
    		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    		startActivity(intent);  
	         Login.this.finish();
		}












	private void SetDistination() {


		SharedPreferences database_list = getSharedPreferences("DATABASELIST", 0);
		String str = database_list.getString("databaselist", "");



		JSONObject objdistination= null;
		JSONArray jsonarraydistination= null;
		try {
			objdistination=new JSONObject(str);
			jsonarraydistination = objdistination.getJSONArray("output");

			File_Confix_Data.sor_=jsonarraydistination;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		Gson gson = new Gson();
		List_data listdata=   gson.fromJson(str, List_data.class);
		File_Confix_Data.getOutput_data_List= listdata.getOutput();
				if(File_Confix_Data.getOutput_data_List.size()>0){

					boolean check_id=false;
					for(int i=0;i<File_Confix_Data.getOutput_data_List.size();i++){
						check_id=false;
						for(int k=0;k<data_.SelectAllData().size();k++){
							if(File_Confix_Data.getOutput_data_List.get(i).getTravel_id().equals(data_.SelectAllData().get(k).get("col1"))){
								check_id=true;
							}

						}
                    if(check_id){

					}else{
						data_.InsertData(null,File_Confix_Data.getOutput_data_List.get(i).getTravel_id(),"0","","","","","","","");
						Log.d("id",""+File_Confix_Data.getOutput_data_List.get(i).getTravel_id());
					}
					}
				}




		for(int i=0;i<data_.SelectAllData().size();i++){
			if(data_.SelectAllData().get(i).get("col1").equals(File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_id())){

			}
		}
		check_load=true;

}


	private void Load_List() {
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://projectandroid.top/Travel/index.php/APITravel", new AsyncHttpResponseHandler() {

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


				SharedPreferences settings = getSharedPreferences("DATABASELIST", 0);
				SharedPreferences.Editor prefsEd = settings.edit();
				prefsEd.putString("databaselist", str);
				prefsEd.commit();


				SetDistination();

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
	}
