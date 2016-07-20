/**
 * Created by dianamohanu on 14/07/2016.
 */
// Functions used in viewProducts.jsp
$("#deleteButton").click(function() {
    $('input[id="idProd"]:checked').each(function() {
        var arr = new Array();
        var toInt = parseInt(this.value);
        arr.push(toInt);

        $.ajax({
            type : "POST",
            url : "../product",
            data : {
                prodArray: arr
            },
            success : function(response) {
                $("#prodTable").load( "../product #prodTable" );
                console.log("success");
            },
            error : function(e) {
                alert('Error: ' + e);
            }
        });
    });
});


$("#selectall").click(function () {
    $('.check').attr('checked', this.checked);
});



//For collapsible checkout form
$('.panel-heading h4 a input[type=checkbox]').on('click', function(e) {
    e.stopPropagation();
})

function billingFunction() {
    if (document.getElementById("same").checked) {
        document.getElementById("billingStreet").value=document.getElementById("deliveryStreet").value;
        document.getElementById("billingNumber").value=document.getElementById("deliveryNumber").value;
        document.getElementById("billingCity").value=document.getElementById("deliveryCity").value;
    } else {
        document.getElementById("billingStreet").value="";
        document.getElementById("billingNumber").value="";
        document.getElementById("billingCity").value="";
    }
}

