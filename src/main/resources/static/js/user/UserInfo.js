$(function(){
    alert("222");
    getUserInfo();
    function getUserInfo(){
        var url='/travel/users/getuserbyid';
        $.getJSON(url,function (data) {
            if(data.success){
                var userNameHtml='<h1>userName:'+data.user.uname+'</h1>';
                var userIconHtml='<h1>userIcon:<img src="http://localhost:8080/travel/images/'+data.user.uicon+'"/></h1>';
                $('#user-name').html(userNameHtml);
                $('#user-icon').html(userIconHtml);
            }
        });
    }
})