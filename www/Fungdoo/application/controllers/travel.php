<?php

class travel extends CI_Controller {
    //put your code here
    public $data = array();
    function __construct()
    {
        parent::__construct();
        $this->load->helper('url'); //You should autoload this one ;)
        $this->load->helper('ckeditor');

        //Ckeditor's configuration
        $this->data['ckeditor'] = array(

                //ID of the textarea that will be replaced
                'id' 	=> 	'content',
                'path'	=>	'js/ckeditor',

                //Optionnal values
                'config' => array(
                        'toolbar' 	=> 	"Full", 	//Using the Full toolbar
                        'width' 	=> 	"550px",	//Setting a custom width
                        'height' 	=> 	'100px',	//Setting a custom height

                ),

                //Replacing styles from the "Styles tool"
                'styles' => array(

                        //Creating a new style named "style 1"
                        'style 1' => array (
                                'name' 		=> 	'Blue Title',
                                'element' 	=> 	'h2',
                                'styles' => array(
                                        'color' 	=> 	'Blue',
                                        'font-weight' 	=> 	'bold'
                                )
                        ),

                        //Creating a new style named "style 2"
                        'style 2' => array (
                                'name' 	=> 	'Red Title',
                                'element' 	=> 	'h2',
                                'styles' => array(
                                        'color' 		=> 	'Red',
                                        'font-weight' 		=> 	'bold',
                                        'text-decoration'	=> 	'underline'
                                )
                        )				
                )
        );
        
        $this->load->library('ckeditor');
        $this->load->library('ckfinder');
        $this->ckeditor->basePath = base_url().'asset/ckeditor/';
        $this->ckeditor->config['toolbar'] = array(
                                                array( 'Bold', 'Italic', 'Underline', 'Strike'),
                                                array('JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'),
                                                array('Format'),
                                                array( 'Font', 'FontSize', 'FontColor', 'TextColor'),
                                                array('Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord' ),
                                                array('Image', 'Table', 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', 'Blockquote'),
                                                array('Subscript','Superscript'),
                                                array( 'Link', 'Unlink' ),
                                                array('Source')
                                            );
        
        $this->ckeditor->config['language'] = 'en';
        $this->ckeditor->config['width'] = '500px';
        $this->ckeditor->config['height'] = '300px';            

        //Add Ckfinder to Ckeditor
        $this->ckfinder->SetupCKEditor($this->ckeditor,'../../asset/ckfinder/');
        
        $this->load->model('m_travel');
    }
    public function index()
    {
        
        
        
        if($this->session->userdata('logged_in')){
            $this->data['travel'] = $this->m_travel->getDatatravel();
            $this->data['category'] = $this->m_travel->getDataCategory();
			$this->data['province'] = $this->m_travel->getProvince();
            $this->load->view('travel_view',$this->data);
        }else{
            $this->load->view('login_view');
        }
    }
    
    public function Savetravel(){
        if(!$this->session->userdata('logged_in')){
            redirect('login','refresh');
            exit;
        }
        $category_id = $this->input->post('category_id');
        $travel_name = $this->input->post('travel_name');
        $travel_detail = $this->input->post('travel_detail');
        $travel_address = $this->input->post('travel_address');
        $travel_menu = $this->input->post('travel_menu');
        $latitude = $this->input->post('latitude');
        $longitude = $this->input->post('longitude');
        $telephone = $this->input->post('telephone');
        $url_share = $this->input->post('url_share');
        
        
        if(!$this->input->post('travel_id')){
            $data = array(
                
                "category_id" => $category_id,
				"province_id" => $this->input->post('province_id'),
                "travel_name" => $travel_name,
                "travel_detail" => $travel_detail,
                "travel_address" => $travel_address,
                "travel_menu" => $travel_menu,
                "latitude" => $latitude,
                "longitude" => $longitude,
                "telephone" => $telephone,
				"url_share" => $url_share,
                "active" => 1,
                "date" => date("Y-m-d")
            );

            $travel_id = $this->m_travel->SavetravelDB($data);
            //----------------------------------------------------------
            if (!empty($_FILES['images']['name'][0])) {
			
                $this->upload_files($_FILES['images'], $travel_id);
            }
            //----------------------------------------------------------
            
        }else{
            $data = array(
                
                "category_id" => $category_id,
				"province_id" => $this->input->post('province_id'),
                "travel_name" => $travel_name,
                "travel_detail" => $travel_detail,
                "travel_address" => $travel_address,
                "travel_menu" => $travel_menu,
                "latitude" => $latitude,
                "longitude" => $longitude,
                "telephone" => $telephone,
				"url_share" => $url_share,
                "active" => 1,
                "date" => date("Y-m-d")
            );
            
            $this->m_travel->UpdatetravelDB($data, $this->input->post('travel_id'));
            //----------------------------------------------------------
            if (!empty($_FILES['images']['name'][0])) {
                $this->upload_files($_FILES['images'], $this->input->post('travel_id'));
            }
            //----------------------------------------------------------
            
        }
        $this->session->set_flashdata('result_save', 'บันทึกข้อมูลเรียบร้อยแล้ว');
        $this->index();
    }
    
    public function upload_files($files , $travel_id){
        
        $config = array(
            'upload_path'   => 'uploads/travel',
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
                $this->m_travel->saveImageUpload($name_image, $travel_id);
            } else {
				var_dump($this->upload->display_errors());exit;
                //return false;
            }
        }

    }
    public function remove_travel($travel_id){
        $this->m_travel->remove_travelDB($travel_id);
        $this->index();
    }
    public function getDataEdittravel($travel_id){
        //$travel_id = $this->input->post('travel_id');
        $result = $this->m_travel->getDataEdittravelDB($travel_id);
        //echo json_encode($result);
        $this->data['travel_edit'] = $result;
        $this->data['travel'] = $this->m_travel->getDatatravel();
        $this->data['category'] = $this->m_travel->getDataCategory();
		$this->data['province'] = $this->m_travel->getProvince();
        $this->load->view('travel_view',$this->data);
    }
    public function list_image_show($travel_id){
        $data['image'] = $this->m_travel->getDataImageProduct($travel_id);
        $this->load->view('list_image_show',$data);
    }
    public function removeImage(){
        $id = $this->input->post('id');
        $this->m_travel->removeImageDB($id);
    }
}
