
<div class="logo">
	<img src="../../images/logo.jpg">
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
				alert("You are Successfully signed out!")
				window.location.href = "/RMT/Pages/login/login.jsp?c=1";
			}
		});
	});
});
</script>

<header>
	<div class="btn-group">
		<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><i class="icon-user icon-white"></i>${sessionScope.username}<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li class="disabled"><a tabindex="-1" href="#"><font
					size="1px"><b>Client</b></font></a></li>
			<li class="divider"></li>
			<li id="logout"><a href="#">Log Out</a></li>
		</ul>
	</div>
</header>
<input type="hidden" value=${sessionScope.role} id="session">
<input type="hidden" value=${sessionScope.userid} id="userid">
<div class="clearfix"></div>

