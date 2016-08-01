/**
 * 
 */
var app=angular.module('studentApp', []);

app.controller('StudentCtrl', function ($scope, $http) {
	$scope.get=function () {
		$http({
			url:'/student',
			method:'get'
		})
		.then(function (response) {
			$scope.students=response.data;
			console.log(response);
		}, function (response) {
			 /* body... */ 
		});
	}
	$scope.get();
	
	$scope.deleteStudent = function(id){
		swal({
			  title: "តើអ្នកពិតជាចង់លុបមែនទេ?",
			  text: "អ្នកនឹងមិនអាចទាញយកមកវិញទេ",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonColor: "#DD6B55",
			  confirmButtonText: "លុប",
			  cancelButtonText: "មិនលុប",
			  closeOnConfirm: false,
			  closeOnCancel: false
			},
			function(isConfirm){
			  if (isConfirm) {
			  	$http({
					url:'/delete/'+id,
					method:"delete"
				})
				.then(function (response) {
					$scope.get();
				}, function (response) {
					 /* body... */ 
				});
				swal("បានលុប!", "ទិន្នន័យត្រូវបានលុប.", "success");
			  } else {
				    swal("មិនលុប", "ទិន្នន័យមិនត្រូវបានលុប", "error");
			  }
			});
	}
	$scope.update=function(){
		var data = JSON.stringify({id: $scope.DataElement.id,name : $scope.name, gender : $scope.gender, score:$scope.score});
		console.log(data);
		swal({
		  title: "តើអ្នកពិតជាចង់កែប្រែមែនទេ?",
		  text: "អ្នកនឹងមិនអាចត្រលប់ទិន្នន័យវិញទេ",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#DD6B55",
		  confirmButtonText: "កែប្រែ",
		  cancelButtonText: "បោះបង់",
		  closeOnConfirm: false,
		  closeOnCancel: false
		},
		function(isConfirm){
		  if (isConfirm) {
		  	$http.put('/updatestudent',data)
			.then(function sucess(response) {
				// body...
				$scope.get();
			});
			swal("បានកែប្រែ!", "ទិន្នន័យត្រូវបានកែប្រែ.", "success");
		  } else {
			    swal("មិនបានកែប្រែ", "ទិន្នន័យមិនត្រូវបានកែប្រែ", "error");
		  }
		});
		
	}
	$scope.insert=function(){

		var data = JSON.stringify({name:$scope.name, gender:$scope.gender, score:$scope.score});
		console.log(data);
		$http/*.post({
			url:'/addstudent',
			method:'POST',
			data:{
				id:0,
				name:$scope.name,
				gender:$scope.gender,
				score:$scope.score
			}
		})*/.post('/addstudent/',data)
		.then(function sucess(response) {
			$scope.get();
			swal("បានសំរេច!", "ទិន្នន័យត្រូវបានបញ្ចូល.", "success");
		},
		function error(element) {
			// body...
		});
	}
	$scope.doManipulate=function() {
		if($scope.operation=='update'){
			$scope.update();
		}
		else{
			$scope.insert();
			$scope.name='';
			$scope.gender='';
			$scope.score='';
		}
	}
	$scope.manipulate=function(Type,Comment,operation,element){
		$scope.manipulateComment=Comment;
		$scope.manipulateType=Type;
		$scope.DataElement=element;
		console.log($scope.DataElement);
		$scope.operation=operation;
		
		$scope.name=element.name;
		$scope.score=element.score;
		$scope.gender=element.gender;
		
		//$('#input-name').val(element.name);
		//$('#input-score').val(element.score);
		//$('#input-gender').val(element.gender);
	}
});