<fieldset class="fieldset-style">
	<form action="hotelsetup" method="POST">
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
								<label class="control-label">Hotel Name</label>
								<div class="controls">
								<input type="hidden" class="form-control" id="guestName"
										name="id"  value="${hotelInfo.id}"  />
									<input type="text" class="form-control" id="guestName"
										name="hotelName"  value="${hotelInfo.hotelName}" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Controller Name</label>
								<div class="controls">
									<%-- <input type="text" class="form-control" id="mobileNo"
										name="controllerName" value="${hotelInfo.controllerName}"/> --%>
						<select class="" id="controllerName" name="controllerName">
							
							<option value="WIFISOFT" <c:if test="${hotelInfo.controllerName == 'WIFISOFY'}"> selected</c:if> >WIFI-SOFT</option>
							<option value="ANTLABS" <c:if test="${hotelInfo.controllerName == 'ANTLABS'}"> selected</c:if>>ANTLABS</option>
							<option value="24ONLINE" <c:if test="${hotelInfo.controllerName == '24ONLINE'}"> selected</c:if>>24ONLINE</option>
						</select> 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Warn Point</label>
								<div class="controls">
									<input type="text" class="form-control" id="mobileNo"
										name="warnPoint" value="${hotelInfo.warnPoint}" />
								</div>
							</div>

							
						</div>

						<!-- 2 Column -->

						<div class="firstquad">

							<div class="control-group">
								<label class="control-label">SMS Vendor</label>
								<div class="controls">
									<input type="text" class="form-control" id="guestName"
										name="smsVendor" value="${hotelInfo.smsVendor}" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">SMS User Id</label>
								<div class="controls">
									<input type="text" class="form-control" id="guestName"
										name="userId" value="${hotelInfo.userId}" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">SMS Sender Id</label>
								<div class="controls">
									<input type="text" class="form-control" id="mobileNo"
										name="senderId" value="${hotelInfo.senderId}" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">SMS Password</label>
								<div class="controls">
									<input type="password" class="form-control" id="mobileNo"
										name="password" value="${hotelInfo.password}" />
								</div>
							</div>

						</div>

						<!-- 3 Column -->

						<div class="firstquad">
							<div class="control-group">
								<label class="control-label">SMS Format</label>
								<div class="controls">
									<textarea rows="6" cols="50" name="message">${hotelInfo.message}</textarea>
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

	var dateStr = currDate + "/" + currMonth + "/" + currYear;

	$('#date').datepicker({
		autoclose : true,
		todayHighlight : true,
		format : "dd/mm/yyyy",
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
</script>