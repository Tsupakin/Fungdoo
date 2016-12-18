<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>fungdoo</title>
	<!-- BOOTSTRAP STYLES-->
        <link href="<?php echo base_url(); ?>assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="<?php echo base_url(); ?>assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="<?php echo base_url(); ?>assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<br><br><br><br><br>
<div class="row">
    <div class="col-md-4 col-sm-4">
        
    </div>
    <div class="col-md-4 col-sm-4">
         <?php if($this->session->flashdata('result')){ ?>
            <div class="alert alert-success">
                <?php echo '** '.$this->session->flashdata('result'); ?>
            </div>
        <?php } ?>
        <div class="panel panel-primary">
            
            <div class="panel-heading" style="text-align: center;">
                <big><b>ยินดีต้อนรับเข้าสู่ระบบจัดการ fungdoo</b> <br> Login For User</big>
            </div>
            
            <div class="panel-body" style="height:220px;">
                <form action="<?php echo base_url(); ?>index.php/login/doing_login" method="POST">
                    <div class=" form-group input-group input-group-lg">
                        <span class="input-group-addon">@</span>
                        <input type="text" name="username" class="form-control" placeholder="Username" />
                    </div>
                    <div class=" form-group input-group input-group-lg">
                        <span class="input-group-addon">@</span>
                        <input type="password" name="password" class="form-control" placeholder="Password" />
                    </div>
                    
                    <center>
                        <div class=" form-group input-group">
                            <button type="submit" class="btn btn-success">Login Now</button> &nbsp;
                            <button type="reset" class="btn btn-default">Cancel</button>
                        </div>
                        <?php if(isset($error)){ ?>
                            <div style="color: red;">
                                <?php echo '** '.$error; ?>
                            </div>
                        <?php } ?>
                    </center>
                </form>
            </div>
            <div class="panel-footer">
                *กรุณากรอก Username และ Password ก่อนเข้าสู่ระบบหลังบ้าน
            </div>
        </div>
        
    </div>
    <div class="col-md-4 col-sm-4">
        
    </div>
</div>

<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="<?php echo base_url(); ?>assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="<?php echo base_url(); ?>assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="<?php echo base_url(); ?>assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="<?php echo base_url(); ?>assets/js/custom.js"></script>
</body>
</html>