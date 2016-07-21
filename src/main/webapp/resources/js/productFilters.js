/**
 * Created by nicoletatica on 19/07/2016.
 */
var arr;
var maxSizeArr
$(document).ready(function () {
    arr = new Array();
    $allCheckboxes = $('#allCategories input[type="checkbox"]');
    maxSizeArr=$allCheckboxes.length;
    $( $allCheckboxes ).each(function() {
        arr.push($(this).val());
    });

})


function applySelectedFilter($selectedCheckboxCategory) {
    $valueInput= $($selectedCheckboxCategory).val();


    $url=document.URL;
    if( $($selectedCheckboxCategory).is(':checked') ) {
        closeButton = "<a   href=\"";
        $add = '';
        rectangleDiv = "<div id=\"rectangle\"  class=\"" + $valueInput + "\" style='display: inline-block; align: center' >";
        $add += (rectangleDiv);
        $add += $($selectedCheckboxCategory).attr("id");
        $add += closeButton + "javascript:deleteFilter('" +  $valueInput+ "')\"> X </a>";

        $add += "</div>";
        $("#selectedCategories").append($add);


        if(arr.length==maxSizeArr){
            arr.length=0;
        }
        arr.push($valueInput);
        if ($url.indexOf("?") <0){
            $url=$url+"?";
        }
        $url=$url+"&category="+$valueInput;
        // window.location=$url;
        // location.replace($url);

        // $url=$url+"sortValue=sortnameza";
    }
    else {
        if ($url.indexOf("category="+$valueInput) >= 0){
            $url=$url.replace("&category="+$valueInput,'');
        }
        $("#selectedCategories").find("."+$valueInput).remove();
        if(jQuery.inArray( $valueInput, arr )){
            arr.splice($.inArray($valueInput, arr),1);

        }
    }

    alert(arr);

    $.ajax({
        type:'POST',
        url: "products",
        data : {
            selectedCategoriesArray: arr
        },
        success: function (result) {
            $(".square").load("../products .square" );
            console.log("success");
        },
        error: function (result) {
            alert("error"+result.responseText);
        }
    });


}
function deleteFilter($selectedValue) {
    $checkBox=$('[value=\''+$selectedValue+'\']');
    $checkBox.attr("checked", false);
    // $("#selectedCategories").find("."+$selectedValue).remove();
    applySelectedFilter($checkBox);

}