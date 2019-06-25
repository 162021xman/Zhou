function ajax(min){
	var ppath=window.location.pathname;
	var rep=/^[A-Za-z0-9]{6,15}$/;//在Css内规定长度为（6，15）
	var $s=$(min).siblings("input");
	var oldps=$s[0].value;
	var newps=$s[1].value;
	if(rep.test(oldps)&&rep.test(newps))
		if(oldps==newps)
			$.ajax({
        url: "http://localhost:8080/Loginwuye",
        type:"Post",
        data:{"oldps":oldps,"newps":newps},
        datatype:"String",
        success:function(data){
        	alert(data);
        },
        error:function(data){
        	alert("fail");
        }
    });
		else
	alert("密码不一样");
	else
		alert("格式不正确");

}
function  checktext() {	
	var rep=/^[A-Za-z0-9]{6,15}$/;//在Css内规定长度为（6，15）
	var $j=$("#submit-login").siblings("input");
	if(rep.test($j[0].value)&&rep.test($j[1].value)){
   return true;
	}	
	alert("不符合格式请重新输入");
	return false; 

}