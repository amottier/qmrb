// Get list of services and inject in search form
function injectServiceCehckboxes() {
	$(document).ready(function() {
		$.getJSON('service', function(data) {
			var formCode = '';
			$.each(data, function(key, value) {
					formCode += '<label><input type="checkbox" name="serviceIds" value="'+value.id+'" />'+value.description+'</label>';
			});
			$('div#services div.widget').append(formCode);
		});
	});
}

// Slider to select time frame for results
function injectResultTimeframeSlider() {
	$(function() {
		 $( "#slider" ).slider();
	});
}

// Handling form submission
function injectFormSubmissionHandler() {
	$( '#searchForm' ).submit(function( event ) {
		var posting = $.post("search", $( this ).serializeArray(), function( data ) {
			//data = $.parseJSON(data);
		    updateResultTable(data);
		  }, "json");
		
		//posting.done();
		return false;
	});
}

function updateResultTable(data) {
	
	$( '#resultsTable' ).dataTable( {
		"bDestroy": true,
		"aaData": data,
		"aoColumns": [
			{ "sTitle": "Nom" },
			{ "sTitle": "Titre" }
		]
	} );
}