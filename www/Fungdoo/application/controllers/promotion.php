<?php


class promotion  extends CI_Controller{
    //put your code here
    function __construct()
    {
        parent::__construct();
        $this->load->model('m_promotion');
    }
    public function index(){
        $data['restaurant'] = $this->m_promotion->getRestaurant();
        $data['promotion'] = $this->m_promotion->getPromotion();
        $this->load->view('promotion_view', $data);
    }
    public function SavePromotion(){
        if(!$this->session->userdata('logged_in')){
            redirect('login','refresh');
            exit;
        }
        $restaurant_id = $this->input->post('restaurant_id');
        $promotion_name = $this->input->post('promotion_name');
        $promotion_detail = $this->input->post('promotion_detail');
        $date_start = $this->input->post('date_start');
        $date_end = $this->input->post('date_end');
        
        
        $image_name = '';
        //----------------------------------------------------------
        if (!empty($_FILES['images']['name'][0])) {
            $image_name = $this->upload_files($_FILES['images']);
        }
        //----------------------------------------------------------
        if(!$this->input->post('promotion_id')){
            $data = array(
                "restaurant_id" => $restaurant_id,
                "promotion_name" => $promotion_name,
                "promotion_detail" => $promotion_detail,
                "date_start" => $date_start,
                "date_end" => $date_end,
                
                "image_name" => $image_name
                
            );

            $this->m_promotion->SavePromotionDB($data);
        }else{
            if($image_name == ''){
                $data = array(
                    "restaurant_id" => $restaurant_id,
                    "promotion_name" => $promotion_name,
                    "promotion_detail" => $promotion_detail,
                    "date_start" => $date_start,
                    "date_end" => $date_end,
                   
                );
            }else{
                $data = array(
                    "restaurant_id" => $restaurant_id,
                    "promotion_name" => $promotion_name,
                    "promotion_detail" => $promotion_detail,
                    "date_start" => $date_start,
                    "date_end" => $date_end,
                    
                    "image_name" => $image_name
                    
                );
            }
            $this->m_promotion->UpdatePromotionDB($data, $this->input->post('promotion_id'));
        }
        $this->session->set_flashdata('result_save', 'บันทึกข้อมูลเรียบร้อยแล้ว');
        redirect('promotion','refresh');
    }
    
    public function upload_files($files){
        $name_image = '';
        $config = array(
            'upload_path'   => './uploads/promotion',
            'allowed_types' => 'jpg|gif|png',
            'overwrite'     => FALSE,
            'max_size'	=> '3000',
            'max_width' => '1024',
            'max_height' => '1024'
        );

        $this->load->library('upload', $config);

        $images = array();

        foreach ($files['name'] as $key => $image) {
            $_FILES['images[]']['name']= $files['name'][$key];
            $_FILES['images[]']['type']= $files['type'][$key];
            $_FILES['images[]']['tmp_name']= $files['tmp_name'][$key];
            $_FILES['images[]']['error']= $files['error'][$key];
            $_FILES['images[]']['size']= $files['size'][$key];

            $fileName = '_'. $image;

            $images[] = $fileName;

            $config['file_name'] = $fileName;

            $this->upload->initialize($config);

            if ($this->upload->do_upload('images[]')) {
                $upload_data = $this->upload->data();
                $name_image = $upload_data['file_name'];
                
            } else {
                //return false;
            }
        }

        return $name_image;
    }
    
    public function remove_promotion($id){
        $this->m_promotion->remove_promotionDB($id);
        redirect('promotion','refresh');
    }
    public function getDataEditPromotion(){
        $promotion_id = $this->input->post('promotion_id');
        $result = $this->m_promotion->getDataEditPromotionDB($promotion_id);
        echo json_encode($result);
    }
}
