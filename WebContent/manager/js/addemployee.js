layui.use('laydate', function(){
				  var laydate = layui.laydate;
				  
				  //常规用法
				  laydate.render({
				    elem: '#birthday'
				   
				  });

});

layui.use(['form', 'layedit', 'laydate'], function(){
	var form=layui.form;
	var $=layui.$;
	form.verify({
		   	 name: function(value){
		      if(value.length == 0){
		        return '姓名不能为空哦';
		      }
		    }
		    ,pass: [
		      /^[\S]{6,12}$/
		      ,'密码必须6到12位，且不能出现空格'
		    ]
		    ,content: function(value){
		      layedit.sync(editIndex);
		    }
		  });
	  form.on('submit(judge)', function(data){
		    
		    $.ajax({
		    	type: "POST",
	             url: "../employeeInsertServlet",
	             data: $('#edit-emp-form').serialize(),
	             dataType: "json",
	             success:function(res){
	            	 consle.log(res);
	            	 alert("添加成功");
	             }
		    })
		    
		  });
  
});
