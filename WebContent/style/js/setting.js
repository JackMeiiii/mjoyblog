$(function(){		
 			
 	$('[name="pure-menu-list"] li').each(function(){		
 		$('.pageName').text('全局');		
 		$(this).click(function(){		
 			$('.pageName').text($(this).text());		
 		})		
 	});
 	$('.blog_name').change(function(){		
 		var blog_name=$('.blog_name').val();
 		$.post(_path+"/admin/updateBlogName.do",{val:blog_name});
 		$('title').text(blog_name);
 	});
 	if (errorMsg.length != 0) {		
 		alert(errorMsg);		
 	};
 })