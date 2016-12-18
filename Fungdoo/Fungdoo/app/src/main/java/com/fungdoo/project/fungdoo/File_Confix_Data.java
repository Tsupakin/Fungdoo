package com.fungdoo.project.fungdoo;

import org.json.JSONArray;

import java.util.List;

public final class File_Confix_Data {

 	public static List<List_data.OutputBean> getOutput_data_List;
 	public static List<List_data.OutputBean> getOutput_data_Category;
    public static List<List_User.OutputBean> data_list_user;
	public static List<List_comment.OutputBean> List_comment;

	public static List<List_Category.OutputBean> data_Category;

	public static List<Check_Booking.OutputBean> getOutput_data_ListCheck_Booking;

	public static List<List_data_filter.OutputBean> getOutput_data_List_filter;
	public static String string_id_cat="";
	public static String string_id_data="";
	public static String titel="";
	public static  int position_id=0;

	public static  int position_id_regist=0;


	public static double latitude=0.0;
	public static double longitude=0.0;



	public static JSONArray sor_;

	public static String select_type_sex[] ;


	public static class Config {
		public static final boolean DEVELOPER_MODE = false;
	}

	public static class Extra {
		public static final String IMAGES = "IMAGES";
		public static final String IMAGE_POSITION = "IMAGE_POSITION";
	} 
	
}
 