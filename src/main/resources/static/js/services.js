//services for api  call
var myApp = angular.module('myApp');
myApp.factory('userRepository',function ($http){
   return {
        getByCategory:function(product){
           var url="/category/"+product;
           return $http.get(url);
       }
   };
});
myApp.factory('productRepository',function ($http){
	   return {
	        getByProduct:function(productId){
	           var url="/product/"+productId;
	           return $http.get(url);
	       }
	   };
	});
myApp.factory('orderRepository',function ($http){
	   return {
		      postByOrders:function(order){
	           var url="/orders/checkout";
	           return $http.post(url,order)
	       }
	   };
	});
myApp.factory('orderDetails',function ($http,$q,$log){
	   return {		      
		       getUserOrders:function(email){
		    	   var deferred = $q.defer();
		    	   var res;
		           var url="/orders/history";
		           $http.post(url,email)
		           .success(function(results) { 		        	  
		        	             deferred.resolve(
		        	            	 JSON.stringify(results)
		        	                );
		        	          }).error(function(msg, code) {
		        	             deferred.reject(msg);
		        	             $log.error(msg, code);
		        	          });
		        	        return deferred.promise;

	       }
	   };
});
myApp.factory('searchRepository',function ($http,$q,$log){
	   return {
		      search:function(searchQuery){
		       var deferred = $q.defer();
	           var url="/search";          	    	   
	           $http.post(url,searchQuery)
	           .success(function(results) { 		        	  
	        	             deferred.resolve(
	        	            	 JSON.stringify(results)
	        	                );
	        	          }).error(function(msg, code) {
	        	             deferred.reject(msg);
	        	             $log.error(msg, code);
	        	          });
	        	        return deferred.promise;
	       }
	   }
});	   
myApp.factory('merchantRepository',function ($http){
	   return {
		      merchantRating:function(rating){
			           var url="/merchant";
			           return $http.post(url,rating);
			      
	       }
	   }
});
