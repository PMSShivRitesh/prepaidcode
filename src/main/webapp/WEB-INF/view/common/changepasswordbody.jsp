<fieldset class="fieldset-style">
	<div class="alert alert-success" id="idsuccess">
		<button type="button" class="close" data-dismiss="alert" onClick="buttonClick();">&times;</button>
		<i class="icon-thumbs-up"></i>
		<div id="idsuccessmsg" filter="false"></div>
	</div>
	 <!-- <div class="alert alert-warning" id="idwarning">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<i class="icon-warning-sign"></i>
		<div id="idwarningmsg" filter="false"></div>
	</div> -->	
	<div class="alert alert-error" id="iderror">
		<button type="button" class="close" data-dismiss="alert" onClick="buttonClick();">&times;</button>
		<i class="icon-remove"></i>
		<div id="iderrormsg" filter="false"></div>
	</div>
	
	<input type="hidden" id="message" value="${message}">
	
	<form action="changepassword" method="POST" onsubmit="return validateForm()">
		<div class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="container-fluid header-padding">
						<div class="row-fluid">
							<div class="span7" align="left">Change Password</div>
							<div class="span5" align="right">
								<!-- <input type="submit" class="btn-save" value="" id="btnsave" /> -->
							</div>
						</div>
					</div>
				</div>
				<div class="container-fluid panel-body">
					<div class="row-fluid search-align">
					
							<div class="control-group">
								<label class="control-label">New Password<font color="red">*</font></label>
								<div class="controls">
									<input type="text" class="form-control" id="password" name="password"  >
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Confirm Password<font color="red">*</font></label>
								<div class="controls">
									<input type="text" class="form-control" id="cpassword" name="cpassword" >
								</div>
							</div>
							<input type="submit" class="btn btn-success" value="Update" id="btnsave" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	
</fieldset>
<!-- ./wrapper -->


<script>

//# sourceURL=createform.js

$('#idsuccess').hide();
$('#iderror').hide();

if ($("#message").val() != "") {
	$("#idsuccess").show();
	$("#idsuccessmsg").html($("#message").val());
}

	
 	
	function validateForm() {
        var password = $("#password").val();
        var cpassword = $("#cpassword").val();

        var msg="";
        if (password == "") {
        	msg=msg+"* Please Enter password<br>";
        }
        
        if(password != cpassword){
        	msg=msg+"* Please Confirm password<br>";
        }
        if(msg == null || msg==""){
        	return true;
        }
        $("#iderror").show();
        $("#iderrormsg").html(msg);
        return false;
    }
	
	function buttonClick(){
		 $("#idsuccess").hide();
		 $("#iderror").hide();
	}
	
	
	
 	
</script>


