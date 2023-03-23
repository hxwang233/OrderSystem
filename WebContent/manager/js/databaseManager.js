var filename = "";
var path;
var fpath;

$(document).on('click','#up',function(){
	  $.ajax({
			url : "../FileServlet",
			type:'POST',
			data:{
				'path':path,
				'fpath':fpath,
				'filename':filename
			},
			//dataType : 'json',
			success : function(res) {
				alert("正在还原");
				setTimeout(function(){
				    alert('还原成功');
				    },1000);
			},
			
	})
})
$(document).on('click','#down',function(){
	  $.ajax({
		  	type:'POST',
			url : "../FileServlet",
			//dataType : 'json',
			success : function(res) {
				alert("正在备份");
				setTimeout(function(){
				    alert('备份成功');
				    },1000);
			},
			
	});
})

layui.use('upload','element', function(){
  var upload = layui.upload;
  //var $=layui.$;


});
function getFile() {
	$("#getF").click();
}

function clickF() {
	var tt = $("#getF").val();
	path=$("#getF").val();
	var filenames = tt.split("\\");
	filename = filenames[filenames.length - 1];
	fpath=tt.substring(0,tt.length-(filename.length+1));
	//console.log(path);
	//console.log(fpath);
	$("#lb").text(filename);
};


