	

layui.config({
	base : '../ext/', // 模块目录
}).extend({
	soulTable : 'soulTable' // 模块别名
});

layui.use('element', function() {
	var element = layui.element;
});

layui.use([ 'soulTable' ], function() {
	var table = layui.table;
	
	var $=layui.$;
	
	// 第一个实例
	var myTable=table.render({
		elem : '#demo',
		id : 'init',
		height : 470,
		method : "post",
		title : '用户数据表',
		limit : 10,
		page : true,
		where : {
			"search" : 1
		},
		cols : [ [ // 表头
		{

			field : 'logid',
			title : 'LogID',
			width : 90,
			sort : true,

		}, {
			field : 'tablename',
			title : '表名',
			width : 80,
			filter : true
		}, {
			field : 'operation',
			title : '操作',
			width : 80,
			sort : true,
			filter : true
		}, {
			field : 'information',
			title : '详情',
			width : 140,

		}, {
			field : 'operatingtime',
			title : '时间',
			templet : "<div>{{layui.util.toDateString(d.hiredate, 'yyyy-MM-dd')}}</div>",
			width : 140,
			sort : true,
			
		}, {
			field : 'operatorname',
			title : '操作者',
			width : 100,
			sort : true,
			filter : true

		} ] ],
		 filter: {
			 bottom: false
		  },
		request : {

		},
		done : function(res, curr, count) {
			layui.soulTable.render(this)
		}
	});
	table.on('sort(demo)', function (obj) {
	    myTable.reload({
	        initSort: obj,
	        data: obj.type ? layui.sort(curData.concat(), obj.field, obj.type === 'desc'): curData
	    })
	})
	$.ajax({
			url : '../logServlet',
			
			dataType : 'json',
			success : function(res) {
				myTable.reload({
					data : res.data
				})
			},
			
	})

});