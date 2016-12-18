<?php

class product_approve extends CI_Controller{
    //put your code here
    function __construct()
    {
        parent::__construct();
        $this->load->model('m_product_approve');
    }
    public function index(){
        $data['all_product'] = $this->m_product_approve->getDataAllProduct();
        
        $this->load->view('product_approve_view',$data);
    }
    public function approve_message(){
        $product_id = $this->input->post('product_id');
        $data = array(
            "approve" => 1
        );
        $this->m_product_approve->approve_messageDB($data, $product_id);
        
        
    }
    public function wait_message(){
        $product_id = $this->input->post('product_id');
        $data = array(
            "approve" => 0
        );
        $this->m_product_approve->approve_messageDB($data, $product_id);
        
        
    }
}
