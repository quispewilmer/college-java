<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register a teacher</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Teacher's form</h1>
		<form method="POST" action="TeacherServlet">
			<fieldset>
				<legend>Data section</legend>
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
					<label for=age class="form-label">Age</label> <input type="number"
						class="form-control" id="age" aria-describedby="age" name="age">
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
							aria-describedby="gender" value="male" name="gender"> <label
							for="male">Male</label>

					</div>
					<div class="form-check">
						<input type="radio" class="form-check-input" id="female"
							aria-describedby="gender" value="female" name="gender"> <label
							for="female">Female</label>
					</div>
				</div>
				<div class="mb-3">
					<label for="birthday" class="form-label">Birthday</label> <input
						type="date" class="form-control" id="birthday"
						aria-describedby="birthday" name="birthday">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</fieldset>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>