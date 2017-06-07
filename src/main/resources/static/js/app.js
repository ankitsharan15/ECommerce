var myApp = angular.module('myApp', ["ngRoute"]);

myApp.controller('myCtrl', function ($scope,$location,$rootScope) {	
      $rootScope.cartCount = 0;
      $rootScope.cart=new Map();
      $rootScope.cart.set('1','Oppo')
      if($rootScope.cart.size<=0){
        $('.numberCircle').hide();
    }
  $('.modal').modal();
    $('.modal').modal({
      dismissible: false, 
    })
  $rootScope.go = function ( path ) {
  $location.path( path );$scope.emailSubmit = function () {
      console.log('email',$('#email').val()); //email_id
      if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#email').val())){
         $scope.go('/orders')  
         $('#email_modal').modal('close'); 
      }
      else{
          $("#email").next("label").attr('data-error','Wrong');
          alert('You have entered wrong email address');
      }
      
};
    }; 

    

});

myApp.directive('ngEnter', function() {
        return function(scope, element, attrs) {
            element.bind("keydown keypress", function(event) {
                if(event.which === 13) {
                    scope.$apply(function(){
                        scope.$eval(attrs.ngEnter, {'event': event});
                    });

                    event.preventDefault();
                }
            });
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
           
});

myApp.controller('productController', function($scope,userRepository) {
    $('ul.tabs').tabs();
    $('ul.tabs').tabs('select_tab', 'tab_id');
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
    $rootScope.addToCart = function(productName) {
        console.log('cart', productName)
         $('.numberCircle').show();
            $rootScope.cartCount++;
    };   
});

myApp.controller('cartController', function($scope,$rootScope,orderRepository) {
	 $rootScope.deleteFromCart = function() {
		    $rootScope.cart.delete('1'); //delete by key -> ProductID
		    if($rootScope.cartCount>0){
			   $rootScope.cartCount--;
		    }}
		     $scope.emailSubmit = function () {
		      console.log('emailForCart',$('#email').val()); //email_id
		      if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#emailForCart').val())){
		         $rootScope.go('/orders')  
		         $('#email_modal').modal('close'); 
		      }
		      else{
		          alert('You have entered wrong email address');
		      }

		     }      
	  $scope.testData= { 
			  "emailId": "neelasha@gmail.com",
			  "date"   : "1496595243861",
		      "productList": [{
					"productId": 234,
					"merchantId": 11,
					"quantity": 1,
					"rating": 2.0,
					"reviews": "Nice"
		      },{
					"productId": 235,
					"merchantId": 12,
					"quantity": 2,
					"rating": 5.0,
					"reviews": "Very Nice"
		    	  
		      }]
	  }
	  var test = $scope.testData;
	  $rootScope.testPost = function(){
		  orderRepository.postByOrders(test);
	  }


});
myApp.controller('orderController',function($scope){
    
});