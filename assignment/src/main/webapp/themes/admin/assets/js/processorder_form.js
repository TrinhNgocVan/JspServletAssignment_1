var ProcessOrderComponent = function() {
	
	var initForm = function() {
        if (!$().select2) {
            console.warn('Warning - select2.js is not loaded.');
            return;
        }

    	// select2
   	 	$('.select2').select2();


        $('.datepicker').datepicker({
          dateFormat: 'dd/mm/yy',
          changeMonth: true,
          changeYear: true
        });
        
        // bootbox
        if (typeof bootbox == 'undefined') {
            console.warn('Warning - bootbox.min.js is not loaded.');
            return;
        }

	}
	
	var confirmPO = function(){
		$('#processOrderConfirm').on('click',function(e){
			bootbox.confirm({
				title: "Xác nhận:",
			    message: "Việc này sẽ gửi thông tin lên hệ thống SAP. Bạn có chắc chắn không?",
			    buttons: {
			        confirm: {
			            label: 'Xác nhận',
			            className: 'btn-success'
			        },
			        cancel: {
			            label: 'Từ chối',
			            className: 'btn-danger'
			        }
			    },
			    callback: function (result) {
			    	if(result) {
			    		//set lai ngay thang nam
						var realStartDate = $('#processOrderRealStartDate').val();
						var strS = realStartDate.split('/');
						var monthS = Math.abs(strS[1]) - 1; //// the month is 0-indexed
						var startdate = new Date(strS[2],monthS,strS[0]).toLocaleDateString('en-GB');
						document.getElementById("realStartDate").value = startdate;
						
						//set lai ngay thang nam
						var realEndDate = $('#processOrderRealEndDate').val();
						var strE = realEndDate.split('/');
						var monthE = Math.abs(strE[1]) - 1; //// the month is 0-indexed
						var enddate = new Date(strE[2],monthE,strE[0]).toLocaleDateString('en-GB');
						document.getElementById("realEndDate").value = enddate;
						$('#processOrderStatus').val('confirmed');
						$('#processOrderForm').attr('action', '/processOrder/confirmed');
						$('#processOrderForm').submit();
			    	}
			    }
			});
		});
	}
	
	var closePO = function(){
		$('#processOrderClose').on('click',function(e){
			bootbox.confirm({
				title: "Xác nhận:",
			    message: "Việc này sẽ gửi thông tin lên hệ thống SAP. Bạn có chắc chắn không?",
			    buttons: {
			        confirm: {
			            label: 'Xác nhận',
			            className: 'btn-success'
			        },
			        cancel: {
			            label: 'Từ chối',
			            className: 'btn-danger'
			        }
			    },
			    callback: function (result) {
			    	if(result) {
			    		//set lai ngay thang nam
						var realStartDate = $('#processOrderRealStartDate').val();
						var strS = realStartDate.split('/');
						var monthS = Math.abs(strS[1]) - 1; //// the month is 0-indexed
						var startdate = new Date(strS[2],monthS,strS[0]).toLocaleDateString('en-GB');
						document.getElementById("realStartDate").value = startdate;
						
						//set lai ngay thang nam
						var realEndDate = $('#processOrderRealEndDate').val();
						var strE = realEndDate.split('/');
						var monthE = Math.abs(strE[1]) - 1; //// the month is 0-indexed
						var enddate = new Date(strE[2],monthE,strE[0]).toLocaleDateString('en-GB');
						document.getElementById("realEndDate").value = enddate;
						$('#processOrderStatus').val('closed');
						$('#processOrderForm').attr('action', '/processOrder/confirmed');
						$('#processOrderForm').submit();
			    	}
			    }
			});
		});
	}
	
	
	var hideTable = function(){
		$('#hideTblQuotas').on('click',function(e){
			var x = document.getElementById("tableQuota");
			  if (x.style.display === "none") {
			    x.style.display = "block";
			  } else {
			    x.style.display = "none";
			  }
		});
	}
	
    return {
        init: function() {
        	initForm();
        	confirmPO();
        	closePO();
        	hideTable();
        }
    }
}();

var Custom = {
		checkStatus: () => {
			var status = $('#processOrderStatus').val().toLowerCase();
			if(status == 'unconfirmed') {
				$("#processOrderQuantity").attr("readonly", false);
				$("#processOrderStartDate").attr("readonly", false);
				$("#processOrderEndDate").attr("readonly", false);
				$("#processOrderRealStartDate").attr("readonly", false);
				$("#processOrderRealEndDate").attr("readonly", false);
			}
		},
		
		hideTable: () => {
			var x = document.getElementById("tableQuota");
			x.style.display = "none";
		},
		
}

// Initialize module
// ------------------------------

document.addEventListener('DOMContentLoaded', function() {
	ProcessOrderComponent.init();
	Custom.checkStatus();
	Custom.hideTable();
});
