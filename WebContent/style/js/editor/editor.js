var post_count=0;
var article_count=0;
$(function(){
	$(".goBack").click(function(){
		$(this).attr("href",_path+"/index.do");
	})
	
	$('#cat_post .remove').each(function(){
		$(this).click(function(){
			var catalogId = $(this).siblings().text();
			$.post(_path+"/admin/removeCatalog",{catalogId:catalogId});
			alert("删除成功");
			refresh();
		})
	})
	
	$('#art_post .remove').each(function(){
		$(this).click(function(){
			var catalogId = getUrlParam("catalogId");
			var articleTitle =$(this).siblings().text();
			var articleContent = $('.art_content').val();
			$.post(_path+"/admin/removeArticle",{catalogId:catalogId,articleTitle:articleTitle});
			alert("删除成功");
			refresh();
		})
	})
	
	$('[name="catList"]').hover(function(){
		var catalogId = $(this).children().children(".catalogId").text();
		$(this).children().attr("href",_path+"/admin/editor"+"?catalogId="+base64_encode(catalogId));
	})
	
	$('.each_art_title').each(function(){
		var art_title = $(this).text();
		var catalogId = getUrlParam("catalogId");
		$(this).click(function(){
			$.ajax({
				async:false,
				dataType:"xml",
				type:"post",
				data:{catalogId:catalogId,articleTitle:art_title},
				cache:false,
				url:_path+"/admin/mains",
				error:function(){
					alert("请求失败");
				},
				success:function(datas){
					var root = $(datas).find("root");
					var artt = root.children("artt").text();
					var artct =root.children("artct").text();
					$('.art_title').attr("value",artt);
					$('.art_content').val(artct);
				}
			})
			
		})
	})
	
	$('#cat_cmds').click(function(){
		post_count = post_count+1;
		if(post_count>1){
			alert("建议一次添加一个目录");
		}
		else{
			$('.cat_save').before("<li name='new_post_li' id='new_post_li'><a data-bind='click: edit, event:{touchend: edit}' href='#' class='post' id='new_cat_post'> <input type='text' placeholder='目录名' class='new_post_Id'><input type='text' class='new_categories' placeholder='分类名'><span data-bind='click: remove' class='remove' id='removeCatalog' onclick='removeCatalog()'>x</span></a></li>");
		}
	 })
	
	$('#art_cmds').click(function(){
		article_count = article_count+1;
		if(article_count>1){
			alert("建议一次添加一篇文章");
		}
		else{
			var catalogId = getUrlParam("catalogId");
			if(catalogId==null){
				alert("请选择所存目录");
			}
			else{
				$('.art_save').before("<li name='artList' class='art_post'><a data-bind='click: edit, event:{touchend: edit}' href='#' id='art_post' class='new_art_post'> <input type='text' placeholder='文章名' class='new_post_title' onchange='saveArticle2Local()'><span data-bind='click: remove' class='remove' id='removeArticle' onclick='removeArticle()'>x</span></a></li>");
			}
		}
	})
	
	$('.new_post_title').change(function(){
		alert($(this).val());
		$('.art_title').attr("value",$(this).val());
	});
	
	$("#cat_save").click(function(){
		var new_post = $(".new_post").val();
		var new_categories = $(".new_categories").val();
		if(new_post=""||new_categories!=""){
			var catalogId = $(".new_post_Id").val();
			var categories = $(".new_categories").val();
			$.post(_path+"/admin/addCatalog",{catalogId:catalogId,categories:categories});
			alert("保存成功！");
			post_count = 0;
			refresh();
		}
		else{
			alert("目录名或分类不能为空！");
		}
	})
	
	$("#art_save").click(function(){
		if($(".posts").hasClass("new_post_title") && $('.new_post_title').val()==null){
			alert("请选择新建");
		}
		else{
			var catalogId = base64_decode(getUrlParam("catalogId"));
			var articleTitle = $('.art_title').val();
			var articleContent = $('.art_content').val();
			$.post(_path+"/admin/addArticle",{catalogId:catalogId,articleTitle:articleTitle,articleContent:articleContent});
			article_count = 0;
			alert("添加文章成功");
			$(".art_post").addClass("art_list");
			$(".art_post").removeClass("art_post");
			$(".new_art_post").addClass("post");
			$(".new_art_post").removeClass("new_art_post");
			$(".new_span").addClass("each_art_title");
			$(".new_span").removeClass("new_span");
		}
	})
	
//	$(".art_list").each(function(){
//		$(this).click(function(){
//			$(this)
//		})
//	})
	
	var nicesx = $('.cat_controls').niceScroll({
					touchbehavior:false,
					cursorcolor:"#3FA7CB",
					cursoropacitymax:1.6,
					cursorwidth:8,
					horizrailenabled:false,
					cursorborderradius:0,
					autohidemode:false
					});
	var nicesx = $('.article_controls').niceScroll({
		touchbehavior:false,
		cursorcolor:"#3FA7CB",
		cursoropacitymax:1.6,
		cursorwidth:8,
		horizrailenabled:false,
		cursorborderradius:0,
		autohidemode:false
		});
})

function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null){
            	return unescape(r[2]);
            }
            else{
            	return null; //返回参数值
            }
	}

function refresh(){
	window.location.reload();
}

function getUrl(){
	window.location.href;
}
function removeCatalog(){
	$('#new_post_li').remove();
	post_count = 0;
}

function removeArticle(){
	$('.art_list').remove();
	refresh();
}

function saveArticle2Local(){
	var new_post_title = $('.new_post_title').val();
	$('.new_post_title').remove();
	$('.new_art_post').append('<span data-bind="text: title" class="new_span"></span>');
	$('.new_span').text(new_post_title);
	$('.art_title').attr("value",new_post_title);
	$('.art_content').val("");
	
}
