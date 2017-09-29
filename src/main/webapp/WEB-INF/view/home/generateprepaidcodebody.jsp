<fieldset class="fieldset-style">
	<!-- <div class="alert alert-success" id="idsuccess">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<i class="icon-thumbs-up"></i>
		Module added successfully!
	</div> -->
	 <div class="alert alert-error" id="idwarning">
		<button type="button" class="close" data-dismiss="alert" onClick="buttonClick();">&times;</button>
		<i class="icon-warning-sign"></i>
		<div id="idwarningmsg" filter="false"></div>
	</div>
		
	<!-- <div class="alert alert-error" id="iderror">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<i class="icon-remove"></i>
		Module added to project with errors!
	</div>  -->
	<form action="saveusedplaninfo" method="POST" onsubmit="return validateForm()">
		<div class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="container-fluid header-padding">
						<div class="row-fluid">
							<div class="span7" align="left">Generate PrepaidCode</div>
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
								<label class="control-label">Select Plan<font
									color="red">*</font></label>
								<div class="controls">
									<select id="days" name="days" onchange="call();"
										Style="height: 25px; width: 206px !important;">
										<option value="0">Select Plan</option>
										<option value="1">1 Day</option>
										<option value="2">2 Day</option>
										<option value="3">3 Day</option>
										<option value="5">5 Day</option>
										<option value="7">1 Week</option>
										<option value="15">15 Day</option>
										<option value="30">1 Month</option>
									</select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Select Proof Type</label>
								<div class="controls">
									<select id="photoIdProofType" name="photoIdProofType"
										Style="height: 25px; width: 206px !important;">
										<option value="0">Proof Type</option>
										<option value="ELECTION CARD">Election Card</option>
										<option value="AADHAR CARD">Aadhar Card</option>
										<option value="PAN CARD">Pan Card</option>
										<option value="DRIVING LICENCES">Driving license</option>
										<option value="PASS PORT">Pass Port</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Guest Name<font color="red">*</font></label>
								<div class="controls">
									<input type="text" class="form-control" id="guestName"
										name="guestName" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Phone No.<font color="red">*</font></label>
								<div class="controls">
									<input type="text" class="form-control" id="mobileNo"
										name="mobileNo" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Email Id</label>
								<div class="controls">
									<input type="text" class="form-control"
										placeholder="Enter Email Id." name="emailId" id="emailId">
								</div>
							</div>
						</div>

						<!-- 2 Column -->

						<div class="firstquad">

							<div class="control-group">
								<label class="control-label">Status</label>
								<div class="controls">
									<div class="large m-wrap" id="prepaidcodeStatus">
										<font color="red">${usedPlanInfo}</font>
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Photo ID Proof</label>
								<div class="controls">
									<input type="text" class="form-control"
										placeholder="Enter Address" id="photoIdProof"
										name="photoIdProof">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Date</label>
								<div class="controls">
									<input type="text" class="form-control" id="date" name="date"
										readonly>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Room No.<font color="red">*</font></label>
								<div class="controls">
									<input type="text" class="form-control"
										placeholder="Enter Room No." id="roomNo" name="roomNo">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Address</label>
								<div class="controls">
									<input type="text" class="form-control"
										placeholder="Enter Address" id="address" name="address">
								</div>
							</div>

						</div>

						<!-- 3 Column -->

						<div class="firstquad">
							<div class="control-group">
								<label class="control-label">Amount</label>
								<div class="controls">
									<input type="text" class="form-control"
										placeholder="Enter Amount" id="amount" name="amount">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</fieldset>
<!-- ./wrapper -->









<script>
$('#idwarning').hide();
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

	$('#date').datepicker({
		autoclose : true,
		todayHighlight : true,
		format : "mm/dd/yyyy",
		defaultDate : dateStr
	});

	$('#date').val(dateStr);

	function call() {
		var days = $("#days").val();
		if (days != 0) {
			$("#amount").val("");
			$.ajax({
				url : 'prepaidcodestatusbyday',
				type : 'GET',

				data : {
					days : days
				},
				success : function(data) {
					//alert(data);
					if (data.size != null && data.size > 0) {
						if(data.warnPoint >= data.size ){
							$("#prepaidcodeStatus").html(
							"<font color='red'>"+data.size+"</font> <font color='green'> Available</font>");
						}else{
							$("#prepaidcodeStatus").html(
							"<font color='green'> Available</font>");
						}
						$("#amount").val(data.amount);
					} else {
						$("#prepaidcodeStatus").html(
								"<font color='red'>Not Available</font>");
					}
				}
			});
		}
	}
	
	function validateForm() {
        var guestName = $("#guestName").val();
        var mobileNo = $("#mobileNo").val();
        var roomNo= $("#roomNo").val();
        var days = $("#days").val();
       //idwarningmsg
       //idwarning
        var msg="";
        if (days == 0) {
         	msg=msg+"* Please select plan <br>";
         } 
        if (guestName == null || guestName == "") {
        	msg=msg+"* Please Enter Guest Name <br>";
        }
        if (mobileNo == null || mobileNo == "") {
        	msg=msg+"* Please Enter Mobile No. <br>";
        }
        if(roomNo == null || roomNo==""){
        	msg=msg+"* Please Enter Room No. <br>";
        }
        if(msg == null || msg==""){
        	return true;
        }
        $("#idwarning").show();
        $("#idwarningmsg").html(msg);
        return false;
    }
	
	function buttonClick(){
		 $("#idwarning").hide();
	}
</script>