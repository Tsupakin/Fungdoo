<?php


class user  extends CI_Controller{
    //put your code here
    function __construct()
    {
        parent::__construct();
        $this->load->model('m_login');
    }
    public function index(){
        //$data['restaurant'] = $this->m_promotion->getRestaurant();
       $data['user'] = $this->m_login->getUserAll();
        $this->load->view('user_view', $data);
    }
    public function SaveUser(){
        if(!$this->session->userdata('logged_in')){
            redirect('login','refresh');
            exit;
        }
        
        $image_name = '';
        //----------------------------------------------------------
        if (!empty($_FILES['images']['name'][0])) {
            $image_name = $this->upload_files($_FILES['images']);
        }
        //----------------------------------------------------------
        if(!$this->input->post('user_id')){
            $data = array(
                "employeeID" => $this->input->post('employeeID'),
                "username" => $this->input->post('username'),
                "password" => $this->input->post('password'),
                "name_title" => $this->input->post('name_title'),
                "full_name" => $this->input->post('full_name'),
				"identityid" => $this->input->post('identityid'),
				"address" => $this->input->post('address'),
				"tel" => $this->input->post('tel'),
				"email" => $this->input->post('email'),
				"sex" => $this->input->post('sex'),
				"emp_division" => $this->input->post('emp_division'),
				"emp_status" => $this->input->post('emp_status'),
				
                
                "image_name" => $image_name
                
            );

            $this->db->insert('user', $data);
        }else{
            if($image_name == ''){
                $data = array(
                   "employeeID" => $this->input->post('employeeID'),
                "username" => $this->input->post('username'),
                "password" => $this->input->post('password'),
                "name_title" => $this->input->post('name_title'),
                "full_name" => $this->input->post('full_name'),
				"identityid" => $this->input->post('identityid'),
				"address" => $this->input->post('address'),
				"tel" => $this->input->post('tel'),
				"email" => $this->input->post('email'),
				"sex" => $this->input->post('sex'),
				"emp_division" => $this->input->post('emp_division'),
				"emp_status" => $this->input->post('emp_status'),
                   
                );
            }else{
                $data = array(
                   "employeeID" => $this->input->post('employeeID'),
                "username" => $this->input->post('username'),
                "password" => $this->input->post('password'),
                "name_title" => $this->input->post('name_title'),
                "full_name" => $this->input->post('full_name'),
				"identityid" => $this->input->post('identityid'),
				"address" => $this->input->post('address'),
				"tel" => $this->input->post('tel'),
				"email" => $this->input->post('email'),
				"sex" => $this->input->post('sex'),
				"emp_division" => $this->input->post('emp_division'),
				"emp_status" => $this->input->post('emp_status'),
					
                    
                    "image_name" => $image_name
                    
                );
            }
			$this->db->where('id', $this->input->post('user_id'));
			$this->db->update('user', $data); 
            
        }
        $this->session->set_flashdata('result_save', 'บันทึกข้อมูลเรียบร้อยแล้ว');
        redirect('user','refresh');
    }
    
    public function upload_files($files){
        $name_image = '';
        $config = array(
            'upload_path'   => './uploads/user',
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
    
    public function remove_user($id){
        $this->db->where('id', $id);
		$this->db->delete('user'); 
        redirect('user','refresh');
    }
    public function getDataEditUser(){
        $user_id = $this->input->post('user_id');

		$this->db->select('*');
        $this->db->from('user');
        $this->db->where('id', $user_id);
        $result = $this->db->get();
        $temp = $result->result_array();
		
        //$result = $this->m_promotion->getDataEditPromotionDB($promotion_id);
        echo json_encode($temp);
    }
}
