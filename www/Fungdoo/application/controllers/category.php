<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class category extends CI_Controller {
    function __construct()
    {
        parent::__construct();
        $this->load->model('m_category');
    }
    public function index()
    {
        if(!$this->session->userdata('logged_in')){
            redirect('login','refresh');
            exit;
        }
        $data['category'] = $this->m_category->getDataCategory();
        $this->load->view('category_view',$data);
    }
    
    public function SaveCategory(){
        if(!$this->session->userdata('logged_in')){
            redirect('login','refresh');
            exit;
        }
        $category_name = $this->input->post('category_name');
        $category_detail = $this->input->post('category_detail');
        
        $image_name = '';
        //----------------------------------------------------------
        if (!empty($_FILES['images']['name'][0])) {
            $image_name = $this->upload_files($_FILES['images']);
        }
        //----------------------------------------------------------
        if(!$this->input->post('category_id')){
            $data = array(
                "category_name" => $category_name,
                "category_detail" => $category_detail,
                
                "image_name" => $image_name
                
            );

            $this->m_category->SaveCategoryDB($data);
        }else{
            if($image_name == ''){
                $data = array(
                    "category_name" => $category_name,
                    "category_detail" => $category_detail
                   
                );
            }else{
                $data = array(
                    "category_name" => $category_name,
                    "category_detail" => $category_detail,
                    
                    "image_name" => $image_name
                    
                );
            }
            $this->m_category->UpdateCategoryDB($data, $this->input->post('category_id'));
        }
        $this->session->set_flashdata('result_save', 'บันทึกข้อมูลเรียบร้อยแล้ว');
        redirect('category','refresh');
    }
    
    public function upload_files($files){
        $name_image = '';
        $config = array(
            'upload_path'   => './uploads/category',
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
    
    
    public function remove_category($category_id){
        $this->m_category->remove_categoryDB($category_id);
        redirect('category','refresh');
    }
    public function getDataEditCategory(){
        $category_id = $this->input->post('category_id');
        $result = $this->m_category->getDataEditCategoryDB($category_id);
        echo json_encode($result);
    }
}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */