<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher's list</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Teacher's list</h1>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#exampleModal">Launch demo modal</button>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Register
							teacher</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form method="POST" action="teachers">
							<fieldset>
								<legend>Data section</legend>
								<div class="mb-3">
									<label for="id" class="form-label">Id</label> <input
										type="text" class="form-control" id="id"
										aria-describedby="id" name="id">
								</div>
								<div class="mb-3">
									<label for="firstName" class="form-label">Firstname</label> <input
										type="text" class="form-control" id="firstName"
										aria-describedby="firstName" name="firstName">
								</div>
								<div class="mb-3">
									<label for="lastName" class="form-label">Lastname</label> <input
										type="text" class="form-control" id="lastName"
										aria-describedby="lastName" name="lastName">
								</div>
								<div class="mb-3">
									<label for="email" class="form-label">Email</label> <input
										type="email" class="form-control" id="email"
										aria-describedby="email" name="email">
								</div>
								<div class="mb-3">
									<label for=age class="form-label">Age</label> <input
										type="number" class="form-control" id="age"
										aria-describedby="age" name="age">
								</div>
								<div class="mb-3">
									<label for=money class="form-label">Money</label> <input
										type="number" class="form-control" id="money"
										aria-describedby="money" name="money">
								</div>
								<div class="mb-3">
									<label for="gender" class="form-label">Gender</label>
									<div class="form-check">
										<input type="radio" class="form-check-input" id="male"
											aria-describedby="gender" value="MALE" name="gender">
										<label for="male">Male</label>

									</div>
									<div class="form-check">
										<input type="radio" class="form-check-input" id="female"
											aria-describedby="gender" value="FEMALE" name="gender">
										<label for="female">Female</label>
									</div>
								</div>
								<div class="mb-3">
									<label for="birthday" class="form-label">Birthday</label> <input
										type="date" class="form-control" id="birthday"
										aria-describedby="birthday" name="birthday">
								</div>
								<button type="submit" class="btn btn-primary" name="action"
									value="INSERT">Register</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">firstName</th>
					<th scope="col">lastName</th>
					<th scope="col">email</th>
					<th scope="col">age</th>
					<th scope="col">money</th>
					<th scope="col">phone</th>
					<th scope="col">gender</th>
					<th scope="col">birthday</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${teachersList}" var="row">
					<tr>
						<td>${row.id}</td>
						<td>${row.firstName}</td>
						<td>${row.lastName}</td>
						<td>${row.email}</td>
						<td>${row.age}</td>
						<td>${row.money}</td>
						<td>${row.phone}</td>
						<td>${row.gender}</td>
						<td>${row.birthday}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		var myModal = document.getElementById('myModal')
		var myInput = document.getElementById('myInput')

		myModal.addEventListener('shown.bs.modal', function() {
			myInput.focus()
		})
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>