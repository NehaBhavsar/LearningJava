jQuery(document).ready(function(){     
    /* This js uses the functions defined into forgot password
  * ---------------------------------------------------------------------------------------
 * ---------------------- FUNCTION USED TO OPEN FORGOT PASSWORD DIALOG
 * ---------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------
					 */
   



    //AJAX CALL ON CLICK OF SUBMIT BUTTON
   
    $("#submitBtn").click(function(){
        //VALIDATE THE USERNAME
       
        var username = $("#username1").val();
        username = jQuery.trim(username);
        if(username==""){
            alert("Please, enter the username");
            $("#username").focus();
            return false;
        }else if(username.length<4){
            alert("Username must be greater than 4 characters long");
            $("#username").focus();
            return false;
        }else{
            //AJAX CALL TO RECOVER THE PASSWORD 
            var urlstr = "recoverPWD.do?username="+$("#username1").val();
            $.ajax({
                url:urlstr,
                global: false,
                type:"POST",
                dataType:"json",
                async:false,
                error:function(){
                    alert("Can not connect to server");
                },
                success: function(data){
                    if(data!=null){
                        if(data.status=="SUCCESS"){
                            alert(data.message);                                        
                        }else{
                            alert(data.message);
                        }
                    }else{
                        alert("Service call failed. Please contact system admin");
                    }                                   
                }
            });
        }                     
    });
});
