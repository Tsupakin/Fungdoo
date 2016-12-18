package com.fungdoo.project.fungdoo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by poliveira on 11/03/2015.
 */
public class Listdata_Vacin extends Fragment {

    public static final String TAG = "stats";
    Spinner spinner1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment



         View v = inflater.inflate(R.layout.search_data, container, false);
        spinner1 = (Spinner) v.findViewById(R.id.spin1);
        List<String> list1 = new ArrayList<String>();
        list1.add("สุนัข");
        list1.add("แมว");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);


//        data11 = (TextView) v.findViewById(R.id.data11);


        Button btnSubmit = (Button) v.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                File_Confix_Data.titel= String.valueOf(spinner1.getSelectedItem());
                if( String.valueOf(spinner1.getSelectedItem()).equals("สุนัข")){
                    File_Confix_Data.string_id_cat="10";

                }else{
                    File_Confix_Data.string_id_cat="11";

                }


                Intent i = new Intent(getActivity(), MainactivityMain2.class);
                startActivity(i);
            }
        });

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

}
