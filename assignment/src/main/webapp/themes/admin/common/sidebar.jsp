<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/themes/common/taglibs.jsp"%>

		<div class="sidebar sidebar-light sidebar-main sidebar-expand-md">
			<!-- Sidebar mobile toggler -->
			<div class="sidebar-mobile-toggler text-center">
				<a href="#" class="sidebar-mobile-main-toggle"><i class="icon-arrow-left8"></i></a>
				Navigation
				<a href="#" class="sidebar-mobile-expand"><i class="icon-screen-full"></i><i class="icon-screen-normal"></i></a>
			</div>
			<!-- /sidebar mobile toggler -->

			<!-- Sidebar content -->
				<div class="sidebar-content">

				<!-- User menu -->
				<div class="sidebar-user">
					<div class="card-body">
						<div class="media">
							<div class="mr-3"><a href="#"><img src="<c:url value='/themes/admin/global_assets/images/placeholders/placeholder.jpg'/>" width="38" height="38" class="rounded-circle" alt=""></a></div>
							<div class="media-body">
								<div class="media-title font-weight-semibold"><%-- <fmt:message key="label.hello"/> ${USERNAME} --%>Hello,Admin</div>
								<div class="font-size-xs opacity-50">
									<i class="icon-pin font-size-sm"></i>
									<span>Tổ chức <strong></strong></span>
								</div>
							</div>
							<div class="ml-3 align-self-center"><a href="#" class="text-white"><i class="icon-cog3"></i></a></div>
						</div>
					</div>
				</div>
				<!-- /user menu -->

				<!-- Main navigation -->
				<div class="card sidebar-mobile">
					<ul class="nav nav-sidebar" data-nav-type="accordion">																	
						<li class=" nav-item nav-item-submenu nav-item-submenu-parent">
							<a  href="#" class="nav-link "><i class="icon-piggy-bank" aria-hidden="true"></i><span>Quản lý thực đơn</span></a>
							<ul class="nav nav-group-sub nav-group-sub-parent" >							
								<li class="nav-item"><a  href="/assignment/dishs" class="nav-link">Danh mục món ăn</a></li>			
							</ul>
						</li>
				
					
						
					</ul>
				</div>

			</div>
			<!-- /sidebar content -->
			
		</div>
