$(function(){
	new Index().init() ;
}) ;

function Index(){
	
}

Index.prototype.init = function(){
	var url = $("#contextPath").val() +"/api/getMessage" ;
	$("#req1").click(function(){
		var token = Common.getLoginToken() ;
		$.ajax({
		    type:"GET",
		    url:url,
		    headers:{'Accept': 'application/text','X-Access-Token':token},
		    success:function(data){
		    	console.info(data) ;
		    },
		    error:function(jqXHR){
		        console.log("发生错误："+jqXHR.status);
		    }
		});
		
	}) ;
}