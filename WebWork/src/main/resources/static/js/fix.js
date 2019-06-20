function ajax(min){
	var ppath=window.location.pathname;
	var rid=$("#rid").val();
	var fixms=$("#fixms").val();
	var fixtype=$("#fixtype").val();
			$.ajax({
        url: "http://localhost:8080"+ppath+"M",
        type:"Post",
        data:{"rid":rid,"fixms":fixms,"fixtype":fixtype},
        datatype:"String",
        success:function(data){
        	alert(data);
        },
        error:function(data){
        	alert("fail");
        }
    });

}