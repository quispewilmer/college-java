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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>