$(function() {
    // 左侧导航分类选中样式
    $(".panel-body .accordion-body>ul").on('click', 'li', function() {
        $(this).siblings().removeClass('super-accordion-selected');
        $(this).addClass('super-accordion-selected');

        //新增一个选项卡
        var tabUrl = $(this).data('url');
        var tabTitle = $(this).text();
        //tab是否存在
        if($("#tt").tabs('exists', tabTitle)) {
            $("#tt").tabs('select', tabTitle);
        } else {
            var content = '<iframe scrolling="auto" frameborder="0"  src="' + tabUrl + '" style="width:100%;height:99%;"></iframe>';
            $('#tt').tabs('add', {
                title: tabTitle,
                //content: content,
                href: tabUrl,
                closable: true
            });
        }
    });
    
    // 设置按钮的下拉菜单
	$('.super-setting-icon').on('click', function() {
		$('#mm').menu('show', {
			top: 65,
			left: document.body.scrollWidth
		});
	});
	
    // 退出系统
    $("#logout").on('click', function(){
    	$.messager.confirm('提示','确定要退出?',function(r){
            if (r){
                progressLoad();
                $.post(basePath + '/logout', function(result) {
                    if(result.success){
                        progressClose();
                        window.location.href= basePath;
                    }
                }, 'json');
            }
        });
    });

    $.ajaxSetup({
        complete:function(XMLHttpRequest,textStatus){
            if(textStatus=="parsererror"){
                $.messager.alert('提示信息', "登陆超时！请重新登陆！", 'info',function(){
                    window.location.href = 'login';
                });
            } else if(textStatus=="error"){
                $.messager.alert('提示信息', "请求超时！请稍后再试！", 'info');
            }
        }
    })
});
