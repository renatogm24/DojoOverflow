<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container my-3">
		<div class="d-flex justify-content-between">
			<div class="d-flex flex-column">
				<h3>Questions Dashboard</h3>			
			</div>
			<div class="d-flex flex-column">
				
			</div>
		</div>
		<div class="my-3">
			<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="question" items="${questions}">
					<tr>
						<td><a href="/questions/${question.getId()}"><c:out
									value="${question.getQuestion()}" /></a></td>
						<td><c:out value="${question.makeListTags()}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-sm btn-primary" href="/questions/new">New Question</a>
		</div>
	</div>
</body>
</html>