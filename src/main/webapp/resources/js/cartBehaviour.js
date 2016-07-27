/**
 * Created by mateimihai on 7/20/2016.
 */
$('#cartIcon').hover(function () {
    $(this).css('width','8%');
},function () {
    $(this).css('width','7%');
})

var toggleMenu = false;
var idCart=1;

$('#cartIcon, #prodNr').click(function () {

    var entriesNo = 0;

    if(!toggleMenu){
        toggleMenu = true;
        $.ajax({
            type : "POST",
            url : "/mvc/cart/entries",
            data : {cartId: idCart},
            success : function(result) {

                $("#entry-data").html("");

                $("#total-value").text(result.total);
                $.each(result.entries, function (index, entry) {
                        $("#entry-data").html($("#entry-data").html() +
                            "<div class='entry-line'>" +
                                "<span class='entry-quantity'>" + entry.quantity + "  x  " + "</span>" +
                                "<span class='entry-name'>" + entry.name + "   " + "</span>" +
                                "<span class='entry-subtotal'>" + entry.subtotal + "$" + "</span>" +
                            "</div>"
                        );
                    entriesNo++;
                    }
                );

                $('#cartPanel').css("position","absolute");
                $('#cartPanel').css("visibility", "visible");
                $('#cartPanel').animate({height: (entriesNo*20 + 85).toString() + '%'}, 200);
            },
            error : function(e) {
                console.log('Error: ', e);
            }
        });
    }else{
        toggleMenu = false;
        $('#cartPanel').animate({height: '0%'}, 200);
        $('#cartPanel').delay(200);
        $('#cartPanel').css("visibility", "hidden");
    }
    }
)


$("#addButtonID").click(function() {
        $.ajax({
            type : "POST",
            url : "/mvc/cart/addToCart",
            data : {
                quantity: $("#quantityFieldID").val(),
                productId: $('#product-id').val(),
                cartId: 1 //temporary!
            },
            success : function(response) {
                alert($("#successMessageId").val());
                console.log("success");
            },
            error : function(e) {
                alert('An error occurred while trying to add the product to the cart. Please try again later. ');
            }
       });

});

