<html>
<head>
	<script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
	<script>
		$(function(){
			$("#btn").click(function(){
//				$.getJSON('validTest', function(data){
//					alert(data)
//				});
				$.ajax({
					type:"POST",
//					url:"http://1.xiaoye2016.applinzi.com/login/valid",
					url:"validTest",
					contentType:"application/json;charset=utf-8",
					data:'{"account":"admin","password":"admin"}',
					success:function(json){
						alert(json);
					}
				});
			})
		});
	</script>
</head>
<body>
	<input id="btn" type="button" value="test"/>
</body>
</html>