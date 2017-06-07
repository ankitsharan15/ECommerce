var myApp = angular.module('myApp', ["ngRoute"]);

myApp.controller('myCtrl', function ($scope,$location,$rootScope) {	
      $rootScope.cartCount = 0;
      $('.modal').modal();
      $scope.go = function ( path ) {
      $location.path( path );
    }; 

    

});

myApp.config(function($routeProvider) {
    $routeProvider
    .when("/home", {
        templateUrl : "Templates/home.html",
        controller: 'homeController'
    })
    .when("/product", {
        templateUrl : "Templates/product.html",
        controller: 'productController'
    })
    .when("/list" ,{
        templateUrl: "/Templates/list.html",
        controller: 'listController'
        
    })

    .when("/cart", {
        templateUrl : "Templates/cart.html",
        controller: 'cartController'
    });
});

myApp.controller('homeController', function($scope,$rootScope) {
	  $('.carousel.carousel-slider').carousel({fullWidth: true});           
            $rootScope.addToCart = function() {
        $rootScope.cartCount++;
      };
});

myApp.controller('productController', function($scope,userRepository) {
    $scope.getAllProducts=function(){
          userRepository.getByCategory().success(function(data) {
           $scope.Products = data.product;
        });
      }
});

myApp.controller('listController', function($scope,userRepository,$rootScope) {

    $rootScope.getViaCategory=function(x){

         $scope.selectedCategory = x ;
         var product = $scope.selectedCategory;
          userRepository.getByCategory(product).success(function(response) {
           console.log('response'+response);
           $scope.Products = response;
        });
      }
    $rootScope.addToCart = function() {
        console.log('cart', $rootScope.cartCount)
        $rootScope.cartCount++;
    };   
});

myApp.controller('cartController', function($scope,$rootScope,orderRepository) {
	  $scope.testData={
               "emailId": "neelasha@gmail.com",
				"date": 1496595243861,
				"productList": {
					"productId": 234,
					"merchantId": 11,
					"quantity": 1,
					"rating": 2.0,
					"reviews": "Nice"
				}
			}
	  var test = $scope.testData;
	  $rootScope.testPost = function(){
		  orderRepository.postByOrders(test).success(function(){
				 console.log("successfully sent"); 
			  });  
	  }

});
