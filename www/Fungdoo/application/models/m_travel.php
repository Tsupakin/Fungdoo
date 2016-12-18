<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of m_teacher
 *
 * @author Chaowalit kongkom
 */
class m_travel extends CI_Model{
    //put your code here
    function SavetravelDB($data){
        
        $this->db->trans_start();
        $this->db->insert('travel', $data);
        $insert_id = $this->db->insert_id();
        $this->db->trans_complete();
        return  $insert_id;
    }
    function getDatatravel(){
        $this->db->select('travel.*,category.*,travel.id as travel_id');
        $this->db->from('travel');
        $this->db->join('category', 'category.id = travel.category_id');
        
        $result = $this->db->get();
        return $result->result();
    }
    function getDataCategory(){
        $this->db->select('*');
        $this->db->from('category');
        
        
        $result = $this->db->get();
        return $result->result();
    }
    
    function saveImageUpload($name_image, $product_id){
        $data = array(
            "travel_id" => $product_id,
            "image_name" => $name_image,
            "date" => date("Y-m-d")
        );
        $this->db->insert('image_travel', $data);
    }
    
    function remove_travelDB($travel_id){
        $this->db->where('id', $travel_id);
        $this->db->delete('travel'); 
    }
    function getDataEdittravelDB($travel_id){
        $this->db->select('*');
        $this->db->from('travel');
        $this->db->where('id', $travel_id);
        $result = $this->db->get();
        return $result->result_array();
    }
    function UpdatetravelDB($data, $product_id){
        $this->db->where('id', $product_id);
        $this->db->update('travel', $data); 
    }
    function getDataImageProduct($travel_id){
        $this->db->select('*');
        $this->db->from('image_travel');
        $this->db->where('travel_id',$travel_id);
        $result = $this->db->get();
        return $result->result();
    }
    function removeImageDB($id){
        $this->db->where('id', $id);
        $this->db->delete('image_travel'); 
    }
	function getProvince(){
		$this->db->select('*');
        $this->db->from('province');
        
        $result = $this->db->get();
        return $result->result();
	}
}
