layui.config({
	base : '../ext/', // 模块目录
}).extend({
	soulTable : 'soulTable' // 模块别名
});

layui.use('element', function() {
	var element = layui.element;
	var $ = layui.$;
});
layui.use([ 'soulTable' ], function() {
	var table = layui.table;
	var $ = layui.$;
	// 第一个实例
	var myTable = table.render({
		elem : '#demo',
		id : 'init',
		height : 470,
		page :true,
		method : "post",
		title : '用户数据表'

		,
		cols : [ [ // 表头

		{

			field : 'employeeno',
			title : 'ID',
			width : 90,
			sort : true,

		}, {
			field : 'employeename',
			title : '姓名',
			width : 80
		}, {
			field : 'sex',
			title : '性别',
			templet : "<div>{{d.sex =='F' ? '女' : '男'  }}</div>",
			width : 80,
			sort : true
		}, {
			field : 'department',
			title : '所属部门',
			width : 140,
			filter : true
		}, {
			field : 'headship',
			title : '职务',
			width : 80,
			filter : true
		}, {
			field : 'hiredate',
			title : '入职时间',
			templet : "<div>{{layui.util.toDateString(d.hiredate, 'yyyy-MM-dd')}}</div>",
			width : 140,
			sort : true,

		}, {
			field : 'salary',
			title : '薪水',
			width : 80,
			sort : true,
			filter : true

		}, {
			field : 'birthday',
			title : '生日',
			templet : "<div>{{layui.util.toDateString(d.birthday, 'yyyy-MM-dd')}}</div>",
			width : 140
		}, {
			field : 'address',
			title : '家庭住址',
			width : 135
		}, {
			field : 'telephone',
			title : '联系方式'
		}, {
			fixed : 'right',
			title : '操作',
			toolbar : '#barDemo',
			width : 150
		} ] ],
		filter : {
			bottom : false
		},
		request : {

		},
		done : function(res, curr, count) {
			layui.soulTable.render(this)
		}
	});

	table.on('tool(test)', function(obj) {
		var data = obj.data;
		var $ = layui.$;
		// console.log(obj)
		if (obj.event === 'del') {
			layer.confirm('真的删除行么', function(index) {
				obj.del();

				$.ajax({
					type : "POST",
					url : "../employeeDeleteServlet",
					data : {
						employeeno : data.employeeno
					},
					dataType : "json",
					success : function(res) {
						alert("删除成功");
					}
				})

				layer.close(index);
			});
		} else if (obj.event === 'edit') {
			layer.open({
				type : 2,
				title : '编辑员工信息',
				area : [ '650px', '300px' ],
				offset : '150px',
				btn: ['确认修改'],
				shadeClose : true,
				shade : 0.4,
				maxmin : true,
				content : 'empdetails.html',
				success : function(layero, index) {
					let body = layer.getChildFrame('body', index);
					body.find("#employeeno").val(data.employeeno);
					// body.find("#employeename").val(data.employeename);
					// body.find("#sex").val(data.sex);
					body.find("#department").val(data.department);
					body.find("#headship").val(data.headship);
					body.find("#salary").val(data.salary);
					// body.find("#address").val(data.address);
					// body.find("#birthday").val(data.birthday);
					// body.find("#telephone").val(data.telephone);
					layui.form.render();
				},
				yes : function(index, layero) {
					let body = layer.getChildFrame('body', index);
					body.find("#edit-emp-form").submit();
					obj.update({

						
						department : body.find("#department").val(),
						headship : body.find("#headship").val(),
						salary : body.find("#salary").val(),
							

					});

					layer.close(index);
				}
			})

		}
	});

	var active = {
		reload : function() {
			
			$.ajax({
				url : '../employeeServlet',
				type : 'POST',
				data:{
					'employeeno':$('#sid').val(),
					'stime':$('#stime').val(),
					'etime':$('#etime').val()
					
				},
				dataType : 'json',
				success : function(res) {
					
					myTable.reload({
						data : res.data
					})
				},

			})
			// 执行重载
			/*table.reload('init', {
				
				
				where : {
					id : sid.val(),
					stime : stime.val(),
					etime : etime.val()
				}
			});*/
		}
	};

	$('.demoTable .layui-btn').on('click', function() {
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});

	layui.use('laydate', function() {
		var laydate = layui.laydate;

		// 常规用法
		laydate.render({
			elem : '#stime'

		});
		laydate.render({
			elem : '#etime'
		});
	});
	
	$.ajax({
		url : '../employeeServlet',
		type : 'post',
		dataType : 'json',
		success : function(res) {
			
			myTable.reload({
				data : res.data
			})
		},

	})

});