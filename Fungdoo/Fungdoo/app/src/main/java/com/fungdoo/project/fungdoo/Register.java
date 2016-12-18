package com.fungdoo.project.fungdoo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;


public class Register extends Activity {
	ProgressDialog pDialog ;
	private Bitmap bitmapSave=null;
	public static final int REQUEST_GALLERY = 1;
	static final int DATE_DIALOG_ID = 999;
 

	private EditText text1;
	private EditText text2;
	private EditText text3;
	private EditText text4;
	private EditText text5;
	private EditText text6;
	private EditText text7;
	//private String nameType;
	private Button btnCancel,btnSubmit;
	private Uri part;
	 String fname ;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main_register);
	    

	    text1 = (EditText) findViewById(R.id.text1);
	    text2 = (EditText) findViewById(R.id.text2);
	    text3 = (EditText) findViewById(R.id.text3);
	    text4 = (EditText) findViewById(R.id.text4);
	    text5 = (EditText) findViewById(R.id.text5);
	    text6= (EditText) findViewById(R.id.text6);
	    text7= (EditText) findViewById(R.id.text7);


//		//เพศ
//        // Spinner element
//        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
//        // Spinner click listener
//        // Spinner Drop down elements
//        final List<String> categories1= new ArrayList<String>();
//        categories1.add("ชาย");
//        categories1.add("หญิง");
//
//        // Creating adapter for spinner
//		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
//		// Drop down layout style - list view with radio button
//		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		// attaching data adapter to spinner
//		spinner1.setAdapter(dataAdapter1);
//		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
//		    @Override
//		    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//		        // your code here
//		    	nameType=categories1.get(position).toString();
//		    }
//		    @Override
//		    public void onNothingSelected(AdapterView<?> parentView) {
//		        // your code here
//		    }
//		});
		btnSubmit= (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				if(text1.getText().toString().equals("")||text2.getText().toString().equals("")
						||text3.getText().toString().equals("")||text4.getText().toString().equals("")
						||text6.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "กรุณากรอกข้อมูลให้ครบ", Toast.LENGTH_LONG).show();
				}else{
					pDialog = new ProgressDialog(Register.this);
					pDialog.setMessage("Loading ....");
					pDialog.setIndeterminate(false);
					pDialog.setCancelable(false);
					pDialog.show();
					Add_data_Register(text1.getText().toString(),text2.getText().toString(),text3.getText().toString(),text4.getText().toString()
							,text5.getText().toString()
							,text6.getText().toString()
							,text7.getText().toString());
				}
			}
		});

		btnCancel= (Button) findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				text1.setText(" ");
				text2.setText(" ");
				text3.setText(" ");
				text4.setText(" ");
				text5.setText(" ");
				text6.setText(" ");
				text7.setText(" ");

			}
		});
	}
 

	@Override
	public void onBackPressed() {
		Register.this.finish();
		   Intent i = new Intent(Register.this, Login.class);
           startActivity(i);

    }
	private void Add_data_Register(String dd1, String dd2, String dd3, String dd4, String dd5, String dd6, String dd7 ) {
//AddUser
//
//		$reg_username  = $_GET['reg_username'];
//		$reg_pass       = $_GET['reg_pass'];
//		$reg_identification  = $_GET['reg_identification'];
//		$reg_name        = $_GET['reg_name'];
//		$reg_address         = $_GET['reg_address'];
//		$reg_telephone  = $_GET['reg_telephone'];
//		$reg_email      		= $_GET['reg_email'];

		String URL="http://projectandroid.top/Review-Travel/index.php/APISaleProduct/AddUser?reg_username="+dd1+"&reg_pass="+dd2
				+"&reg_identification="+dd3
				+"&reg_name="+dd4
				+"&reg_address="+dd5
				+"&reg_telephone="+dd6
				+"&reg_email="+dd7
				+"&bank_name="+dd7
				+"&bank_number="+dd2
				+"&bank_account_name="+dd2;

		AsyncHttpClient client = new AsyncHttpClient();

		client.get(URL, new AsyncHttpResponseHandler() {

			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2,
								  Throwable arg3) {
				// TODO Auto-generated method stub
				;
			}
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				// TODO Auto-generated method stub
				String str = null;
				try {
					str = new String(arg2, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Load_USER();



			}

		});
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
	private void intent_activity() {


		pDialog.dismiss();;

		Gson gson = new Gson();
		SharedPreferences database_list = getSharedPreferences("DATABASEUSER", 0);
		String str = database_list.getString("databaseuser", "");
		Debug.out(str);



		List_User  data_list_user=   gson.fromJson(str, List_User.class);
		File_Confix_Data.data_list_user= data_list_user.getOutput();


		Intent intent = new Intent(Register.this, Login.class);
		startActivity(intent);
		finish();

	}

}
