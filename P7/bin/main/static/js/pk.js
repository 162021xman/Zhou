function ajax(min){
	var $s=$(min).siblings("input");
	var oldps=$s[0].value;
	var newps=$s[1].value;
	alert(oldps);
			$.ajax({
        url: "http://localhost:8080/addyuyue",
        type:"Post",
        data:{"kname":oldps,"kphone":newps},
        datatype:"String",
        success:function(data){
        	alert(data);
        },
        error:function(data){
        	alert("fail");
        }
    });

}