<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>


	<%@ include file="header.jsp"%>

	<!--  

	private String customerName;
	private long customerId;
	private String emailId;
	private String address;
	private String password;
	private LocalDate dateOfBirth;
	private BankAccount account;


-->

	<div class="card m-5">
		<div class="card-header">Edit Customer Details</div>
		<div class="m-3">
			<%--  <form:form class="row m-2" action="editprofile" method="post" modelAttribute="customer">
            <div class="col-md-4 form-group">
                <form:label path="customerId" for="exampleInputEmail1">Customer ID</form:label>
                <form:input type="number" path="customerId"  readonly class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Account ID"/>
            </div>
            <div class="col-md-4 form-group">
                <form:label for="exampleInputEmail1">Name*</form:label>
                <form:input type="text" path="customerName" required class="form-control" id="exampleInputEmail81" aria-describedby="emailHelp" placeholder="Name"/>
            </div>
            <div class="col-md-4 form-group">
                <form:label for="exampleInputEmail1">DOB</form:label>
                <form:input type="date" path="dateOfBirth" required readonly  class="form-control" id="exampleInputsEmai8l1" aria-describedby="emailHelp" placeholder="Date of Birth"/>
            </div>
            <div class="col-md-4 form-group">
                <form:label for="exampleInputEmail1">Email*</form:label>
                <form:input type="email" path="emailId" required  class="form-control" id="examxpleInputEmai8l1" aria-describedby="emailHelp" placeholder="Email"/>
            </div>
            <div class="col-md-4 form-group">
                <form:label for="exampleInputEmail1">Address*</form:label>
                <form:input type="text" path="address" required  class="form-control" id="exampleInputEmai8l1" aria-describedby="emailHelp" placeholder="Address"/>
                <br>
                <button type="submit" class="btn btn-primary btn-block">Edit Profile</button><br>
                <c:if test="${requestScope.success == false}">
                    <div class="alert alert-danger" role="alert">
						<b>Customer not found!!!!</b>
					</div>
					</c:if>
					<c:if test="${requestScope.success == true}">
                    <div class="alert alert-success" role="alert">
						<b>Done editing</b>
					</div>
					</c:if>
                * - Mandatory fields
            </div>
        </form:form> --%>
			<form:form action="editprofile" method="post"
				modelAttribute="customer">
				<form:label path="customerId">Customer ID</form:label>
				<form:input path="customerId" readonly="readonly" />

				<form:label path="customerName">Customer Name</form:label>
				<form:input path="customerName" readonly="readonly" />

				<form:label path="dateOfBirth">Date of Birth</form:label>
				<form:input type="date" path="dateOfBirth" readonly="readonly" />

				<form:label path="address">Address</form:label>
				<form:input path="address" readonly="readonly" />

				<input type="submit" name="submit">
			</form:form>


		</div>
	</div>





	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>