<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>


    </div>
</div>
<table id="dg"></table>

<script>
    //搜索提交表单
    function searchForm() {
        $('#dg').datagrid('load',{
            title:$('#title').val(),
            status:$('#status').combobox('getValue')
        });
    }

    function add(){
        ddshop.addTabs('新增商品','item-add');
    }

    function edit(){
        console.log('edit');
    }

    function up(){
        var selections = $('#dg').datagrid('getSelections');
        if(selections.length==0){
            $.messager.alert('提示','请选择至少一条记录!','warning');
            return;
        }

        //确认框，第一个参数为标题，第二个参数确认框的提示内容，第三参数是一个确认函数
        //function(r) 如果用户点击的是"确定"，那么r=true
        $.messager.confirm('确认','您确定要将该条记录状态改成上架吗?',function (r) {
            if(r){
                //存放id的集合
                var ids = [];
                //遍历选中的记录,将记录的id存放到js数组中
                for(var i=0;i<selections.length;i++){
                    ids.push(selections[i].id);
                }

                $.post(
                    'items/up',
                    {'ids[]':ids},
                    function (data) {
                        $('#dg').datagrid('reload');//页面自动刷新,且停在当前页
                    },
                    'json'

                );

            }
        });

    }

    function down(){
        var selections = $('#dg').datagrid('getSelections');
        if(selections.length==0){
            $.messager.alert('提示','请选择至少一条记录!','warning');
            return;
        }

        //确认框，第一个参数为标题，第二个参数确认框的提示内容，第三参数是一个确认函数
        //function(r) 如果用户点击的是"确定"，那么r=true
        $.messager.confirm('确认','您确定要将该条记录状态改成下架吗?',function (r) {
            if(r){
                //存放id的集合
                var ids = [];
                //遍历选中的记录,将记录的id存放到js数组中
                for(var i=0;i<selections.length;i++){
                    ids.push(selections[i].id);
                }

                $.post(
                    'items/down',
                    {'ids[]':ids},
                    function (data) {
                        $('#dg').datagrid('reload');//页面自动刷新,且停在当前页
                    },
                    'json'

                );

            }
        });

    }

    function remove(){
        var selections = $('#dg').datagrid('getSelections');
        if(selections.length==0){
            $.messager.alert('提示','请选择至少一条记录!','warning');
            return;
        }

        //确认框，第一个参数为标题，第二个参数确认框的提示内容，第三参数是一个确认函数
        //function(r) 如果用户点击的是"确定"，那么r=true
        $.messager.confirm('确认','您确定要删除该条记录吗',function (r) {
            if(r){
                //存放id的集合
                var ids = [];
                //遍历选中的记录,将记录的id存放到js数组中
                for(var i=0;i<selections.length;i++){
                    ids.push(selections[i].id);
                }

                $.post(
                    'items/remove',
                    {'ids[]':ids},
                    function (data) {
                        $('#dg').datagrid('reload');//页面自动刷新,且停在当前页
                    },
                    'json'

                );

            }
        });

    }


    $('#dg').datagrid({
        //多列联合查询
        multiSort:true,
        //将工具栏添加到数据库表格中
        toolbar: '#toolbar',
        url: 'items',//请求远程服务器上的URL http://localhost:8080/ddshop/items
        striped: true,//斑马线效果
        pagination: true,//显示分页工具栏
        fit: true,//使得数据表格自适应填充父容器
        rownumbers: true,//显示行号
        pageSize: 20,
        pageList: [20, 50, 100],
        columns: [[
            {field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 120, sortable: true},
            {field: 'title', title: '商品名称', width: 100, sortable: true},
            {field: 'sellPoint', title: '卖点', width: 200},
            {field: 'catName', title: '商品类别', width: 100},
            {field: 'price', title: '价格', width: 100, formatter:function (value) {
                var num = value/100;
                return num.toFixed(2);
            }},
            {field: 'status', title: '状态', width: 50, formatter: function (value) {
                switch (value) {
                    case 1:
                        return '正常';
                        break;
                    case 2:
                        return '下架';
                        break;
                    case 3:
                        return '删除';
                        break;
                    default:
                        return '不明';
                        break;
                }
            }
            },
            {field: 'created', title: '创建时间', formatter: function (value) {
                return moment(value).format('YYYY年MM月DD日 hh:mm:ss');

            }},
            {field: 'updated', title: '更新时间', formatter: function (value) {
                return moment(value).format('YYYY年MM月DD日 hh:mm:ss');

            }},
        ]]
    });

</script>
