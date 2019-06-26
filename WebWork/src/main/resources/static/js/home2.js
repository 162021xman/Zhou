function select(min){
	var ownerid=$(min).parent().siblings("input[name='ownerid']").val();
	var rep=/^[A-Za-z0-9]{5,15}$/;
	if(rep.test(ownerid)){
	$.ajax({
        url: "http://localhost:8080/SelectAllownersM",
        type:"get",
        data:{"ownerid":ownerid},
        datatype:"json",
        success:function(data){
        	$("#message").siblings().remove();
        	for(var i=0;i<data.length;i++){
        		
        		$("#table").append("<tr>"+"<td name='ownerid'>"+data[i].ownerid+"</td>"+
        				"<td>"+data[i].ownername+"</td>"+"<td>"+data[i].ownertel+"</td>"
        				+"<td><a href='Updateowner'>修改</a>"+"</td>"+"<td><button onclick='del(this)'>删除</button></td>"+
        				"</tr>");
        	}
        	
        }
        ,//window.location.href="",
        error:function(data){
        	alert("fail");
        }
    });
	}
	else
		alert("不符合格式");
}
function del(min){
	var $ownerid=$(min).parent().siblings("td[name='ownerid']");
	alert($ownerid.text());
	$.ajax({
        url: "http://localhost:8080/DeleteownerM",
        type:"post",
        data:{"ownerid":$ownerid.text()},
        datatype:"string",
        success:function(data){
        	$ownerid.parent("tr").remove();
        	alert(data);
        },
        error:function(data){
        	alert("fail");
        }
    });
}
function policy(){
	
}