<fieldset class="fieldset-style">
	<form action="createplan" method="POST">
		<div class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="container-fluid header-padding">
						<div class="row-fluid">
							<div class="span7" align="left">Create Organization Plan</div>
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
								<label class="control-label">Organization Name</label>
								<div class="controls">
								
									<select class="" id="orgId" name="orgId">
									<option value="">Select</option>
										<c:forEach var="org" items="${orgList}">
											<option value="${org.id}">${org.hotelName}</option>
										</c:forEach>
									</select>
									
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Plan Name</label>
								<div class="controls">
									<input type="text" class="form-control" id="name"
										name="name" value=""/>
						
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Plan Description</label>
								<div class="controls">
									<input type="text" class="form-control" id="description"
										name="description" value="" />
								</div>
							</div>

							
						</div>


						

					</div>
				</div>
			</div>
		</div>
	</form>
	
	<div class="form-horizontal">
		
			<div class="panel panel-default">
					
					<div class="panel-heading">
						<div class="container-fluid header-padding">
							<div class="row-fluid">
								<div class="span7" align="left">Organization Plan List</div>
								<!-- <div class="span5" align="right">
									<input type="submit" class="btn-save" value="" id="btnsave" />
								</div> -->
							</div>
						</div>
					</div>
					
					<div class="panel-body">
						<div class="singleline-records">
				<%-- 	<table id="idtable" class="table table-bordered insideform" style="font-size: 12px;">
						<tr bgcolor="#84939f">
							<th>Name</th>
							<th>Controller Name</th>
							<th>Warn Point</th>
							<th>SMS Vendor</th>
							<th>SMS User Id</th>
							<th>SMS Sender Id</th>
							<th>SMS Format</th>
						</tr>
						<c:forEach items="${orgList}" var="org"> 
							<tr>
								<td>${org.hotelName}</td>
								<td>${org.controllerName} </td>
								<td>${org.warnPoint}</td>
								<td>${org.smsVendor}</td>
								<td>${org.userId}</td>
								<td>${org.senderId}</td>
								<td>${org.message}</td>
							</tr>
						</c:forEach>
					</table> --%>
				</div>
					</div>
					
			</div>

		</div>
	
</fieldset>









