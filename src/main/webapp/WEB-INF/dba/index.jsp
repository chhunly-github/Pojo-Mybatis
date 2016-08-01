<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home | Page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/sweetalert-master/dist/sweetalert.css">
	<link rel="stylesheet" type="text/css" href="/resources/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
	<script src="/resources/js/angular.min.js"></script>
	<script src="/resources/js/javascript.js"></script>
	<script src="/resources/js/jquery.min.js"></script>
	<script src="/resources/sweetalert-master/dist/sweetalert.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
</head>
<body ng-app="studentApp">
	<h1>Welcome, dba!</h1>
	<div class="container" ng-controller="StudentCtrl">
		<div>
			<button ng-click="manipulate('បញ្ចូល','បញ្ចូលទិន្នន័យថ្មី','insert','')" class="btn btn-success" data-toggle="modal" data-target="#input-modal">បន្ថែមទិន្នន័យថ្មី</button>
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
							<!-- <button ng-click="deleteStudent(st.id)">delete</button> -->
							<button ng-click="manipulate('កែប្រែ','កែប្រែទិន្នន័យ','update',st)" data-toggle="modal" data-target="#input-modal" class="btn btn-info"><i class='fa fa-pencil' aria-hidden='true'></i></button>
							<button ng-click="deleteStudent(st.id)" class="btn btn-danger"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="modal fade" id="input-modal" role="dialog">
			<div class="modal-dialog">

			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">{{manipulateComment}}</h4>
					</div>
					<div class="modal-body" >
						<form action="" name="input" novalidate>
							<table id="studentInputTable" class="table">
								<tr>
									<td><label class="form-label">ឈ្មោះ</label></td>
									<td><input type="text" ng-model="name" placeholder="meymey" class="form-group form-control" value="name" id="input-name" ng-pattern="/^[a-zA-Z]*$/"></td>
								</tr>
								<tr>
									<td><label class="form-label">ភេទ</label></td>
									<td><select  ng-model="gender" class="form-group form-control" id="input-gender">
											<option value="male">Male</option>
											<option value="female">Female</option>
										</select>
									</td>
								</tr>
								<tr>
									<td><label class="form-label">ពិន្ទុ</label></td>
									<td><input type="text" ng-model="score" placeholder="19"  class="form-group form-control" value="score" id="input-score" ng-pattern="/^[0-9]{1,2}$/" required=""></td>
								</tr>
							</table>
							<input type="button" value={{manipulateType}} ng-click="doManipulate()" class="form-group form-control btn-success" ng-disabled=" !name || !gender || !score || input.score.$error.pattern || input.name.$error.pattern || input.gender.$error.pattern ">
							<h1></h1>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>