<?php
date_default_timezone_set("Asia/Bangkok");

class APItravel  extends CI_Controller{
    //put your code here
    function __construct()
    {
        parent::__construct();
        
        $this->load->model('m_api_travel');
    }
    public function index(){
        $result = $this->m_api_travel->getDataSearchAlltravel();
        $return_data = array();
        
        foreach($result as $row){
            $array_push['travel_id'] = $row->travel_id;
            $array_push['category_id'] = $row->category_id;
            $array_push['category_name'] = $row->category_name;
            $array_push['travel_name'] = $row->travel_name;
            $array_push['travel_detail'] = $row->travel_detail;
            $array_push['travel_address'] = $row->travel_address;
            $array_push['travel_menu'] = $row->travel_menu;
	    $array_push['url_share'] = $row->url_share;
            $array_push['latitude'] = $row->latitude;
            $array_push['longitude'] = $row->longitude;
            $array_push['telephone'] = $row->telephone;
            $array_push['date'] = $row->date;
            $array_image = array();
            $result2 = $this->m_api_travel->getDataSearchImage($row->travel_id);
            foreach($result2 as $row2){
                $temp = base_url()."uploads/travel/".$row2->image_name;
                array_push($array_image,$temp);
            }
            $array_push['image_product'] = $array_image;
            array_push($return_data, $array_push);
        }
        $output = array('output' => $return_data,'status' => true);
        echo json_encode($output);
    }
    public function getDataSearchCategory(){
        $category = $this->m_api_travel->getCategory();
        $return_data = array();
        foreach($category as $row){
            $array_push['category_id'] = $row->id;
            $array_push['category_name'] = $row->category_name;
            $array_push['category_detail'] = $row->category_detail;
            $array_push['category_icon'] = base_url()."uploads/category/".$row->image_name;
            
            array_push($return_data, $array_push);
        }
        $output = array('output' => $return_data,'status' => true);
        echo json_encode($output);
    }
    public function getDataSearchPromotion(){
        $category = $this->m_api_travel->getPromotion();
        $return_data = array();
        foreach($category as $row){
            $array_push['promotion_id'] = $row->promotion_id;
            $array_push['travel_id'] = $row->travel_id;
            $array_push['travel_name'] = $row->travel_name;
            $array_push['promotion_name'] = $row->promotion_name;
            $array_push['promotion_detail'] = $row->promotion_detail;
            $array_push['date_start'] = $row->date_start;
            $array_push['date_end'] = $row->date_end;
            
            $array_push['promotion_icon'] = base_url()."uploads/promotion/".$row->image_name;
            
            array_push($return_data, $array_push);
        }
        $output = array('output' => $return_data,'status' => true);
        echo json_encode($output);
    }
    public function AddCommenttravel(){
        $travel_id = $_GET['travel_id'];
        $user_comment = $_GET['user_comment'];
        $comment_detail = $_GET['comment_detail'];
        $created = date("Y-m-d H:i:s");

        $data = array(
            "travel_id" => $travel_id,
            "user_comment" => $user_comment,
            "comment_detail" => $comment_detail,
            "created" => $created
        );
        $this->m_api_travel->AddCommenttravelDB($data);
        
        $return_data = array(
            "travel_id" => $travel_id,
            "user_comment" => $user_comment,
            "comment_detail" => $comment_detail,
            "created" => $created,
            "status" => 1
        );
        
        $output = array('output' => $return_data,'status' => true);
        echo json_encode($output);
    }
    public function GetCommenttravel(){
        $travel_id = $_GET['travel_id'];
        
        $result = $this->m_api_travel->GetCommenttravelDB($travel_id);
        $return_data = array();
        
        foreach($result as $row){
            $array_push['travel_id'] = $row->travel_id;
            $array_push['user_comment'] = $row->user_comment;
            $array_push['comment_detail'] = $row->comment_detail;
            $array_push['created'] = $row->created;
            
            array_push($return_data, $array_push);
        }
        $output = array('output' => $return_data,'status' => true);
        echo json_encode($output);
        
    }
}
