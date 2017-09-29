<fieldset class="fieldset-style">
	<div class="form-horizontal">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="container-fluid header-padding">
					<div class="row-fluid">
						<div class="span10" align="left">Generate Bulk prepaidCode</div>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<div class="singleline-records">
					<form class="form-horizontal" method="GET" action="bulkprepaidcode" target="_blank">
						Select Plan <select class="" id="plan" name="plan">
							<option value="1">1 Day</option>
							<option value="2">2 Day</option>
							<option value="3">3 Day</option>
							<option value="5">5 Day</option>
							<option value="7">1 Week</option>
							<option value="15">15 Day</option>
							<option value="30">1 Month</option>

						</select> 
						Enter Quantity <input type="text" class="" id="count"
							name="count" value="10" />

<br>
							<br>
<input type="Submit" class="btn btn-primary" value="Generate Bulk prepaidCode"/>

<br>
${msg}
					</form>


				</div>
			</div>
		</div>
	</div>
</fieldset>
