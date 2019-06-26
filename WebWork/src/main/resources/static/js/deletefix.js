function del(min){
	var $ownerid=$(min).parent().siblings("td[name='ownerid']");
	
	$.ajax({
        url: "http://localhost:8080/DeleteFixM",
        type:"post",
        data:{"rid":$ownerid.text()},
        datatype:"string",
        success:function(data){
        	alert(data);
        	if(data.trim()!="fail"){        	
        		$ownerid.parent("tr").remove();
        	}
        	
        	
        },
        error:function(data){
        	alert("fail");
        }
    });
}