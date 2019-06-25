function  checktext(min) {	
	var rep=/^[A-Za-z0-9]{5,15}$/;//在Css内规定长度为（6，15）
	var $j=$(min).siblings("input");
	//alert($j[1].value);
	if(rep.test($j[1].value)){
		var datas={"id":$j[0].value,"password":$j[1].value};
		ajax("post",datas,"home2");
	}	
	else
	alert("不符合格式请重新输入"); 

}
function check(min){//测试输入不为空值
	var rep=/^[A-Za-z0-9]{5,15}$/;//在Css内规定长度为（6，15）
	var $j=$(min).siblings("input");
	if(rep.test($j[0].value)&&rep.test($j[1].value)){
		return true;
	}	
	else
	alert("不符合格式请重新输入"); 
	return false;
};
function ajax(method,datas,href){
	var ppath=window.location.pathname;
	$.ajax({
        url: "http://localhost:8080"+ppath+"M",
        type:method,
        data:JSON.stringify(datas),
        datatype:"json",
        contentType : "application/json;charset=utf8",
        //xhrFields: {withCredentials: true},
        success:function(data){
        	if(data!="error")
        	window.location.href=data;
        	else
        		alert("连接失败");
        },
        error:function(data){
        	alert("fail");
        }
    });
}
