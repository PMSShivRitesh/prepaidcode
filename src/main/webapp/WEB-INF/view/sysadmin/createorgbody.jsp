<fieldset class="fieldset-style">
	<form action="hotelsetup" method="POST">
		<div class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="container-fluid header-padding">
						<div class="row-fluid">
							<div class="span7" align="left">Create Organization</div>
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
								<label class="control-label">Hotel Name</label>
								<div class="controls">
								
									<input type="text" class="form-control" id="guestName"
										name="hotelName"  value="" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Controller Name</label>
								<div class="controls">
									<%-- <input type="text" class="form-control" id="mobileNo"
										name="controllerName" value="${hotelInfo.controllerName}"/> --%>
						<select class="" id="controllerName" name="controllerName" >
							<option value="" >Select</option>
							<option value="WIFISOFT" >WIFI-SOFT</option>
							<option value="ANTLABS" >ANTLABS</option>
							<option value="24ONLINE" >24ONLINE</option>
						</select> 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Warn Point</label>
								<div class="controls">
									<input type="text" class="form-control" id="mobileNo"
										name="warnPoint" value="" />
								</div>
							</div>

							
						</div>

						<!-- 2 Column -->

						<div class="firstquad">


							<div class="control-group">
								<label class="control-label">SMS Vendor</label>
								<div class="controls">
						<select class="" id="smsVendor" name="smsVendor" >
							<option value="" >Select</option>
							<option value="Cellx" >Cellx</option>
							<option value="smswave" >SmsWave</option>
						</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">SMS User Id</label>
								<div class="controls">
									<input type="text" class="form-control" id="guestName"
										name="userId" value="" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">SMS Sender Id</label>
								<div class="controls">
									<input type="text" class="form-control" id="mobileNo"
										name="senderId" value="" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">SMS Password</label>
								<div class="controls">
									<input type="password" class="form-control" id="mobileNo"
										name="password" value=""  />
								</div>
							</div>

						</div>

						<!-- 3 Column -->

						<div class="firstquad">
							<div class="control-group">
								<label class="control-label">SMS Format</label>
								<div class="controls">
									<textarea rows="6" cols="50" name="message">Welcome to Hotel Name, your WIFI User id <userid> and password is <password> for <plan></textarea>
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
								<div class="span7" align="left">Organization List</div>
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
					</table>
				</div>
					</div>
					
			</div>

		</div>
	
</fieldset>









