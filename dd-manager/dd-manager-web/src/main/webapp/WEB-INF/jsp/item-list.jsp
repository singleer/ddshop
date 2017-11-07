<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="dg"></table>


<script>
    $('#dg').datagrid({
        url: 'items',//请求远程服务器上的URL http://localhost:8080/ddshop/items
        striped: true,//斑马线效果
        pagination: true,//显示分页工具栏
        fit: true,//使得数据表格自适应填充父容器
        rownumbers: true,//显示行号
        pageSize: 10,
        pageList: [10, 15, 20],
        columns: [[
            {field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 100},
            {field: 'catName', title: '商品类别', width: 100},
            {field: 'title', title: '商品名称', width: 100},
            {field: 'sellPoint', title: '卖点', width: 200},
            {field: 'price', title: '价格', width: 100, align: 'right'}
        ]]
    });

</script>
