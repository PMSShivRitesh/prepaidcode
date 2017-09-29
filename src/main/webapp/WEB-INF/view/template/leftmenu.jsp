<!-- <script type="text/javascript">
 	$(document).ready(function(){
	
	 	var role= $("#role").val();
		$.ajax({
		url : "accessActionGetMenusList.action",
		type : "GET",
		data: 'role='+role,
		dataType : 'json',

		success : function(data) {
			$.each(data, function (key, value) {
				var menuid=value.menus.menuTitle;
				menuid=menuid.replace(/ +/g, '');
				$('#idmenus').append('<li id="'+menuid+'"><a href="'+value.menus.menuUrl+'"><i class="'+value.menus.menuIcon+'"></i><i class="icon-chevron-right"></i>'+value.menus.menuTitle+'</a></li>');
		     });
		} 
	});  
		
		 $.ajax({
			url : "accessActiongetMenusList.action",
			type : "GET",
			data: 'role='+sessionValue,
			dataType : 'json',

			success : function(data) {
				var obj = JSON.parse(data.jsonString);
				
				$.each(obj, function (key, value) {
					
					 $.each(value, function (key, value) {
						 var menutitle=null;
						 var menulink=null;
						 var menuicon=null;
						 
						 if(key=="menus"){
							 $.each(value, function (key, value) {
								 if(key=="menuTitle"){
									 menutitle=value;
								 }
								 if(key=="menuUrl"){
									 menulink=value;
								 }
								 if(key=="menuIcon"){
									 menuicon=value;
								 }
				    		});
							 var menuid=menutitle;
							 menuid=menuid.replace(/ +/g, '');
							 $('#idmenus').append('<li id="'+menuid+'"><a href="'+menulink+'"><i class="'+menuicon+'"></i><i class="icon-chevron-right"></i>'+menutitle+'</a></li>');
						 }
					 });
			    	
			     });
			}
		}); 
	});
</script>
 -->
<div class="span3 bs-docs-sidebar">
	<ul class="nav nav-list bs-docs-sidenav" id="idmenus">
		<li class="active"><a style="cursor: default;"><b>Menus</b></a></li>
		
		<li id="1"><a href="/"><i class="icon-home"></i>
		<i class="icon-chevron-right"></i>Home</a></li>
		
		<li id="1"><a href="generateprepaidcode"><i class="icon-pencil"></i>
		<i class="icon-chevron-right"></i>Generate PrepaidCode</a></li>
		
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
		<li id="1"><a href="generatebulkprepaidcode"><i class="icon-pencil"></i>
		<i class="icon-chevron-right"></i>Gen Bulk PrepaidCode</a></li>
		<li id="1"><a href="importcsv"><i class="icon-search"></i>
		<i class="icon-chevron-right"></i>Import CSV</a></li>
		
		<li id="1"><a href="#"><i class="icon-search"></i>
		<i class="icon-chevron-right"></i>Todays PrepaidCode</a></li>
		
		<li id="1"><a href="#"><i class="icon-list"></i>
		<i class="icon-chevron-right"></i>Search PrepaidCode</a></li>
		
		<li id="1"><a href="hotelsetup"><i class="icon-list"></i>
		<i class="icon-chevron-right"></i>SetUp Organization Info</a></li>
		
		<li id="1"><a href="createuser"><i class="icon-list"></i>
		<i class="icon-chevron-right"></i>Create User</a></li>
		
		
		<li id="1"><a href="report"><i class="icon-list"></i>
		<i class="icon-chevron-right"></i>Reports</a></li>
		</security:authorize>
	</ul>
	<%-- <input type="hidden" value=${sessionScope.role } id="role"> --%>
</div>


