package com.fungdoo.project.fungdoo;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Adil Soomro
 *
 */
public class MainactivityMain2 extends AppCompatActivity {


	 protected static final int RESULT_SPEECH = 1;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_cat);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

       // getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getSupportActionBar().setTitle(Html.fromHtml("<font style='normal' color='#ffffff'>"+File_Confix_Data.titel+" </font>")) ;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00BAE2")));


        TextView titel = (TextView) findViewById(R.id.texttitel);
       titel.setText("เลือก");

        ListView listListView = (ListView) findViewById(R.id.listview);
        RelativeLayout relativeLayout1 = (RelativeLayout) findViewById(R.id.relativeLayout1);
        relativeLayout1.setVisibility(View.GONE);


                JSONArray vavul ;
                JSONArray vavul_total=new JSONArray();



        vavul=new JSONArray();
        for(int i=0;i<File_Confix_Data.sor_.length();i++){
            try {
            final JSONObject jo = File_Confix_Data.sor_.getJSONObject(i);

                    if(jo.getString("category_id").toString().equals(File_Confix_Data.string_id_cat)){
                        vavul.put(jo);
                    }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
       // list.add(vavul);
        vavul_total=vavul;




        JSONObject velueS= new JSONObject() ;

        if(vavul_total.length()>0){
            try {
                velueS.put("output",vavul_total);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("sortDistination",""+velueS);

            Gson gson = new Gson();
            List_data_filter listdata=   gson.fromJson(velueS.toString(), List_data_filter.class);
            File_Confix_Data.getOutput_data_List_filter= listdata.getOutput();
            listListView.setAdapter(new CustomListViewAdapter( ));
            }

        }

    public class CustomListViewAdapter extends BaseAdapter {

        public int getCount() {
            return  File_Confix_Data.getOutput_data_List_filter.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_listview_listview, null);
                holder = new ViewHolder();
                holder.titleTextView = (TextView) convertView.findViewById(R.id.title);
                holder.descTextView = (TextView) convertView.findViewById(R.id.artistsss);
                holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
                holder.relativeLayoutthumbnail = (RelativeLayout) convertView.findViewById(R.id.relativeLayoutthumbnail);
                holder.authorImageView = (ImageView) convertView.findViewById(R.id.list_image);
                holder.relativeLayoutthumbnail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                     //   Toast.makeText(MainactivityMain2.this,  File_Confix_Data.getOutput_data_List.get(myIntArray[position]).getRestaurant_name()+"  "
                                //+ File_Confix_Data.getOutput_data_List.get(myIntArray[position]).getRestaurant_id(), Toast.LENGTH_SHORT).show();


                        final String catID = v.getTag(R.id.relativeLayoutthumbnail).toString();
                        File_Confix_Data.string_id_data=catID;

                        for(int i=0;i<File_Confix_Data.getOutput_data_List.size();i++) {

                            if(File_Confix_Data.getOutput_data_List.get(i).getTravel_id().equals(File_Confix_Data.string_id_data)){

                                File_Confix_Data.position_id=i;
                            }
                        }


                        Intent intent = new Intent(MainactivityMain2.this, SuccessActivity.class);
                        startActivity(intent);
                    }
                });

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

             holder.titleTextView.setText(File_Confix_Data.getOutput_data_List_filter.get( position).getCategory_name() );
             holder.descTextView.setText(File_Confix_Data.getOutput_data_List_filter.get( position).getTravel_name());
            holder.textView1.setText( File_Confix_Data.getOutput_data_List_filter.get( position).getTravel_detail()   );


        if(File_Confix_Data.getOutput_data_List_filter.get( position).getImage_product().size()>0){

           Glide.with(getApplicationContext()).load(File_Confix_Data.getOutput_data_List_filter.get( position).getImage_product().get(0)).into(holder.authorImageView);
        }else {
            holder.authorImageView.setBackgroundResource(R.drawable.music_icon);
        }

       holder.relativeLayoutthumbnail.setTag(R.id.relativeLayoutthumbnail, File_Confix_Data.getOutput_data_List_filter.get( position).getTravel_id());
            return convertView;
        }
        public class ViewHolder {
            TextView titleTextView;
            ImageView authorImageView;
            TextView textView1;
            TextView descTextView;
            RelativeLayout relativeLayoutthumbnail;

        }
    }
		@Override
		public void onBackPressed() {

    		 finish();
		}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return true;
    }
}