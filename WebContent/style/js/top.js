/*初始化*/
$(function(){
	$('.space a').each(function(){
		$(this).hover(function(){
			$(this).css("border-bottom","solid red 1px");
		},function(){
			$(this).css("border-bottom","none");
		})
	})
})