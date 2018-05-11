<!--左侧导航-->
<div class="easyui-accordion" data-options="border:false,fit:true,selected:true">
	<#list menuLists as menulist>
	<div title="${menulist.name}" data-options="iconCls:'fa fa-${menulist.icon}'">
        <ul>
        	<#list menulist.children as item>
        	<li data-url='${item.url}'><i class="fa fa-${item.icon}"></i>${item.name}</li>
        	</#list>
        </ul>
    </div>
	</#list>
</div>