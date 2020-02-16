<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
</head>
  	<style type="text/css">

	     .layui-table-cell {
            height: 100%;
            max-width: 100%;
	   }
	   </style>
<body>
 
<table class="layui-hide" id="test"></table>

 		<table class="layui-table" >
				  <colgroup>
				    <col width="150">
				    <col width="200">
				    <col>
				  </colgroup>
				  <thead>
				    <tr>
				      <th>商品ID</th>
				      <th>商品名称</th>
				      <th>价格</th>
				      <th>参考图</th>
				      <th>种类</th>
				      <th>简介</th>
				      <th>描述</th>
				   
				      <th>操作</th>
				    </tr> 
				  </thead>
	
				   
				  <tbody>

				   <form action="addgoods.action" method="post"  " name="form" enctype="multipart/form-data">
				   			
				  	<tr>
					  	
					  		<td><label ><h4>添加商品</h4></label></td>
					      <td><input type="text" name="goodsname" required="required"></td>
					      <td><input type="text" name="gprice" required="required"></td>
					      <td><input type="file" name="file"></td>
					      <td><input type="text" name="sort" required="required"></td>
					      <td><input type="text" name="intro" required="required"></td>
					      <td><textarea type="text" name="descri" required="required"></textarea></td>
					      <td><button  type="submit" >添加</button></td>
					
					      
					    </tr> 
				 </form>
			
				<c:forEach items="${goodslist }" var="goods">    
					<tr>
				      <td>${goods.id }</td>
				      <td>${goods.name }</td>
				      <td>${goods.price }</td>
				      <td><img src="${goods.img }" width="300" height="364"></td>
				      <td>${goods.sort}</td>
				      <td>${goods.intro }</td>
				      <td>${goods.description }</td>
				      <td><a href="goodsdelete.action?goodsid=${goods.id }">删除</a></td>
				    </tr>
				 </c:forEach>
				  
				  </tbody>
	
				</table>

              
          
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
 
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    	 , url : '/project/goodsservlet'
    ,cols: [[
    	
         {field: 'id', title: 'ID', minWidth:60,width:60, align:"center",sort: true},
 　　　　 { field: 'img', title: '图片预览',width:120, sort: false,style:'height:100px;', templet:function (d) {
                 return  '<div> <img layer-pid="图片id，可以不写"  layer-src="/images/bug-success-bg.jpg" src="'+d.img+'" alt="图片	"></div>'
             }
         },
         {field: 'name', title: '名称',edit: 'text',  minWidth:50, align:'center'},
         {field: 'price', title: '价格',edit: 'text', width:60, align:'center',sort: true},
         {field: 'intro', title: '简介',edit: 'text', minWidth:100,width:130, align:'center',sort: true},
         {field: 'sort', title: '种类',edit: 'text', width:100,minWidth:100, align:'center',sort: true},
         {field: 'description', title: '描述',edit: 'text', edit: 'text', minWidth:100, align:'center',sort: true},

         {title: '操作', minWidth:175,align:"center",templet:function (f) {
             return  '<a href="goodsdelete.action?goodsid='+f.id+'">删除</a>'
         } }
    ]]
 
   
  });

  
});
</script>

</body>
</html>