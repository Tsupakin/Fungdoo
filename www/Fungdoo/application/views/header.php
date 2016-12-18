<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>fungdoo</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="<?php echo base_url(); ?>assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="<?php echo base_url(); ?>assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLES-->
    <link href="<?php echo base_url(); ?>assets/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<?php echo base_url(); ?>assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="<?php echo base_url(); ?>assets/js/dataTables/dataTables.bootstrap.js"></script>
   <link href="<?php echo base_url(); ?>assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
   
   <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
   <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
   <script>
       $(document).ready(function () {
           $('#date_start,#date_end').datepicker({ dateFormat: 'yy-mm-dd' });
       });
   </script>
   <!-- ckeditor -->
   <script type="text/javascript" src="/asset/ckeditor/ckeditor.js"></script>
   <script type="text/javascript" src="/asset/ckfinder/ckfinder.js"></script>
   
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" style="background: #4D4D4D;border-radius: 0px;" href="<?php echo base_url(); ?>index.php/travel">fungdoo</a> 
            </div>
            <div style="color: white;padding: 15px 50px 5px 50px;float: right;font-size: 16px;"> 
                (--- ยินดีต้อนรับ : <?php echo "<label style='color:blue;'>".$this->session->userdata('username')."</label>"; ?> ---) &nbsp;
                Last access : <?php echo date("d"); ?> <?php echo date("M"); ?> <?php echo date("Y"); ?> &nbsp; <a href="<?php echo base_url(); ?>index.php/login/logout" class="btn btn-danger square-btn-adjust">Logout</a> 
            </div>
        </nav>   
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li class="text-center">
                        <img src="<?php echo base_url(); ?>assets/img/Music-icon.png" class="user-image img-responsive"/>
                    </li>
                    
                    
                    <li>
                        <a  href="<?php echo base_url(); ?>index.php/travel"><i class="fa fa-sitemap fa-3x"></i> บันทึกเพลง</a> 
                    </li>

                    <li>
                        <a  href="<?php echo base_url(); ?>index.php/category"><i class="fa fa-desktop fa-3x"></i> หมวดหมู่เพลง</a>
                    </li>
                       <li>
                        <a  href="<?php echo base_url(); ?>index.php/user"><i class="fa fa-desktop fa-3x"></i> ข้อมูลลูกค้า</a>
                    </li>
                  
                   
                    <!--
					                   
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-3x"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>

                                </ul>
                               
                            </li>
                        </ul>
                    </li>  
                    <li>
                        <a class="active-menu"  href="blank.html"><i class="fa fa-square-o fa-3x"></i> Blank Page</a>
                    </li>
                    -->
                </ul>
               
            </div>
        </nav>  
    
        