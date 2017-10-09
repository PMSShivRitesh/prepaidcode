<div class="logo">
	<img src="/RMT/images/logo.jpg">
</div>

<script type="text/javascript">
$(document).ready(function(){
	var userid=$("#userid").val();
	if(userid==null){
		window.location.href = "/RMT/Pages/login/login.jsp";
	}
	
	$("#logout").click(function() {
		$.ajax({
			url : "loginActionLogOut.action",
			type : "GET",
			dataType : 'json',
			success : function(data) {
				window.location.href = "/RMT/Pages/login/login.jsp?status=true";
			}
		});
	});
});

$(document).ajaxStart(function(){
    $("#wait").css("display", "block");
});

$(document).ajaxComplete(function(){
    $("#wait").css("display", "none");
});
</script>

<header>
	<div class="btn-group">
		<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" id="btn-primary-roles"><i class="icon-user icon-white"></i>${sessionScope.username}<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li class="disabled"><a tabindex="-1" href="#"><font
					size="1px"><b>Admin</b></font></a></li>
			<li class="divider"></li>
			<li id="logout"><a href="#">Log Out</a></li>
		</ul>
	</div>
	<div class="logininfo">
<span><b>Login Id: </b>${sessionScope.userid}</span>
<span><b>Account Type: </b>${sessionScope.usertype}</span>
<span><b>Current Role: </b>${sessionScope.role}</span>
</div>
</header>
<input type="hidden" value=${sessionScope.role} id="role">
<input type="hidden" value=${sessionScope.userid} id="userid">
<div class="clearfix"></div>
<img class="loading-image" alt="please wait..." src="/RMT/images/loading.gif" id="wait">

