<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of m_student
 *
 * @author Chaowalit kongkom
 */
class m_category extends CI_Model{
    //put your code here
    function SaveCategoryDB($data){
        $this->db->insert('category', $data); 
    }
    function getDataCategory(){
        $this->db->select('*');
        $this->db->from('category');
        
        $result = $this->db->get();
        return $result->result();
    }
    function remove_categoryDB($category_id){
        $this->db->where('id', $category_id);
        $this->db->delete('category'); 
    }
    function getDataEditCategoryDB($category_id){
        $this->db->select('*');
        $this->db->from('category');
        $this->db->where('id', $category_id);
        $result = $this->db->get();
        return $result->result_array();
    }
    function UpdateCategoryDB($data, $category_id){
        $this->db->where('id', $category_id);
        $this->db->update('category', $data); 
    }
}
