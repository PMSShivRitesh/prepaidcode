<fieldset class="fieldset-style">
		<div class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="container-fluid header-padding">
						<div class="row-fluid">
							<div class="span7" align="left">User Info</div>
						</div>
					</div>
				</div>
				<div class="container-fluid panel-body">
					<div class="row-fluid search-align">
						<div class="firstquad">
							<div class="control-group">
								<label class="control-label">Plan<font color="red">*</font></label>
								<div class="controls">${usedPlanInfo.plan}</div>
							</div>
							<div class="control-group">
								<label class="control-label">Proof Type<font color="red">*</font></label>
								<div class="controls">${usedPlanInfo.photoIdProofType}:
									${usedPlanInfo.photoIdProof}</div>
							</div>


							<div class="control-group">
								<label class="control-label">guestName</label>
								<div class="controls">${usedPlanInfo.guestName}</div>
							</div>

							<div class="control-group">
								<label class="control-label">Phone No.</label>
								<div class="controls">${usedPlanInfo.mobileNo}</div>
							</div>

							<div class="control-group">
								<label class="control-label">Email Id</label>
								<div class="controls">${usedPlanInfo.emailId}</div>
							</div>
						</div>

						<!-- 2 Column -->

						<div class="firstquad">

							<div class="control-group">
							
							<c:if test="${not empty usedPlanInfo.prepaidCode}">
								<label class="control-label">PrepaidCode </label>
								<div class="controls">
									<div class="large m-wrap" id="prepaidcodeStatus">
										<font color="red" size="5px">${usedPlanInfo.prepaidCode}</font>
									</div>
								</div>
							</c:if>	
							
							<c:if test="${not empty usedPlanInfo.wuserid}">
							
								<label class="control-label">User Id</label>
								<div class="controls">
									<div class="large m-wrap" id="prepaidcodeStatus">
										<font color="red" size="5px">${usedPlanInfo.wuserid} </font>&nbsp;&nbsp;&nbsp; Password &nbsp;&nbsp;&nbsp;<font color="red" size="5px">${usedPlanInfo.wpassword}</font>
									</div>
								</div>
							</c:if>
								
							</div>
							<div class="control-group">
								<label class="control-label">Date</label>
								<div class="controls">${usedPlanInfo.date}</div>
							</div>
							<div class="control-group">
								<label class="control-label">Room No.</label>
								<div class="controls">${usedPlanInfo.roomNo}</div>
							</div>
							<div class="control-group">
								<label class="control-label">Address</label>
								<div class="controls">${usedPlanInfo.address}</div>
							</div>
							<div class="control-group">
								<form action="myReport" method="GET" target="_blank">
								
								<c:if test="${not empty usedPlanInfo.prepaidCode}">
								<input type="hidden" id="prepaidCode" name="prepaidCode" value="${usedPlanInfo.prepaidCode}"/>
								</c:if>
								<c:if test="${not empty usedPlanInfo.wuserid}">
								<input type="hidden" id="prepaidCode" name="prepaidCode" value="${usedPlanInfo.wuserid}"/>
								</c:if>
								<input type="hidden" id="orgId" name="orgId" value="${usedPlanInfo.orgId}"/>
                                       
                                       <input type="Submit" class="btn btn-primary" value="Print"/>
                                       <input type="button" class="btn btn-primary" onclick="sendSms()" value="Send Sms"/>
                                </form>  
							</div>
						</div>

						<!-- 3 Column -->

						<div class="firstquad">
							<div class="control-group">
								<label class="control-label">Amount</label>
								<div class="controls">${usedPlanInfo.amount}</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-heading">
					<div class="container-fluid header-padding">
						<div class="row-fluid">
							<div class="span7" id= "smsstatus" align="left"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
</fieldset>
<!-- ./wrapper -->
<script>
function sendSms(){
	var prepaidCode =$("#prepaidCode").val();
	var orgId= $("orgId").val();
	$.ajax({
        url:'sendprepaidcodeassms',
        type:'GET',
        data:{"prepaidCode":prepaidCode,
        	  "orgId":orgId},
        success:function(data){
           $("#smsstatus").html("<font color='green'> "+data+"</font>");
        }
        });
	}
</script>