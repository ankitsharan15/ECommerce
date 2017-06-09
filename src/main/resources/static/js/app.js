var myApp = angular.module('myApp', ["ngRoute"]);

myApp.controller('myCtrl', function ($scope,$location,$rootScope,orderDetails,searchRepository) {	
      $rootScope.cartCount = 0;
      $rootScope.localCart = JSON.parse(localStorage.getItem('session'));
      $rootScope.cartCollection = [];
      $rootScope.clickedProduct;
      //$rootScope.cart.set('1','Oppo')
      if($rootScope.cartCollection.size<=0){
    }
  $('.modal').modal();
  $rootScope.go = function ( path ) {
  $location.path( path );

  }
  $scope.searchProducts = function(){
	  var seachText = $('#search').val();
	  console.log(seachText);
	  searchRepository.search(seachText).then(function(data){
		  $rootScope.Products = data;
      });
  }
      $scope.emailSubmit = function () {
      if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#email').val())){
    	  $('#email_modal').modal('close'); 
    	  var emailForOrderDetails = $('#email').val(); 
    	  $rootScope.emailForOrderDetails="";
    	  $rootScope.emailForOrderDetails = emailForOrderDetails;
    	  $rootScope.orderdata;
          orderDetails.getUserOrders(emailForOrderDetails).then(function(data){
        	  $rootScope.orderdata = data;
          });
          var abc;
          abc = $rootScope.orderdata;
    	  console.log(abc);
          $scope.go('/orders')  
         
         
      }
      else{
          alert('You have entered wrong email address');
      }
      

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

myApp.directive('a', function() {
    return {
        restrict: 'E',
        link: function(scope, elem, attrs) {
            if(attrs.href === '#email_modal'||attrs.href === '#email_modal1'){
                elem.on('click', function(e){
                    e.preventDefault();
                });
            }
        }
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
    .when("/orders", {
        templateUrl : "Templates/orders.html",
        controller: 'orderController'
    })
    .when("/cart", {
        templateUrl : "Templates/cart.html",
        controller: 'cartController'
    });
});

myApp.controller('homeController', function($scope,$rootScope) {
	  $('.carousel.carousel-slider').carousel({fullWidth: true});           
           
});

myApp.controller('productController', function($scope,$rootScope,userRepository) {
    $('ul.tabs').tabs();
    $('ul.tabs').tabs('select_tab', 'tab_id');
    $scope.getAllProducts=function(){
          userRepository.getByCategory().success(function(data) {
           $rootScope.Products = data.product;
        });
      }
});

myApp.controller('listController', function($scope,userRepository,$rootScope,productRepository) {
    $rootScope.clickedProduct="";
    $rootScope.getViaCategory=function(x){
         $scope.selectedCategory = x ;
         var product = $scope.selectedCategory;
          userRepository.getByCategory(product).success(function(response) {
           console.log('response'+response);
           $scope.Products = response;
            
        });
      }
    $rootScope.addToCart = function(product) {
         if($rootScope.localCart){
         $rootScope.localCart.push(product) }
        else{
            $rootScope.localCart=[];
            $rootScope.localCart.push(product) 
        }
        localStorage.setItem('session', JSON.stringify($rootScope.localCart));
    } 
    $scope.goToProduct=function(product){
        	var productId = product.productCode;
        	productRepository.getByProduct(productId).success(function(data) {
        		$rootScope.productDetails = data.product;
        		$rootScope.specificationDetails = data.specification;;
        		$rootScope.merchantDetails = data.customMerchant;
        		$rootScope.specDetails = data.specList;
        		        		
            });

         $rootScope.go('/product');  

    }
    });

myApp.controller('cartController', function($scope,$rootScope,orderRepository) {
	$scope.currentDate = new Date();
	
 $('#email_modal1').modal();
	 $rootScope.deleteFromCart = function(x) {
          var i = $rootScope.localCart.indexOf(x);
          if(i!=-1){
              $rootScope.localCart.splice(i,1);
          }
          localStorage.setItem('session', JSON.stringify($rootScope.localCart));
		    }
		     $scope.emailSubmitCart = function () {
		    	 $scope.orderData= { 
		   			  "emailId":$('#emailForCart').val(),
		   			  "date"   : $scope.currentDate,
		   		      "productList": [{
		   					"productId": 544,
		   					"productName":"iphone",
		   					"merchantId": 4,
		   					"merchantName":"sai",
		   					"quantity": 1,
		   					"price":20001.0,
		   					"rating": 2.0,
		   					"reviews": "Nice",
		   					"imageUrl":"http://ecx.images-amazon.com/images/I/814lO6nm9vL._SL1500_.jpg"
		   		      }]
		   	  }
		    	 console.log('under email submit function');
		      console.log('emailForCart',$('#emailForCart').val()); //email_id
		      if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#emailForCart').val())){
			         var currentOrder = $scope.orderData; 
			         console.log(currentOrder);
			         orderRepository.postByOrders(currentOrder);
		         $rootScope.go('/orders');
		         $('#email_modal1').modal('close');

		      }
		      else{
		          alert('You have entered wrong email address');
		     }

		     }
             var emailSend = $rootScope.emailForOrderDetails;
		     
			  
     // var currentOrder = $scope.orderData;    
			  
	 /* $scope.saveOrder = function(){
		  if ($scope.flag == 1){
		   orderRepository.postByOrders(currentOrder);
		  }
	  }   */  

});
myApp.controller('orderController',function($scope,$rootScope){
	
    
});