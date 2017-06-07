//services for api  call
var myApp = angular.module('myApp');
myApp.factory('userRepository',function ($http){
   return {
        getByCategory:function(product){
           var url="category/"+product;
           return $http.get(url);
       }
   };
});
