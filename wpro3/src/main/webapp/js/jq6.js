$(document).ready(function(){
	$("#btnSearch").click(function(){
		$("#show").empty();
		$("#showCount").empty();
		
		let bname = $("#bname").val();
		
		$.ajax({
			type:"get",
			url:"jq6json.jsp",
			data:{"bname":bname},
			dataType:"json",
			success:function(datas){
				let str = "<table border='1'>";
				str +="<tr><th>사번</th><th>직원명</th><th>직급</th><th>관리고객</th></tr>";
				let count =0;
					//alert(data);
				
				$.each(datas, function(idx,entry){
					str +="<tr>";
					str +="<td>" + entry["jikwon_no"]+"</td>";
					//alert(typeof(entry["jikwon_gogek"])); //String
					if(Number(entry["jikwon_gogek"]) ===0){
					str +="<td>" + entry["jikwon_name"]+"</td>";						
					}else{
						str +="<td><a href='javascript:func(" + entry["jikwon_no"]+")'>"+
						entry["jikwon_name"]+"</a></td>";
					}
					str +="<td>" + entry["jikwon_jik"]+"</td>";
					str +="<td>" + entry["jikwon_gogek"]+"</td>";
					str +="</tr>";
					count++;
				});
				str +="</table>";
				$("#show").append(str);
				$("#showCount").append(count);
			},
			error: function(){
				$('#showCount').text('all 처리 오류');
			}
		});
	});
	
})
function func(para){
	//alert('a');
	$("#gogek").empty();
	$.ajax({
			type:"get",
			url:"jq6gogek.jsp",
			data:{"arg":para},
			dataType:"json",
			success:function(datas){
				let str = "<table border='1'>";
				str +="<tr><th>고객명</th><th>고객번호</th></tr>";
				let count =0;
					//alert(data);
				
				$.each(datas, function(idx,entry){
					str +="<tr>";
					str +="<td>" + entry["gogek_name"]+"</td>";
					str +="<td>" + entry["gogek_tel"]+"</td>";
					str +="</tr>";
					count++;
				});
				str +="</table>";
				$("#gogek").append(str);
			},
			error: function(){
				$('#show').text('all 처리 오류');
			}
		});
}