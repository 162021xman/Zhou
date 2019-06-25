$(document).ready(function() {
	$("#submit2").click(function(e) {
		$.ajax({
			url : "http://localhost:8080/del/" + $('#submit2').data('id'),
			// 按照url来将文本内容传过去，url服务器的地址
			type : "get",
			dataType : "json",
			success : function(result) {//
				if (result.success) {
					window.location.reload();
//					$("#submit2").parent("td").parent("tr").remove();
				}
			}
		});
	});

});