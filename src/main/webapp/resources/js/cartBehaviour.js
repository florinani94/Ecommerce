/**
 * Created by mateimihai on 7/20/2016.
 */
$('#cartIcon').hover(function () {
    $(this).css('width','8%');
},function () {
    $(this).css('width','7%');
})

var clicks = 0;
//var arr = ["one", "two", "three", "four", "five"];
var arr = <%=new ProductDAOImpl().getAllProducts()%>;
//console.log(cart);

$('#cartIcon').click(function () {
    if(clicks===0){
        clicks++;
        $('#cartPanel').css("visibility", "visible");
        $('#cartPanel').animate({height: (arr.length*5).toString() + '%'}, 500);
    }else{
        clicks--;
        $('#cartPanel').animate({height: '0%'}, 500);
        $('#cartPanel').css("visibility", "hidden");
    }
    }
)
