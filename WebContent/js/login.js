/**
 * login.js
 * aabbcczhy 2019.3.26 19:54
 */

$(function () {
	//登录身份判断
	$('#login_btn').click(function() {
		if($('#u').val()==""){
			alert("用户名不能为空");
			return false;
		}
		if($('#p').val()==""){
			alert("密码不能为空");
			return false;
		}
		var url = null;
		var identity = $('input:radio[name="identity"]:checked').val();
		if(identity=='manager'){
			url = 'ManagerLoginServlet';
		}else if(identity=='comment'){
			url = 'CommentLoginServlet';
		}
		$.post({
			url:url,
			data:{
				"userid":$('#u').val(),
				"password":$('#p').val()
			},
			success:function(res){
				if(res=="fail"){
					alert("用户名或密码输入错误");
					$('#p').val('');
				}else{
					$('#loginform').attr('action',url);
					$('#loginform').submit();
				}
			}
		})
	});
	//重新获得焦点，输入框颜色恢复
	$('.inputstyle').click(function(){
		$(this).removeClass('input-error');
		$('.info').css('display','none');
	});
});