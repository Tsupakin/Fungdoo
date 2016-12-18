<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>รูปภาพ</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach($image as $row){ ?>
        <tr>
            <td>
                <img src="<?php echo base_url(); ?>uploads/travel/<?php echo $row->image_name; ?>" style="width:120px;height: 120px;" id="<?php echo $row->id; ?>">
                <a class="<?php echo $row->id; ?>" onclick="delect_message(<?php echo $row->id; ?>)" title="<?php echo $row->id; ?>" style="cursor: pointer;">[delete]</a>
            </td>
        </tr>
        <?php } ?>
    </tbody>
</table>
<script>
    $( document ).ready(function() {
        
    });
    function delect_message(id){
        if (confirm("Are you sure ?")) {
            $.ajax({
                type:"POST",
                url:"<?php echo base_url(); ?>index.php/travel/removeImage",
                data:{ id:id },
                dataType: 'html',
                success:function(result){

                    $("#"+id).remove();
                    $("."+id).remove();
                }
            }); 
        }
    }
</script>