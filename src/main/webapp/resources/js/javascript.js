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
	
	$scope.delete=function(id){
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
					url:'/delete'+id,
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
});