layui.use('element', function() {
	var element = layui.element;
	var $=layui.jquery;
	element.on('nav(test)',function(elem){
		title=elem.find('cite').text();
		if(title==""){
			return;
		}
		url=elem.attr('_href');
		for(var i=0;i<$('.em-iframe').length;i++)
		{
			if($('.em-iframe').eq(i).attr('src')==url){
				element.tabChange('em-tab',i);
				return;
			}
			
		}
		res=element.tabAdd('em-tab',{
			title:title,
			content:'<iframe src="'+url+'" frameborder="0" class="em-iframe" style="width:100%;height:532.68px;"></iframe>',
			id:$('.layui-tab-title li').length
		})
		element.tabChange('em-tab',$('.layui-tab-title li').length-1);
		$('.layui-tab-title li').eq(0).find('i').remove();
	})
});
		
		