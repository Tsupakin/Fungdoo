<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of m_login
 *
 * @author Chaowalit kongkom
 */
class m_login extends CI_Model{
    //put your code here
    function registerUserDB($data_user){
        $this->db->insert('register', $data_user); 
    }
    function verify_userDB($username, $password){
        $this->db->select('*');
        $this->db->from('register');
        $this->db->where('reg_username', $username);
        $this->db->where('reg_pass', $password);
        $result = $this->db->get();
        return $result->result_array();
    }
    public function getDataUser($reg_id){
        $this->db->select('*');
        $this->db->from('register');
        $this->db->where('id', $reg_id);
        
        $result = $this->db->get();
        return $result->result_array();
    }
    function update_register_userDB($data_user, $reg_id){
        $this->db->where('id', $reg_id);
        $this->db->update('register', $data_user); 
    }
		function getUserAll(){
		$this->db->select('*');
        $this->db->from('user');
  
        $this->db->order_by('id', 'desc');
        $result = $this->db->get();
        return $result->result();
	}
}
