package com.fungdoo.project.fungdoo;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Profile extends Activity {
	TextView textview2,textview3 ,textview5
			,textview6,textview7,textview8,textview9,textview10
			   ;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.profile);
			 
			textview2 = (TextView)findViewById(R.id.textview2);
			textview3 = (TextView)findViewById(R.id.textview3);
	 
			textview5 = (TextView)findViewById(R.id.textview5);
			
			textview6 = (TextView)findViewById(R.id.textview6);
			textview7 = (TextView)findViewById(R.id.textview7);
			textview8 = (TextView)findViewById(R.id.textview8);
			textview9 = (TextView)findViewById(R.id.textview9);
			textview10 = (TextView)findViewById(R.id.textview10);
			



   android_set_data();
				textview2.setTextColor(Color.BLACK);
				textview3.setTextColor(Color.BLACK);
				textview5.setTextColor(Color.BLACK);
				textview6.setTextColor(Color.BLACK);
				textview7.setTextColor(Color.BLACK);
				textview8.setTextColor(Color.BLACK);
				textview9.setTextColor(Color.BLACK);



			Button btnSubmit= (Button) findViewById(R.id.btnSubmit);
			btnSubmit.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					Intent i = new Intent(Profile.this, Profile_Update.class);
					startActivity(i);
				}
			});

			Button btnCancel= (Button) findViewById(R.id.btnCancel);
			btnCancel.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					Profile.this.finish();

				}
			});
		}

	private void android_set_data() {

		textview2.setText("ชื่อผู้ใช้งาน       "+File_Confix_Data.data_list_user.get(File_Confix_Data.position_id_regist).getReg_username());
		textview3.setText("รหัสผ่าน      "+File_Confix_Data.data_list_user.get(File_Confix_Data.position_id_regist).getReg_pass());
		textview5.setText("ชื่อ-นามสุกุล       "+File_Confix_Data.data_list_user.get(File_Confix_Data.position_id_regist).getReg_name());
		textview6.setText("รหัสประจำตัวประชาชน       "+File_Confix_Data.data_list_user.get(File_Confix_Data.position_id_regist).getReg_identification());
		textview7.setText("ที่อยู่       "+File_Confix_Data.data_list_user.get(File_Confix_Data.position_id_regist).getReg_address());
		textview8.setText("เบอร์โทร       "+File_Confix_Data.data_list_user.get(File_Confix_Data.position_id_regist).getReg_telephone());
		textview9.setText("อีเมลล์       "+File_Confix_Data.data_list_user.get(File_Confix_Data.position_id_regist).getReg_email());
	}

	@Override
	protected void onStart() {
		super.onStart();

		android_set_data();
	}

	@Override
		public void onBackPressed() {
			 
	         Profile.this.finish();
		}
	}
