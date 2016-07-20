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
});