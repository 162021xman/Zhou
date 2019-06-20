//当需要提交的是密码时设置<input type="password">
$(document).ready(function (){
	$("input[name='password']").attr("type","password");
});
function ajax(min){
	var ppath=window.location.pathname;
	var rep=/^[A-Za-z0-9]{6,15}$/;//在Css内规定长度为（6，15）
	var phone=/^[0-9]{11}$/;
	var $s=$(min).siblings("input");
	var ownerid=$s[0].value;
	var ownername=$s[1].value;
	var ownertel=$s[2].value;
	var password=$s[3].value;
	if(rep.test(ownerid)&&rep.test(ownerpassword))
		if(phone.test(ownertel))
			$.ajax({
        url: "http://localhost:8080"+ppath+"M",
        type:"Post",
        data:{"ownerid":ownerid,"ownername":ownername,"ownertel":ownerte,"password":password},
        datatype:"String",
        success:function(data){
        	alert(data);
        },
        error:function(data){
        	alert("fail");
        }
    });
		else
	alert("电话号码不正确");
	else
		alert("格式不正确");

}