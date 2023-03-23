layui.use('element', function() {
	var element = layui.element;
	var $ = layui.jquery;
	element.on('nav(test)', function(elem) {
		title = elem.find('cite').text();
		$.ajax({
			url : "../EchartServlet",
			type : "post",
			data : {
				search : title
			},
			dataType : "json",
			success : function(res) {
				var n = new Array();
				for ( var i in res) {
					n[i] = res[i].name;
				}

				if (title == "近一周订单分布") {
					var dom = document.getElementById("main");
					var myChart = echarts.init(dom, 'westeros');
					var app = {};
					app.title = '坐标轴刻度与标签对齐';

					option = {
						color : [ '#3398DB' ],
						tooltip : {
							trigger : 'axis',
							axisPointer : { // 坐标轴指示器，坐标轴触发有效
								type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
							}
						},
						grid : {
							left : '3%',
							right : '4%',
							bottom : '3%',
							containLabel : true
						},
						xAxis : [ {
							type : 'category',
							data : n,
							axisTick : {
								alignWithLabel : true
							}
						} ],
						yAxis : [ {
							type : 'value'
						} ],
						series : [ {
							name : '订单量',
							type : 'bar',
							barWidth : '60%',
							data : res
						} ]
					};

					if (option && typeof option === "object") {
						myChart.setOption(option, true);
					}
				}

				if (title == "近一周订单交易额") {
					var dom = document.getElementById("main");
					var myChart = echarts.init(dom, 'westeros');
					var app = {};
					app.title = '坐标轴刻度与标签对齐';

					option = {
						xAxis : {
							type : 'category',
							data : n
						},
						yAxis : {
							type : 'value'
						},
						series : [ {
							data : res,
							type : 'line',
							smooth : true
						} ]
					};

					if (option && typeof option === "object") {
						myChart.setOption(option, true);
					}
				}

			},
			error : function() {
				alert("加载失败");
			}

		})
	})

});

/*
 * 
 * $(function() { // 文档就绪事件
 * 
 * });
 */