layui.use(['form', 'layedit', 'laydate'], function(){
	var form=layui.form;
	var $=layui.$;
	form.verify({
		    title: function(value){
		      if(value.length < 5){
		        return '标题至少得5个字符啊';
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
	/*  form.on('submit(judge)', function(data){
		 
		    $.ajax({
		    	type: "POST",
	             url: "../employeeAUpdateServlet",
	             data: $('#edit-emp-form').serialize(),
	             //dataType: "json",
	             success:function(res){
	            	// consle.log(res);
	            	 alert("修改成功");
	             }
		    })
		    //return false;
		  });
  */
});
