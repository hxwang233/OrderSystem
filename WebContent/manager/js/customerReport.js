layui.use('element', function(){
	var element = layui.element;
	var $=layui.jquery;
	element.on('nav(test)',function(elem){
		title=elem.find('cite').text();
		$.ajax({
			url : "../EchartServlet",
			type : "post",
			data : {
				search : title
			},
			dataType : "json",
			success : function(res) {

				if (title=="客户分布") {
					var dom = document.getElementById("main");
					var myChart = echarts.init(dom, 'westeros');
					var app = {};
					option = null;
					option = {
						title : {
							text : title,
							x : 'center'
						},
						tooltip : {
							trigger : 'item',
							formatter : "{a} <br/>{b} : {c} ({d}%)"
						},
						legend : {
							orient : 'vertical',
							left : 'left',
							data : res 
						},
						series : [ {
							name : '客户分布',
							type : 'pie',
							radius : '55%',
							center : [ '50%', '60%' ],
							data : res,
							itemStyle : {
								emphasis : {
									shadowBlur : 10,
									shadowOffsetX : 0,
									shadowColor : 'rgba(0, 0, 0, 0.5)'
								}
							}
						} ]
					};

					app.currentIndex = -1;

					setInterval(function() {
						var dataLen = option.series[0].data.length;
						// 取消之前高亮的图形
						myChart.dispatchAction({
							type : 'downplay',
							seriesIndex : 0,
							dataIndex : app.currentIndex
						});
						app.currentIndex = (app.currentIndex + 1) % dataLen;
						// 高亮当前图形
						myChart.dispatchAction({
							type : 'highlight',
							seriesIndex : 0,
							dataIndex : app.currentIndex
						});
						// 显示 tooltip
						myChart.dispatchAction({
							type : 'showTip',
							seriesIndex : 0,
							dataIndex : app.currentIndex
						});
					}, 1000);
					;
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

$(function() {
	// 文档就绪事件
	
});
*/