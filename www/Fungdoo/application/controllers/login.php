<?php

class login extends CI_Controller {
    //put your code here
    function __construct()
    {
        parent::__construct();
        $this->load->model('m_login');
    }
    public function index()
    {
        if($this->session->userdata('logged_in')){
            redirect('travel','refresh');
        }else{
            $this->load->view('login_view');
        }
    }
    public function doing_login(){
        $username = $this->input->post('username');
        $password = $this->input->post('password');
        
        if($username == "admin" && $password == "123456"){
            $newdata = array(
                   'username'  => 'admin',
                   'logged_in' => TRUE
            );
            $this->session->set_userdata($newdata);
            redirect('travel','refresh');
        }else{
            $data['error'] = "ชื่อผู้ใช้งาน หรือ รหัสผ่านไม่ถูกต้อง";
            $this->load->view('login_view',$data);
        }
    }
    
    public function logout(){
        $this->session->unset_userdata('username');
        $this->session->unset_userdata('logged_in');
        
        redirect('','refresh');
    }
}
