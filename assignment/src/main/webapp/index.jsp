<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>
<head>
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
 <div class="content">

	    
	<!-- \Table -->
	<div class="card">
		<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<thead>
					<tr class="table-success">
						<th class="text-center" style="width: 10px">#</th>
						<th class="text-center" style="width: 10px">Mã món ăn</th>
						<th class="text-center" style="width: 10px">Tên món ăn</th>
						<th class="text-center" style="width: 10px">Mã danh mục món ăn</th>
						<th class="text-center" style="width: 10px">Mô tả</th>
						<th class="text-center" style="width: 10px">Ảnh đại diện</th>
						<th class="text-center" style="width: 10px">Giá</th>
						<th class="text-center" style="width: 10px">Ngày bán</th>
						<th class="text-center" style="width: 10px">Trạng thái</th>
						<th class="text-center" style="width:120px;">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty page}">
						<tr><td colspan="9" class="text-center text-none-data">Không có món ăn nào</td></tr>
					</c:if>
					<c:forEach var="item" items="${page}" varStatus="cnt">
						<tr>
						<th class="text-center">${item.id }</th>
						<th class="text-center">${item.code} </th>
						<th class="text-center">${item.name} </th>
						<th class="text-center">${item.categoryCode} </th>
						<th class="text-center">${item.description} </th>
						<th class="text-center"> <img height="50"  alt="" src="${item.imageUrl}"> </th>
						<th class="text-center">${item.price} </th>
						<th class="text-center">${item.starteddate} </th>
						<th class="text-center" >${item.status} </th>	
						<th class="text-center" >Add</th>						
						</tr> 
					</c:forEach>
				</tbody> 
			</table>
		</div>
	</div>
	<!-- /Table -->
</div>
</body>