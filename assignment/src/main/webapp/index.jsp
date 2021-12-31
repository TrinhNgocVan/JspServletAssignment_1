<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>
<head>
</head>
<body>
 <div class="content">
	<form id="barnForm"  action="/assignment/dishs"  method="post">
	<!-- \Searching -->
	<div class="card">
		<div class="card-body">
			<div class="row">
				<div class="col-md-8 offset-md-2"><input class="form-control" type="text" name="code" value="" placeholder="Enter keyword..."/></div>
				<div class="col-md-2"><button type="submit" class="btn btn-secondary"> <i class="icon-search4"></i>Search</button></div>
	    	</div>
    	</div>
    </div>
    <!-- /Searching -->	 
       
	<!-- \Table -->
	<div class="card">
		<div class="card-header header-elements-inline">
			<span class="text-uppercase font-size-lg font-weight-bold">Danh sách món ăn tại nhà hàng </span>		
			<div class="header-elements">
				<div class="list-icons">					
					<a href="<c:url value='./dish/form'/>" class="btn btn-sm btn-primary" title="Thêm mới món ăn "><i class="icon-plus22"></i>Thêm mới món ăn</a>              	
               	</div>
        	</div>     
		</div>
		<div class="card-body">Danh sách món ăn</div>
		<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<thead>
					<tr class="table-success">
						<th class="text-center" style="width: 10px">#</th>
						<th class="text-center" style="width: 10px">Mã món ăn</th>
						<th class="text-center" style="width: 10px">Tên món ăn</th>
						<th class="text-center" style="width: 10px">Danh mục</th>
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
						<tr><td colspan="10" class="text-center text-none-data">Không có món ăn nào</td></tr>
					</c:if>
					<c:forEach var="item" items="${page.content}" varStatus="cnt">
						<tr>
						<td class="text-center">${item.id }</td>
						<td class="text-center">${item.code} </td>
						<td class="text-center">${item.name} </td>
						<td class="text-center">${item.categoryCode} </td>
						<td class="text-center">${item.description} </td>
						<td class="text-center"> <img height="50"  alt="" src="${item.imageUrl}"> </td>
						<td class="text-center">${item.price} </td>
						<td class="text-center">${item.starteddate} </td>
						<td class="text-center" >${item.status} </td>	
						<td class="text-center">
									<div class="list-icons">
										<div class="dropdown">
											<a href="#" class="list-icons-item" data-toggle="dropdown" data-boundary="viewport"><i class="icon-menu7"></i></a>
											<div class="dropdown-menu dropdown-menu-right">										
													<a href="<c:url value="./dish/form?id=${item.id}"/>" class="dropdown-item"><i class="icon-pencil7" style="color:blue"> Edit</i></a>												
											</div>
										</div>
									</div>
								</td>					
						</tr> 
					</c:forEach>
				</tbody> 
			</table>
		</div>
		<jsp:include page="/themes/admin/common/pagination.jsp">
         	<jsp:param value="${page.number}" name="pageNumber"/>
         	<jsp:param value="${page.totalPages}" name="maxPages"/>
         	<jsp:param value="${page.size}" name="size"/>
         	<jsp:param value="${page.totalElements}" name="totalElements"/>
      	</jsp:include>
	</div>
	<!-- /Table -->
	</form>
</div>
</body>