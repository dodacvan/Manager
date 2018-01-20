$(document).ready(function() {
	$('#dataTables-example').DataTable({
		responsive : true
	});
});
$('div .alert').delay(3000).slideUp();
$('a#del').click(function() {
	$(this).parents('#gradeX').css({
		"color" : "red",
		"border" : "2px solid red"
	});

});
function xacnhanxoa(msg) {
	if (window.confirm(msg)) {
		return true;
	}
	return false;
}
