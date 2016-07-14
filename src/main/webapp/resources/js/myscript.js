/**
 * Created by dianamohanu on 14/07/2016.
 */

$("#deleteButton").click(function() {
    $('input[id="idProd"]:checked').each(function() {
        var arr = new Array();
        var toInt = parseInt(this.value);
        arr.push(toInt);

        $.ajax({
            type : "POST",
            url : "../backoffice/product",
            data : {
                prodArray: arr
            },
            success : function(response) {
                $("#prodTable").load( "../backoffice/product #prodTable" );
                console.log("success");
            },
            error : function(e) {
                alert('Error: ' + e);
            }
        });
    });
});


$("#selectall").change(function(){
    $(".check").prop('checked', $(this).prop("checked"));
});
