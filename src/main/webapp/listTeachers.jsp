<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Teacher's list</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>
	<div class="container py-4">
		<div class="card">
			<div class="card-header">
				<h1 class="text-center">Teacher's list</h1>
			</div>
			<div class="card-body">
				<a class="btn btn-primary" href="/teacher/new" role="button">Register
					teacher</a>

				<table class="teachers-table table my-4">
					<thead class="teachers-table__head">
						<tr>
							<th>ID</th>
							<th>firstName</th>
							<th>lastName</th>
							<th>email</th>
							<th>age</th>
							<th>money</th>
							<th>phone</th>
							<th>gender</th>
							<th>birthday</th>
							<th>operations</th>
						</tr>
					</thead>
					<tbody class="teachers-table__body">
						<c:forEach items="${teachersList}" var="row">
							<tr class="teachers-table__info teacher-row">
								<td class="teacher-row__id">${row.id}</td>
								<td class="teacher-row__firstName">${row.firstName}</td>
								<td class="teacher-row__lastName">${row.lastName}</td>
								<td class="teacher-row__email">${row.email}</td>
								<td class="teacher-row__age">${row.age}</td>
								<td class="teacher-row__money">${row.money}</td>
								<td class="teacher-row__phone">${row.phone}</td>
								<td class="teacher-row__gender">${row.gender}</td>
								<td class="teacher-row__birthday">${row.birthday}</td>
								<td class="teacher-row__operations">
									<a href="/teachers/edit?id=${row.id}" class="btn btn-primary" name="action"
										value="UPDATE" id="update-teacher">Update</a>
									<a href="/teachers/delete?id=${row.id}" class="btn btn-primary" name="action"
										value="DELETE" id="delete-teacher">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		if (window.history.replaceState) {
			window.history.replaceState(null, null, window.location.href);
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>