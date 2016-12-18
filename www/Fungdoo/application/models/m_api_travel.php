<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of m_APICoursesStudent
 *
 * @author Chaowalit kongkom
 */
class m_api_travel extends CI_Model{
    //put your code here
    function getDataSearchAlltravel(){
        $this->db->select('travel.*,category.*,travel.id as travel_id');
        $this->db->from('travel');
        $this->db->join('category', 'category.id = travel.category_id');
        
        $result = $this->db->get();
        return $result->result();
    }
    function getDataSearchImage($travel_id){
        $this->db->select('*');
        $this->db->from('image_travel');
        
        $this->db->where('travel_id', $travel_id);
        
        $result = $this->db->get();
        return $result->result();
    }
    function getCategory(){
        $this->db->select('*');
        $this->db->from('category');
        
        $result = $this->db->get();
        return $result->result();
    }
    function getPromotion(){
        $this->db->select('promotion.*,travel.*,promotion.id as promotion_id');
        $this->db->from('promotion');
        $this->db->join('travel', 'travel.id = promotion.travel_id');
        $this->db->where('date_end >=', date("Y-m-d"));
        $result = $this->db->get();
        return $result->result();
    }
    function AddCommenttravelDB($data){
        $this->db->insert('comment_travel', $data); 
    }
    function GetCommenttravelDB($travel_id){
        $this->db->select('*');
        $this->db->from('comment_travel');
        $this->db->where('travel_id', $travel_id);
        $this->db->order_by("id","desc");
        $this->db->limit(200);
        $result = $this->db->get();
        return $result->result();
    }
}
