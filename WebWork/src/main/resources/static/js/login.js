function  checktext() {	
	var rep=/^[A-Za-z0-9]{6,15}$/;//在Css内规定长度为（6，15）
	var $j=$("#submit-login").siblings("input");
	if(rep.test($j[0].value)&&rep.test($j[1].value)){
   return true;
	}	
	alert("不符合格式请重新输入");
	return false; 

}
function getText(){//测试输入不为空值
	
};
function ajax(){
	$.ajax({
        url: "http://localhost:8080/login/"+$("#text1").val(),
        type:"get",
        datatype:"json",
        success:function(data){
        	$("#ch2").remove();
        	$("#content").append("<h2 id='ch2'>"+data.a+":"+data.s+"</h2>");
        },
        error:function(data){
        	alert("fail");
        }
    });
}