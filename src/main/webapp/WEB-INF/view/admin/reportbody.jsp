<fieldset class="fieldset-style">
	<form action="report" method="POST">
		<div class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="container-fluid header-padding">
						<div class="row-fluid">
							<div class="span7" align="left">Report</div>
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
								<label class="control-label">From Date</label>
								<div class="controls">
									<input type="text" class="form-control" id="fromDate" name="fromDate"
										readonly>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">From Date</label>
								<div class="controls">
									<input type="text" class="form-control" id="toDate" name="toDate"
										readonly>
								</div>
							</div>

							
						</div>

						<!-- 2 Column -->

						<div class="firstquad">
							

						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<div>
				
	</div>


	<div class="form-horizontal">

    			<div class="panel panel-default">

    					<div class="panel-heading">
    						<div class="container-fluid header-padding">
    							<div class="row-fluid">
    								<div class="span7" align="left">Report</div>
    							
    							</div>
    						</div>
    					</div>

    					<div class="panel-body">
    						<div class="singleline-records">
    					<table id="idtable" class="table table-bordered insideform" style="font-size: 12px;">
    						<tr bgcolor="#84939f">
    							<th>Guest Name</th>
    							<th>Room No.</th>
    							<th>Plan</th>
    							<th>Date</th>
    							<th>Mobile Number</th>
    							<th>photoIdProofType</th>
    							<th>photoIdProof</th>
    							<th>Email Id</th>
    							<th>address</th>
    							<th>generatedByUser</th>

    						</tr>
    						<c:forEach items="${usedPlanInfoDTOs}" var="usedPlanInfoDTO">
    							<tr>
    								<td>${usedPlanInfoDTO.guestName}</td>
    								<td>${usedPlanInfoDTO.roomNo}</td>
    								<td>${usedPlanInfoDTO.plan}</td>
    								<td>${usedPlanInfoDTO.date}</td>
    								<td>${usedPlanInfoDTO.mobileNo}</td>
    								<td>${usedPlanInfoDTO.photoIdProofType}</td>
    								<td>${usedPlanInfoDTO.photoIdProof}</td>
    								<td>${usedPlanInfoDTO.emailId}</td>
    								<td>${usedPlanInfoDTO.address}</td>
    								<td>${usedPlanInfoDTO.generatedByUser}</td>
    							</tr>
    						</c:forEach>
    						
    					</table>
    				</div>
    					</div>

    			</div>

    		</div>
</fieldset>

<script>
var d = new Date();

var currDate = d.getDate();
var currMonth = d.getMonth();
var currYear = d.getFullYear();

if (currDate < 10) {
	currDate = "0" + currDate;
}
if ((currMonth + 1) < 10) {
	currMonth = "0" + (currMonth + 1);
}

/* var dateStr = currDate + "/" + currMonth + "/" + currYear; */
var dateStr = currMonth + "/" + currDate + "/" + currYear;


$('#fromDate').datepicker({
	autoclose : true,
	todayHighlight : true,
	format : "mm/dd/yyyy",
	defaultDate : dateStr
});
$('#fromDate').val(dateStr);

$('#toDate').datepicker({
	autoclose : true,
	todayHighlight : true,
	format : "mm/dd/yyyy",
	defaultDate : dateStr
});

$('#toDate').val(dateStr);
</script>
