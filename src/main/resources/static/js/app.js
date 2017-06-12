var app = angular.module('app', ["ngRoute"]);
app.controller('Ctrl', function ($scope,$location,$rootScope,orderDetails,productsRepository,userRepository,searchRepository) {	
     
  $rootScope.localCart = JSON.parse(localStorage.getItem('session'));
  
  $('.modal').modal();
  $rootScope.go = function ( path ) {
  $location.path( path );
  }
  $rootScope.searchProducts = function(){
	  $rootScope.seachText = $('#search').val();
      console.log('search initiated');
	  $rootScope.searchData=searchRepository.search($rootScope.seachText).success(function(data) {
        		$rootScope.searchData=data;
        		        		
            });
      console.log('searchData',$rootScope.searchData);
      $rootScope.go('/search');
  }
  $rootScope.getViaCategory=function(categorisedData){
         $rootScope.selectedCategory = categorisedData ;
         var product = $rootScope.selectedCategory;
         userRepository.getByCategory(product).success(function(response) {
           $scope.Products = response;   
        });
      $rootScope.go('/list')
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
          $rootScope.go('/orders');            
      }
      else{
          Materialize.toast('Wrong Email ID', 4000,'rounded')
      }
};
    $rootScope.goToProduct=function(product){
        	var productId = product.productCode;
            console.log('productId',productId);
            productsRepository.getByProduct(productId).success(function(data) {
        		$rootScope.productDetails = data.product;
                console.log('productDetails',$rootScope.productDetails);
        		$rootScope.specificationDetails = data.specification;
        		$rootScope.merchantDetails = data.customMerchant;
        		$rootScope.specDetails = data.specList;
        		        		
            });
         $rootScope.go('/product'); 

    }
$('.carousel').carousel({

padding : 200

});

autoplay()

function autoplay() {
    $('.carousel').carousel('next');
    setTimeout(autoplay, 4500);
}
});

app.directive('ngEnter', function() {
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

app.directive('a', function() {
    return {
        restrict: 'E',
        link: function(scope, elem, attrs) {
            if(attrs.href === '#email_modal'||'#email_modal1'){
                elem.on('click', function(e){
                    e.preventDefault();
                });
            }
        }
   };
}); 
app.config(function($routeProvider) {
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
    })
    .when("/rate",{
        templateUrl : "Templates/rate.html",
        controller: 'rateController'
    })
    .when("/search",{
        templateUrl:"Templates/search.html",
        controller:'searchController'
    })
});

app.controller('homeController', function($scope,$rootScope,userRepository) {
	  $('.carousel.carousel-slider').carousel({fullWidth: true});
    userRepository.getByCategory('phone').success(function(data) {
           $scope.phones = data;
        });
    userRepository.getByCategory('fashion').success(function(data) {
           $scope.fashion= data;
        });
           
});

app.controller('productController', function($scope,$rootScope,productsRepository) {
    $('ul.tabs').tabs();
    $('ul.tabs').tabs('select_tab', 'tab_id');
    $scope.getAllProducts=function(){
          productsRepository.getByCategory().success(function(data) {
           $rootScope.Products = data.product;

        });
      }
});

app.controller('listController', function($scope,productsRepository,$rootScope) {
    $rootScope.addToCart = function(product,merchantDetails,index) {
      /*  for(var merhantIndex=0;merchantIndex<merchantDetails.length;merchantDetails++){
            
        } */
        //console.log('merchant',merchant,'index',index);
        //console.log('merchant product merchant',merchant[index].productMerchant.price);
        //console.log('merchant product merchant id',merchant.productMerchant[0].productmerchantid);
         if($rootScope.localCart){
       /*  var prodMerchant='{\"productId\":\"'+product.productCode+'\",\"productName\":\"'+product.productName+'\",\"merchantId\":\"'+merchant.productMerchant.productmerchantid.merchantId+'\",\"imageUrl\":\"'+product.productImage+'\"}'
        // console.log('prodMerchant',prodMerchant); */
         $rootScope.localCart.push(product) }
        else{
            $rootScope.localCart=[];
            $rootScope.localCart.push(product) 
        }
        localStorage.setItem('session', JSON.stringify($rootScope.localCart));
    } 
    
    });

app.controller('cartController', function($scope,$rootScope,orderRepository) {
    if($rootScope.localCart.length==0){
      $('.cartHeader').hide();
  }
    else{
        $('.emptyCart').hide();
    }
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

                 
		    	// console.log('under email submit function');
		     // console.log('emailForCart',$('#emailForCart').val()); //email_id
		      if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#emailForCart').val())){

			         var currentOrder = $scope.orderData; 
			          //console.log(currentOrder);
			         orderRepository.postByOrders(currentOrder);
		             $rootScope.go('/rate');
                     $rootScope.localCart=[];
                     localStorage.setItem('session', JSON.stringify($rootScope.localCart));
		             $('#email_modal1').modal('close');

		      }
		      else{
		          Materialize.toast('Wrong Email ID', 4000,'rounded')
		     }
                //console.log('order quantity',$('#quantity').val(),'rating',$('#rating').val(),'review',$('#review').val())

		     }
             var emailSend = $rootScope.emailForOrderDetails;		  
	  $scope.saveOrder = function(){
		  if ($('#review').val()==""){
           $('#review').val("OK");
		  }
	  }   

});
app.controller('orderController',function($scope,$rootScope){
   
});

app.controller('rateController',function($scope,$rootScope){
    
});

app.controller('searchController',function($scope,$rootScope){
    
})