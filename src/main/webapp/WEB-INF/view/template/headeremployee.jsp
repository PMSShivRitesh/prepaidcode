
<div class="logo">
	<img src="images/airwire.png" >
</div>

<%-- <% 
if (session.getAttribute("userName") == null || session.getAttribute("userName").toString().isEmpty()){
	%>
	<script type="text/javascript">
	window.location.href = "index.html";
	</script>
	<%
	}
	%> --%>
<header>

<script type="text/javascript">
$(document).ready(function(){
	
	
	

	
	
	$("#logout").click(function() {
		window.location.href = "logout";
	});
	});
	


</script>

<div class="btn-group">
	<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" id="btn-primary-roles" title="${sessionScope.username}"><i class="icon-user icon-white"></i>${sessionScope.username}<span class="caret"></span>
	</button>
	<ul class="dropdown-menu">
		<!--  <li class="disabled" ><a tabindex="-1" href="#"><font size="1px"><b>Use RMT as:</b></font></a></li>
		<li id="teammember"><a href="#">Team Member</a>
		</li>
		<li id="manager"><a href="#">Manager</a>
		</li>
		<li class="divider"></li> -->
		<li id="logout"><a href="#">Log Out</a>
		</li>
	</ul>
</div>

<div class="logininfo">
 <span><b>Login Id: </b>${userName}</span>
<%-- <span><b>Account Type: </b>${sessionScope.usertype}</span> --%>
<%-- <span><b>Current Role: </b>${sessionScope.role}</span> --%>
</div>
</header>
<!-- <input type="hidden" value=${sessionScope.role} id="role"> -->
<input type="hidden" value="${userName}" id="userid">
<div class="clearfix"></div>
<!-- <img class="loading-image" alt="please wait..." src="images/loading.gif" id="wait"> -->

