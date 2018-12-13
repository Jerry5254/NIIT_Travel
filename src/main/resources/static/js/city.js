$(function () {
    alert("Hello");
    var cityId=getQueryString('cityId');
    alert('cityId');
    var cityInfoUrl='/travel/city/city_id';
    getCity();
    function getCity() {
        $.getJSON(cityInfoUrl, function (data) {
            if (data.success) {
                var cityHtml = '';
                cityHtml += '<li role="presentation" ><a role="menuitem" tabindex="-1" href="' + 'javascript:void(0);' + '" data-id="' + data.city.cid + '">' + data.city.cname + '</a></li>';
                $('#city-info').html(cityHtml);
            }
        });
    }
})