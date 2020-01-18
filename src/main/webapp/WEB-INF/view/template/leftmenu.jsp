<div class="span3 bs-docs-sidebar">
	<ul class="nav nav-list bs-docs-sidenav" id="idmenus">
		<li class="active"><a style="cursor: default;"><b>Menus</b></a></li>
		
		<li id="1"><a href="welcome"><i class="icon-home"></i>
		<i class="icon-chevron-right"></i>Home</a></li>
		
		<li id="1"><a href="generateprepaidcode"><i class="icon-pencil"></i>
		<i class="icon-chevron-right"></i>Generate PrepaidCode</a></li>
		
		
		<li id="1"><a href="generatebulkprepaidcode"><i class="icon-pencil"></i>
		<i class="icon-chevron-right"></i>Gen Bulk PrepaidCode</a></li>
		
		
		<security:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN') or hasRole('ROLE_SYSTEMADMIN')">
		<li id="1"><a href="importcsv"><i class="icon-search"></i>
		<i class="icon-chevron-right"></i>Import CSV</a></li>
		</security:authorize>
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<li id="1"><a href="hotelsetup"><i class="icon-list"></i>
			<i class="icon-chevron-right"></i>SetUp Organization Info</a></li>
		</security:authorize>
		
		<security:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN') or hasRole('ROLE_SYSTEMADMIN')">
		<li id="1"><a href="createuser"><i class="icon-list"></i>
		<i class="icon-chevron-right"></i>Create User</a></li>
		<li id="1"><a href="report"><i class="icon-list"></i>
		<i class="icon-chevron-right"></i>Reports</a></li>
		</security:authorize>
		
		<security:authorize access="hasRole('ROLE_SYSTEMADMIN')">
			 <li id="1"><a href="createorganization "><i class="icon-list"></i>
			 <i class="icon-chevron-right"></i>Create Organization</a></li>
			 
			  <li id="1"><a href="createplan "><i class="icon-list"></i>
			 <i class="icon-chevron-right"></i>Create Organization Plan</a></li>
		</security:authorize>
		
		<!-- <li id="1"><a href="#"><i class="icon-search"></i>
		<i class="icon-chevron-right"></i>Todays PrepaidCode</a></li>
		<li id="1"><a href="#"><i class="icon-list"></i>
		<i class="icon-chevron-right"></i>Search PrepaidCode</a></li> -->
		<!--  -->
		
	</ul>
</div>


