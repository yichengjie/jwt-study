$(function(){
	new Login().init() ;
});


function Login(){
	
}
Login.prototype.init = function(){
	var self = this ;
	$("#loginBtn").click(function(){
		self.login() ;
	}) ;
}

Login.prototype.getFormData = function(){
	var username = $("#username").val() ;
	var password = $("#password").val() ;
	return {"username":username,"password":password} ;
}

Login.prototype.login =function(){
	var formData = this.getFormData() ;
	var url = $("#contextPath").val() + "/api/login" ;
	$.ajax({
		contentType:'application/json' ,
	    type:"POST",
	    url:url,
	    dataType:"json",
	    data:JSON.stringify(formData) ,
	    //headers:{'Accept': 'application/json','Authorization':'Bearer '+ valToken},
	    success:function(data){
	    	if(data.token != undefined){
	    		alert('登录成功！') ;
	    		Common.saveLoginToken(data.token) ;
	    	}else{
	    		alert(data.message) ;
	    	}
	    },
	    error:function(jqXHR){
	        console.log("发生错误："+jqXHR.status);
	    }
	});
}

