<fieldset class="fieldset-style">
	<form action="createuser" method="POST">
		<div class="form-horizontal">
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
										<c:forEach items="${roleList}" var="role"> 
										  <option value="${role.id}">${role.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</fieldset>
