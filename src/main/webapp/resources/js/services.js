(function($) {
	// Handler for .ready() called.
	$(document).ready(function() {
		fetchproductdata();
		// Handler for .ready() called.
		$('#search-button').click(function() {
			fetchproductdata();
		});
	});

	function fetchproductdata() {
		// demo/services/product/list
		$('#loading-image').show();
		var url = "searchproduct?name=" + $('#search-box').val()
		if ($('#search-box').val() == '') {
			url = '/demo/services/product/list';
		}

		$.ajax({
			url : url
		}).fail(function() {
			$('#search-error').text('Error in searching the data')
		}).done(function(data) {
			populate_table_data(data);
			$('#loading-image').hide();
		});
	}

	function populate_table_data(data) {
		var row, editlink, deletelink;
		$.each(data,function(index, value) {
			row += "<tr id='" + value.id + "-product-row'>"
			row += "<td>" + value.name + "</td>"
			row += "<td>" + value.description + "</td>"
			row += "<td>" + value.category + "</td>"
			row += "<td>" + value.price + "</td>"
			row += "<td>" + value.uom + "</td>"
			row += "<td>" + value.currency + "</td>"
			editlink = '<a productId="'
					+ value.id
					+ '" class="edit-link" href="javascript:void(0);" >Edit</a>'
			deletelink = '<a productId="'
					+ value.id
					+ '" class="delete-link"  href="javascript:void(0);" >Delete</a>'
			row += "<td>" + editlink + ' / ' + deletelink
					+ "</td>"
			row += "</tr>"
		});
		$("#tbody-data").html(row);
	}

})(jQuery);