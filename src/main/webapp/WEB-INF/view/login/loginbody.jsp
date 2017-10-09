<div class="form-signin" id="loginDiv">
	<!-- <img src="images/citrus_logo_chinchwad.png" width="330"> -->
	
	<img src="images/airwire.png" width="330"">
	

	<p class="text-left" style="margin-bottom: 10px; margin-top: 15px;">Sign
		in </p>

<form method="POST" action="${contextPath}/login" id="loginForm">
	<input type="text" class="input-block-level" placeholder="User Name"
		id="username" name="username"> <input type="password" class="input-block-level"
		placeholder="Password" id="password" name="password">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<!-- <button class="btn btn-primary" style="width: 100%;"
		onclick="document.forms['loginForm'].submit()">Sign in</button> -->
		<input type="submit" class="btn btn-primary" style="width: 100%;" value="Sign in">
</form>
	<div class="checkbox">
		${error}
			${message}
	</div>

	<!-- <a id="forgot_password" class="cursor" onclick="forgotPassword();">Forgot
		Password?</a>  -->
</div>

<script>

var d = new Date();

var currDate = d.getDate();
var currMonth = d.getMonth();
var currYear = d.getFullYear();

if (currDate < 10) {
	currDate = "0" + currDate;
}
if ((currMonth + 1) < 10) {
	currMonth = "0" + (currMonth + 1);
}

 var dateStr = currYear + "-" + currMonth + "-" + currDate; 

$.ajax( {
	type:'Get',
	url:'license',
	success:function(data) {
	 //alert(data.lDate);
	 var d1=new Date(data.lDate);
	 var d2=new Date(dateStr);
	 if( d1<= d2)
	 {
		$('#loginDiv').html('Oop\'s, Your License Expired Please Contact System Administrator' );
	 }
	}
	});

</script>
