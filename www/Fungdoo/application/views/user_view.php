<?php $this->load->view('header'); ?>
<!-- /. NAV SIDE  -->
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
             <h2>บันทึกข้อมูลลูกค้า</h2>   
                <h5>>>> หน้าบันทึก แก้ไข ลบ ข้อมูลลูกค้า ... </h5>
                
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
                    บันทึก แก้ไข ข้อมูลลูกค้า
                </div>
                <div class="panel-body">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="collapsed" id="open_close_tab">เปิด / ปิด ฟอร์มบันทึกข้อมูลลูกค้า</a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" style="height: 0px;">
                                <div class="panel-body">
                                    <div class="col-md-3 col-sm-3" id="show_image">
                                        <img src="<?php echo base_url(); ?>assets/img/find_user.png" class="user-image img-responsive" style="width:128px;height: 128px;"/>
                                    </div>
                                    <div class="col-md-8 col-sm-8">
                                        <form role="form" action="<?php echo base_url(); ?>index.php/user/SaveUser" method="POST" enctype="multipart/form-data" accept-charset="utf-8">
                                            <fieldset>
												<!--
                                                <div class="form-group">
                                                    <label for="restaurant_id">ชื่อร้านอาหาร</label>
                                                    <select name="restaurant_id" id="restaurant_id" class="form-control">
                                                        <option value="">กรุณาเลือกร้านอาหาร</option>
                                                        <?php foreach($restaurant as $row){ ?>
                                                        <option value="<?php echo $row->id; ?>"><?php echo $row->restaurant_name; ?></option>
                                                        <?php } ?>
                                                    </select>
                                                </div>
												
                                                <div class="form-group">
                                                    <label for="user_number">รหัสลูกค้า</label>
                                                    <input class="form-control" id="employeeID" name="employeeID" type="text" placeholder="รหัสสมาชิก" />
                                                </div>
												-->
												 <div class="form-group">
                                                    <label for="promotion_detail">ชื่อผู้ใช้งาน</label>
                                                    
													<input class="form-control" id="username" name="username" type="text" placeholder="username" />
                                                </div>
												 <div class="form-group">
                                                    <label for="promotion_detail"> รหัสผ่าน</label>
													<input class="form-control" id="password" name="password" type="text" placeholder="password" />
                                                <!--
												</div>
												    <div class="form-group">
                                                    <label for="promotion_detail"> คำนำหน้าชื่อ</label>
                                                    
													<input class="form-control" id="name_title" name="name_title" type="text" placeholder="คำนำหน้าชื่อ" />
                                                </div>
												-->
												
                                                <div class="form-group">
                                                    <label for="promotion_detail">ชื่อ-นามสุกุล</label>
                                                    
													<input class="form-control" id="full_name" name="full_name" type="text" placeholder="ชื่อ-นามสุกุล" />
                                                </div>
												
												
												 <div class="form-group">
                                                    <label for="date_start">รหัสประจำตัวประชาชน</label>
                                                    <input class="form-control" id="identityid" name="identityid" type="number" placeholder="รหัสประจำตัวประชาชน" />
                                                </div>
												
												
												
                                                <div class="form-group">
												 
                                                    <label for="promotion_detail">ที่อยู่</label>
                                                    <textarea class="form-control" rows="3" id="address" name="address" placeholder="ที่อยู่"></textarea>
                                                </div>
												<div class="form-group">
                                                    <label for="date_start">เบอร์โทร</label>
                                                    <input class="form-control" id="tel" name="tel" type="number" placeholder="เบอร์โทร" />
                                                </div>
												  <div class="form-group">
                                                    <label for="promotion_detail"> อีเมลล์</label>
                                                    
													<input class="form-control" id="email" name="email" type="text" placeholder="อีเมลล์" />
                                                </div>
												  <div class="form-group">
                                                    <label for="promotion_detail"> เพศ</label>
                                                    
													<input class="form-control" id="sex" name="sex" type="text" placeholder="เพศ" />
                                                </div>
												 <!--
												 <div class="form-group">
                                                    <label for="promotion_detail">  ตำแหน่งลูกค้า</label>
                                                    
													<input class="form-control" id="emp_division" name="emp_division" type="text" placeholder="ตำแหน่งลูกค้า" />
                                                </div>
												 <div class="form-group">
                                                    <label for="promotion_detail">  สถานะของลูกค้า</label>
                                                    
													<input class="form-control" id="emp_status" name="emp_status" type="text" placeholder="สถานะของลูกค้า" />
                                                </div>
									 -->
                                                <div class="form-group">
                                                    <label>
															อัพโหลดรูปภาพ
                                                    </label>
                                                    <input type="file" name="images[]"/>
                                                </div>
                                                <input type="hidden" name="user_id" id="user_id">
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
                                    <!--<th>รหัสลูกค้า</th> -->
									<th>ชื่อผู้ใช้งาน</th>
									<th>รหัสผ่าน</th>
										<!--<th>คำนำหน้าชื่อ</th>-->
                                    <th>ชื่อ-นามสุกุล</th>
									<th>เพศ</th>
									<th>รหัสประจำตัวประชาชน</th>
                                    <th>ที่อยู่</th>
									<th>เบอร์โทร</th>
									<th>อีเมลล์</th>
									
									<!--<th>ตำแหน่งลูกค้า</th>
									<th>สถานะของลูกค้า</th> -->
                                    <th>รูปภาพ</th>
                                    <th>จัดการ</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <?php foreach($user as $row){ ?>
                                <tr>
                                  
                                    <td><?php echo $row->username; ?></td>
                                    <td><?php echo $row->password; ?></td>
                              
                                    <td><?php echo $row->full_name; ?></td>
									 <td><?php echo $row->sex; ?></td>
									 <td><?php echo $row->identityid; ?></td>
									 <td><?php echo $row->address; ?></td>
									 <td><?php echo $row->tel; ?></td>
									 <td><?php echo $row->email; ?></td>
								    
									 
                                    <td><img src="<?php echo base_url(); ?>uploads/user/<?php echo $row->image_name; ?>" class="" style="width:50px;height: 50px;"/> </td>
                                    
                                    <td>
                                        <a onclick="edit_message(<?php echo $row->id; ?>)" style="cursor: pointer;">[แก้ไข]</a>    
                                        <a onclick="return confirm('Are you sure?')" href="<?php echo base_url(); ?>index.php/user/remove_user/<?php echo $row->id; ?>">[ลบ]</a>
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
            $("#promotion_id").val('');
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
    
        if($.trim($("#username").val()) == ""){
            check = false;
        }
        if($.trim($("#password").val()) == ""){
            check = false;
        }
   
        if($.trim($("#full_name").val()) == ""){
            check = false;
        }
	 
		if($.trim($("#address").val()) == ""){
            check = false;
        }
	 
	 
 
        return check;
    }
    
    function edit_message(user_id){
        $("#delay_edit").hide(400);
        $("#delay_edit").show(400);
        $("#btn_save_form").html("อัพเดตข้อมูล");
        var open_close = $("#open_close_tab").attr('class');
        if(open_close == "collapsed"){
            $("#open_close_tab").click();
        }
        
        $.ajax({
            type:"POST",
            url:"<?php echo base_url(); ?>index.php/user/getDataEditUser",
            data:{ user_id:user_id },
            dataType: 'json',
            success:function(result){
                $("#employeeID").val(result[0]['employeeID']);
                $("#username").val(result[0]['username']);
                $("#name_title").val(result[0]['name_title']);
                $("#full_name").val(result[0]['full_name']);
                $("#identityid").val(result[0]['identityid']);
               $("#address").val(result[0]['address']);
				$("#tel").val(result[0]['tel']);
				$("#email").val(result[0]['email']);
				$("#sex").val(result[0]['sex']);
				$("#emp_division").val(result[0]['emp_division']);
				$("#emp_status").val(result[0]['emp_status']);
                $("#show_image").html("<img src=\"<?php echo base_url(); ?>uploads/user/" + result[0]['image_name'] + "\" class=\"user-image img-responsive\" style=\"width:128px;height: 128px;\"/>");
                
                
                $("#user_id").val(result[0]['id']);
                
                
            }
        }); 
        
    }
</script>
<?php $this->load->view('footer'); ?>         
