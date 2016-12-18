<?php $this->load->view('header'); ?>
<!-- /. NAV SIDE  -->
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
             <h2>บันทึกข้อมูลเพลง</h2>   
                <h5>>>> หน้าบันทึก แก้ไข ลบ ข้อมูลเพลง ... </h5>
                
            </div>
        </div>
    <!-- /. ROW  -->
    <hr/> 
    <!-- content ------------------------------------------------------------------------------- -->
    <div class="row">
        <div class="col-md-1 col-sm-1">
            
        </div>
        <div class="col-md-10 col-sm-10">
            <div class="panel panel-info" id="delay_edit">
                <div class="panel-heading">
                    บันทึก แก้ไข ข้อมูลเพลง
                </div>
                <div class="panel-body">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="collapsed" id="open_close_tab">เปิด / ปิด ฟอร์มข้อมูลเพลง</a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" style="height: 0px;">
                                <div class="panel-body">
                                    <div class="col-md-3 col-sm-3" id="show_image">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>รูปภาพ</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <th>-</th>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="col-md-8 col-sm-8">
                                        <form role="form" action="<?php echo base_url(); ?>index.php/travel/Savetravel" method="POST" enctype="multipart/form-data" accept-charset="utf-8">
                                            <fieldset>
                                                <div class="form-group">
                                                    <label for="category_id">หมวดหมู่เพลง</label>
                                                    <select name="category_id" id="category_id" class="form-control">
                                                        <option value="">กรุณาเลือกหมวดหมู่เพลง</option>
                                                        <?php foreach($category as $row){ ?>
                                                        <option value="<?php echo $row->id; ?>"><?php echo $row->category_name; ?></option>
                                                        <?php } ?>
                                                    </select>
                                                </div>
										 
                                                <div class="form-group">
                                                    <label for="travel_name">ชื่อเพลง </label>
                                                    <input class="form-control" id="travel_name" name="travel_name" type="text" placeholder="ชื่อ" value="<?php echo @$travel_edit[0]['travel_name']; ?>"/>
                                                </div>
                                     
												
												
												  <div class="form-group">
                                                    <label for="travel_detail">รายละเอียด </label>
                                                    <textarea class="form-control" rows="5" id="travel_detail" name="travel_detail" placeholder="รายละเอียด"><?php echo @$travel_edit[0]['travel_detail']; ?></textarea>
                                                </div>
												
												
                                                <div class="form-group">
                                                    <label for="travel_address">ผู้แต่งเพลง </label>
                                                    <textarea class="form-control" rows="4" id="travel_address" name="travel_address" placeholder="ผู้แต่งเพลง"><?php echo @$travel_edit[0]['travel_address']; ?></textarea>
                                                </div>
                                              
						<div class="form-group">
                                                    <label for="url_share">URL   </label>
                                                    <input class="form-control" id="url_share" name="url_share" type="text" placeholder=" URL" value="<?php echo @$travel_edit[0]['url_share']; ?>"/>
                                                </div>
                                           
                                                <div class="form-group">
                                                    <label>
                                                        อัพโหลดรูปภาพ
                                                    </label>
                                                    <input type="file" name="images[]" multiple/>
                                                </div>
                                                <input type="hidden" name="travel_id" id="travel_id" value="<?php echo @$travel_edit[0]['id']; ?>">
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
        <div class="col-md-1 col-sm-1">
            
        </div>
    </div>
    <!-- table ------------------------------------------------------------------------------------------- -->
                   
    <div class="row">
        <div class="col-md-12">
            <!-- Advanced Tables -->
            <div class="panel panel-default">
                <div class="panel-heading">
                     
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>หมวดหมู่เพลง</th>
								 
                                    <th>ชื่อเพลง</th>
                                    
                                  
                                    <th>รายละเอียด</th>
                                    <th>ผู้แต่งเพลง</th>
                                   
                                    <th>จัดการ</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <?php foreach($travel as $row){ ?>
                                <tr>
                                    <td><?php echo $row->category_name; ?></td>
								 
                                    <td><?php echo $row->travel_name; ?></td>
           
                                    <td><?php echo $row->travel_detail; ?></td>
                                    <td><?php echo $row->travel_address; ?></td>
                                    
                                    <td>
                                        <a  style="cursor: pointer;" href="<?php echo base_url(); ?>index.php/travel/getDataEdittravel/<?php echo $row->travel_id; ?>">[แก้ไข]</a>    
                                        <a onclick="return confirm('Are you sure?')" href="<?php echo base_url(); ?>index.php/travel/remove_travel/<?php echo $row->travel_id; ?>">[ลบ]</a>
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
            $("#travel_id").val('');
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
        if($.trim($("#category_id").val()) == ""){
            check = false;
        }
        if($.trim($("#travel_name").val()) == ""){
            check = false;
        }
        if($.trim($("#travel_detail").val()) == ""){
            check = false;
        }
        if($.trim($("#travel_address").val()) == ""){
            check = false;
        }
     

        return check;
    }
    
    function edit_message(travel_id){
        $("#delay_edit").hide(400);
        $("#delay_edit").show(400);
        $("#btn_save_form").html("อัพเดตข้อมูล");
        var open_close = $("#open_close_tab").attr('class');
        if(open_close == "collapsed"){
            $("#open_close_tab").click();
        }
        
        $.ajax({
            type:"POST",
            url:"<?php echo base_url(); ?>index.php/travel/getDataEdittravel",
            data:{ travel_id:travel_id },
            dataType: 'json',
            success:function(result){
                $("#category_id").val(result[0]['category_id']);
                $("#travel_name").val(result[0]['travel_name']);
                $("#travel_detail").val(result[0]['travel_detail']);
                $("#travel_address").val(result[0]['travel_address']);
                
                //$('textarea[name="travel_menu"]').ckeditor();
                //CKEDITOR.instances.editor1.setData( '<p>This is the editor data.</p>' );
                //$('textarea[name="travel_menu"]').val('rtrtrtr');
                $("#show_data").html(result[0]['travel_menu']);
                $("#latitude").val(result[0]['latitude']);
                $("#longitude").val(result[0]['longitude']);
                $("#telephone").val(result[0]['telephone']);
                
                $("#travel_id").val(result[0]['id']);
                
                //show_data_image(travel_id);
            }
        }); 
        
    }
    
</script>
<?php if(isset($travel_edit)){ ?>
    <script>
    $(document).ready(function () {
        $("#btn_save_form").html("อัพเดตข้อมูล");
        var open_close = $("#open_close_tab").attr('class');
        if(open_close == "collapsed"){
            $("#open_close_tab").click();
        }

        $("#category_id").val(<?php echo $travel_edit[0]['category_id']; ?>);
        $("#province_id").val(<?php echo $travel_edit[0]['province_id']; ?>);
        show_data_image($("#travel_id").val());
        
    });
    
    function show_data_image(travel_id){
        $("#show_image").html('').load("<?php echo base_url(); ?>index.php/travel/list_image_show/"+travel_id);
    }
    </script>
<?php } ?>

<?php $this->load->view('footer'); ?>         
