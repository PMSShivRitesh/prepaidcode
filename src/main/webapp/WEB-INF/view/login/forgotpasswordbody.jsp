<script type="text/javascript">
$(document).ready( function(){
	$('#idwarning').hide();
	$('#idsuccess_change_pass').hide();
	$('#iderror_login').hide();
	$('#signin').hide();
	
	$('.close').click(function(){
		$('#idwarning').hide();
		$('#idsuccess_change_pass').hide();
		$('#iderror_login').hide();
	});
	
	$("#idsecurityques").ready(function(){
		$.ajax({
			url : "securityActionGetSecurityQuestions.action",
			type : "GET",
			dataType : 'json',
			success : function(data) {
				$.each(data, function(key, value) {
					$("#idsecurityques").append('<option value='+value.id+'>'+value.question+'</option>');
				});
				}
		});
		});
});

function validateFunction(){
		var userId = $("#userid").val();
		var queId=$("#idsecurityques").val();
		var ans=$("#answer").val();
		
		$.ajax({
			url:"securityActionUserValidateSecurityQuestionAnswer.action",
			type:"GET",
			data:'userSecurityQuestions.users.userId='+userId+'&userSecurityQuestions.securityQuestions.id='+queId+'&userSecurityQuestions.answer='+ans,
			dataType:'json',
			success:function(data){
				if(data==true){
					document.getElementById('idchangepassword').style.display='block';
					document.getElementById('fade').style.display='block';
				}else if(data==false){
					$("#errormsg").text("");
					$("#errormsg").text("Invalid user name or question or answer!");
					$('#iderror_login').show();
				}
				}
		});
}

function changePassword(){
	var newPassword = $("#idnewpassword").val();
	var confirmPassword = $("#idconfpassword").val();
	var userId = $("#userid").val();
		
	if(!(newPassword==null||newPassword==""||confirmPassword==null||confirmPassword=="")){
		if(!(newPassword==confirmPassword)){
			$('#warningmsg').text("Check confirm password!");
			$('#idwarning').show();
			}else{
				$.ajax({
					url : "securityActionChangePassword.action",
					type : "GET",		
					data : 'userId='+userId+'&newPassword='+newPassword,
					dataType : 'json',
					success : function(data) {
						if (data == true) {
							$('#idwarning').hide();
							$('#iderror_login').hide();
							$('#idsuccess_change_pass').show();
							$('#idform').hide();
							$('#signin').show();
						} else if (data == false) {
							$("#idchangepassword").hide();
							$("#fade").hide();
							$('#idwarning').hide();
							$('#idsuccess_change_pass').hide();
							$("#errormsg").text("");
							$("#errormsg").text("Problem encoured while updating password!");
							$('#iderror_login').show();
						}
					}
				});
			}
		}
	else{
		$('#warningmsg').text("Please enter password before proceed!");
		$('#idwarning').show();
	}
}

function login(){
	window.location.href="/RMT/Pages/login/login.jsp"
}
</script>

    <div class="alert alert-error" id="iderror_login">
    <i class="icon-warning-sign"></i><div id="errormsg"></div></div>
      
	<div class="form-signin">
		<p class="text-left" style="margin-bottom: 10px; margin-top: 15px; font-weight: bold;">Forgot password?</p>
		<label class="control-label">User name</label><input type="text" class="input-block-level" placeholder="User name" id="userid">
		<label class="control-label">Your Security Question</label><select class="input-block-level" id="idsecurityques"></select>
		<label class="control-label">Answer</label><input type="password" class="input-block-level" placeholder="Answer" id="answer"> 
		<button class="btn btn-primary" style="width: 100%;" onclick="validateFunction();">Proceed</button>
	</div>
	
	<div class="white_content" id="idchangepassword">
	<div class="alert alert-warning" id="idwarning">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<i class="icon-warning-sign"></i><div id="warningmsg"></div>
		</div>
	<div class="alert alert-success" id="idsuccess_change_pass">
			<i class="icon-thumbs-up"></i>Successfully changed password!
	</div>
		
	<div class="form-horizontal" style="padding: 8% 0% 8% 19%" id="idform">
					<div class="control-group">
						 <label class="control-label">New password</label>
						  <div class="controls">
							<input type="password" id="idnewpassword" />
						</div>
					</div>

					<div class="control-group">
						 <label class="control-label">Confirm new password</label>
						  <div class="controls">
							<input type="password" id="idconfpassword" />
						</div>
					</div>
					<button class="btn btn-primary" onclick="changePassword();">Change Password</button>
				</div>
		<div id="signin" class="btn-login">
		<button class="btn btn btn-success" onclick="login();">Log in</button>
		</div>
	</div>
	
<a href="javascript:void(0)" onclick="document.getElementById('idchangepassword').style.display='none';document.getElementById('fade').style.display='none'">
<div id="fade" class="black_overlay"></div></a>
	
