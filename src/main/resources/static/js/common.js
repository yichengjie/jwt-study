function Common (){
	
}
Common.saveLoginToken = function(val){
	window.sessionStorage.setItem("X-Access-Token",val) ;
}

Common.getLoginToken = function(){
	return window.sessionStorage["X-Access-Token"] ;
}