angular.module('webshop', [])
	.controller('loginCtrl', ['$scope','ServiceUser', function($scope, ServiceUser) {
		$scope.user = {};
		$scope.validateLogin; 
		$scope.showLoginForm = false;
		$scope.showLogoutBtn = false;
		$scope.login = function(){
			var user;
			user = angular.copy($scope.user);
			ServiceUser.login(user).then(function(response){
				var loginResponse = response.data;
				console.log(loginResponse);
				if(loginResponse.status) {
					$scope.showLoginForm = false;
					$scope.validateLogin = loginResponse.message + ". Welcome " + user.username;
					$scope.showLogoutBtn = true;
				} else {
					$scope.validateLogin = loginResponse.message;
					console.log(loginResponse.message);
				}
			});
		};
		$scope.logout = function(){
			ServiceUser.logout().then(function(response){
				$scope.showLoginForm = true;
				$scope.showLogoutBtn = false;
				$scope.user = {};
				$scope.validateLogin = '';
			});
		};
			
	}])
	.controller('productsCtrl', ['$scope', 'ServiceProduct', function($scope, ServiceProduct){
		$scope.products = [];
		$scope.showProductsTable = false;
		$scope.shoppingCart = [];
		$scope.showShoppingCart = false;
		$scope.total;
		$scope.user = {};
		
		$scope.user.name = "";
		$scope.user.surname = "";
		$scope.user.card_no = "";
		
		$scope.submitForm = {};
		
		$scope.showProducts = function() {
			$scope.showProductsTable = true;
			$scope.products = ServiceProduct.getAll().then(function(response){
				$scope.products = response.data;
			});
		}
		
		$scope.buyProducts = function(){
			var products = $scope.products;
			var total = 0;
			
			console.log($scope.products);
			//$scope.products = [];
			
			
			for(var i = 0; i < products.length; i++) {
				console.log(products[i]);
				if(products[i].count > 0) {
					$scope.shoppingCart.push(products[i]);
					total += products[i].price * products[i].count;
				}
			};
			
			
			
			$scope.showShoppingCart = true;
			$scope.total = total;
			
			$scope.submitTransaction = function(){
				$scope.user.card_no = parseInt($scope.user.card_no);
				console.log($scope.user);
				ServiceProduct.verifyUser($scope.user).then(function(response){
					if(response.data.status) {
						ServiceProduct.submitTransaction($scope.shoppingCart);
						$scope.shoppingCart = [];
					}
					
					window.alert(response.data.message);
				});
								
			};
		}
		
	}])
	.factory('ServiceUser', ['$http', function($http) {
		var service = {};
		
		service.login = function(user) {
			return $http.post('http://localhost:8080/WebShop/rest/user', user);
		}
		service.logout = function() {
			return $http.get('http://localhost:8080/WebShop/rest/user');
		}
		
		return service;
	}])
	.factory('ServiceProduct', ['$http', function($http) {
		var service = {};
		
		service.getAll = function(){
			return $http.get('http://localhost:8080/WebShop/rest/product');
		}
		
		service.verifyUser = function(user){
			return $http.post('http://localhost:8080/WebShop/rest/user/verifyuser', user);
		}
		
		service.submitTransaction = function(shoppingCart){
			return $http.post('http://localhost:8080/WebShop/rest/transaction',shoppingCart);
		}
		
		return service;
	}]);

