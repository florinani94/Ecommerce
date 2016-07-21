/**
 * Created by mateimihai on 7/20/2016.
 */
$('#cartIcon').hover(function () {
    $(this).css('width','8%');
},function () {
    $(this).css('width','7%');
})

var clicks = 0;
var idCart=1;

$('#cartIcon').click(function () {
    if(clicks===0){
        $.ajax({
            type : "POST",
            url : "/mvc/cart/entries",
            data : {cartId: idCart},
            success : function(result) {
                console.log(result);
                clicks++;
                $('#cartPanel').css("position","absolute");
                $('#cartPanel').css("visibility", "visible");
                $('#cartPanel').animate({height: (result.length*5).toString() + '%'}, 500);
            },
            error : function(e) {
                console.log('Error: ', e);
            }
        });
    }else{
        clicks--;
        $('#cartPanel').animate({height: '0%'}, 500);
        $('#cartPanel').css("visibility", "hidden");
    }
    }
)
