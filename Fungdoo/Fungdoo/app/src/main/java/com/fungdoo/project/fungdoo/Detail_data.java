package com.fungdoo.project.fungdoo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;


public class Detail_data extends Fragment {
    TextView texttitel,contect,addres   ;
    TextView data11   ;
    LinearLayout layout_share ,layout_faar ;
    Database data_;
    ImageView ImageView_fullhart_icon;

    String Code_Id="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        data_=new Database(getContext());


        View v = inflater.inflate(R.layout.detail, container, false);
        texttitel = (TextView) v.findViewById(R.id.texttitel);
        contect = (TextView) v.findViewById(R.id.contect);
        addres = (TextView) v.findViewById(R.id.addres);

        data11 = (TextView) v.findViewById(R.id.data11);
        ImageView_fullhart_icon = (ImageView) v.findViewById(R.id.ImageView_fullhart_icon);

        ImageView imageView_music = (ImageView) v.findViewById(R.id.imageView_music);
        if(File_Confix_Data.getOutput_data_List.get( File_Confix_Data.position_id).getImage_product().size()>0){

            Glide.with(getActivity()).load(File_Confix_Data.getOutput_data_List.get( File_Confix_Data.position_id).getImage_product().get(0)).into(imageView_music);
        }else {
            imageView_music.setBackgroundResource(R.drawable.music_icon);
        }
         layout_share = (LinearLayout) v.findViewById(R.id.layout_share);

        layout_faar = (LinearLayout) v.findViewById(R.id.layout_faar);


         Settext();
        return  v;
    }

    private void Settext() {

        for(int i=0;i<data_.SelectAllData().size();i++){
            if(data_.SelectAllData().get(i).get("col1").equals(File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_id()) ){

                Code_Id=data_.SelectAllData().get(i).get("Code");
            }
            else {

                Log.d("id",""+data_.SelectAllData().get(i).get("col1"));
            }
        }


        texttitel.setText( File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getCategory_name());
       contect.setText(File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_name());
       addres.setText(File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_detail()

       );



        data11.setText("ผู้แต่ง "+File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_address()

                        +"\nลงเมื่อ    "+File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getDate()
                 );

              String[] SelectDataCode= data_.SelectDataCode(Code_Id);
                 if(SelectDataCode[2].equals("1")){
                     ImageView_fullhart_icon.setBackgroundResource(R.mipmap.ic_action_halfhart_icon);
                 }else{
                     ImageView_fullhart_icon.setBackgroundResource(R.mipmap.ic_action_fullhart_icon_);
                 }




        layout_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String text11=texttitel.getText().toString();
                String text33=addres.getText().toString();
                String ShareSub=text11+" "+text33+data11.getText().toString();



                String uri = "http://maps.google.com/maps?saddr=" +File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getLatitude()+","+File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getLongitude();
                String ShareSubS= ShareSub+"  "+uri;
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                share.putExtra(Intent.EXTRA_SUBJECT, "data Share link!" );
                share.putExtra(Intent.EXTRA_TEXT,ShareSubS);
                startActivity(Intent.createChooser(share, "Share link!"));

            }
        });



        layout_faar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String[] SelectDataCode= data_.SelectDataCode(Code_Id);
                if(SelectDataCode[2].equals("1")){
                    data_.UpdateData(Code_Id,File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_id(),"0","","","","","","","");
                }else{
                    data_.UpdateData(Code_Id,File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_id(),"1","","","","","","","");
                }

                Settext();

            }
        });



    }


    @Override
    public void onDetach() {
        super.onDetach();

    }


}
