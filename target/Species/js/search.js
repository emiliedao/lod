/**
 * Created by emiliedao on 5/27/16.
 */
$(document).ready(function() {

    $("#search-value").keyup(
        function(request, response) {
            $("#search-results").empty();
            var $value = $("#search-value").val();

            $.get("search", {value: $value},  function(response) {
                $.each(response, function(index, item) {
                    var $a = $("<a>").text(item);
                    $a.attr("href", "/species?name=" + encodeURI(item));

                    $("#search-results").append($("<li>").append($a));
                });
            });

    });
});