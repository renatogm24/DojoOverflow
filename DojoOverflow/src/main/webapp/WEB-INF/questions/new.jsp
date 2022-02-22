<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Book</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-evenly">
			<div class="px-5 px-sm-0 col-sm-6 col-md-4 mb-5">
				<h2 class="text-center mb-3">What is your question?</h2>
				<div class="mx-auto">
					<form:form
						class="row g-2 justify-content-center bg-dark text-light py-4 px-3 rounded"
						action="/questions" method="post" modelAttribute="questionAux">

						<form:label for="question" path="question" class="form-label">Question:</form:label>
						<form:errors path="question" class="text-danger" />
						<form:input type="text" path="question" class="form-control" id="question" />
						
						<form:label for="listTags" path="listTags" class="form-label">Tags:</form:label>
						<form:errors path="listTags" class="text-danger" />
						<form:input type="text" path="listTags" class="form-control"
							id="listTags" />

						<button class="btn btn-primary mt-4" type="submit">Submit</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>