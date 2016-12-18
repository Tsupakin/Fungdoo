package com.fungdoo.project.fungdoo;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
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

/**
 * @author Adil Soomro
 *
 */
public class Favorite extends AppCompatActivity {
    ListView listListView;

    protected static final int RESULT_SPEECH = 1;
   private int[] myIntArray ;
    private int count=0;
    Database data_;
    TextView titel;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_cat);
        data_=new Database(Favorite.this);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

       // getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00BAE2")));


          titel = (TextView) findViewById(R.id.texttitel);




       listListView = (ListView) findViewById(R.id.listview);


        }

    @Override
    protected void onStart() {
        super.onStart();
        count=0;
        for(int i=0;i<File_Confix_Data.getOutput_data_List.size();i++) {
            if(data_.SelectAllData().get(i).get("col2").equals("1")){
                count++;
            }
        }
        if(count>0){
            getSupportActionBar().setTitle(Html.fromHtml("<font style='normal' color='#ffffff'>"+"favorite"+" </font>")) ;
            titel.setText("favorite");
        }else{
            getSupportActionBar().setTitle(Html.fromHtml("<font style='normal' color='#ffffff'>"+"No Favorite"+" </font>")) ;
            titel.setText("No Favorite");
        }

        myIntArray = new int[count];
        int y=0;
        for(int i=0;i<File_Confix_Data.getOutput_data_List.size();i++) {
            if(data_.SelectAllData().get(i).get("col2").equals("1")){
                myIntArray[y]=i;
                y++;
            }
        }
        listListView.setAdapter(new CustomListViewAdapter( ));
    }

    public class CustomListViewAdapter extends BaseAdapter {

        public int getCount() {
            return count;
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


                        final String catID = v.getTag(R.id.relativeLayoutthumbnail).toString();
                        File_Confix_Data.string_id_data=catID;

                        for(int i=0;i<File_Confix_Data.getOutput_data_List.size();i++) {

                            if(File_Confix_Data.getOutput_data_List.get(i).getTravel_id().equals(File_Confix_Data.string_id_data)){

                                File_Confix_Data.position_id=i;
                            }
                        }

                        Intent intent = new Intent(Favorite.this, SuccessActivity.class);
                        startActivity(intent);
                    }
                });

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

             holder.titleTextView.setText(File_Confix_Data.getOutput_data_List.get(myIntArray[position]).getCategory_name());
             holder.descTextView.setText(File_Confix_Data.getOutput_data_List.get(myIntArray[position]).getTravel_name());
            holder.textView1.setText(File_Confix_Data.getOutput_data_List.get(myIntArray[position]).getTravel_detail() );


        if(File_Confix_Data.getOutput_data_List.get(myIntArray[position]).getImage_product().size()>0){

           Glide.with(getApplicationContext()).load(File_Confix_Data.getOutput_data_List.get(myIntArray[position]).getImage_product().get(0)).into(holder.authorImageView);
        }else{
            holder.authorImageView.setBackgroundResource(R.drawable.music_icon);
        }

       holder.relativeLayoutthumbnail.setTag(R.id.relativeLayoutthumbnail, File_Confix_Data.getOutput_data_List.get(myIntArray[position]).getTravel_id());
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