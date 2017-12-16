<fieldset class="fieldset-style">
	<div class="form-horizontal">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="container-fluid header-padding">
					<div class="row-fluid">
						<div class="span10" align="left">Upload PrepaidCode File</div>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<div class="singleline-records">
					<form class="form-horizontal" method="POST"
						enctype="multipart/form-data" action="uploadprepaidcodeexcelfilebysuperadmin">
								Organization Name
								
						<select class="" id="hotelId" name="hotelId">
							<c:forEach var="hotelInfo" items="${hotelInfoList}">
								<option value="${hotelInfo.id}" > ${hotelInfo.hotelName}</option>
							</c:forEach>
						</select> 
								
						
						Select Plan <select class="" id="plan" name="days">
							<option value="1">1 Day</option>
							<option value="2">2 Day</option>
							<option value="3">3 Day</option>
							<option value="5">5 Day</option>
							<option value="7">1 Week</option>
							<option value="15">15 Day</option>
							<option value="30">1 Month</option>

						</select> 
						Enter Amount <input type="text" class="" id="amount"
							name="amount" value="0" readonly />
							
 Select File<font color="red">*</font>

<input class="btn btn-file" type="file" name="file"/> 

<!-- <label class="btn btn-default">
    Browse <input type="file" name="file" hidden/>
</label> -->

<!-- <span class="btn btn-file">Upload<input type="file" /></span>
 -->


<br>
							<br>
<input type="Submit" class="btn btn-primary" value="Upload File"/>

<br>
${msg}
					</form>


				</div>
			</div>
		</div>
	</div>
</fieldset>
