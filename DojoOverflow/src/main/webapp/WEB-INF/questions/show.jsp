<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show book</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<div class="container justify-center">
		<h1 class="text-danger">${question.getQuestion()}</h1>
		<div class="d-flex">
			<h4>Tags</h4>
			<div class="d-flex mx-3">
			<c:forEach var="tag" items="${question.getTags()}">
			<a class="btn btn-sm btn-primary mx-2" style="width:100px;" href="#">${tag.getSubject()}</a>			
			</c:forEach>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Answers</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="answer" items="${question.answers}">
					<tr>
						<td> <c:out value="${answer.getAnswer()}" /></td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2 class="text-center mb-3">Add your answer!</h2>
		<div class="mx-auto">
			<form:form
				class="row g-2 justify-content-center bg-dark text-light py-4 px-3 rounded"
				action="/questions/addAnswer" method="post" modelAttribute="answerAux">	
				
				<form:input type="hidden" path="question" value="${question.getId()}" />
				
				<form:label for="answer" path="answer" class="form-label">Answer:</form:label>
				<form:errors path="answer" class="text-danger" />
				<form:input type="text" path="answer" class="form-control" id="answer" />
				
				<button class="btn btn-primary mt-4" type="submit">Answer</button>
			</form:form>
		</div>

	</div>
</body>
</html>