/**
 * Created by dianamohanu on 14/07/2016.
 */

$("#deleteButton").click(function() {
    $('input[id="idProd"]:checked').each(function() {
        var arr = new Array();
        var toInt = parseInt(this.value);
        arr.push(toInt);

        console.log(arr);

        $.ajax({
            type : "POST",
            url : "/mvc/backoffice/products",
            data : {
                prodArray: arr
            },
            success : function(response) {
                $("#prodTable").load( "/mvc/backoffice/products #prodTable" );
                console.log("success");
            },
            error : function(e) {
                alert('Error: ' + e);
            }
        });
    });

});