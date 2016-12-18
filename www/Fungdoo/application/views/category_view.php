<?php $this->load->view('header'); ?>
<!-- /. NAV SIDE  -->
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
             <h2>บันทึกข้อมูลหมวดหมู่</h2>   
                <h5>>>> หน้าบันทึก แก้ไข ลบ ข้อมูลหมวดหมู่ ... </h5>
                
            </div>
        </div>
    <!-- /. ROW  -->
    <hr/> 
    <!-- content ------------------------------------------------------------------------------- -->
    <div class="row">
        <div class="col-md-2 col-sm-2">
            
        </div>
        <div class="col-md-8 col-sm-8">
            <div class="panel panel-info" id="delay_edit">
                <div class="panel-heading">
                    บันทึก แก้ไข ข้อมูลหมวดหมู่
                </div>
                <div class="panel-body">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="collapsed" id="open_close_tab">เปิด / ปิด ฟอร์มบันทึกข้อมูลหมวดหมู่</a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" style="height: 0px;">
                                <div class="panel-body">
                                    <div class="col-md-3 col-sm-3" id="show_image">
                                        <img src="<?php echo base_url(); ?>assets/img/find_user.png" class="user-image img-responsive" style="width:128px;height: 128px;"/>
                                    </div>
                                    <div class="col-md-8 col-sm-8">
                                        <form role="form" action="<?php echo base_url(); ?>index.php/category/SaveCategory" method="POST" enctype="multipart/form-data" accept-charset="utf-8">
                                            <fieldset>
                                                <div class="form-group">
                                                    <label for="category_name">ชื่อหมวดหมู่ </label>
                                                    <input class="form-control" id="category_name" name="category_name" type="text" placeholder="ชื่อหมวดหมู่หมวดหมู่" />
                                                </div>
                                                <div class="form-group">
                                                    <label for="category_detail">รายละเอียด </label>
                                                    
                                                    <textarea class="form-control" rows="3" id="category_detail" name="category_detail" placeholder="รายละเอียดข้อมูลหมวดหมู่"></textarea>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <label>
                                                        อัพโหลดรูปภาพ
                                                    </label>
                                                    <input type="file" name="images[]"/>
                                                </div>
                                                <input type="hidden" name="category_id" id="category_id">
                                                <button type="submit" class="btn btn-primary" id="btn_save_form">บันทึกข้อมูล</button> &nbsp;
                                                <button type="reset" class="btn btn-warning" id="btn_cancel_form">ยกเลิก</button>
                                            </fieldset>
                                        </form>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <div class="panel-footer">
                    <span style="color:blue;">*กรุณากรอกข้อมูลให้ถูกต้อง ครบถ้วน</span>
                </div>
            </div>
        </div>
        <div class="col-md-2 col-sm-2">
            
        </div>
    </div>
    <!-- table ------------------------------------------------------------------------------------------- -->
                   
    <div class="row">
        <div class="col-md-12">
            <!-- Advanced Tables -->
            <div class="panel panel-default">
                <div class="panel-heading">
                     Advanced Tables
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>ชื่อหมวดหมู่ </th>
                                    <th>รายละเอียด</th>
                                    <th>รูปภาพ</th>
                                    <th>จัดการ</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php foreach($category as $row){ ?>
                                <tr>
                                    <td><?php echo $row->category_name; ?></td>
                                    <td><?php echo $row->category_detail; ?></td>
                                    <td><img src="<?php echo base_url(); ?>uploads/category/<?php echo $row->image_name; ?>" class="" style="width:50px;height: 50px;"/> </td>
                                    
                                    <td>
                                        <a onclick="edit_message(<?php echo $row->id; ?>)" style="cursor: pointer;">[แก้ไข]</a>    
                                        <a onclick="return confirm('Are you sure?')" href="<?php echo base_url(); ?>index.php/category/remove_category/<?php echo $row->id; ?>">[ลบ]</a>
                                    </td>
                                </tr>
                                <?php } ?>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
            <!--End Advanced Tables -->
        </div>
    </div>
    
    <!-- end table ------------------------------------------------------------------------------------------- -->
    
    
    <!-- end content ------------------------------------------------------------------------------- -->
    </div>
    <!-- /. PAGE INNER  -->
</div>

<script>
    $(document).ready(function () {
        $("#btn_cancel_form").click(function(){
            $("#btn_save_form").html("บันทึกข้อมูล");
            $("#category_id").val('');
            $("#show_image").html('');
            
        });
        $("#btn_save_form").click(function(e){
            if(check_form_data()){
                alert('Success');
            }else{
                e.preventDefault();
                alert('กรุณากรอกข้อมูลให้ครบทุกช่อง');
            }
        });

    });
    
    function check_form_data(){
        var check = true;
        if($.trim($("#category_name").val()) == ""){
            check = false;
        }
        if($.trim($("#category_detail").val()) == ""){
            check = false;
        }
        

        return check;
    }
    
    function edit_message(category_id){
        $("#delay_edit").hide(400);
        $("#delay_edit").show(400);
        $("#btn_save_form").html("อัพเดตข้อมูล");
        var open_close = $("#open_close_tab").attr('class');
        if(open_close == "collapsed"){
            $("#open_close_tab").click();
        }
        
        $.ajax({
            type:"POST",
            url:"<?php echo base_url(); ?>index.php/category/getDataEditCategory",
            data:{ category_id:category_id },
            dataType: 'json',
            success:function(result){
                $("#category_name").val(result[0]['category_name']);
                $("#category_detail").val(result[0]['category_detail']);
                
                $("#show_image").html("<img src=\"<?php echo base_url(); ?>uploads/category/" + result[0]['image_name'] + "\" class=\"user-image img-responsive\" style=\"width:128px;height: 128px;\"/>");
                
                
                $("#category_id").val(result[0]['id']);
                
                
            }
        }); 
        
    }
</script>
<?php $this->load->view('footer'); ?>         
