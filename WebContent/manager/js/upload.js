
layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
  upload.render({
	    elem: '#test8'
	    ,url: '/upload/'
	    ,auto: false
	    ,accept: 'file' 
	    //,multiple: true
	    ,bindAction: '#test9'
	    ,done: function(res, index, upload){
	      console.log(res)
	    }
	  });
  
})