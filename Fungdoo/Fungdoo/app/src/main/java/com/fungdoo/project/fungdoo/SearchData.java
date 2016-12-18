package com.fungdoo.project.fungdoo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * Created by poliveira on 11/03/2015.
 */
public class SearchData extends Fragment {
    public static final String TAG = "stats";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         View v = inflater.inflate(R.layout.search_data, container, false);
        ListView listListView = (ListView) v.findViewById(R.id.listview);
         listListView.setAdapter(new  CustomListViewAdapter( ));
        return  v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
    @Override
    public void onStart(){
        super.onStart();
        // Apply any required UI change now that the Fragment is visible.


    }
    public class CustomListViewAdapter extends BaseAdapter {

        public int getCount() {
            return File_Confix_Data.data_Category.size();
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
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.item_listview_listview, null);
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
                        File_Confix_Data.string_id_cat=catID;
                          for(int j=0;j<File_Confix_Data.data_Category.size();j++){

                                      if( File_Confix_Data.data_Category.get(j).getCategory_id().equals(File_Confix_Data.string_id_cat)){
                                          File_Confix_Data.titel=  File_Confix_Data.data_Category.get(j).getCategory_name();
                                      }
                          }


                        Intent intent = new Intent(getActivity(), MainactivityMain2.class);
                        startActivity(intent);
                    }
                });

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.titleTextView.setText( File_Confix_Data.data_Category.get( position).getCategory_name());
            holder.descTextView.setText(  File_Confix_Data.data_Category.get( position).getCategory_detail());
            holder.textView1.setText("เลือกรายการนี้   ..." );


            Glide.with(getActivity()).load(File_Confix_Data.data_Category.get( position).getCategory_icon()).into(holder.authorImageView);


            holder.relativeLayoutthumbnail.setTag(R.id.relativeLayoutthumbnail, File_Confix_Data.data_Category.get( position).getCategory_id());
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

}
