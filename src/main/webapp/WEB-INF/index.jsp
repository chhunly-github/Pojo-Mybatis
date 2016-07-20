<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home | Page</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
	<script src="/resources/js/angular.min.js"></script>
	<script src="/resources/js/javascript.js"></script>
	<script src="/resources/sweetalert-master/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/sweetalert-master/dist/sweetalert.css">
	<link rel="stylesheet" type="text/css" href="/resources/font-awesome/css/font-awesome.min.css">
</head>
<body ng-app="studentApp">
	<div class="container" ng-controller="StudentCtrl">
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>gender</th>
					<th>score</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="st in students">
					<td>{{st.id}}</td>
					<td>{{st.name}}</td>
					<td>{{st.gender}}</td>
					<td>{{st.score}}</td>
					<td>
						<button >delete</button>
						<button>Update</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>