$(document).ready(function(){
	//html 문서를 text로 읽기
	$('#test1').click(function(){
		//alert('a');
		$('#disp1').empty();
		//$('#disp1').load("jq4.html"); //비동기 방식
		$('#disp1').hide().load("jq4.html",function(){
			$(this).fadeIn(); //effect 처리
		});
		//$('#disp1').animate(,2000);
	});
	
	//json 읽기
	$('#test2').click(function(){
		$.getJSON('jq4json.jsp', function(datas){//json 전용 객체
		$('#disp2').empty();
			//alert(datas);//[object Object]
			//$('#disp2').text(datas);
			let items = [];
			let str = "<ul>";
			$.each(datas.sangpum,function(index, data){
				//alert(index);
				//alert(data); //[object Object],[object Object],[object Object],[object Object]
				let s ="<li>"+(index + 1)+" )"+data["code"]+" "
				 +data["sang"]+" "
				 +data["su"]+" "
				 +data.dan+" </li>"
				items.push(s);
			});
			str += items.join('')+ "</ul>";
			
			$('#disp2').html(str);
		});
		
		//xml 읽기
		$('#test3').click(function(){
			//alert('a');
			$.get('jq4xml.jsp', function(datas){
			//$.post('jq4xml.jsp', function(datas){
				//alert(datas);
				//alert($(datas).find('sangpum').length); //하위 element(요소)를 검색할 때 find()
				$('#disp3').empty();
				$(datas).find('sangpum').each(function(){
					let sangpum = $(this);
					let str = "<div>";
					str+= sangpum.find('code').text() +" ";
					str+= sangpum.find('sangirum').text() +" ";
					str+= sangpum.find('su').text() +" ";
					str+= sangpum.find('danga').text();
					str +="</div>";
					$('#disp3').append(str);
				});
			}).faill(function(){
				$('#disp3').text('test3 처리 오류');
			});
		});
		
		//json 읽기
		$('#test4').click(function(){
			$('#disp4').empty();
			$.ajax({
				type:"get", //요청방식
				url:"jq4json.jsp",
				//data:{'code':3, 'sang':'book'}, //jq4json.jsp?code=3&sang=book;
				dataType:"json", // 반환타입
				success:function(datas){
					//alert(datas);
					$('#disp4').empty();
					let str="";
					let count =0;
					str += "<table border ='1'>";
					str +="<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
					$.each(datas.sangpum, function(idx, data){
						str +="<tr>";
						str +="<td>"+ data["code"]+ "</td>";
						str +="<td>"+ data["sang"]+ "</td>";
						str +="<td>"+ data["su"]+ "</td>";
						str +="<td>"+ data["dan"]+ "</td>";
						str +="</tr>";
						count++;
					});
					str +="</table>";
					$("#disp4").append(str);
					$("#disp4").append(`건수 : ${count}개`);				
				},error:function(){
					$('#disp4').text('test3 처리 오류');
				}
			});
		});
		
		//xml 읽기
		$('#test5').on('click',function(){
			$.ajax({
				type:"post", //요청방식
				url:"jq4xml.jsp",
				dataType:"xml", // 반환타입
				success:function(datas){
					//alert(datas);
					$('#disp5').empty();
					
					let count =0;
					let str = "<table border ='1'>";
					str +="<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
					$(datas).find('sangpum').each(function(){
						str +="<tr>";
						str +="<td>"+ $(this).find("code").text()+ "</td>";
						str +="<td>"+ $(this).find("sangirum").text()+ "</td>";
						str +="<td>"+ $(this).find("su").text()+ "</td>";
						str +="<td>"+ $(this).find("danga").text()+ "</td>";
						str +="</tr>";
						count++;
					});
					str +="</table>";
					$("#disp5").append(str);
					$("#disp5").append(`건수(xml) : ${count}개`);				
				},error:function(){
					$('#disp5').text('test3 처리 오류');
				}
			});
			
		});
	})
});