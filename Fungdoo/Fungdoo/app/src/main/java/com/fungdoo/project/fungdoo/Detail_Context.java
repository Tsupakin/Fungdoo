package com.fungdoo.project.fungdoo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Detail_Context extends Fragment {

    TextView data11  ,data1,data2,data3,data4 ;
    LinearLayout layout_share,gpsS,layout_call;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v = inflater.inflate(R.layout.detail_context, container, false);


        data11 = (TextView) v.findViewById(R.id.data11);

           layout_share = (LinearLayout) v.findViewById(R.id.layout_share);
        gpsS = (LinearLayout) v.findViewById(R.id.layout_gps);
        layout_call = (LinearLayout) v.findViewById(R.id.layout_call);




   //     Settext();
        return  v;
    }

//    private void Settext() {
//
//
//        data11.setText("ที่อยู่ \n\n"+File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_address() );
//
//
//
//
//        layout_share.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//
//                String text11=File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_name();
//                String text33=File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTravel_detail();
//                String ShareSub=text11+" "+text33+data11.getText().toString();
//
//
//
//                String uri = "http://maps.google.com/maps?saddr=" +File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getLatitude()+","+File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getLongitude();
//                String ShareSubS= ShareSub+"  "+uri;
//                Intent share = new Intent(Intent.ACTION_SEND);
//                share.setType("text/plain");
//                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
//                share.putExtra(Intent.EXTRA_SUBJECT, "data Share link!" );
//                share.putExtra(Intent.EXTRA_TEXT,ShareSubS);
//                startActivity(Intent.createChooser(share, "Share link!"));
//
//            }
//        });
//        gpsS.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                String destination = File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getLatitude()+","+File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getLongitude(); // กำหนดปลายทางแบบพิกัด Lat ,Lng
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+destination));
//                startActivity(intent);
//            }
//        });
//
//        layout_call.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + File_Confix_Data.getOutput_data_List.get(File_Confix_Data.position_id).getTelephone()));
//                startActivity(intent);
//            }
//        });
//    }


    @Override
    public void onDetach() {
        super.onDetach();

    }


}
