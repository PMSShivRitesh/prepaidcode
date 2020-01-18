<fieldset class="fieldset-style">
	
		<div class="form-horizontal">
		<form action="createuser" method="POST">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="container-fluid header-padding">
						<div class="row-fluid">
							<div class="span7" align="left">Create User</div>
							<div class="span5" align="right">
								<input type="submit" class="btn-save" value="" id="btnsave" />
							</div>
						</div>
					</div>
				</div>
				<div class="container-fluid panel-body">
					<div class="row-fluid search-align">
						<div class="firstquad">

							<security:authorize access="hasRole('ROLE_SUPERADMIN') or hasRole('ROLE_SYSTEMADMIN')">
							<div class="control-group">
								<label class="control-label">Select Org Name</label>
								<div class="controls">
									<select class="" id="orgId" name="orgId">
									<option value="">Select</option>
										<c:forEach var="org" items="${orgList}">
											<option value="${org.id}">${org.hotelName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							</security:authorize>

							<div class="control-group">
								<label class="control-label">Name</label>
								<div class="controls">
								
									<input type="text" class="form-control" id="guestName"
										name="name"/>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Email Id</label>
								<div class="controls">
									<input type="text" class="form-control" id="mobileNo"
										name="email" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Mobile No.</label>
								<div class="controls">
									<input type="text" class="form-control" id="mobileNo"
										name="mobileNo"  />
								</div>
							</div>

							
						</div>

						<!-- 2 Column -->

						<div class="firstquad">

							<div class="control-group">
								<label class="control-label">User Name</label>
								<div class="controls">
									<input type="text" class="form-control" id="guestName"
										name="username"  />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Password</label>
								<div class="controls">
									<input type="text" class="form-control" id="mobileNo"
										name="password"  />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Role</label>
								<div class="controls">
									<select id="role" name="roleId" Style="height: 25px; width: 206px !important;">
									<option value="0">Select Role</option>
										<%-- <c:forEach items="${roleList}" var="role"> 
										  <option value="${role.id}">${role.name}</option>
										</c:forEach> --%>
										<option value="1">ROLE_ADMIN</option>
										<option value="2">ROLE_OPERATOR</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</form>
		</div>
		<div class="form-horizontal">
		
			<div class="panel panel-default">
					
					<div class="panel-heading">
						<div class="container-fluid header-padding">
							<div class="row-fluid">
								<div class="span7" align="left">User List</div>
								<!-- <div class="span5" align="right">
									<input type="submit" class="btn-save" value="" id="btnsave" />
								</div> -->
							</div>
						</div>
					</div>
					
					<div class="panel-body">
						<div class="singleline-records">
					<table id="idtable" class="table table-bordered insideform" style="font-size: 12px;">
						<tr bgcolor="#84939f">
							<th>Name</th>
							<th>Role</th>
							<th>Mobile Number</th>
							<th>Email Id</th>
							<th>UserName</th>
							<th>Reset</th>
							<th>Delete</th>
						</tr>
						<c:forEach items="${userList}" var="user"> 
							<c:if test="${user.active}">
							<tr>
								<td>${user.name}</td>
								<td>
									<c:forEach items="${user.roles}" var="role">
										${role.name},
									</c:forEach>
								</td>
								<td>${user.mobileNo}</td>
								<td>${user.email}</td>
								<td>${user.username}</td>
								<td><a href="reset?id=${user.id}" >Reset</a></td>
								<td><a href="delete?id=${user.id}" >Delete</a></td>
							</tr>
							</c:if>
						</c:forEach>
					</table>
				</div>
					</div>
					
			</div>

		</div>
</fieldset>

 


