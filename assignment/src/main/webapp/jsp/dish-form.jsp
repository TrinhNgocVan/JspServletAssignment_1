<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>

<head>
    <title></title>
</head>

<!-- Content area -->
<div class="content">
<form id="eventForm" action="./form" method="post" role="form">
	<input hidden="hidden"  value = "${criteria.id}" name ="id" /> 
	<!-- Basic layout-->
	<div class="card">
		<div class="card-header header-elements-inline">
			<span class="text-uppercase font-size-lg font-weight-bold">Thêm mới món ăn</span>
		</div>
		<div class="card-body">
			<p class="mb-4">Thêm mới món ăn vào menu nhà hàng</p>
			<fieldset class="mb-3">
				<legend class="text-uppercase font-size-sm font-weight-bold">Chi tiết</legend>
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-xs-12 col-md-3">
								<div class="form-group">
									<label >Thông tin món ăn </label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-md-4">
								<div class="form-group">
									<label >Mã món ăn </><span class="help-block">*</span></label>
									<input type="text" id="dishCode" name="dishCode" value="${criteria.code}"  class="form-control"  />
								</div>
							</div>

							<div class="col-xs-12 col-md-4">
								<div class="form-group">
									<label>Tên món ăn<span class="help-block">*</span></label>
									<input type="text" id="dishName" name="dishName" value="${criteria.name}" class="form-control" />
								</div>
							</div>
							<div class="col-xs-12 col-md-4">
								<div class="form-group">
									<label>Danh mục món ăn <span class="help-block">*</span></label>
									<select  id ="categoryCode" name="categoryCode" class="form-control select2" data-placeholder="Chọn danh mục  "   >
									<option value="">&nbsp;</option>
									<c:forEach var="s" items="${categorys}" >
										<option value="${s.value}" ${criteria.categoryCode  eq s.value ? 'selected' : ''} >${s.value }</option>
									</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-md-4">
								<div class="form-group">
									<label >Mô tả <span class="help-block">*</span></label>
									<input type="text" id="description" name="description"  value="${criteria.description}" class="form-control"  />
								</div>
							</div>

							<div class="col-xs-12 col-md-4">
								<div class="form-group">
									<label>Giá<span class="help-block">*</span></label>
									<input type="number" id="price" name="price"   value="${criteria.price}" class="form-control" min="0" />
								</div>
							</div>
							<div class="col-xs-12 col-md-4">
								<div class="form-group">
									<label>Ngày bắt đầu bán<span class="help-block">*</span></label>
									<input type="date" id="starteddate" name="starteddate" class="form-control " />
								</div>
							</div>
							
						</div>
						<div class="row">
							<div class="col-xs-12 col-md-4">
								<div class="form-group">
									<label >Trạng thái<span class="help-block">*</span></label>
									<select  id ="status" name="status" class="form-control select2" data-placeholder="Trạng thái  "   >
									<option value="">&nbsp;</option>
									<c:forEach var="s" items="${status}" >
										<option value="${s.value}"  ${criteria.status  eq s.value ? 'selected' : ''} >${s.value }</option>
									</c:forEach>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="d-flex justify-content-end align-items-center">
					<a href="<c:url value="/assignment/dishs"/>" id="back" class="btn btn-light"><i class="icon-point-left mr-2"></i>Back</a>
					<button type="submit" id="eventSubmit" class="btn btn-primary ml-3">Save<i class="icon-database-insert ml-2"></i></button>						
				</div>			
			</fieldset>
		</div>
	</div>
	<!-- /basic layout -->
</form>
</div>
<!-- /content area -->
<script src="<c:url value='/themes/admin/assets/js/dish_form.js'/>"></script>