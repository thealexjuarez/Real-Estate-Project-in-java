<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>${setClient.firstName}'s Profile</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.4/examples/cover/">

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css"
	rel="stylesheet">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="cover.css" rel="stylesheet">
</head>


<body class="text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Claim's Real Estate Site.</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="/">Home</a>
				</nav>
			</div>
		</header>

		<div class="container">
			<div class="card">
				<img src="assets/images/charlie.jpg" alt="Person" height="100px"
					width="100px" class="card__image"> <strong>Name</strong>
				<div class="card_name">${setClient.firstName}
					${setClient.lastName}</div>
				<strong>Email</strong>

				<div class="grid-child-posts">${setClient.email}</div>
				<strong>Phone Number</strong>
				<div class="grid-child-followers">${setClient.phoneNumber}</div>
			</div>
		</div>
		
		<main role="main" class="inner cover">
			<c:if test="${scheduled != null }">
				<h2 class="cover-heading">${setClient.firstName}'s Purchased Houses</h2>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Course ID</th>
							<th scope="col">Course Name</th>
							<th scope="col">Professor</th>
							<th scope="col">Start Date</th>
							<th scope="col">Start Time</th>
						</tr>
					</thead>
					<c:forEach items="${scheduled }" var="schedule">
						<tr>
							<td><c:out value="${schedule.course.courseId }"></c:out></td>
							<td><c:out value="${schedule.course.courseName }"></c:out></td>
							<td><c:out value="${schedule.course.professor }"></c:out></td>
							<td><c:out value="${schedule.course.startDate }"></c:out></td>
							<td><c:out value="${schedule.course.startTime }"></c:out></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<h2 class="cover-heading">Available Houses</h2>
			<c:if test="${courselist != null }">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Course ID</th>
							<th scope="col">Logo</th>
							<th scope="col">Course Name</th>
							<th scope="col">Start Date</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<c:forEach items="${courselist }" var="courses">
						<tr>
							<td><c:out value="${courses.courseId }"></c:out></td>
							<td><img alt="logo goes here" height="50px" width="70px"
								src="${courses.imagePath }"></td>
							<td><c:out value="${courses.courseName }"></c:out></td>
							<td><c:out value="${courses.startDate }"></c:out></td>
							<td><a href="addcourse?courseId=${courses.courseId }"><button
										class="btn draw-border">Details</button></a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</main>
		

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>A David Tsacnaris Works</p>
			</div>
		</footer>
	</div>


</body>
</html>


